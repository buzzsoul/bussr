package org.dataport.bussr.model;

import org.dataport.bussr.model.foundation.BaseEntity;

public class SearchTerm extends BaseEntity {

    private String term;
    private int total;
    
    public String getTerm() {
        return term;
    }
    public void setTerm(String term) {
        this.term = term;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
   

}
