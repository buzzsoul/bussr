package org.dataport.bussr.service.search.provider;

import java.net.URL;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

import org.dataport.bussr.service.search.Provider;
import org.dataport.bussr.service.search.SearchProvider;
import org.dataport.bussr.service.search.SearchResult;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.fetcher.FeedFetcher;
import com.sun.syndication.fetcher.impl.FeedFetcherCache;
import com.sun.syndication.fetcher.impl.HashMapFeedInfoCache;
import com.sun.syndication.fetcher.impl.HttpURLFeedFetcher;

public class OncheOchoSetentaSearchProvider implements SearchProvider {

    private static final String URL_ENCODING = "UTF-8";
    private String urlQueryTemplate;

    public OncheOchoSetentaSearchProvider(String searchEndpoint, String applicationToken, String authenticationSign) {
        super();
        StringBuilder urlQueryTemplateBuilder = new StringBuilder(searchEndpoint);
        urlQueryTemplateBuilder.append("?q={0}&appToken=").append(applicationToken).append("&authSign=").append(
                authenticationSign);
        this.urlQueryTemplate = urlQueryTemplateBuilder.toString();
    }

    public List<SearchResult> search(String q) {
        List<SearchResult> ret = new LinkedList<SearchResult>();
        try {
            // get URL from template
            String urlQuery = MessageFormat.format(this.urlQueryTemplate, URLEncoder.encode(q, URL_ENCODING));
            URL url = new URL(urlQuery);

            // it uses a cache logic inside using a singleton
            FeedFetcherCache feedInfoCache = HashMapFeedInfoCache.getInstance();
            FeedFetcher feedFetcher = new HttpURLFeedFetcher(feedInfoCache);
            SyndFeed feed = feedFetcher.retrieveFeed(url);
            for (Object object : feed.getEntries()) {
                ret.add(processEntry((SyndEntry) object));
            }
        } catch (Exception e) {
            // TODO log error/warn message
            e.printStackTrace();
        }
        return ret;
    }

    private SearchResult processEntry(SyndEntry entry) {
        BaseSearchResult ret = new BaseSearchResult();
        ret.setProvider(Provider.ONCEOCHOSETENTA);
        ret.setText(entry.getDescription().getValue());
        ret.setTitle(entry.getTitle());
        ret.setLink(entry.getLink());
        return ret;
    }
}
