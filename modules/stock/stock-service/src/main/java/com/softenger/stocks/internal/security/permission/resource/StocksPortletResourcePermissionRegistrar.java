package com.softenger.stocks.internal.security.permission.resource;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.softenger.stocks.constants.StocksConstants;
import com.softenger.stocks.constants.StocksPortletKeys;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.Dictionary;

/**
 * The registrar of the portlet resource permission for the stocks domain area in the OSGI bundle.
 *
 * @author Meet
 */
@Component(immediate = true)
public class StocksPortletResourcePermissionRegistrar {

    @Activate
    public void activate(BundleContext bundleContext) {
        Dictionary<String, Object> properties = new HashMapDictionary<>();

        properties.put("resource.name", StocksConstants.RESOURCE_NAME);

        _serviceRegistration = bundleContext.registerService(
                PortletResourcePermission.class,
                PortletResourcePermissionFactory.create(StocksConstants.RESOURCE_NAME,
                        new StagedPortletPermissionLogic(_stagingPermission, StocksPortletKeys.STOCKS_PORTLET)),
                properties);
    }

    @Deactivate
    public void deactivate() {
        _serviceRegistration.unregister();
    }

    /**
     * The service registration link of the portlet resource permission.
     */
    private ServiceRegistration<PortletResourcePermission> _serviceRegistration;

    @Reference
    private StagingPermission _stagingPermission;

}
