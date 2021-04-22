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
    static void in_waiting(ArrayList<Integer> userIds, int resourceId) {
        System.out.print("Users ");
        for(int userId: userIds) {
            System.out.print(userId + " ,");
        }
        System.out.println(" are waiting for resource " + resourceId);
    }
    void in_action() {
        System.out.println(this.name + " is now using the resource " + this.resource);
    }
    boolean is_completed() {
        return this.status.equals("complete");
    }
    void reportRequest() {
        if(is_completed())
            System.out.println("User " + this.user + "'s request on " + "resource " + this.resource + " has been completed.");
    }
    void display_time() {
        this.duration--;
        System.out.println(this.name + " on resource " + this.resource + " | Time left: " + this.duration);
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
