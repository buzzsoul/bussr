package org.dataport.bussr.model;

import java.util.Date;

import org.dataport.bussr.model.foundation.BaseEntity;

/**
 * Class that represents log entry for any page of the application.
 * 
 * @author tute
 * 
 */
public class LogEntry extends BaseEntity {

    protected Date date;
    protected String url;
    protected String userAgent;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

}
