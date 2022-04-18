package com.softenger.stocks.web.internal.security.permission.resource;

import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.softenger.stocks.constants.StocksConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true)
public class StocksPortletPermission {

    public static void check(PermissionChecker permissionChecker, long groupId, String actionId)
            throws PrincipalException {
        _portletResourcePermission.check(permissionChecker, groupId, actionId);
    }

    public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId) {
        return _portletResourcePermission.contains(permissionChecker, groupId, actionId);
    }

    @Reference(target = "(resource.name=" + StocksConstants.RESOURCE_NAME + ")", unbind = "-")
    protected void setPortletResourcePermission(PortletResourcePermission portletResourcePermission) {
        _portletResourcePermission = portletResourcePermission;
    }

    private static PortletResourcePermission _portletResourcePermission;
}