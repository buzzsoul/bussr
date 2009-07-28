package org.dataport.bussr.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.dataport.bussr.model.LogEntry;
import org.dataport.bussr.model.mapper.foundation.ExtendedParameterizedRowMapper;

public class LogEntryMapper implements ExtendedParameterizedRowMapper<LogEntry> {

    public LogEntry mapRow(ResultSet rs, int rowNum) throws SQLException {
        LogEntry ret = new LogEntry();
        ret.setId(rs.getLong("id"));
        ret.setUserAgent(rs.getString("user_agent"));
        ret.setDate(rs.getDate("date"));
        ret.setUrl(rs.getString("url"));

        return ret;
    }

    public String getFieldListAsString() {
        return "id, user_agent, date, url";
    }

    public Map<String, Object> getParameters(LogEntry entity) {
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("id", entity.getId());
        ret.put("user_agent", entity.getUserAgent());
        ret.put("date", entity.getDate());
        ret.put("url", entity.getUrl());
        return ret;
    }

    public String getParametersListAsString() {
        return ":id, :user_agent, :date, :url";
    }

    public String getTableName() {
        return "log_entry";
    }

    public String getPrimaryKeyFieldName() {
        return "id";
    }
}