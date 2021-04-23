package com.rosalieraz.cmsc125;

import java.util.ArrayList;

public class User {

    private final int id; //user 1, 2, 3 .. etc
    Request[] userRequests;

    User(int id) { //Constructor
        this.id = id;
    }

    //Getter Functions
    int getId(){return this.id;}
    int getRequestCount() {return this.userRequests.length;}

    //Setter Functions
    void setUserRequests(Request[] requests) {
        this.userRequests = requests;
    }

    //Helper functions
    void displayUserDetail() {
        System.out.println("User " + this.id + " has " + this.userRequests.length + " resource request/s.");
    }

    void displayRequestedResources() {
        System.out.print("Requested resource/s: ");
        for(Request req: userRequests) {
            System.out.print(req.getResource() + " ");
        }
        System.out.println();
    }
}
