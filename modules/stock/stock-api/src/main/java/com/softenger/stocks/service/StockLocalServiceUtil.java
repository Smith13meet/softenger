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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.softenger.stocks.model.Stock;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Stock. This utility wraps
 * <code>com.softenger.stocks.service.impl.StockLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StockLocalService
 * @generated
 */
public class StockLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.softenger.stocks.service.impl.StockLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
	public static Stock addStock(Stock stock) {
		return getService().addStock(stock);
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
	public static Stock addStock(
			String name, int quantity,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addStock(name, quantity, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new stock with the primary key. Does not add the stock to the database.
	 *
	 * @param stockId the primary key for the new stock
	 * @return the new stock
	 */
	public static Stock createStock(long stockId) {
		return getService().createStock(stockId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

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
	public static Stock deleteStock(long stockId) throws PortalException {
		return getService().deleteStock(stockId);
	}

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
	public static Stock deleteStock(Stock stock) throws PortalException {
		return getService().deleteStock(stock);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Stock fetchStock(long stockId) {
		return getService().fetchStock(stockId);
	}

	/**
	 * Returns the stock matching the UUID and group.
	 *
	 * @param uuid the stock's UUID
	 * @param groupId the primary key of the group
	 * @return the matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public static Stock fetchStockByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchStockByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the stock with the primary key.
	 *
	 * @param stockId the primary key of the stock
	 * @return the stock
	 * @throws PortalException if a stock with the primary key could not be found
	 */
	public static Stock getStock(long stockId) throws PortalException {
		return getService().getStock(stockId);
	}

	/**
	 * Returns the stock matching the UUID and group.
	 *
	 * @param uuid the stock's UUID
	 * @param groupId the primary key of the group
	 * @return the matching stock
	 * @throws PortalException if a matching stock could not be found
	 */
	public static Stock getStockByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getStockByUuidAndGroupId(uuid, groupId);
	}

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
	public static List<Stock> getStocks(int start, int end) {
		return getService().getStocks(start, end);
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
	public static List<Stock> getStocks(long groupId, int start, int end) {
		return getService().getStocks(groupId, start, end);
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
	public static List<Stock> getStocks(
		long groupId, int status, int start, int end) {

		return getService().getStocks(groupId, status, start, end);
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
	public static List<Stock> getStocks(
		long groupId, int status, int start, int end,
		OrderByComparator<Stock> orderByComparator) {

		return getService().getStocks(
			groupId, status, start, end, orderByComparator);
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
	public static List<Stock> getStocks(
		long groupId, int start, int end,
		OrderByComparator<Stock> orderByComparator) {

		return getService().getStocks(groupId, start, end, orderByComparator);
	}

	/**
	 * Returns all the stocks matching the UUID and company.
	 *
	 * @param uuid the UUID of the stocks
	 * @param companyId the primary key of the company
	 * @return the matching stocks, or an empty list if no matches were found
	 */
	public static List<Stock> getStocksByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getStocksByUuidAndCompanyId(uuid, companyId);
	}

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
	public static List<Stock> getStocksByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Stock> orderByComparator) {

		return getService().getStocksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of stocks.
	 *
	 * @return the number of stocks
	 */
	public static int getStocksCount() {
		return getService().getStocksCount();
	}

	/**
	 * Counts stocks in a site given by <code>groupId</code> and with the status
	 * {@link WorkflowConstants#STATUS_APPROVED}.
	 *
	 * @param groupId the id of a site to which stocks belong.
	 * @return the number of matching stocks.
	 */
	public static int getStocksCount(long groupId) {
		return getService().getStocksCount(groupId);
	}

	/**
	 * Counts stocks in a site given by <code>groupId</code> and with the given <code>status</code>.
	 *
	 * @param groupId the id of a site to which stocks belong.
	 * @param status  the Liferay status value for filtering.
	 * @return the number of matching stocks.
	 */
	public static int getStocksCount(long groupId, int status) {
		return getService().getStocksCount(groupId, status);
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
	public static Stock updateStatus(long userId, long stockId, int status)
		throws PortalException {

		return getService().updateStatus(userId, stockId, status);
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
	public static Stock updateStock(Stock stock) {
		return getService().updateStock(stock);
	}

	public static StockLocalService getService() {
		return _service;
	}

	private static volatile StockLocalService _service;

}