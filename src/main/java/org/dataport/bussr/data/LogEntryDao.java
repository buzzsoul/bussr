package org.dataport.bussr.data;

import org.dataport.bussr.model.LogEntry;

public interface LogEntryDao {

    LogEntry load(Long id);
    void save(LogEntry logEntry);
    
}
