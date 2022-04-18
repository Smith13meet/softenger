package com.softenger.stocks.web.internal.portlet.render;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.softenger.stocks.constants.StocksActionKeys;
import com.softenger.stocks.constants.StocksPortletKeys;
import com.softenger.stocks.web.internal.constants.StocksWebKeys;
import com.softenger.stocks.web.internal.security.permission.resource.StocksPortletPermission;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StocksPortletKeys.STOCKS_PORTLET,
                "mvc.command.name=" + StocksWebKeys.ADD_STOCK_RENDER_COMMAND
        },
        service = MVCRenderCommand.class
)
public class AddStockMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(
            final RenderRequest renderRequest,
            final RenderResponse renderResponse) throws PortletException {
        final ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try {
            StocksPortletPermission.check(themeDisplay.getPermissionChecker(), themeDisplay.getScopeGroupId(),
                    StocksActionKeys.ADD_STOCK);
        } catch (PrincipalException e) {
            _log.error(e);
            SessionErrors.add(renderRequest, e.getClass());
            return "/error.jsp";
        }

        return "/stocks/edit_stock.jsp";
    }

    private static final Log _log = LogFactoryUtil.getLog(AddStockMVCRenderCommand.class);
}