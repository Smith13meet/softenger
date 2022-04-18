package com.softenger.stocks.constants;

/**
 * The set of social activity types in the {@link StocksConstants#RESOURCE_NAME} resources domain.
 *
 * @author Meet
 */
public final class StocksActivityKeys {
    /**
     * The id of a social activity that means a stock was added by a user.
     */
    public static final int ADD_STOCK = 1;

    /**
     * The id of a social activity that means a stock was updated by a user.
     */
    public static final int UPDATE_STOCK = 2;

    /**
     * Private constructor to block instantiation.
     */
    private StocksActivityKeys() {
    }
}
