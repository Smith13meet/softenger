package com.softenger.stocks.web.internal.display.context;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.softenger.stocks.constants.StocksPortletKeys;
import com.softenger.stocks.model.Stock;
import com.softenger.stocks.model.impl.StockModelImpl;
import com.softenger.stocks.service.StockLocalServiceUtil;
import javaslang.Lazy;

import javax.portlet.PortletURL;
import javax.portlet.RenderURL;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.liferay.petra.string.StringPool.BLANK;
import static com.liferay.portal.kernel.util.WebKeys.SINGLE_PAGE_APPLICATION_CLEAR_CACHE;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * The display context for a list of stocks.
 *
 * @author Enterra GmbH
 */
public class StocksDisplayContext {

    /**
     * The actual request.
     */
    private final LiferayPortletRequest _liferayPortletRequest;

    /**
     * The actual response.
     */
    private final LiferayPortletResponse _liferayPortletResponse;

    /**
     * The theme display related to an actual portlet request.
     */
    private final ThemeDisplay _themeDisplay;

    /**
     * The search container for the page which lists learning story.
     */
    private final Lazy<SearchContainer<Stock>> _searchContainer;

    /**
     * The keyword to filter learning story by.
     */
    private final String _keyword;

    /**
     * The display style based on user preference.
     */
    private final String _displayStyle;

    /**
     * The management toolbar display context.
     */
    private final StocksManagementToolbarDisplayContext _managementToolbarDisplayContext;

    public StocksDisplayContext(
            final LiferayPortletRequest liferayPortletRequest, final LiferayPortletResponse liferayPortletResponse)
            throws PortalException {
        checkNotNull(liferayPortletRequest, "Argument 'liferayPortletRequest' cannot be null");
        checkNotNull(liferayPortletResponse, "Argument 'liferayPortletResponse' cannot be null");

        _liferayPortletRequest = liferayPortletRequest;
        _liferayPortletResponse = liferayPortletResponse;
        _themeDisplay = (ThemeDisplay) liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
        _keyword = ParamUtil.getString(liferayPortletRequest, "keyword", BLANK);
        final PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(
                liferayPortletRequest);

        String displayStyle = ParamUtil.getString(liferayPortletRequest, "displayStyle");
        if (Validator.isBlank(displayStyle)) {
            displayStyle = portalPreferences.getValue(StocksPortletKeys.STOCKS_PORTLET,
                    "display-style",
                    "list");
        } else {
            portalPreferences.setValue(StocksPortletKeys.STOCKS_PORTLET, "display-style",
                    displayStyle);
            liferayPortletRequest.setAttribute(SINGLE_PAGE_APPLICATION_CLEAR_CACHE, Boolean.TRUE);
        }

        this._displayStyle = displayStyle;
        this._searchContainer = Lazy.of(() -> {
            try {
                final RenderURL iteratorUrl = liferayPortletResponse.createRenderURL();
                iteratorUrl.setParameter("displayStyle", _displayStyle);
                if (isNotBlank(_keyword)) {
                    iteratorUrl.setParameter("keyword", _keyword);
                }
                final SearchContainer<Stock> searchContainer = new SearchContainer<>(liferayPortletRequest,
                        iteratorUrl, null, "no-stocks-were-found");

                final int start = searchContainer.getStart();
                final int end = searchContainer.getEnd();
                final OrderByComparator<Stock> orderByComparator;

                final String orderByCol = ParamUtil.getString(liferayPortletRequest,
                        searchContainer.getOrderByColParam(), "name");
                final String orderByType = ParamUtil.getString(liferayPortletRequest,
                        searchContainer.getOrderByTypeParam(), "asc");

                final String column;
                switch (orderByCol) {
                    case "name":
                    default:
                        column = "name";
                        break;
                    case "created-at":
                        column = "createDate";
                        break;
                    case "modified-at":
                        column = "modifiedDate";
                        break;
                }

                orderByComparator = OrderByComparatorFactoryUtil.create(StockModelImpl.TABLE_NAME, column,
                        orderByType.equals("asc"));

                searchContainer.setForcePost(true);
                searchContainer.setClassName(Stock.class.getName());

                final int stocksCount = StockLocalServiceUtil.getStocksCount(_themeDisplay.getScopeGroupId());
                final List<Stock> stocks = StockLocalServiceUtil.getStocks(_themeDisplay.getScopeGroupId(), start, end,
                        orderByComparator);

                searchContainer.setTotal(stocksCount);
                searchContainer.setResults(stocks);

                return searchContainer;
            } catch (final Exception e) {
                throw new SystemException("Failed to fetch stocks", e);
            }
        });

        this._managementToolbarDisplayContext = new StocksManagementToolbarDisplayContext(
                liferayPortletRequest,
                liferayPortletResponse, _searchContainer.get(), this);

    }

    /**
     * Constructs a portlet URL to render stocks with the pagination settings of the search container.
     *
     * @return the portlet URL to render stocks list.
     */
    public PortletURL createPaginationUrl() {
        final PortletURL result = _liferayPortletResponse.createActionURL();
        result.setParameter(getSearchContainer().getDeltaParam(), Integer.toString(getSearchContainer().getDelta()));
        result.setParameter(getSearchContainer().getOrderByColParam(), getSearchContainer().getOrderByCol());
        result.setParameter(getSearchContainer().getOrderByTypeParam(), getSearchContainer().getOrderByType());
        return result;
    }

    /**
     * @return the search container that lists stocks.
     */
    public SearchContainer<Stock> getSearchContainer() {
        return _searchContainer.get();
    }

    /**
     * @return the current display style.
     */
    public String getDisplayStyle() {
        return _displayStyle;
    }

    /**
     * @return the management toolbar display context.
     */
    public StocksManagementToolbarDisplayContext getManagementToolbarDisplayContext() {
        return _managementToolbarDisplayContext;
    }

}
