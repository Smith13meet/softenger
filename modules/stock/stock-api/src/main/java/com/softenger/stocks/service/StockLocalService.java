/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.softenger.stocks.service;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.softenger.stocks.exception.NoSuchStockException;
import com.softenger.stocks.exception.StockNameException;
import com.softenger.stocks.exception.StockQuantityException;
import com.softenger.stocks.model.Stock;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Stock. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see StockLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface StockLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.softenger.stocks.service.impl.StockLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the stock local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link StockLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the stock to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StockLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stock the stock
	 * @return the stock that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Stock addStock(Stock stock);

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
	@Indexable(type = IndexableType.REINDEX)
	@Transactional(
		noRollbackFor = {
			NoSuchUserException.class, StockNameException.class,
			StockQuantityException.class
		}
	)
	public Stock addStock(
			String name, int quantity, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new stock with the primary key. Does not add the stock to the database.
	 *
	 * @param stockId the primary key for the new stock
	 * @return the new stock
	 */
	@Transactional(enabled = false)
	public Stock createStock(long stockId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the stock with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StockLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stockId the primary key of the stock
	 * @return the stock that was removed
	 * @throws PortalException if a stock with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Transactional(noRollbackFor = NoSuchStockException.class)
	public Stock deleteStock(long stockId) throws PortalException;

	/**
	 * Deletes the stock from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StockLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stock the stock
	 * @return the stock that was removed
	 * @throws PortalException
	 */
	@Indexable(type = IndexableType.DELETE)
	@Transactional
	public Stock deleteStock(Stock stock) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.softenger.stocks.model.impl.StockModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.softenger.stocks.model.impl.StockModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Stock fetchStock(long stockId);

	/**
	 * Returns the stock matching the UUID and group.
	 *
	 * @param uuid the stock's UUID
	 * @param groupId the primary key of the group
	 * @return the matching stock, or <code>null</code> if a matching stock could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Stock fetchStockByUuidAndGroupId(String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the stock with the primary key.
	 *
	 * @param stockId the primary key of the stock
	 * @return the stock
	 * @throws PortalException if a stock with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Stock getStock(long stockId) throws PortalException;

	/**
	 * Returns the stock matching the UUID and group.
	 *
	 * @param uuid the stock's UUID
	 * @param groupId the primary key of the group
	 * @return the matching stock
	 * @throws PortalException if a matching stock could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Stock getStockByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the stocks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.softenger.stocks.model.impl.StockModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @return the range of stocks
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Stock> getStocks(int start, int end);

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
	public List<Stock> getStocks(long groupId, int start, int end);

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
	public List<Stock> getStocks(long groupId, int status, int start, int end);

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
	public List<Stock> getStocks(
		long groupId, int status, int start, int end,
		OrderByComparator<Stock> orderByComparator);

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
	public List<Stock> getStocks(
		long groupId, int start, int end,
		OrderByComparator<Stock> orderByComparator);

	/**
	 * Returns all the stocks matching the UUID and company.
	 *
	 * @param uuid the UUID of the stocks
	 * @param companyId the primary key of the company
	 * @return the matching stocks, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Stock> getStocksByUuidAndCompanyId(String uuid, long companyId);

	/**
	 * Returns a range of stocks matching the UUID and company.
	 *
	 * @param uuid the UUID of the stocks
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching stocks, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Stock> getStocksByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Stock> orderByComparator);

	/**
	 * Returns the number of stocks.
	 *
	 * @return the number of stocks
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getStocksCount();

	/**
	 * Counts stocks in a site given by <code>groupId</code> and with the status
	 * {@link WorkflowConstants#STATUS_APPROVED}.
	 *
	 * @param groupId the id of a site to which stocks belong.
	 * @return the number of matching stocks.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getStocksCount(long groupId);

	/**
	 * Counts stocks in a site given by <code>groupId</code> and with the given <code>status</code>.
	 *
	 * @param groupId the id of a site to which stocks belong.
	 * @param status  the Liferay status value for filtering.
	 * @return the number of matching stocks.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getStocksCount(long groupId, int status);

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
	@Transactional(
		noRollbackFor = {NoSuchUserException.class, NoSuchStockException.class}
	)
	public Stock updateStatus(long userId, long stockId, int status)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	@Transactional(
		noRollbackFor = {
			NoSuchStockException.class, StockNameException.class,
			StockQuantityException.class
		}
	)
	public Stock updateStock(
			long stockId, String name, int quantity,
			ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Updates the stock in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StockLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stock the stock
	 * @return the stock that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Stock updateStock(Stock stock);

}