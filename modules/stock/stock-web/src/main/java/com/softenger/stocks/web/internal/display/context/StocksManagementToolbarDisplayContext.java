package com.softenger.stocks.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.softenger.stocks.constants.StocksActionKeys;
import com.softenger.stocks.model.Stock;
import com.softenger.stocks.web.internal.constants.StocksWebKeys;
import com.softenger.stocks.web.internal.security.permission.resource.StocksPortletPermission;

import javax.portlet.PortletURL;
import javax.portlet.RenderURL;
import javax.portlet.WindowStateException;

import static com.liferay.petra.string.StringPool.BLANK;
import static com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY;
import static javax.portlet.WindowState.MAXIMIZED;

/**
 * The display context for the management toolbar for the list of stocks.
 *
 * @author Enterra GmbH
 */
public class StocksManagementToolbarDisplayContext extends SearchContainerManagementToolbarDisplayContext {

    /**
     * The parent display context.
     */
    private final StocksDisplayContext _stocksDisplayContext;

    /**
     * The theme display related to an actual portlet request.
     */
    private final ThemeDisplay _themeDisplay;

    public StocksManagementToolbarDisplayContext(
            final LiferayPortletRequest liferayPortletRequest, final LiferayPortletResponse liferayPortletResponse,
            final SearchContainer<Stock> searchContainer,
            final StocksDisplayContext stocksDisplayContext) {
        super(liferayPortletRequest.getHttpServletRequest(), liferayPortletRequest, liferayPortletResponse,
                searchContainer);

        this._themeDisplay = (ThemeDisplay) liferayPortletRequest.getAttribute(THEME_DISPLAY);
        this._stocksDisplayContext = stocksDisplayContext;
    }

    @Override
    public Boolean isSelectable() {
        return false;
    }

    /**
     * @return the creation menu for the management bar.
     */
    @Override
    public CreationMenu getCreationMenu() {
        try {
            final RenderURL addURL = liferayPortletResponse.createRenderURL();
            addURL.setWindowState(MAXIMIZED);
            addURL.setParameter("mvcRenderCommandName", StocksWebKeys.ADD_STOCK_RENDER_COMMAND);
            addURL.setParameter("returnToFullPageURL", PortalUtil.getCurrentURL(liferayPortletRequest));

            return CreationMenuBuilder.addPrimaryDropdownItem(
                    dropdownItem -> {
                        dropdownItem.setHref(addURL.toString());
                        dropdownItem.setLabel("add");
                    }
            ).build();
        } catch (final WindowStateException ignored) {
        }
        return null;
    }

    @Override
    public String getSearchActionURL() {
        final PortletURL searchActionURL = getPortletURL();
        return searchActionURL.toString();
    }

    @Override
    public String getClearResultsURL() {
        final PortletURL clearResultsURL = getPortletURL();
        clearResultsURL.setParameter(getSearchInputName(), BLANK);
        return clearResultsURL.toString();
    }

    @Override
    public String getSearchFormName() {
        return "searchForm";
    }

    @Override
    public String getSearchInputName() {
        return "keyword";
    }

    @Override
    public Boolean isDisabled() {
        return false;
    }

    @Override
    public Boolean isShowCreationMenu() {
        return StocksPortletPermission.contains(_themeDisplay.getPermissionChecker(),
                _themeDisplay.getScopeGroupId(),
                StocksActionKeys.ADD_STOCK);
    }

    @Override
    protected PortletURL getPortletURL() {
        final PortletURL portletURL = super.getPortletURL();

        portletURL.setParameter(searchContainer.getDeltaParam(), Integer.toString(searchContainer.getDelta()));
        portletURL.setParameter(searchContainer.getOrderByColParam(), getOrderByCol());
        portletURL.setParameter(searchContainer.getOrderByTypeParam(), getOrderByType());

        return portletURL;
    }

    @Override
    protected String[] getDisplayViews() {
        return new String[] { "icon", "descriptive", "list" };
    }

    @Override
    protected String[] getOrderByKeys() {
        return new String[] { "name", "created-at", "modified-at" };
    }

    @Override
    protected String getOrderByType() {
        return ParamUtil.getString(liferayPortletRequest, getOrderByTypeParam(), "asc");
    }

    @Override
    protected String getOrderByCol() {
        return ParamUtil.getString(liferayPortletRequest, getOrderByColParam(), "name");
    }

    @Override
    protected String getDefaultDisplayStyle() {
        return _stocksDisplayContext.getDisplayStyle();
    }
}
