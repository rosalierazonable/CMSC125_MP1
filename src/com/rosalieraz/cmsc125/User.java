package com.rosalieraz.cmsc125;

import java.util.ArrayList;

public class User {

    private final int id; //user 1, 2, 3 .. etc
    private int request_count; //randomized number of request to have
    ArrayList<Integer> resourceArr= new ArrayList<Integer>();

    User(int id, int request_count) { //Constructor
        this.id = id;
        this.request_count = request_count;
    }

    int getId(){return this.id;}
    int getRequestCount() {
        return this.request_count;
    }
    void updateRequestCount() {
        this.request_count--;
    }
    void setResourceArray(ArrayList<Integer> resources){
        this.resourceArr.addAll(resources);
    }
    void displayResourceList(){
        System.out.println("User " + this.id + " resource count: " + this.request_count);
        for(Integer res: this.resourceArr) {
            System.out.print(" | " + res + " | ");
        }
        System.out.println();
    }
    boolean isWaiting(int requestId) {
        return this.resourceArr.contains(requestId);
    }
}
