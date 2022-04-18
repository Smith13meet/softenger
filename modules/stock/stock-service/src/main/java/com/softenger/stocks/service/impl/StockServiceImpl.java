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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.softenger.stocks.constants.StocksActionKeys;
import com.softenger.stocks.constants.StocksConstants;
import com.softenger.stocks.exception.NoSuchStockException;
import com.softenger.stocks.exception.StockNameException;
import com.softenger.stocks.exception.StockQuantityException;
import com.softenger.stocks.model.Stock;
import com.softenger.stocks.service.base.StockServiceBaseImpl;
import org.osgi.service.component.annotations.Component;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * The implementation of the stock remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.softenger.stocks.service.StockService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StockServiceBaseImpl
 */
@Component(
        property = {
                "json.web.service.context.name=softenger",
                "json.web.service.context.path=Stock"
        },
        service = AopService.class
)
public class StockServiceImpl extends StockServiceBaseImpl {

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
    @Override
    public Stock addStock(final String name, final int quantity, final ServiceContext serviceContext)
            throws PortalException {
        _portletResourcePermission.check(getPermissionChecker(), serviceContext.getScopeGroupId(),
                StocksActionKeys.ADD_STOCK);
        return stockLocalService.addStock(name, quantity, serviceContext);
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
    @Override
    public Stock updateStock(
            final long stockId, final String name, final int quantity, final ServiceContext serviceContext)
            throws PortalException {
        _stockModelResourcePermission.check(getPermissionChecker(), stockId, ActionKeys.UPDATE);
        return stockLocalService.updateStock(stockId, name, quantity, serviceContext);
    }

    /**
     * Deletes the given stock completely.
     *
     * @param stock the stock to delete.
     * @return the deleted stock.
     * @throws PrincipalException if permission check fails.
     * @throws PortalException    if something's gone wrong.
     */
    @Override
    public Stock deleteStock(final Stock stock) throws PortalException {
        checkNotNull(stock, "Argument 'stock' cannot be null");

        _stockModelResourcePermission.check(getPermissionChecker(), stock.getStockId(), ActionKeys.DELETE);
        return stockLocalService.deleteStock(stock);
    }

    /**
     * Deletes a stock given by its id completely.
     *
     * @param stockId the id of a stock to delete.
     * @return the deleted stock.
     * @throws NoSuchStockException if no stock with the given id exists.
     * @throws PrincipalException   if permission check fails.
     * @throws PortalException      if something's gone wrong.
     */
    @Override
    public Stock deleteStock(final long stockId) throws PortalException {
        _stockModelResourcePermission.check(getPermissionChecker(), stockId, ActionKeys.DELETE);
        return stockLocalService.deleteStock(stockId);
    }

    /**
     * Retrieves a stock identified by its <code>stockId</code>.
     *
     * @param stockId the id of the stock to be retrieved.
     * @return the retrieved stock.
     * @throws NoSuchStockException if no stock with the given id exists.
     * @throws PrincipalException   if permission check fails.
     * @throws PortalException      if something's gone wrong.
     */
    @Override
    public Stock getStock(final long stockId) throws PortalException {
        _stockModelResourcePermission.check(getPermissionChecker(), stockId, ActionKeys.VIEW);
        return stockLocalService.getStock(stockId);
    }

    /**
     * The model resource permission for the stocks domain area.
     */
    private static volatile ModelResourcePermission<Stock> _stockModelResourcePermission =
            ModelResourcePermissionFactory.getInstance(StockServiceImpl.class, "_stockModelResourcePermission",
                    Stock.class);

    /**
     * The portlet resource permission for the stocks domain area.
     */
    private static volatile PortletResourcePermission _portletResourcePermission =
            PortletResourcePermissionFactory.getInstance(StockServiceImpl.class, "_portletResourcePermission",
                    StocksConstants.RESOURCE_NAME);
}