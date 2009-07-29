package org.dataport.bussr.action;

import java.util.List;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.integration.spring.SpringBean;
import net.sourceforge.stripes.validation.Validate;

import org.dataport.bussr.action.foundation.BaseActionBean;
import org.dataport.bussr.service.search.SearchResult;
import org.dataport.bussr.service.search.SearchService;

@UrlBinding("/search")
public class SearchActionBean extends BaseActionBean {

    @SpringBean("onceOchoSetentaService")
    private SearchService onceOchoSetentaService;

    // input parameters, it's necessary to disable the encrypted property, otherwise a strange log we have in jetty
    @Validate(encrypted = false)
    private String query;

    // output parameters
    private List<SearchResult> results;

    public Resolution search() {
        if (query != null) {
            results = onceOchoSetentaService.search(query);
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
