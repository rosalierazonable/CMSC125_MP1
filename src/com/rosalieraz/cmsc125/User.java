package com.rosalieraz.cmsc125;

import java.util.ArrayList;

public class User {

    private final int id; //user 1, 2, 3 .. etc
    ArrayList<Request> userRequests;

    User(int id) { //Constructor
        this.id = id;
    }

    //Getter Functions
    int getId(){return this.id;}

    //Setter Functions
    void setUserRequests(ArrayList<Request> requests) {
        this.userRequests = requests;
    }

    //Helper functions
    void displayUserDetail() {
        System.out.println("User " + this.id + " has " + this.userRequests.size() + " resource request/s.");
    }
    void displayRequestedResources() {
        System.out.print("Requested resource/s: ");
        for(Request req: userRequests) {
            System.out.print(req.getResource() + " ");
        }
        System.out.println();
    }
}
