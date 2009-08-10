package org.dataport.bussr.model;

import java.util.Date;

import org.dataport.bussr.model.foundation.BaseEntity;
import org.dataport.bussr.service.search.Provider;

public class ResultUrl extends BaseEntity {

    private String url;
    private Provider provider;
    private Date creationDate;
    
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public Provider getProvider() {
        return provider;
    }
    public void setProvider(Provider provider) {
        this.provider = provider;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}
