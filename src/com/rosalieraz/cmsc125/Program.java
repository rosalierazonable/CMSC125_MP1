package com.rosalieraz.cmsc125;

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
    void Timer(User user, Request req) {
        while( req.getTimeRemaining()!=0) {
            req.display_time();
        }
    }
    boolean isRequestFree(Request req) {
        return req.is_completed();
    }
}
