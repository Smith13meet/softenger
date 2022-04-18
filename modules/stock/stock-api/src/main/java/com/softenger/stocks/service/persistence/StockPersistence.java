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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.softenger.stocks.exception.NoSuchStockException;
import com.softenger.stocks.model.Stock;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the stock service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StockUtil
 * @generated
 */
@ProviderType
public interface StockPersistence extends BasePersistence<Stock> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StockUtil} to access the stock persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the stocks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching stocks
	 */
	public java.util.List<Stock> findByUuid(String uuid);

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
	public java.util.List<Stock> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Stock> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator);

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
	public java.util.List<Stock> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first stock in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public Stock findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Stock>
				orderByComparator)
		throws NoSuchStockException;

	/**
	 * Returns the first stock in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public Stock fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator);

	/**
	 * Returns the last stock in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public Stock findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Stock>
				orderByComparator)
		throws NoSuchStockException;

	/**
	 * Returns the last stock in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public Stock fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator);

	/**
	 * Returns the stocks before and after the current stock in the ordered set where uuid = &#63;.
	 *
	 * @param stockId the primary key of the current stock
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stock
	 * @throws NoSuchStockException if a stock with the primary key could not be found
	 */
	public Stock[] findByUuid_PrevAndNext(
			long stockId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Stock>
				orderByComparator)
		throws NoSuchStockException;

	/**
	 * Removes all the stocks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of stocks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching stocks
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the stock where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchStockException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public Stock findByUUID_G(String uuid, long groupId)
		throws NoSuchStockException;

	/**
	 * Returns the stock where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public Stock fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the stock where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public Stock fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the stock where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the stock that was removed
	 */
	public Stock removeByUUID_G(String uuid, long groupId)
		throws NoSuchStockException;

	/**
	 * Returns the number of stocks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching stocks
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the stocks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching stocks
	 */
	public java.util.List<Stock> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Stock> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Stock> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator);

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
	public java.util.List<Stock> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first stock in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public Stock findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Stock>
				orderByComparator)
		throws NoSuchStockException;

	/**
	 * Returns the first stock in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public Stock fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator);

	/**
	 * Returns the last stock in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public Stock findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Stock>
				orderByComparator)
		throws NoSuchStockException;

	/**
	 * Returns the last stock in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public Stock fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator);

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
	public Stock[] findByUuid_C_PrevAndNext(
			long stockId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Stock>
				orderByComparator)
		throws NoSuchStockException;

	/**
	 * Removes all the stocks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of stocks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching stocks
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the stocks where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching stocks
	 */
	public java.util.List<Stock> findByGroupIdAndStatus(
		long groupId, int status);

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
	public java.util.List<Stock> findByGroupIdAndStatus(
		long groupId, int status, int start, int end);

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
	public java.util.List<Stock> findByGroupIdAndStatus(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator);

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
	public java.util.List<Stock> findByGroupIdAndStatus(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first stock in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public Stock findByGroupIdAndStatus_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Stock>
				orderByComparator)
		throws NoSuchStockException;

	/**
	 * Returns the first stock in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public Stock fetchByGroupIdAndStatus_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator);

	/**
	 * Returns the last stock in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public Stock findByGroupIdAndStatus_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Stock>
				orderByComparator)
		throws NoSuchStockException;

	/**
	 * Returns the last stock in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public Stock fetchByGroupIdAndStatus_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator);

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
	public Stock[] findByGroupIdAndStatus_PrevAndNext(
			long stockId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Stock>
				orderByComparator)
		throws NoSuchStockException;

	/**
	 * Returns all the stocks that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching stocks that the user has permission to view
	 */
	public java.util.List<Stock> filterFindByGroupIdAndStatus(
		long groupId, int status);

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
	public java.util.List<Stock> filterFindByGroupIdAndStatus(
		long groupId, int status, int start, int end);

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
	public java.util.List<Stock> filterFindByGroupIdAndStatus(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator);

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
	public Stock[] filterFindByGroupIdAndStatus_PrevAndNext(
			long stockId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Stock>
				orderByComparator)
		throws NoSuchStockException;

	/**
	 * Removes all the stocks where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByGroupIdAndStatus(long groupId, int status);

	/**
	 * Returns the number of stocks where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching stocks
	 */
	public int countByGroupIdAndStatus(long groupId, int status);

	/**
	 * Returns the number of stocks that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching stocks that the user has permission to view
	 */
	public int filterCountByGroupIdAndStatus(long groupId, int status);

	/**
	 * Returns all the stocks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching stocks
	 */
	public java.util.List<Stock> findByGroupId(long groupId);

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
	public java.util.List<Stock> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Stock> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator);

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
	public java.util.List<Stock> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first stock in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public Stock findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Stock>
				orderByComparator)
		throws NoSuchStockException;

	/**
	 * Returns the first stock in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public Stock fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator);

	/**
	 * Returns the last stock in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stock
	 * @throws NoSuchStockException if a matching stock could not be found
	 */
	public Stock findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Stock>
				orderByComparator)
		throws NoSuchStockException;

	/**
	 * Returns the last stock in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching stock, or <code>null</code> if a matching stock could not be found
	 */
	public Stock fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator);

	/**
	 * Returns the stocks before and after the current stock in the ordered set where groupId = &#63;.
	 *
	 * @param stockId the primary key of the current stock
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stock
	 * @throws NoSuchStockException if a stock with the primary key could not be found
	 */
	public Stock[] findByGroupId_PrevAndNext(
			long stockId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Stock>
				orderByComparator)
		throws NoSuchStockException;

	/**
	 * Returns all the stocks that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching stocks that the user has permission to view
	 */
	public java.util.List<Stock> filterFindByGroupId(long groupId);

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
	public java.util.List<Stock> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Stock> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator);

	/**
	 * Returns the stocks before and after the current stock in the ordered set of stocks that the user has permission to view where groupId = &#63;.
	 *
	 * @param stockId the primary key of the current stock
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next stock
	 * @throws NoSuchStockException if a stock with the primary key could not be found
	 */
	public Stock[] filterFindByGroupId_PrevAndNext(
			long stockId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Stock>
				orderByComparator)
		throws NoSuchStockException;

	/**
	 * Removes all the stocks where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of stocks where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching stocks
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of stocks that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching stocks that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Caches the stock in the entity cache if it is enabled.
	 *
	 * @param stock the stock
	 */
	public void cacheResult(Stock stock);

	/**
	 * Caches the stocks in the entity cache if it is enabled.
	 *
	 * @param stocks the stocks
	 */
	public void cacheResult(java.util.List<Stock> stocks);

	/**
	 * Creates a new stock with the primary key. Does not add the stock to the database.
	 *
	 * @param stockId the primary key for the new stock
	 * @return the new stock
	 */
	public Stock create(long stockId);

	/**
	 * Removes the stock with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stockId the primary key of the stock
	 * @return the stock that was removed
	 * @throws NoSuchStockException if a stock with the primary key could not be found
	 */
	public Stock remove(long stockId) throws NoSuchStockException;

	public Stock updateImpl(Stock stock);

	/**
	 * Returns the stock with the primary key or throws a <code>NoSuchStockException</code> if it could not be found.
	 *
	 * @param stockId the primary key of the stock
	 * @return the stock
	 * @throws NoSuchStockException if a stock with the primary key could not be found
	 */
	public Stock findByPrimaryKey(long stockId) throws NoSuchStockException;

	/**
	 * Returns the stock with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stockId the primary key of the stock
	 * @return the stock, or <code>null</code> if a stock with the primary key could not be found
	 */
	public Stock fetchByPrimaryKey(long stockId);

	/**
	 * Returns all the stocks.
	 *
	 * @return the stocks
	 */
	public java.util.List<Stock> findAll();

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
	public java.util.List<Stock> findAll(int start, int end);

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
	public java.util.List<Stock> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator);

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
	public java.util.List<Stock> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Stock>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the stocks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of stocks.
	 *
	 * @return the number of stocks
	 */
	public int countAll();

}