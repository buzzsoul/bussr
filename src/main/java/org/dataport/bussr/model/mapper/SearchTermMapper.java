package org.dataport.bussr.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.dataport.bussr.model.SearchTerm;
import org.dataport.bussr.model.mapper.foundation.ExtendedParameterizedRowMapper;

public class SearchTermMapper implements ExtendedParameterizedRowMapper<SearchTerm> {

    public SearchTerm mapRow(ResultSet rs, int rowNum) throws SQLException {
        SearchTerm ret = new SearchTerm();
        ret.setId(rs.getLong("id"));
        ret.setTerm(rs.getString("term"));
        ret.setTotal(rs.getInt("total"));

        return ret;
    }

    public String getFieldListAsString() {
        return "id, term, total";
    }

    public Map<String, Object> getParameters(SearchTerm entity) {
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("id", entity.getId());
        ret.put("term", entity.getTerm());
        ret.put("total", entity.getTotal());
        return ret;
    }

    public String getParametersListAsString() {
        return ":id, :term, :total";
    }

    public String getTableName() {
        return "search_term";
    }

    public String getPrimaryKeyFieldName() {
        return "id";
    }
}