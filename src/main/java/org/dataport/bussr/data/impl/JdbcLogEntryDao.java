package org.dataport.bussr.data.impl;

import javax.sql.DataSource;

import org.dataport.bussr.data.LogEntryDao;
import org.dataport.bussr.data.foundation.GenericDao;
import org.dataport.bussr.model.LogEntry;
import org.dataport.bussr.model.mapper.foundation.ExtendedParameterizedRowMapper;

public class JdbcLogEntryDao extends GenericDao<LogEntry, ExtendedParameterizedRowMapper<LogEntry>> implements
        LogEntryDao {

    public JdbcLogEntryDao(DataSource dataSource, Class<ExtendedParameterizedRowMapper<LogEntry>> mapperClass)
            throws InstantiationException, IllegalAccessException {
        super(dataSource, mapperClass);
    }

}
