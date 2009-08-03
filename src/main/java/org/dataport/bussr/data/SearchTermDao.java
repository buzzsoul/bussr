package org.dataport.bussr.data;

import java.util.List;

import org.dataport.bussr.model.SearchTerm;

public interface SearchTermDao {
    void save(SearchTerm searchTerm);
    void update(SearchTerm searchTerm);
    SearchTerm loadByTerm(String term);
    List<SearchTerm> loadPopularSearchTerms(int maxResults);    
}
