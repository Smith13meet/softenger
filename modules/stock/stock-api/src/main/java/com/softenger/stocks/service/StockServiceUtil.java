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

import com.liferay.portal.kernel.exception.PortalException;

import com.softenger.stocks.model.Stock;

/**
 * Provides the remote service utility for Stock. This utility wraps
 * <code>com.softenger.stocks.service.impl.StockServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see StockService
 * @generated
 */
public class StockServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.softenger.stocks.service.impl.StockServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Stock addStock(
			String name, int quantity,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addStock(name, quantity, serviceContext);
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
	public static Stock deleteStock(long stockId) throws PortalException {
		return getService().deleteStock(stockId);
	}

	/**
	 * Deletes the given stock completely.
	 *
	 * @param stock the stock to delete.
	 * @return the deleted stock.
	 * @throws PrincipalException if permission check fails.
	 * @throws PortalException    if something's gone wrong.
	 */
	public static Stock deleteStock(Stock stock) throws PortalException {
		return getService().deleteStock(stock);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
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
	public static Stock getStock(long stockId) throws PortalException {
		return getService().getStock(stockId);
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
	public static Stock updateStock(
			long stockId, String name, int quantity,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateStock(
			stockId, name, quantity, serviceContext);
	}

	public static StockService getService() {
		return _service;
	}

	private static volatile StockService _service;

}