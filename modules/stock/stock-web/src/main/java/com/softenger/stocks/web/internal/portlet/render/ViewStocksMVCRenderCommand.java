package com.softenger.stocks.web.internal.portlet.render;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.PortalUtil;
import com.softenger.stocks.constants.StocksPortletKeys;
import com.softenger.stocks.web.internal.constants.StocksWebKeys;
import com.softenger.stocks.web.internal.display.context.StocksDisplayContext;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StocksPortletKeys.STOCKS_PORTLET,
                "mvc.command.name=/"
        },
        service = MVCRenderCommand.class
)
public class ViewStocksMVCRenderCommand implements MVCRenderCommand {
    @Override
    public String render(final RenderRequest renderRequest, final RenderResponse renderResponse)
            throws PortletException {
        try {
            renderRequest.setAttribute(StocksWebKeys.STOCKS_DISPLAY_CONTEXT,
                    new StocksDisplayContext(PortalUtil.getLiferayPortletRequest(renderRequest),
                            PortalUtil.getLiferayPortletResponse(renderResponse)));
        } catch (PortalException e) {
            throw new PortletException(e);
        }
        return "/stocks/view.jsp";
    }
}