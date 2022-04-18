package com.softenger.stocks.web.internal.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.softenger.stocks.constants.StocksPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

/**
 * @author Pc
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Stocks",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/stocks/view.jsp",
                "javax.portlet.name=" + StocksPortletKeys.STOCKS_PORTLET,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class StocksPortlet extends MVCPortlet {
}