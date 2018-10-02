package com.spring.ex.core.logger;

import com.spring.ex.core.beans.Event;

/**
 * Created by zhansaya on 10/1/18.
 */
public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
