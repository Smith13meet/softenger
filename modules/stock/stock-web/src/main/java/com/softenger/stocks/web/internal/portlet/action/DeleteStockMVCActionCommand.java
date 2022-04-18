package com.softenger.stocks.web.internal.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.softenger.stocks.constants.StocksPortletKeys;
import com.softenger.stocks.service.StockService;
import com.softenger.stocks.web.internal.constants.StocksWebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * The action command which delete an existing stock.
 *
 * @author Meet
 */
@Component(
        property = {
                "javax.portlet.name=" + StocksPortletKeys.STOCKS_PORTLET,
                "mvc.command.name=" + StocksWebKeys.DELETE_STOCK_ACTION_COMMAND
        },
        service = MVCActionCommand.class
)
public class DeleteStockMVCActionCommand extends BaseMVCActionCommand {
    @Override
    protected void doProcessAction(final ActionRequest actionRequest, final ActionResponse actionResponse)
            throws Exception {
        final ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        final long stockId = ParamUtil.getLong(actionRequest, StocksWebKeys.STOCK_ID_PARAM_NAME);
        final String returnToFullPageURL = ParamUtil.getString(actionRequest, "returnToFullPageURL");

        try {
            _stockService.deleteStock(stockId);
            SessionMessages.add(actionRequest, "stockDeleted");
            actionResponse.sendRedirect(returnToFullPageURL);
        } catch (Exception e) {
            _log.error(e.getMessage(), e);
            SessionErrors.add(actionRequest, e.getClass());
            actionResponse.setRenderParameter("mvcPath", "/error.jsp");
            hideDefaultErrorMessage(actionRequest);
        }
    }

    @Reference
    private StockService _stockService;

    private static final Log _log = LogFactoryUtil.getLog(DeleteStockMVCActionCommand.class);
}
