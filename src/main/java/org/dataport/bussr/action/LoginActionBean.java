package org.dataport.bussr.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import org.dataport.bussr.action.foundation.BaseActionBean;

@UrlBinding("/login")
public class LoginActionBean extends BaseActionBean {

    @DefaultHandler
    public Resolution load() {
        logEntry();
        return new ForwardResolution("/WEB-INF/pages/login.jsp");
    }
}
