package org.dataport.bussr.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.dataport.bussr.action.foundation.BaseActionBean;

@UrlBinding("/url/{url}")
public class UrlViewAction extends BaseActionBean {

    private String url;


    @DefaultHandler
    public Resolution load() {
        // TODO
        return null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
