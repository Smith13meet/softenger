package com.softenger.stocks.web.internal.constants;

import com.softenger.stocks.model.Stock;
import com.softenger.stocks.web.internal.portlet.StocksPortlet;

/**
 * The keys specific for stocks.
 *
 * @author Meet
 */
public final class StocksWebKeys {

    /**
     * The category name for the {@link StocksPortlet}.
     */
    public static final String PROJECTS_PORTLET_CATEGORY = "root//Softenger//Stocks";

    /**
     * The key of a {@link Stock} instance in the request attributes.
     */
    public static final String STOCK = "stock";

    /**
     * The key of a {@link com.softenger.stocks.web.internal.display.context.StocksDisplayContext} instance in the request attributes.
     */
    public static final String STOCKS_DISPLAY_CONTEXT = "STOCKS_DISPLAY_CONTEXT";

    /**
     * The name of a resource command to search stocks.
     */
    public static final String SEARCH_RESOURCE_COMMAND = "/stocks/search";

    /**
     * The name of a parameter for the id of a stock.
     */
    public static final String STOCK_ID_PARAM_NAME = "stockId";

    /**
     * The name of an action command to add a new stock.
     */
    public static final String ADD_STOCK_ACTION_COMMAND = "/stock/add";

    /**
     * The name of an action command to update an existing stock.
     */
    public static final String EDIT_STOCK_ACTION_COMMAND = "/stock/update";

    /**
     * The name of an action command to delete an existing stock.
     */
    public static final String DELETE_STOCK_ACTION_COMMAND = "/stock/delete";

    /**
     * The name of a render command to edit a stock.
     */
    public static final String EDIT_STOCK_RENDER_COMMAND = "/stock/edit";

    /**
     * The name of a render command to add a stock.
     */
    public static final String ADD_STOCK_RENDER_COMMAND = "/stock/new";

    /**
     * The name of a render command to view a stock.
     */
    public static final String VIEW_STOCK_RENDER_COMMAND = "/stock/view";

    /**
     * Private constructor to block instantiation.
     */
    private StocksWebKeys() {
    }

}
