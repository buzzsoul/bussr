package org.dataport.bussr.service.search.provider;

import org.dataport.bussr.service.search.Provider;
import org.dataport.bussr.service.search.SearchResult;

public class BaseSearchResult implements SearchResult {

    private String title;
    private String rating;
    private String text;
    private String link;
    private Provider provider;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

}
