package org.dataport.bussr.data.impl;

import javax.sql.DataSource;

import org.dataport.bussr.data.LogEntryDao;
import org.dataport.bussr.model.LogEntry;
import org.dataport.bussr.model.mapper.LogEntryMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class JdbcLogEntryDao implements LogEntryDao {

    private SimpleJdbcTemplate jdbcTemplate;

    public JdbcLogEntryDao(DataSource dataSource) {
        super();
        this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    public LogEntry load(Long id) {
        LogEntryMapper mapper = new LogEntryMapper();
        StringBuilder query = new StringBuilder("select ").append(mapper.getFieldListAsString()).append(" from ")
                .append(mapper.getTableName()).append(" where ").append(mapper.getPrimaryKeyFieldName()).append(
                        " = :?");
        return jdbcTemplate.queryForObject(query.toString(), mapper, id);
    }

    public void save(LogEntry logEntry) {
        LogEntryMapper mapper = new LogEntryMapper();
        StringBuilder query = new StringBuilder("insert into ").append(mapper.getTableName()).append(" (");
        query.append(mapper.getFieldListAsString()).append(") values (").append(mapper.getParametersListAsString())
                .append(")");

        jdbcTemplate.update(query.toString(), mapper.getParameters(logEntry));
    }

}
