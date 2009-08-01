package org.dataport.bussr.service.search.provider;

import java.util.LinkedList;
import java.util.List;

import net.unto.twitter.Api;
import net.unto.twitter.TwitterProtos.Results.Result;

import org.dataport.bussr.service.search.Provider;
import org.dataport.bussr.service.search.SearchProvider;
import org.dataport.bussr.service.search.SearchResult;

public class TwitterSearchProvider implements SearchProvider {

    private static final String TWITTER_BASE_URL = "http://www.twitter.com/";

    public List<SearchResult> search(String q) {
        List<SearchResult> ret = new LinkedList<SearchResult>();

        Api api = Api.builder().build();
        for (Result currentResult : api.search(q).build().get().getResultsList()) {
            ret.add(processResult(currentResult));
        }
        return ret;

    }

    private SearchResult processResult(Result currentResult) {
        BaseSearchResult ret = new BaseSearchResult();
        ret.setProvider(Provider.TWITTER);
        ret.setTitle(currentResult.getText());
        if (currentResult.hasFromUser()) {
            // TODO define URL to show
            ret.setLink(TWITTER_BASE_URL + currentResult.getFromUser()); 
        }

        return ret;
    }

}
