<%@ include file="../init.jsp" %>

<%
    final ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
    final Stock stock = (Stock) row.getObject();
%>

<liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon"
                      message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>">
    <c:if test="<%= StockPermission.contains(permissionChecker, stock.getStockId(),
            ActionKeys.UPDATE) %>">
        <portlet:renderURL var="editStockRenderURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
            <portlet:param name="mvcRenderCommandName"
                           value="<%= StocksWebKeys.EDIT_STOCK_RENDER_COMMAND %>"/>
            <portlet:param name="stockId"
                           value="<%= String.valueOf(stock.getStockId()) %>"/>
            <portlet:param name="returnToFullPageURL" value="<%= PortalUtil.getCurrentURL(request) %>"/>
        </portlet:renderURL>
        <liferay-ui:icon message="edit" url="${editStockRenderURL}" />
    </c:if>

    <c:if test="<%= StockPermission.contains(permissionChecker, stock.getStockId(),
            ActionKeys.DELETE) %>">
        <portlet:actionURL name="<%= StocksWebKeys.DELETE_STOCK_ACTION_COMMAND %>"
                           var="deleteStockActionURL">
            <portlet:param name="stockId"
                           value="<%= String.valueOf(stock.getStockId()) %>"/>
            <portlet:param name="returnToFullPageURL" value="<%= PortalUtil.getCurrentURL(request) %>"/>
        </portlet:actionURL>
        <liferay-ui:icon-delete message="delete"
                                confirmation="are-you-sure-you-want-to-delete-the-stock"
                                url="${deleteStockActionURL}"/>
    </c:if>
</liferay-ui:icon-menu>
