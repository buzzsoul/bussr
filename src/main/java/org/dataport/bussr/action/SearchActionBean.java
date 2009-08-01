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

    // output parameters
    private List<SearchResult> results;

    public Resolution search() {
        if (query != null) {
            SearchTerm searchTerm = searchTermDao.loadByTerm(query);
            if (searchTerm == null) {
                searchTerm = new SearchTerm();
                searchTerm.setTotal(1);
                searchTerm.setTerm(query.trim());
                searchTermDao.save(searchTerm);
            } else {
                searchTerm.setTotal(searchTerm.getTotal() + 1);
                searchTermDao.update(searchTerm);
            }

            // by default, we search in all the engines (for the moment)
            results = onceOchoSetentaSearchProvider.search(query);
            results.addAll(googleSearchProvider.search(query));
            results.addAll(twitterSearchProvider.search(query));
        }
        return new ForwardResolution("/WEB-INF/pages/results.jsp");
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<SearchResult> getResults() {
        return results;
    }

}
