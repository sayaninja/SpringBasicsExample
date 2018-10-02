package com.spring.ex.core;

import com.spring.ex.core.beans.Client;
import com.spring.ex.core.beans.Event;
import com.spring.ex.core.beans.EventType;
import com.spring.ex.core.logger.EventLogger;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by zhansaya on 10/1/18.
 */
@Value
@AllArgsConstructor
public class MainApp {
    Client client;
    EventLogger eventLogger;
    Map<EventType, EventLogger> loggers;

    public void logEvent(EventType eventType, Event event, String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            logger = eventLogger;
        }

        logger.logEvent(event);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        MainApp mainApp = (MainApp) context.getBean("mainApp");

        Client client = (Client) context.getBean("client");
        System.out.println(client.getGreeting());

        Event event = context.getBean(Event.class);
        event.setMsg("HelloWorld");

        mainApp.logEvent(EventType.INFO, event, "Some event for 1");
        mainApp.logEvent(EventType.ERROR, event, "Some event for 2");

        context.close();
    }
}
