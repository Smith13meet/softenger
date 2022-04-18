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

package com.softenger.stocks.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.softenger.stocks.model.Stock;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the stock service. This utility wraps <code>com.softenger.stocks.service.persistence.impl.StockPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StockPersistence
 * @generated
 */
public class StockUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Stock stock) {
		getPersistence().clearCache(stock);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Stock> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Stock> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Stock> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Stock> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Stock> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Stock update(Stock stock) {
		return getPersistence().update(stock);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Stock update(Stock stock, ServiceContext serviceContext) {
		return getPersistence().update(stock, serviceContext);
	}

	/**
	 * Returns all the stocks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching stocks
	 */
	public static List<Stock> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the stocks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @return the range of matching stocks
	 */
	public static List<Stock> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the stocks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stocks
	 */
	public static List<Stock> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Stock> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stocks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stocks
	 */
	public static List<Stock> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Stock> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stock in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public static Stock findByUuid_First(
			String uuid, OrderByComparator<Stock> orderByComparator)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first stock in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public static Stock fetchByUuid_First(
		String uuid, OrderByComparator<Stock> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last stock in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public static Stock findByUuid_Last(
			String uuid, OrderByComparator<Stock> orderByComparator)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last stock in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public static Stock fetchByUuid_Last(
		String uuid, OrderByComparator<Stock> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the stocks before and after the current stock in the ordered set where uuid = &#63;.
	 *
	 * @param stockId the primary key of the current stock
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stock
	 * @throws NoSuchStockException if a stock with the primary key could not be found
	 */
	public static Stock[] findByUuid_PrevAndNext(
			long stockId, String uuid,
			OrderByComparator<Stock> orderByComparator)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().findByUuid_PrevAndNext(
			stockId, uuid, orderByComparator);
	}

	/**
	 * Removes all the stocks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of stocks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching stocks
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the stock where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStockException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public static Stock findByUUID_G(String uuid, long groupId)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the stock where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public static Stock fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the stock where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public static Stock fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the stock where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the stock that was removed
	 */
	public static Stock removeByUUID_G(String uuid, long groupId)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of stocks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching stocks
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the stocks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching stocks
	 */
	public static List<Stock> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the stocks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @return the range of matching stocks
	 */
	public static List<Stock> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the stocks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stocks
	 */
	public static List<Stock> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Stock> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stocks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stocks
	 */
	public static List<Stock> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Stock> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stock in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public static Stock findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Stock> orderByComparator)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first stock in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public static Stock fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Stock> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last stock in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public static Stock findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Stock> orderByComparator)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last stock in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public static Stock fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Stock> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the stocks before and after the current stock in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param stockId the primary key of the current stock
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stock
	 * @throws NoSuchStockException if a stock with the primary key could not be found
	 */
	public static Stock[] findByUuid_C_PrevAndNext(
			long stockId, String uuid, long companyId,
			OrderByComparator<Stock> orderByComparator)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().findByUuid_C_PrevAndNext(
			stockId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the stocks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of stocks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching stocks
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the stocks where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching stocks
	 */
	public static List<Stock> findByGroupIdAndStatus(long groupId, int status) {
		return getPersistence().findByGroupIdAndStatus(groupId, status);
	}

	/**
	 * Returns a range of all the stocks where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @return the range of matching stocks
	 */
	public static List<Stock> findByGroupIdAndStatus(
		long groupId, int status, int start, int end) {

		return getPersistence().findByGroupIdAndStatus(
			groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the stocks where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stocks
	 */
	public static List<Stock> findByGroupIdAndStatus(
		long groupId, int status, int start, int end,
		OrderByComparator<Stock> orderByComparator) {

		return getPersistence().findByGroupIdAndStatus(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stocks where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stocks
	 */
	public static List<Stock> findByGroupIdAndStatus(
		long groupId, int status, int start, int end,
		OrderByComparator<Stock> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupIdAndStatus(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stock in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public static Stock findByGroupIdAndStatus_First(
			long groupId, int status,
			OrderByComparator<Stock> orderByComparator)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().findByGroupIdAndStatus_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first stock in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public static Stock fetchByGroupIdAndStatus_First(
		long groupId, int status, OrderByComparator<Stock> orderByComparator) {

		return getPersistence().fetchByGroupIdAndStatus_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last stock in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public static Stock findByGroupIdAndStatus_Last(
			long groupId, int status,
			OrderByComparator<Stock> orderByComparator)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().findByGroupIdAndStatus_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last stock in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public static Stock fetchByGroupIdAndStatus_Last(
		long groupId, int status, OrderByComparator<Stock> orderByComparator) {

		return getPersistence().fetchByGroupIdAndStatus_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the stocks before and after the current stock in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param stockId the primary key of the current stock
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stock
	 * @throws NoSuchStockException if a stock with the primary key could not be found
	 */
	public static Stock[] findByGroupIdAndStatus_PrevAndNext(
			long stockId, long groupId, int status,
			OrderByComparator<Stock> orderByComparator)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().findByGroupIdAndStatus_PrevAndNext(
			stockId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the stocks that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching stocks that the user has permission to view
	 */
	public static List<Stock> filterFindByGroupIdAndStatus(
		long groupId, int status) {

		return getPersistence().filterFindByGroupIdAndStatus(groupId, status);
	}

	/**
	 * Returns a range of all the stocks that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @return the range of matching stocks that the user has permission to view
	 */
	public static List<Stock> filterFindByGroupIdAndStatus(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByGroupIdAndStatus(
			groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the stocks that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stocks that the user has permission to view
	 */
	public static List<Stock> filterFindByGroupIdAndStatus(
		long groupId, int status, int start, int end,
		OrderByComparator<Stock> orderByComparator) {

		return getPersistence().filterFindByGroupIdAndStatus(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the stocks before and after the current stock in the ordered set of stocks that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param stockId the primary key of the current stock
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stock
	 * @throws NoSuchStockException if a stock with the primary key could not be found
	 */
	public static Stock[] filterFindByGroupIdAndStatus_PrevAndNext(
			long stockId, long groupId, int status,
			OrderByComparator<Stock> orderByComparator)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().filterFindByGroupIdAndStatus_PrevAndNext(
			stockId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the stocks where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByGroupIdAndStatus(long groupId, int status) {
		getPersistence().removeByGroupIdAndStatus(groupId, status);
	}

	/**
	 * Returns the number of stocks where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching stocks
	 */
	public static int countByGroupIdAndStatus(long groupId, int status) {
		return getPersistence().countByGroupIdAndStatus(groupId, status);
	}

	/**
	 * Returns the number of stocks that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching stocks that the user has permission to view
	 */
	public static int filterCountByGroupIdAndStatus(long groupId, int status) {
		return getPersistence().filterCountByGroupIdAndStatus(groupId, status);
	}

	/**
	 * Returns all the stocks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching stocks
	 */
	public static List<Stock> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the stocks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @return the range of matching stocks
	 */
	public static List<Stock> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the stocks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stocks
	 */
	public static List<Stock> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Stock> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stocks where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching stocks
	 */
	public static List<Stock> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Stock> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first stock in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public static Stock findByGroupId_First(
			long groupId, OrderByComparator<Stock> orderByComparator)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first stock in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public static Stock fetchByGroupId_First(
		long groupId, OrderByComparator<Stock> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last stock in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public static Stock findByGroupId_Last(
			long groupId, OrderByComparator<Stock> orderByComparator)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last stock in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public static Stock fetchByGroupId_Last(
		long groupId, OrderByComparator<Stock> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the stocks before and after the current stock in the ordered set where groupId = &#63;.
	 *
	 * @param stockId the primary key of the current stock
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stock
	 * @throws NoSuchStockException if a stock with the primary key could not be found
	 */
	public static Stock[] findByGroupId_PrevAndNext(
			long stockId, long groupId,
			OrderByComparator<Stock> orderByComparator)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().findByGroupId_PrevAndNext(
			stockId, groupId, orderByComparator);
	}

	/**
	 * Returns all the stocks that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching stocks that the user has permission to view
	 */
	public static List<Stock> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the stocks that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @return the range of matching stocks that the user has permission to view
	 */
	public static List<Stock> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the stocks that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching stocks that the user has permission to view
	 */
	public static List<Stock> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Stock> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the stocks before and after the current stock in the ordered set of stocks that the user has permission to view where groupId = &#63;.
	 *
	 * @param stockId the primary key of the current stock
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stock
	 * @throws NoSuchStockException if a stock with the primary key could not be found
	 */
	public static Stock[] filterFindByGroupId_PrevAndNext(
			long stockId, long groupId,
			OrderByComparator<Stock> orderByComparator)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			stockId, groupId, orderByComparator);
	}

	/**
	 * Removes all the stocks where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of stocks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching stocks
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of stocks that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching stocks that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Caches the stock in the entity cache if it is enabled.
	 *
	 * @param stock the stock
	 */
	public static void cacheResult(Stock stock) {
		getPersistence().cacheResult(stock);
	}

	/**
	 * Caches the stocks in the entity cache if it is enabled.
	 *
	 * @param stocks the stocks
	 */
	public static void cacheResult(List<Stock> stocks) {
		getPersistence().cacheResult(stocks);
	}

	/**
	 * Creates a new stock with the primary key. Does not add the stock to the database.
	 *
	 * @param stockId the primary key for the new stock
	 * @return the new stock
	 */
	public static Stock create(long stockId) {
		return getPersistence().create(stockId);
	}

	/**
	 * Removes the stock with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stockId the primary key of the stock
	 * @return the stock that was removed
	 * @throws NoSuchStockException if a stock with the primary key could not be found
	 */
	public static Stock remove(long stockId)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().remove(stockId);
	}

	public static Stock updateImpl(Stock stock) {
		return getPersistence().updateImpl(stock);
	}

	/**
	 * Returns the stock with the primary key or throws a <code>NoSuchStockException</code> if it could not be found.
	 *
	 * @param stockId the primary key of the stock
	 * @return the stock
	 * @throws NoSuchStockException if a stock with the primary key could not be found
	 */
	public static Stock findByPrimaryKey(long stockId)
		throws com.softenger.stocks.exception.NoSuchStockException {

		return getPersistence().findByPrimaryKey(stockId);
	}

	/**
	 * Returns the stock with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stockId the primary key of the stock
	 * @return the stock, or <code>null</code> if a stock with the primary key could not be found
	 */
	public static Stock fetchByPrimaryKey(long stockId) {
		return getPersistence().fetchByPrimaryKey(stockId);
	}

	/**
	 * Returns all the stocks.
	 *
	 * @return the stocks
	 */
	public static List<Stock> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the stocks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @return the range of stocks
	 */
	public static List<Stock> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the stocks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of stocks
	 */
	public static List<Stock> findAll(
		int start, int end, OrderByComparator<Stock> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the stocks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StockModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of stocks
	 * @param end the upper bound of the range of stocks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of stocks
	 */
	public static List<Stock> findAll(
		int start, int end, OrderByComparator<Stock> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the stocks from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of stocks.
	 *
	 * @return the number of stocks
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StockPersistence getPersistence() {
		return _persistence;
	}

	private static volatile StockPersistence _persistence;

}