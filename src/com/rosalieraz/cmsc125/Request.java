package com.rosalieraz.cmsc125;

import java.util.ArrayList;

public class Request {

private final int user;
private final int resource;
private int duration;
private String status;
private final String name;

    Request(String name, int user, int resource, int duration) {
        this.user = user;
        this.resource = resource;
        this.duration = duration;
        this.status = "waiting";
        this.name = name;
    }

    //Helper Functions
    void is_waiting() {
        System.out.println(this.name + " will have to wait for resource " + this.resource + " to be available");
    }

    void in_action() {
        System.out.println(this.name + " will be using the resource " + this.resource + " for " + this.duration + " seconds");
    }
    boolean is_completed() {
        return this.status.equals("complete");
    }
    void displayCompleteReq() {
        if(is_completed())
            System.out.println("User " + this.user + "'s request on " + "resource " + this.resource + " has been completed.");
    }
    void display_time() {
        System.out.println(this.name + " on resource " + this.resource + " | Time left: " + this.duration + " seconds");
        this.duration--;
    }

    //Setter Functions
    void setStatus(String status) {
        this.status = status;
    }

    //Getter Functions
    int getUser() {
        return this.user;
    }
    int getResource() {
        return this.resource;
    }
    int getTimeRemaining() {
        return this.duration;
    }

}
