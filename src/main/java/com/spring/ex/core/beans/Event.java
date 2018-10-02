package com.spring.ex.core.beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhansaya on 10/1/18.
 */
public class Event {
    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private Integer id;
    private String msg;
    private Date date;

    private DateFormat dateFormat;

    public Event(Integer id, Date date, String msg) {
        this.id = id;
        this.date = date;
        this.msg = msg;
    }

    public Event(Date date, DateFormat df) {
        this.id = AUTO_ID.getAndIncrement();
        this.date = date;
        this.dateFormat = df;
    }

    public String toString(){
        return "Event [id=" + id + ", msg=" + msg + ", date=" + dateFormat.format(date) + "]";
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
