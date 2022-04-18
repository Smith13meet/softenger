<%@ include file="../init.jsp" %>
<%@ include file="../exceptions.jspf" %>

<liferay-portlet:actionURL var="updateStockURL"
                           name="<%= StocksWebKeys.EDIT_STOCK_ACTION_COMMAND %>"/>

<liferay-portlet:actionURL var="addStockURL" name="<%= StocksWebKeys.ADD_STOCK_ACTION_COMMAND %>"/>

<aui:container>
    <aui:row>
        <aui:col md="12" sm="12">
            <aui:form name="stockForm"
                      action="${not empty stock ? updateStockURL : addStockURL}" method="post"
                      enctype="multipart/form-data">
                <aui:fieldset-group markupView="lexicon">
                    <aui:input type="hidden" name="stockId" value="${stock.getStockId()}"/>
                    <aui:fieldset>
                        <aui:input name="name" type="text"
                                   label="name"
                                   required="<%= true %>"
                                   value="${stock.getName()}">
                            <aui:validator name="maxLength">
                                <%= StocksConstants.NAME_MAX_LENGTH %>
                            </aui:validator>
                        </aui:input>

                        <aui:input name="quantity" type="test"
                                   label="Quantity"
                                   required="<%= true %>"
                                   value="${stock.getQuantity()}">
                            <aui:validator name="number" />
                        </aui:input>

                        <aui:input type="hidden" name="returnToFullPageURL" value="${returnToFullPageURL}"/>
                    </aui:fieldset>
                </aui:fieldset-group>
                <aui:button-row>
                    <aui:button type="submit" value="submit-for-publication" cssClass="btn btn-primary"/>
                    <aui:button type="cancel" href="${returnToFullPageURL}" />
                </aui:button-row>
            </aui:form>
        </aui:col>
    </aui:row>
</aui:container>