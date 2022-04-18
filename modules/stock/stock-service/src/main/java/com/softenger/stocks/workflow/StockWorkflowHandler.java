package com.softenger.stocks.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ResourceActions;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandler;
import com.softenger.stocks.model.Stock;
import com.softenger.stocks.service.StockLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

/**
 * The workflow handler for the {@link Stock} class in the OSGI bundle.
 *
 * @author Meet
 */
@Component(immediate = true, service = WorkflowHandler.class)
public class StockWorkflowHandler extends BaseWorkflowHandler<Stock> {

    private ResourceActions _resourceActions;
    private StockLocalService _stockLocalService;

    @Override
    public String getClassName() {
        return Stock.class.getName();
    }

    @Override
    public String getType(Locale locale) {
        return _resourceActions.getModelResource(locale, getClassName());
    }

    @Override
    public Stock updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException {
        long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
        long resourcePrimKey = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

        return _stockLocalService.updateStatus(userId, resourcePrimKey, status);
    }

    @Reference(unbind = "-")
    protected void setResourceActions(ResourceActions resourceActions) {
        _resourceActions = resourceActions;
    }

    @Reference(unbind = "-")
    protected void setProjectLocalService(StockLocalService stockLocalService) {
        _stockLocalService = stockLocalService;
    }

}
