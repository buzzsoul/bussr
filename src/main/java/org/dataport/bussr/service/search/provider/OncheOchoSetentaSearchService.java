package org.dataport.bussr.service.search.provider;

import java.net.URL;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

import org.dataport.bussr.service.search.SearchProvider;
import org.dataport.bussr.service.search.SearchResult;
import org.dataport.bussr.service.search.SearchService;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.fetcher.FeedFetcher;
import com.sun.syndication.fetcher.impl.FeedFetcherCache;
import com.sun.syndication.fetcher.impl.HashMapFeedInfoCache;
import com.sun.syndication.fetcher.impl.HttpURLFeedFetcher;

public class OncheOchoSetentaSearchService implements SearchService {

    private String urlQueryTemplate;

    public OncheOchoSetentaSearchService(String searchEndpoint, String applicationToken, String authenticationSign) {
        super();
        StringBuilder urlQueryTemplateBuilder = new StringBuilder(searchEndpoint);
        urlQueryTemplateBuilder.append("?q={0}&appToken=").append(applicationToken).append("&authSign=").append(
                authenticationSign);
        this.urlQueryTemplate = urlQueryTemplateBuilder.toString();
    }

    public List<SearchResult> search(String q) {
        List<SearchResult> ret = new LinkedList<SearchResult>();
        try {
            String urlQuery = MessageFormat.format(this.urlQueryTemplate, URLEncoder.encode(q, "UTF-8"));
            URL url = new URL(urlQuery);

            FeedFetcherCache feedInfoCache = HashMapFeedInfoCache.getInstance();
            FeedFetcher feedFetcher = new HttpURLFeedFetcher(feedInfoCache);
            SyndFeed feed = feedFetcher.retrieveFeed(url);
            BaseSearchResult currentResult = null;
            for (Object object : feed.getEntries()) {
                SyndEntry currentEntry = (SyndEntry) object;

                /**
                 * for mapping feed entries and 11870 contents
                 */
                currentResult = new BaseSearchResult();
                currentResult.setProvider(SearchProvider.ONCEOCHOSETENTA);
                currentResult.setTitle(currentEntry.getTitle());
                currentResult.setLink(currentEntry.getLink());
                ret.add(currentResult);
            }
        } catch (Exception e) {
            // TODO log error/warn message
            e.printStackTrace();
        }
        return ret;
    }
}
