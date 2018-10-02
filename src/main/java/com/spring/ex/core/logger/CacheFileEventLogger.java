package com.spring.ex.core.logger;

import com.spring.ex.core.beans.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhansaya on 10/1/18.
 */
public class CacheFileEventLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(String fileName, int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
        this.cache = new ArrayList<Event>(cacheSize);
    }
    
    @Override
    public void logEvent(Event event) {
        cache.add(event);
        
        if(cache.size() == cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        cache.forEach(super::logEvent);
    }

    public void destroy() {
        if(!cache.isEmpty()) {
            writeEventsFromCache();
        }
    }
}
