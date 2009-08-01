package org.dataport.bussr.service.search.provider;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

import org.dataport.bussr.service.search.Provider;
import org.dataport.bussr.service.search.SearchProvider;
import org.dataport.bussr.service.search.SearchResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSearchProvider implements SearchProvider {

    private static final String URL_ENCODING = "UTF-8";
    private String urlQueryTemplate;

    public GoogleSearchProvider(String searchEndpoint) {
        super();
        StringBuilder urlQueryTemplateBuilder = new StringBuilder(searchEndpoint).append("&q={0}");
        this.urlQueryTemplate = urlQueryTemplateBuilder.toString();
    }

    public List<SearchResult> search(String q) {
        List<SearchResult> ret = new LinkedList<SearchResult>();
        try {
            String urlQuery = MessageFormat.format(this.urlQueryTemplate, URLEncoder.encode(q, URL_ENCODING));
            URLConnection connection = new URL(urlQuery).openConnection();

            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            JSONObject json = new JSONObject(builder.toString());
            JSONObject responseData = json.getJSONObject("responseData");
            if (responseData != null) {
                JSONArray results = responseData.getJSONArray("results");
                if (results != null) {
                    for (int i = 0; i < results.length(); i++) {
                        ret.add(processEntry(results.getJSONObject(i)));
                    }        
                }
            }
        } catch (Exception e) {
            // TODO log error/warn message
            e.printStackTrace();
        }
        return ret;
    }

    private SearchResult processEntry(JSONObject currentResult) throws JSONException {
        BaseSearchResult ret = new BaseSearchResult();
        ret.setTitle(currentResult.getString("titleNoFormatting"));
        ret.setLink(currentResult.getString("unescapedUrl"));
        ret.setProvider(Provider.GOOGLE);
        return ret;
    }
}
