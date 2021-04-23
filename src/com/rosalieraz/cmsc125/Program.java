package com.rosalieraz.cmsc125;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.*;

public class Program {
    User[] users;

    Program(User[] user){
        this.users = user;
    }

    //Helper Functions
    void timer(@NotNull Request req) {
        while( req.getTimeRemaining()!=0) {
            req.display_time();
        }
    }
    boolean isRequestFree(Request req) {
        return req.is_completed();
    }
    static ArrayList<Boolean> areRequestsUnique(ArrayList<Queue<Integer>> resList) {
        ArrayList<Integer> activeRes = new ArrayList<>(); //temporarily holds the unique resource_id
        ArrayList<Boolean> requestStat = new ArrayList<>(); //keeps track of the request status: unique or not

        for (Queue<Integer> rList: resList) {

            if(!activeRes.isEmpty()) {
                if(!activeRes.contains(rList.peek())) {
                    requestStat.add(true); // sets status to true which means that the resource at this index is indeed unique
                    activeRes.add(rList.poll()); //keeps track of unique resource idx
                } else {
                    requestStat.add(false); // sets status to false which means that the some user is still waiting for this resource
                    activeRes.add(0); // just to identify that this resource must not be modified, resource not been dealt with yet
                }
            } else {
                requestStat.add(true); // sets status to true which means that the resource at this index is indeed unique
                activeRes.add(rList.peek()); //keeps track of unique resource idx
            }
        }
        return requestStat;
    }

    static void displayStatus(ArrayList<Boolean> stats) {
        System.out.print("Request Status: ");
        for (Boolean stat: stats) {
            System.out.print(stat + " ");
        }
        System.out.println();
    }
}
