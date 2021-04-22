package com.rosalieraz.cmsc125;

import java.util.ArrayList;

public class User {

    private final int id; //user 1, 2, 3 .. etc
//    private int request_count; //randomized number of request to have
//    ArrayList<Integer> resourceArr= new ArrayList<Integer>();
    Request[] userRequests;

//    User(int id, int request_count) { //Constructor
    User(int id) { //Constructor
        this.id = id;
//        this.request_count = request_count;
    }

    //Getter Functions
    int getId(){return this.id;}
    int getRequestCount() {return this.userRequests.length;}
//    int getRequestCount() {
//        return this.request_count;
//    }
//    void updateRequestCount() {
//        this.request_count--;
//    }
//    void setResourceArray(ArrayList<Integer> resources){
//        this.resourceArr.addAll(resources);
//    }
//    void displayResourceList(){
//        System.out.println("User " + this.id + " resource count: " + this.request_count);
//        for(Integer res: this.resourceArr) {
//            System.out.print(" | " + res + " | ");
//        }
//        System.out.println();
//    }
//    boolean isWaiting(int requestId) {
//        return this.resourceArr.contains(requestId);
//    }

    //Setter Functions
    void setUserRequests(Request[] requests) {
        this.userRequests = requests;
    }

    //Helper functions
    void displayUserDetail() {
        System.out.println("User " + this.id + " has " + this.userRequests.length + " resource request/s.");
    }
}
