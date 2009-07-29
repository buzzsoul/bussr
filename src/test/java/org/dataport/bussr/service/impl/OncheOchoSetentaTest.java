package org.dataport.bussr.service.impl;

import java.net.URL;

import org.junit.Test;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.fetcher.FeedFetcher;
import com.sun.syndication.fetcher.impl.FeedFetcherCache;
import com.sun.syndication.fetcher.impl.HashMapFeedInfoCache;
import com.sun.syndication.fetcher.impl.HttpURLFeedFetcher;

public class OncheOchoSetentaTest {

    @Test
    public void testQuery() throws Exception {
        URL url = new URL("http://11870.com/api/v1/search?q=hola&authSign=28b57b8ae4e60ef8841591ee82239eb2&appToken=3a799df328439d30e57b85495e67ae34");
        
        FeedFetcherCache feedInfoCache = HashMapFeedInfoCache.getInstance();
        FeedFetcher feedFetcher = new HttpURLFeedFetcher(feedInfoCache);
        SyndFeed feed = feedFetcher.retrieveFeed(url);
        System.out.println(feed);
    }
}
