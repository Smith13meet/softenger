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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StockService}.
 *
 * @author Brian Wing Shun Chan
 * @see StockService
 * @generated
 */
public class StockServiceWrapper
	implements ServiceWrapper<StockService>, StockService {

	public StockServiceWrapper(StockService stockService) {
		_stockService = stockService;
	}

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
	public com.softenger.stocks.model.Stock addStock(
			String name, int quantity,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockService.addStock(name, quantity, serviceContext);
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
	public com.softenger.stocks.model.Stock deleteStock(long stockId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockService.deleteStock(stockId);
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
	public com.softenger.stocks.model.Stock deleteStock(
			com.softenger.stocks.model.Stock stock)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockService.deleteStock(stock);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stockService.getOSGiServiceIdentifier();
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
	public com.softenger.stocks.model.Stock getStock(long stockId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockService.getStock(stockId);
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
	public com.softenger.stocks.model.Stock updateStock(
			long stockId, String name, int quantity,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockService.updateStock(
			stockId, name, quantity, serviceContext);
	}

	@Override
	public StockService getWrappedService() {
		return _stockService;
	}

	@Override
	public void setWrappedService(StockService stockService) {
		_stockService = stockService;
	}

	private StockService _stockService;

}