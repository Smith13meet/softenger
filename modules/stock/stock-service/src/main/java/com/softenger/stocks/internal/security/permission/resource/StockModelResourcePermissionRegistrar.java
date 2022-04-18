package com.softenger.stocks.internal.security.permission.resource;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.WorkflowedModelPermissionLogic;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;
import com.softenger.stocks.constants.StocksConstants;
import com.softenger.stocks.constants.StocksPortletKeys;
import com.softenger.stocks.model.Stock;
import com.softenger.stocks.service.StockLocalService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import java.util.Dictionary;

/**
 * The registrar of the model resource permission for the stocks domain area in the OSGI bundle.
 *
 * @author Meet
 */
@Component(immediate = true)
public class StockModelResourcePermissionRegistrar {

    @Activate
    public void activate(BundleContext bundleContext) {
        Dictionary<String, Object> properties = new HashMapDictionary<>();

        properties.put("model.class.name", Stock.class.getName());

        _serviceRegistration = bundleContext.registerService(ModelResourcePermission.class,
                ModelResourcePermissionFactory.create(Stock.class, Stock::getStockId,
                        _stockLocalService::getStock, _portletResourcePermission,
                        (modelResourcePermission, consumer) -> {
                            consumer.accept(new StagedModelPermissionLogic<>(_stagingPermission,
                                    StocksPortletKeys.STOCKS_PORTLET, Stock::getStockId));
                            consumer.accept(new WorkflowedModelPermissionLogic<>(_workflowPermission,
                                    modelResourcePermission, _groupLocalService, Stock::getStockId));
                        }),
                properties);
    }

    @Deactivate
    public void deactivate() {
        _serviceRegistration.unregister();
    }

    @Reference
    private GroupLocalService _groupLocalService;

    @Reference
    private StockLocalService _stockLocalService;

    @Reference(target = "(resource.name=" + StocksConstants.RESOURCE_NAME + ")")
    private PortletResourcePermission _portletResourcePermission;

    @Reference
    private StagingPermission _stagingPermission;

    @Reference
    private WorkflowPermission _workflowPermission;

    /**
     * The service registration link of the model resource permission.
     */
    @SuppressWarnings("rawtypes")
    private ServiceRegistration<ModelResourcePermission> _serviceRegistration;
}
