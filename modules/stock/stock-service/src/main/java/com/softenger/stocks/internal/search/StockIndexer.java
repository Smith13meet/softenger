package com.softenger.stocks.internal.search;

import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.TermsFilter;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.softenger.stocks.model.Stock;
import com.softenger.stocks.service.StockLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import java.util.Locale;

import static com.liferay.portal.kernel.search.IndexWriterHelperUtil.updateDocument;
import static java.lang.String.format;

/**
 * The implementation of {@link Indexer} for the {@link Stock} entity.
 *
 * @author Meet
 */
@Component(immediate = true, service = Indexer.class)
public class StockIndexer extends BaseIndexer<Stock> {
    /**
     * The log for this class.
     */
    private static final Log LOG = LogFactoryUtil.getLog(StockIndexer.class);
    /**
     * The max length of the summary to index.
     */
    private static final int SUMMARY_MAX_LENGTH = 200;

    /**
     * The document field name for to handle community group search by an site type(public/private etc).
     */
    private static final String SITE_TYPE = "siteType";

    /**
     * Default constructor.
     */
    public StockIndexer() {
        setDefaultSelectedFieldNames(
                Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.DESCRIPTION,
                Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID,
                Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE, Field.UID, SITE_TYPE);
        setFilterSearch(true);
        setPermissionAware(true);
    }

    @Override
    protected void doDelete(final Stock stock) throws Exception {
        deleteDocument(stock.getCompanyId(), stock.getStockId());
    }

    @Override
    protected Document doGetDocument(final Stock stock) {
        final Document document = getBaseModelDocument(Stock.class.getName(), stock);
        document.addDate(Field.MODIFIED_DATE, stock.getModifiedDate());
        document.addText(Field.TITLE, stock.getName());
        return document;
    }

    @Override
    protected void doReindex(final String className, final long classPK) throws Exception {
        doReindex(StockLocalServiceUtil.getStock(classPK));
    }

    @Override
    protected void doReindex(final String[] ids) throws Exception {
        final long companyId = GetterUtil.getLong(ids[0]);

        final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
                StockLocalServiceUtil.getIndexableActionableDynamicQuery();

        indexableActionableDynamicQuery.setAddCriteriaMethod(
                dynamicQuery -> dynamicQuery.add(PropertyFactoryUtil.forName("status").in(new int[] {
                        WorkflowConstants.STATUS_APPROVED,
                        WorkflowConstants.STATUS_IN_TRASH
                })));
        indexableActionableDynamicQuery.setCompanyId(companyId);
        indexableActionableDynamicQuery.setPerformActionMethod((final Stock stock) -> {
            try {
                indexableActionableDynamicQuery.addDocuments(getDocument(stock));
            } catch (PortalException pe) {
                if (LOG.isWarnEnabled()) {
                    LOG.warn(format("Unable to index stock {stockId: %d}", stock.getStockId()), pe);
                }
            }
        });
        indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
        indexableActionableDynamicQuery.performActions();
    }

    @Override
    protected void doReindex(final Stock stock) throws Exception {
        updateDocument(getSearchEngineId(), stock.getCompanyId(), getDocument(stock), isCommitImmediately());
    }

    @Override
    protected Summary doGetSummary(
            final Document document, final Locale locale, final String snippet,
            final PortletRequest portletRequest, final PortletResponse portletResponse) {
        final Summary summary = createSummary(document, Field.TITLE, Field.DESCRIPTION);
        summary.setMaxContentLength(SUMMARY_MAX_LENGTH);
        return summary;
    }

    @Override
    public void postProcessContextBooleanFilter(
            final BooleanFilter contextBooleanFilter, final SearchContext searchContext) {
        final TermsFilter siteTypeTermsFilter = new TermsFilter(SITE_TYPE);

        siteTypeTermsFilter.addValues(
                String.valueOf(GroupConstants.TYPE_SITE_OPEN),
                String.valueOf(GroupConstants.TYPE_SITE_RESTRICTED));

        contextBooleanFilter.add(siteTypeTermsFilter, BooleanClauseOccur.MUST);
    }

    @Override
    public void postProcessSearchQuery(
            final BooleanQuery searchQuery, final BooleanFilter booleanFilter, final SearchContext searchContext)
            throws Exception {
        if (searchContext.isAndSearch()) {
            searchQuery.addRequiredTerm(Field.TITLE, searchContext.getKeywords(), false);
            searchQuery.addRequiredTerm(Field.DESCRIPTION, searchContext.getKeywords(), false);
        } else {
            searchQuery.addTerm(Field.TITLE, searchContext.getKeywords(), false);
            searchQuery.addTerm(Field.DESCRIPTION, searchContext.getKeywords(), false);
        }
    }

    @Override
    public String getClassName() {
        return Stock.class.getName();
    }
}
