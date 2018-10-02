package com.spring.ex.core.beans;

/**
 * Created by zhansaya on 10/1/18.
 */
public class Client {
    private String id;
    private String fullName;
    private String greeting;

    public Client(String id, String fullName) {
        super();
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return this.id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public String getGreeting() {
        return this.greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
