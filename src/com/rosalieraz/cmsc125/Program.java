package com.rosalieraz.cmsc125;

import org.jetbrains.annotations.NotNull;
import java.util.*;

public class Program {
    User[] users;
    Request[] reqs;

    Program(User[] user, Request[] req){
        this.users = user;
        this.reqs = req;
    }

    ArrayList<Integer> getUsersWaiting(int requestId) {
        ArrayList<Integer> usersWaiting = new ArrayList<Integer>();

        for(User user: this.users) {
            if(user.isWaiting(requestId))
                usersWaiting.add(user.getId());
        }

        return usersWaiting;
    }
    void timer(@NotNull Request req) {
        while( req.getTimeRemaining()!=0) {
            req.display_time();
        }
    }
    boolean isRequestFree(Request req) {
        return req.is_completed();
    }
    void displayProgramFlow() {
        for (Request req: this.reqs) {
            req.in_action(); //reports that a specific request on a resource is being done
            Request.in_waiting(getUsersWaiting(req.getUser()), req.getResource());
            timer(req); // facilitates allocated time for the specific request
            req.setStatus("complete");
            req.reportRequest();
            users[req.getUser()].updateRequestCount();
        }
    }
}
