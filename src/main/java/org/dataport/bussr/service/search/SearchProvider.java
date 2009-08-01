package org.dataport.bussr.service.search;

import java.util.List;

public interface SearchProvider {

    List<SearchResult> search(String q); 
}
