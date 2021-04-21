package com.rosalieraz.cmsc125;

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

    void in_waiting() {
        System.out.println(this.user + " is waiting for resource " + this.resource);
    }

    void in_action() {
        System.out.println(this.user + "is now using the resource " + this.resource);
    }

    boolean is_completed() {
        return this.status.equals("complete");
    }

    void reportRequest() {
        if(is_completed())
            System.out.println("User " + this.user + "/'s request on" + "Resource " + this.resource + "has been completed.");
    }

    void display_time() {
        this.duration--;
        System.out.println("(User " + this.user + " on resource " + this.resource + ") Time left: " + this.duration);
    }

    void setStatus(String status) {
        this.status = status;
    }

}
