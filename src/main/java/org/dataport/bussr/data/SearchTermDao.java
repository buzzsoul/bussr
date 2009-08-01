package org.dataport.bussr.data;

import org.dataport.bussr.model.SearchTerm;

public interface SearchTermDao {
    SearchTerm loadByTerm(String term);
    void save(SearchTerm searchTerm);
    void update(SearchTerm searchTerm);
}
