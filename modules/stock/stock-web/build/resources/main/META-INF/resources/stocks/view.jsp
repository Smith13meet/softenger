<%@ include file="/init.jsp" %>

<liferay-ui:success key="stockAdded" message="the-stock-request-was-created-successfully"/>
<liferay-ui:success key="stockUpdated" message="the-stock-request-was-updated-successfully"/>
<liferay-ui:success key="stockDeleted" message="the-stock-request-was-deleted-successfully"/>

<%
    final StocksDisplayContext displayContext = (StocksDisplayContext) request.getAttribute(
            StocksWebKeys.STOCKS_DISPLAY_CONTEXT);
    Preconditions.checkNotNull(displayContext, "Attribute 'displayContext' is not set");
    final String displayStyle = displayContext.getDisplayStyle();
    portletDisplay.setShowBackIcon(false);
%>

<div class="stock-list">
    <div id="<portlet:namespace/>stockAutocomplete" class="stock-list-auto-complete">
        <clay:management-toolbar
                displayContext="<%= displayContext.getManagementToolbarDisplayContext() %>"/>
    </div>

    <liferay-ui:search-container id="stocks" searchContainer="<%= displayContext.getSearchContainer() %>">
        <liferay-ui:search-container-row
                className="com.softenger.stocks.model.Stock"
                modelVar="stock">

            <liferay-ui:search-container-column-text property="name" title="name" />
            <liferay-ui:search-container-column-text property="quantity" title="quantity" />
            <liferay-ui:search-container-column-text name="status" >
                <span class="text-default">
                    <aui:workflow-status markupView="lexicon" showIcon="<%= false %>" showLabel="<%= false %>" status="<%= stock.getStatus() %>" />
                </span>
            </liferay-ui:search-container-column-text>
            <liferay-ui:search-container-column-jsp align="right" path="/stocks/stock_actions.jsp"/>

        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator markupView="lexicon" displayStyle="<%= displayStyle %>" paginate="<%= true %>"
                                    searchContainer="<%= displayContext.getSearchContainer() %>"/>
    </liferay-ui:search-container>

</div>