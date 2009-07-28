package org.dataport.bussr.action;

import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.dataport.bussr.action.foundation.BaseActionBean;

@UrlBinding("/search")
public class SearchActionBean extends BaseActionBean {

    private String query;
    
    public Resolution search() {
        // TODO add log
        return new RedirectResolution("http://www.google.es", false).addParameter("q", query);
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
