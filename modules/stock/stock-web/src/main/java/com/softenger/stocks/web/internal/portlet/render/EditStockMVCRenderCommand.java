package com.softenger.stocks.web.internal.portlet.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.softenger.stocks.constants.StocksPortletKeys;
import com.softenger.stocks.exception.NoSuchStockException;
import com.softenger.stocks.model.Stock;
import com.softenger.stocks.service.StockService;
import com.softenger.stocks.web.internal.constants.StocksWebKeys;
import com.softenger.stocks.web.internal.security.permission.resource.StockPermission;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StocksPortletKeys.STOCKS_PORTLET,
                "mvc.command.name=" + StocksWebKeys.EDIT_STOCK_RENDER_COMMAND
        },
        service = MVCRenderCommand.class
)
public class EditStockMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(
            final RenderRequest renderRequest,
            final RenderResponse renderResponse) throws PortletException {
        final ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        final long stockId = ParamUtil.getLong(renderRequest, StocksWebKeys.STOCK_ID_PARAM_NAME);
        try {
            final Stock stock = _stockService.getStock(stockId);

            StockPermission.check(themeDisplay.getPermissionChecker(), stock, ActionKeys.UPDATE);

            renderRequest.setAttribute(StocksWebKeys.STOCK, stock);

            return "/stocks/edit_stock.jsp";
        } catch (final NoSuchStockException | PrincipalException e) {
            _log.error(e);
            SessionErrors.add(renderRequest, e.getClass());
            return "/error.jsp";
        } catch (final PortalException e) {
            throw new PortletException(e);
        }
    }

    @Reference
    private StockService _stockService;

    private static final Log _log = LogFactoryUtil.getLog(EditStockMVCRenderCommand.class);
}