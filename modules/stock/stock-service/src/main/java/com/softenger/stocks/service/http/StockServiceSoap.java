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

package com.softenger.stocks.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.softenger.stocks.service.StockServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>StockServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.softenger.stocks.model.StockSoap</code>. If the method in the
 * service utility returns a
 * <code>com.softenger.stocks.model.Stock</code>, that is translated to a
 * <code>com.softenger.stocks.model.StockSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StockServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class StockServiceSoap {

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
	public static com.softenger.stocks.model.StockSoap addStock(
			String name, int quantity,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.softenger.stocks.model.Stock returnValue =
				StockServiceUtil.addStock(name, quantity, serviceContext);

			return com.softenger.stocks.model.StockSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
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
	public static com.softenger.stocks.model.StockSoap updateStock(
			long stockId, String name, int quantity,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.softenger.stocks.model.Stock returnValue =
				StockServiceUtil.updateStock(
					stockId, name, quantity, serviceContext);

			return com.softenger.stocks.model.StockSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	/**
	 * Deletes the given stock completely.
	 *
	 * @param stock the stock to delete.
	 * @return the deleted stock.
	 * @throws PrincipalException if permission check fails.
	 * @throws PortalException    if something's gone wrong.
	 */
	public static com.softenger.stocks.model.StockSoap deleteStock(
			com.softenger.stocks.model.StockSoap stock)
		throws RemoteException {

		try {
			com.softenger.stocks.model.Stock returnValue =
				StockServiceUtil.deleteStock(
					com.softenger.stocks.model.impl.StockModelImpl.toModel(
						stock));

			return com.softenger.stocks.model.StockSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
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
	public static com.softenger.stocks.model.StockSoap deleteStock(long stockId)
		throws RemoteException {

		try {
			com.softenger.stocks.model.Stock returnValue =
				StockServiceUtil.deleteStock(stockId);

			return com.softenger.stocks.model.StockSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
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
	public static com.softenger.stocks.model.StockSoap getStock(long stockId)
		throws RemoteException {

		try {
			com.softenger.stocks.model.Stock returnValue =
				StockServiceUtil.getStock(stockId);

			return com.softenger.stocks.model.StockSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(StockServiceSoap.class);

}