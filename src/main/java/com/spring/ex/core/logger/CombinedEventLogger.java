package com.spring.ex.core.logger;

import com.spring.ex.core.beans.Event;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by zhansaya on 10/2/18.
 */
public class CombinedEventLogger implements EventLogger {


    private final Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        super();
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger eventLogger : loggers) {
            eventLogger.logEvent(event);
        }
    }

    public Collection<EventLogger> getLoggers() {
        return Collections.unmodifiableCollection(loggers);
    }

}


