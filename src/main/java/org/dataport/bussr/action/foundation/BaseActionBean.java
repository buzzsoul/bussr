package org.dataport.bussr.action.foundation;

import java.util.Date;

import org.dataport.bussr.data.LogEntryDao;
import org.dataport.bussr.model.LogEntry;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.integration.spring.SpringBean;

/**
 * Parent of all the ActionBeans of the application.
 * @author tute
 *
 */
public abstract class BaseActionBean implements ActionBean {

    // TODO use a service?
    @SpringBean("logEntryDao")
    private LogEntryDao logEntryDao;

    protected ActionBeanContext context;

    public ActionBeanContext getContext() {
        return context;
    }

    public void setContext(ActionBeanContext context) {
        this.context = context;
    }
    
    protected void logEntry() {
        LogEntry logEntry = new LogEntry();
        logEntry.setDate(new Date());
        logEntry.setUrl(context.getRequest().getRequestURL().toString());
        logEntry.setUserAgent(context.getRequest().getHeader("User-Agent"));
        logEntryDao.save(logEntry);
    }
}
