package com.softenger.stocks.web.internal.security.permission.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.softenger.stocks.model.Stock;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class StockPermission {

    public static void check(PermissionChecker permissionChecker, Stock stock, String actionId)
            throws PortalException {
        _stockModelResourcePermission.check(permissionChecker, stock, actionId);
    }

    public static void check(PermissionChecker permissionChecker, long stockId, String actionId)
            throws PortalException {
        _stockModelResourcePermission.check(permissionChecker, stockId, actionId);
    }

    public static boolean contains(PermissionChecker permissionChecker, Stock stock, String actionId)
            throws PortalException {
        return _stockModelResourcePermission.contains(permissionChecker, stock, actionId);
    }

    public static boolean contains(PermissionChecker permissionChecker, long stockId, String actionId)
            throws PortalException {
        return _stockModelResourcePermission.contains(permissionChecker, stockId, actionId);
    }

    @Reference(target = "(model.class.name=com.softenger.stocks.model.Stock)", unbind = "-")
    protected void setEntryModelPermission(ModelResourcePermission<Stock> modelResourcePermission) {
        _stockModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<Stock> _stockModelResourcePermission;
}