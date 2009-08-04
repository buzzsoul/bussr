package org.dataport.bussr.action;

import java.util.List;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import org.dataport.bussr.action.foundation.BaseActionBean;
import org.dataport.bussr.data.SearchTermDao;
import org.dataport.bussr.model.SearchTerm;

@UrlBinding("/index")
public class IndexActionBean extends BaseActionBean {

    private int CLOUD_TAGS_MAX_ITEMS = 25;

    // out parameters
    private List<SearchTerm> searchTerms;
    private int totalSearchTermHits;
    
    @SpringBean("searchTermDao")
    private SearchTermDao searchTermDao;

    @DefaultHandler
    public Resolution load() {
        logEntry();
        processSearchTerms();
        return new ForwardResolution("/WEB-INF/pages/index.jsp");
    }

    private void processSearchTerms() {
        searchTerms = searchTermDao.loadPopularSearchTerms(CLOUD_TAGS_MAX_ITEMS);
        for (SearchTerm currentTerm : searchTerms) {
            totalSearchTermHits += currentTerm.getTotal();
        }
    }

    public List<SearchTerm> getSearchTerms() {
        return searchTerms;
    }

    public int getTotalSearchTermHits() {
        return totalSearchTermHits;
    }
    
}
