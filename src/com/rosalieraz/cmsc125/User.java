package com.rosalieraz.cmsc125;

public class User {

    int id; //user 1, 2, 3 .. etc
    int request_count; //randomized number of request to have

    User(int id, int request_count) {
        this.id = id;
        this.request_count = request_count;
    }
}
