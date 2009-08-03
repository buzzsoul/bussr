package org.dataport.bussr.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.dataport.bussr.data.SearchTermDao;
import org.dataport.bussr.data.foundation.GenericDao;
import org.dataport.bussr.model.SearchTerm;
import org.dataport.bussr.model.mapper.foundation.ExtendedParameterizedRowMapper;

public class JdbcSearchTermDao extends GenericDao<SearchTerm, ExtendedParameterizedRowMapper<SearchTerm>> implements SearchTermDao {

    public JdbcSearchTermDao(DataSource dataSource, Class<ExtendedParameterizedRowMapper<SearchTerm>> mapperClass)
            throws InstantiationException, IllegalAccessException {
        super(dataSource, mapperClass);
    }

    public SearchTerm loadByTerm(String term) {
        StringBuilder query = new StringBuilder("select ").append(mapper.getFieldListAsString()).append(" from ").append(
                mapper.getTableName()).append(" where term = ?");

        List<SearchTerm> ret = jdbcTemplate.query(query.toString(), mapper, term);
        if (ret.size() > 0) {
            return ret.get(0);
        } else {
            return null;
        }
    }

    public List<SearchTerm> loadPopularSearchTerms(int maxResults) {
        StringBuilder query = new StringBuilder("select ").append(mapper.getFieldListAsString()).append(" from ").append(
                mapper.getTableName()).append(" order by total desc limit ?");
        return jdbcTemplate.query(query.toString(), mapper, maxResults);
    }

}
