<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@ page import="java.text.DateFormat" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="javax.portlet.WindowState" %>
<%@ page import="javax.portlet.PortletMode" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.google.common.base.Preconditions" %>

<%@ page import="com.liferay.portal.kernel.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.language.UnicodeLanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.petra.string.StringPool" %>
<%@ page import="com.liferay.taglib.search.ResultRow" %>
<%@ page import="com.liferay.asset.kernel.model.AssetCategory" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPCreationMenu" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%@ page import="com.softenger.stocks.model.Stock" %>
<%@ page import="com.softenger.stocks.constants.StocksConstants" %>
<%@ page import="com.softenger.stocks.web.internal.constants.StocksWebKeys" %>
<%@ page import="com.softenger.stocks.web.internal.display.context.StocksDisplayContext" %>
<%@ page import="com.softenger.stocks.web.internal.security.permission.resource.StockPermission" %>


<%@ page import="com.softenger.stocks.exception.NoSuchStockException" %>
<%@ page import="com.softenger.stocks.exception.StockNameException" %>
<%@ page import="com.softenger.stocks.exception.StockQuantityException" %>