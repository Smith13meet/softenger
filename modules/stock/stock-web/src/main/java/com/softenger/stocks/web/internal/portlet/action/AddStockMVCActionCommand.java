package com.softenger.stocks.web.internal.portlet.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.softenger.stocks.constants.StocksPortletKeys;
import com.softenger.stocks.model.Stock;
import com.softenger.stocks.service.StockService;
import com.softenger.stocks.web.internal.constants.StocksWebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * The action command which stores a new stock.
 *
 * @author Meet
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StocksPortletKeys.STOCKS_PORTLET,
                "mvc.command.name=" + StocksWebKeys.ADD_STOCK_ACTION_COMMAND
        },
        service = MVCActionCommand.class
)
public class AddStockMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(final ActionRequest actionRequest, final ActionResponse actionResponse)
            throws Exception {
        final String name = ParamUtil.getString(actionRequest, "name");
        final int quantity = ParamUtil.getInteger(actionRequest, "quantity");

        try {
            final ServiceContext serviceContext = ServiceContextFactory.getInstance(Stock.class.getName(),
                    actionRequest);
            _stockService.addStock(name, quantity, serviceContext);
            SessionMessages.add(actionRequest, "stockAdded");
        } catch (final Exception e) {
            _log.error(e.getMessage(), e);
            SessionErrors.add(actionRequest, e.getClass());
            actionResponse.setRenderParameter("mvcRenderCommandName",
                    StocksWebKeys.ADD_STOCK_RENDER_COMMAND);
            hideDefaultSuccessMessage(actionRequest);
        }
    }

    @Reference
    private StockService _stockService;

    private static final Log _log = LogFactoryUtil.getLog(AddStockMVCActionCommand.class);

}
