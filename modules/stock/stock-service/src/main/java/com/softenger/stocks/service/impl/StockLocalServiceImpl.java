/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.softenger.stocks.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.softenger.stocks.constants.StocksActivityKeys;
import com.softenger.stocks.constants.StocksConstants;
import com.softenger.stocks.exception.NoSuchStockException;
import com.softenger.stocks.exception.StockNameException;
import com.softenger.stocks.exception.StockQuantityException;
import com.softenger.stocks.model.Stock;
import com.softenger.stocks.service.base.StockLocalServiceBaseImpl;
import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.liferay.portal.kernel.model.ResourceConstants.SCOPE_INDIVIDUAL;

/**
 * The implementation of the stock local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.softenger.stocks.service.StockLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StockLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=com.softenger.stocks.model.Stock",
        service = AopService.class
)
public class StockLocalServiceImpl extends StockLocalServiceBaseImpl {

    /**
     * The log for this class.
     */
    private static final Log _log = LogFactoryUtil.getLog(StockLocalServiceImpl.class);

    /**
     * Adds a new stock with the given attributes.
     *
     * @param name           the name for the stock.
     * @param quantity       the number of items needed by user.
     * @param serviceContext the context info about the given service call.
     * @return the added stock.
     * @throws NoSuchUserException    if no user specified in the given service context exists.
     * @throws StockNameException     if the given name is blank or too long.
     * @throws StockQuantityException if the given quantity is blank.
     * @throws PortalException        if something's gone wrong.
     */
    @Transactional(
            noRollbackFor = {
                    NoSuchUserException.class,
                    StockNameException.class,
                    StockQuantityException.class
            }
    )
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Stock addStock(final String name, final int quantity, final ServiceContext serviceContext)
            throws PortalException {
        checkNotNull(serviceContext, "Argument 'serviceContext' cannot be null");

        final User user = userLocalService.getUserById(serviceContext.getUserId());
        final long companyId = serviceContext.getCompanyId();

        validateName(name);
        validateQuantity(quantity);

        final long stockId = counterLocalService.increment(Stock.class.getName());
        final Stock stock = createStock(stockId);

        stock.setUuid(serviceContext.getUuid());
        stock.setCompanyId(user.getCompanyId());
        stock.setGroupId(serviceContext.getScopeGroupId());
        stock.setUserId(user.getUserId());
        stock.setUserName(user.getFullName());

        stock.setName(name);
        stock.setQuantity(quantity);

        final Stock result = updateStock(stock);

        // Resources
        resourceLocalService.addModelResources(stock, serviceContext);

        // Asset
        updateAsset(serviceContext.getUserId(), result, serviceContext.getAssetCategoryIds(),
                serviceContext.getAssetTagNames(), serviceContext.getAssetLinkEntryIds(),
                serviceContext.getAssetPriority());
        // Social
        final JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();
        extraDataJSONObject.put("title", result.getName());

        socialActivityLocalService.addActivity(result.getUserId(), result.getGroupId(), Stock.class.getName(),
                result.getStockId(), StocksActivityKeys.ADD_STOCK, extraDataJSONObject.toString(), 0L);

        // Workflow
        WorkflowHandlerRegistryUtil.startWorkflowInstance(result.getCompanyId(), result.getGroupId(),
                result.getUserId(), Stock.class.getName(), result.getStockId(), result, serviceContext);

        return result;
    }

    /**
     * Updates an existing stock with the given attributes.
     *
     * @param stockId        the id of the stock to be updated.
     * @param name           the name for the stock.
     * @param quantity       the number of items needed by user.
     * @param serviceContext the context info about the given service call.
     * @return the updated stock.
     * @throws NoSuchStockException   if no stock with the given id exists.
     * @throws StockNameException     if the given name is blank or too long.
     * @throws StockQuantityException if the given quantity is blank.
     * @throws PortalException        if something's gone wrong.
     */
    @Transactional(
            noRollbackFor = {
                    NoSuchStockException.class,
                    StockNameException.class,
                    StockQuantityException.class
            }
    )
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Stock updateStock(
            final long stockId, final String name, final int quantity, final ServiceContext serviceContext)
            throws PortalException {
        checkNotNull(serviceContext, "Argument 'serviceContext' cannot be null");

        final Stock stock = getStock(stockId);

        validateName(name);
        validateQuantity(quantity);

        stock.setName(name);
        stock.setQuantity(quantity);

        final Stock result = updateStock(stock);

        // Resources
        resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
                Stock.class.getName(), result.getStockId(), serviceContext.getModelPermissions());

        // Asset
        final AssetEntry assetEntry = assetEntryLocalService.updateEntry(result.getUserId(), result.getGroupId(),
                result.getCreateDate(), result.getModifiedDate(), Stock.class.getName(), result.getStockId(),
                result.getUuid(), 0, serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true,
                true, result.getCreateDate(), null, null, null, ContentTypes.TEXT, result.getName(), null, null, null,
                null, 0, 0, serviceContext.getAssetPriority());

        assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(),
                serviceContext.getAssetLinkEntryIds(), AssetLinkConstants.TYPE_RELATED);

        // Social
        final JSONObject extraDataJSONObject = JSONFactoryUtil.createJSONObject();
        extraDataJSONObject.put("title", result.getName());

        socialActivityLocalService.addActivity(result.getUserId(), result.getGroupId(), Stock.class.getName(),
                result.getStockId(), StocksActivityKeys.UPDATE_STOCK, extraDataJSONObject.toString(), 0L);

        return stock;
    }

    /**
     * Deletes the given stock completely.
     *
     * @param stock the stock to delete.
     * @return the deleted stock.
     * @throws PortalException    if something's gone wrong.
     */
    @Transactional
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Stock deleteStock(final Stock stock) throws PortalException {
        checkNotNull(stock, "Argument 'stock' cannot be null");

        final Stock result = super.deleteStock(stock);

        // Resources
        resourceLocalService.deleteResource(result.getCompanyId(), Stock.class.getName(),
                SCOPE_INDIVIDUAL, result.getStockId());

        // Asset
        final AssetEntry assetEntry = assetEntryLocalService.fetchEntry(Stock.class.getName(), result.getStockId());
        assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
        assetEntryLocalService.deleteEntry(assetEntry);

        // Workflow
        workflowInstanceLinkLocalService.deleteWorkflowInstanceLinks(result.getCompanyId(), result.getGroupId(),
                Stock.class.getName(), result.getStockId());

        return result;
    }

    /**
     * Deletes a stock given by its id completely.
     *
     * @param stockId the id of a stock to delete.
     * @return the deleted stock.
     * @throws NoSuchStockException if no stock with the given id exists.
     * @throws PortalException      if something's gone wrong.
     */
    @Transactional(noRollbackFor = NoSuchStockException.class)
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Stock deleteStock(final long stockId) throws PortalException {
        final Stock stock = getStock(stockId);
        return deleteStock(stock);
    }

    /**
     * Retrieves a stock identified by its <code>stockId</code>.
     *
     * @param stockId the id of the stock to be retrieved.
     * @return the retrieved stock.
     * @throws NoSuchStockException if no stock with the given id exists.
     * @throws PortalException      if something's gone wrong.
     */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public Stock getStock(final long stockId) throws PortalException {
        return stockPersistence.findByPrimaryKey(stockId);
    }

    /**
     * Lists stocks in a site given by <code>groupId</code> and with the status
     * {@link WorkflowConstants#STATUS_APPROVED}.
     *
     * @param groupId the id of a site to which stocks belong.
     * @param start   the lower bound of the range of stocks.
     * @param end     the upper bound of the range of stocks (not inclusive).
     * @return the range of matching stocks.
     */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<Stock> getStocks(final long groupId, final int start, final int end) {
        return getStocks(groupId, WorkflowConstants.STATUS_APPROVED, start, end);
    }

    /**
     * Lists stocks in a site given by <code>groupId</code> and with the given <code>status</code>.
     *
     * @param groupId the id of a site to which stocks belong.
     * @param status  the Liferay status value for filtering.
     * @param start   the lower bound of the range of stocks.
     * @param end     the upper bound of the range of stocks (not inclusive).
     * @return the range of matching stocks.
     */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<Stock> getStocks(final long groupId, final int status, final int start, final int end) {
        return getStocks(groupId, status, start, end, null);
    }

    /**
     * Lists stocks in a site given by <code>groupId</code> and with the given <code>status</code>.
     *
     * @param groupId           the id of a site to which stocks belong.
     * @param status            the Liferay status value for filtering.
     * @param start             the lower bound of the range of stocks.
     * @param end               the upper bound of the range of stocks (not inclusive).
     * @param orderByComparator the comparator to order the stocks by (optionally null).
     * @return the ordered range of matching stocks.
     */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<Stock> getStocks(
            final long groupId, final int status, final int start, final int end,
            final OrderByComparator<Stock> orderByComparator) {
        return stockPersistence.findByGroupIdAndStatus(groupId, status, start, end, orderByComparator);
    }

    /**
     * Lists stocks in a site given by <code>groupId</code> and with the status
     * {@link WorkflowConstants#STATUS_APPROVED}.
     *
     * @param groupId           the id of a site to which stocks belong.
     * @param start             the lower bound of the range of stocks.
     * @param end               the upper bound of the range of stocks (not inclusive).
     * @param orderByComparator the comparator to order the stocks by (optionally null).
     * @return the ordered range of matching stocks.
     */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public List<Stock> getStocks(
            final long groupId, final int start, final int end, final OrderByComparator<Stock> orderByComparator) {
        return stockPersistence.findByGroupId(groupId, start, end);
    }

    /**
     * Counts stocks in a site given by <code>groupId</code> and with the status
     * {@link WorkflowConstants#STATUS_APPROVED}.
     *
     * @param groupId the id of a site to which stocks belong.
     * @return the number of matching stocks.
     */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public int getStocksCount(final long groupId) {
        return getStocksCount(groupId, WorkflowConstants.STATUS_APPROVED);
    }

    /**
     * Counts stocks in a site given by <code>groupId</code> and with the given <code>status</code>.
     *
     * @param groupId the id of a site to which stocks belong.
     * @param status  the Liferay status value for filtering.
     * @return the number of matching stocks.
     */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    @Override
    public int getStocksCount(final long groupId, final int status) {
        return stockPersistence.countByGroupIdAndStatus(groupId, status);
    }

    /**
     * Updates the Liferay status fields and asset visibility of the stock.
     *
     * @param userId    the id of a user who updates the stock.
     * @param stockId the id of the stock to be updated.
     * @param status    the Liferay status to be set.
     * @return The updated stock.
     * @throws NoSuchUserException    if no user with the given id exists.
     * @throws NoSuchStockException if no stock with the given id exists.
     * @throws PortalException        if something's gone wrong.
     */
    @Transactional(noRollbackFor = { NoSuchUserException.class, NoSuchStockException.class })
    @Override
    public Stock updateStatus(final long userId, final long stockId, final int status) throws PortalException {
        final User user = userLocalService.getUserById(userId);
        final Date now = new Date();

        final Stock stock = getStock(stockId);

        stock.setStatus(status);
        stock.setStatusByUserId(userId);
        stock.setStatusByUserName(user.getFullName());
        stock.setStatusDate(now);

        stockPersistence.update(stock);

        assetEntryLocalService.updateVisible(Stock.class.getName(), stockId,
                status == WorkflowConstants.STATUS_APPROVED);

        return stock;
    }

    /**
     * Checks that the given name is valid.
     *
     * @param name      the name to be checked.
     * @throws StockNameException      if the given name is blank or too long.
     */
    private void validateName(final String name) throws PortalException {
        if (StringUtils.isBlank(name)) {
            throw new StockNameException("Name is blank");
        }
        if (StringUtils.length(name) > StocksConstants.NAME_MAX_LENGTH) {
            throw new StockNameException("Name is too long");
        }
    }

    /**
     * Checks that the given description is valid.
     *
     * @param quantity the quantity to be checked.
     * @throws StockQuantityException if the given quantity is not valid.
     */
    private void validateQuantity(final int quantity) throws StockQuantityException {
        if (quantity <= 0 || Validator.isNull(quantity)) {
            throw new StockQuantityException("Quantity is not valid");
        }
    }

    /**
     * Updates an asset entry associated with the given stock.
     *
     * @param userId            the id of a user who updates.
     * @param stock           the stock to be associated with.
     * @param assetCategoryIds  the category ids for the asset entry.
     * @param assetTagNames     the tag names for the asset entry.
     * @param assetLinkEntryIds the link entry ids for the asset entry.
     * @param assetPriority     the priority for the asset entry.
     * @throws PortalException if something's gone wrong.
     */
    private void updateAsset(
            final long userId, final Stock stock, final long[] assetCategoryIds,
            final String[] assetTagNames,
            final long[] assetLinkEntryIds, final Double assetPriority) throws PortalException {
        checkNotNull(stock, "Argument 'project' cannot be null");

        final AssetEntry assetEntry = assetEntryLocalService.updateEntry(
                userId, stock.getGroupId(), stock.getCreateDate(), stock.getModifiedDate(),
                Stock.class.getName(), stock.getStockId(), stock.getUuid(), 0, assetCategoryIds, assetTagNames,
                true, true, null, null, stock.getCreateDate(), null, ContentTypes.TEXT_PLAIN, stock.getName(),
                null, null, null, null, 0, 0, assetPriority);

        assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), assetLinkEntryIds,
                AssetLinkConstants.TYPE_RELATED);
    }

    private User getAdministratorUser(final long companyId) throws PortalException {
        final Role administratorRole = roleLocalService.getRole(companyId, RoleConstants.ADMINISTRATOR);
        final List<User> administratorUsers = userLocalService.getRoleUsers(administratorRole.getRoleId());
        if (administratorUsers.isEmpty()) {
            throw new PortalException("No Administrator User found");
        }
        return administratorUsers.get(0);
    }

}