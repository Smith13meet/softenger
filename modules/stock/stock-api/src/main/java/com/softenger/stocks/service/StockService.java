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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import com.softenger.stocks.model.Stock;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Stock. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see StockServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface StockService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.softenger.stocks.service.impl.StockServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the stock remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link StockServiceUtil} if injection and service tracking are not available.
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
	public Stock addStock(
			String name, int quantity, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Deletes a stock given by its id completely.
	 *
	 * @param stockId the id of a stock to delete.
	 * @return the deleted stock.
	 * @throws NoSuchStockException if no stock with the given id exists.
	 * @throws PrincipalException   if permission check fails.
	 * @throws PortalException      if something's gone wrong.
	 */
	public Stock deleteStock(long stockId) throws PortalException;

	/**
	 * Deletes the given stock completely.
	 *
	 * @param stock the stock to delete.
	 * @return the deleted stock.
	 * @throws PrincipalException if permission check fails.
	 * @throws PortalException    if something's gone wrong.
	 */
	public Stock deleteStock(Stock stock) throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * Retrieves a stock identified by its <code>stockId</code>.
	 *
	 * @param stockId the id of the stock to be retrieved.
	 * @return the retrieved stock.
	 * @throws NoSuchStockException if no stock with the given id exists.
	 * @throws PrincipalException   if permission check fails.
	 * @throws PortalException      if something's gone wrong.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Stock getStock(long stockId) throws PortalException;

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
	public Stock updateStock(
			long stockId, String name, int quantity,
			ServiceContext serviceContext)
		throws PortalException;

}