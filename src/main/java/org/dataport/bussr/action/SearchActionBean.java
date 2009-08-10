package org.dataport.bussr.action;

import java.util.List;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;

import org.dataport.bussr.action.foundation.BaseActionBean;
import org.dataport.bussr.data.SearchTermDao;
import org.dataport.bussr.model.SearchTerm;
import org.dataport.bussr.service.search.SearchProvider;
import org.dataport.bussr.service.search.SearchResult;

import edu.emory.mathcs.backport.java.util.LinkedList;

@UrlBinding("/search")
public class SearchActionBean extends BaseActionBean {

    @SpringBean("onceOchoSetentaSearchProvider")
    private SearchProvider onceOchoSetentaSearchProvider;

    @SpringBean("googleSearchProvider")
    private SearchProvider googleSearchProvider;

    @SpringBean("twitterSearchProvider")
    private SearchProvider twitterSearchProvider;

    @SpringBean("searchTermDao")
    private SearchTermDao searchTermDao;

    private String query;

    private boolean onceOchoSetenta = true;
    private boolean google = true;
    private boolean twitter = true;

    // output parameters
    private List<SearchResult> results;

    @SuppressWarnings("unchecked")
    public Resolution search() {
        logEntry();
        // we only show results page if the user entered a text
        if (query != null) {
            String queryToUse = query.toLowerCase().trim();
            SearchTerm searchTerm = searchTermDao.loadByTerm(queryToUse);
            if (searchTerm == null) {
                searchTerm = new SearchTerm();
                searchTerm.setTotal(1);
                searchTerm.setTerm(queryToUse);
                searchTermDao.save(searchTerm);
            } else {
                searchTerm.setTotal(searchTerm.getTotal() + 1);
                searchTermDao.update(searchTerm);
            }
            results = new LinkedList();
            if (onceOchoSetenta) {
                results.addAll(onceOchoSetentaSearchProvider.search(query));
            }
            if (google) {
                results.addAll(googleSearchProvider.search(query));
            }
            if (twitter) {
                results.addAll(twitterSearchProvider.search(query));
            }
            return new ForwardResolution("/WEB-INF/pages/results.jsp");
        } else {
            // otherwise, we keep the index page
            return new ForwardResolution("/WEB-INF/pages/index.jsp");
        }
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<SearchResult> getResults() {
        return results;
    }

    public void setOnceOchoSetenta(boolean oncheOchoSetenta) {
        this.onceOchoSetenta = oncheOchoSetenta;
    }

    public void setGoogle(boolean google) {
        this.google = google;
    }

    public void setTwitter(boolean twitter) {
        this.twitter = twitter;
    }

    public boolean isOnceOchoSetenta() {
        return onceOchoSetenta;
    }

    public boolean isGoogle() {
        return google;
    }

    public boolean isTwitter() {
        return twitter;
    }

}
