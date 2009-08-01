package org.dataport.bussr.service.search;

/**
 * Abstract concept of something that was found.
 * @author tute
 *
 */
public interface SearchResult {

    String getTitle();
    String getText();
    String getRating();
    String getLink();
    Provider getProvider();
}
