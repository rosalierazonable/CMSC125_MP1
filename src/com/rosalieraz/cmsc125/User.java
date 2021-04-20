package com.rosalieraz.cmsc125;

public class User {

    private final int id; //user 1, 2, 3 .. etc
    private int request_count; //randomized number of request to have
//    Request[] reqs = new Request[request_count];

    User(int id, int request_count) { //Constructor
        this.id = id;
        this.request_count = request_count;
    }

//    User(int id) {
//        this.id = id;
//    }

    int getId(){return this.id;}
    int getRequestCount() {
        return this.request_count;
    }
    void updateRequestCount() {
        this.request_count--;
    }
}
