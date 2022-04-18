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
 * Provides a wrapper for {@link StockLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StockLocalService
 * @generated
 */
public class StockLocalServiceWrapper
	implements ServiceWrapper<StockLocalService>, StockLocalService {

	public StockLocalServiceWrapper(StockLocalService stockLocalService) {
		_stockLocalService = stockLocalService;
	}

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
	@Override
	public com.softenger.stocks.model.Stock addStock(
		com.softenger.stocks.model.Stock stock) {

		return _stockLocalService.addStock(stock);
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

		return _stockLocalService.addStock(name, quantity, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new stock with the primary key. Does not add the stock to the database.
	 *
	 * @param stockId the primary key for the new stock
	 * @return the new stock
	 */
	@Override
	public com.softenger.stocks.model.Stock createStock(long stockId) {
		return _stockLocalService.createStock(stockId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.softenger.stocks.model.Stock deleteStock(long stockId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockLocalService.deleteStock(stockId);
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
	@Override
	public com.softenger.stocks.model.Stock deleteStock(
			com.softenger.stocks.model.Stock stock)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockLocalService.deleteStock(stock);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stockLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _stockLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _stockLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _stockLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _stockLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _stockLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.softenger.stocks.model.Stock fetchStock(long stockId) {
		return _stockLocalService.fetchStock(stockId);
	}

	/**
	 * Returns the stock matching the UUID and group.
	 *
	 * @param uuid the stock's UUID
	 * @param groupId the primary key of the group
	 * @return the matching stock, or <code>null</code> if a matching stock could not be found
	 */
	@Override
	public com.softenger.stocks.model.Stock fetchStockByUuidAndGroupId(
		String uuid, long groupId) {

		return _stockLocalService.fetchStockByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stockLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _stockLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stockLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stockLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the stock with the primary key.
	 *
	 * @param stockId the primary key of the stock
	 * @return the stock
	 * @throws PortalException if a stock with the primary key could not be found
	 */
	@Override
	public com.softenger.stocks.model.Stock getStock(long stockId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockLocalService.getStock(stockId);
	}

	/**
	 * Returns the stock matching the UUID and group.
	 *
	 * @param uuid the stock's UUID
	 * @param groupId the primary key of the group
	 * @return the matching stock
	 * @throws PortalException if a matching stock could not be found
	 */
	@Override
	public com.softenger.stocks.model.Stock getStockByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockLocalService.getStockByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.softenger.stocks.model.Stock> getStocks(
		int start, int end) {

		return _stockLocalService.getStocks(start, end);
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
	@Override
	public java.util.List<com.softenger.stocks.model.Stock> getStocks(
		long groupId, int start, int end) {

		return _stockLocalService.getStocks(groupId, start, end);
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
	@Override
	public java.util.List<com.softenger.stocks.model.Stock> getStocks(
		long groupId, int status, int start, int end) {

		return _stockLocalService.getStocks(groupId, status, start, end);
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
	@Override
	public java.util.List<com.softenger.stocks.model.Stock> getStocks(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.softenger.stocks.model.Stock> orderByComparator) {

		return _stockLocalService.getStocks(
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
	@Override
	public java.util.List<com.softenger.stocks.model.Stock> getStocks(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.softenger.stocks.model.Stock> orderByComparator) {

		return _stockLocalService.getStocks(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns all the stocks matching the UUID and company.
	 *
	 * @param uuid the UUID of the stocks
	 * @param companyId the primary key of the company
	 * @return the matching stocks, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.softenger.stocks.model.Stock>
		getStocksByUuidAndCompanyId(String uuid, long companyId) {

		return _stockLocalService.getStocksByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.softenger.stocks.model.Stock>
		getStocksByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.softenger.stocks.model.Stock> orderByComparator) {

		return _stockLocalService.getStocksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of stocks.
	 *
	 * @return the number of stocks
	 */
	@Override
	public int getStocksCount() {
		return _stockLocalService.getStocksCount();
	}

	/**
	 * Counts stocks in a site given by <code>groupId</code> and with the status
	 * {@link WorkflowConstants#STATUS_APPROVED}.
	 *
	 * @param groupId the id of a site to which stocks belong.
	 * @return the number of matching stocks.
	 */
	@Override
	public int getStocksCount(long groupId) {
		return _stockLocalService.getStocksCount(groupId);
	}

	/**
	 * Counts stocks in a site given by <code>groupId</code> and with the given <code>status</code>.
	 *
	 * @param groupId the id of a site to which stocks belong.
	 * @param status  the Liferay status value for filtering.
	 * @return the number of matching stocks.
	 */
	@Override
	public int getStocksCount(long groupId, int status) {
		return _stockLocalService.getStocksCount(groupId, status);
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
	@Override
	public com.softenger.stocks.model.Stock updateStatus(
			long userId, long stockId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stockLocalService.updateStatus(userId, stockId, status);
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

		return _stockLocalService.updateStock(
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
	@Override
	public com.softenger.stocks.model.Stock updateStock(
		com.softenger.stocks.model.Stock stock) {

		return _stockLocalService.updateStock(stock);
	}

	@Override
	public StockLocalService getWrappedService() {
		return _stockLocalService;
	}

	@Override
	public void setWrappedService(StockLocalService stockLocalService) {
		_stockLocalService = stockLocalService;
	}

	private StockLocalService _stockLocalService;

}