package com.rosalieraz.cmsc125;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.*;

public class Program {
    User[] users;

    Program(User[] user){
        users = user;
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

     ArrayList<Integer> getCurrentRequest(){
        ArrayList<Integer> currReqs = new ArrayList<Integer>();
        for (User user: users) {
            if(currReqs.isEmpty()) {
                currReqs.add(user.getCurrReq());
            } else if(!currReqs.contains(user.getCurrReq())) {
                currReqs.add(user.getCurrReq());
            } else {
                currReqs.add(0);
            }
        }
        return currReqs;
    }

    ArrayList<String> getStatus(ArrayList<Integer> currReqs) {
        ArrayList<String> status = new ArrayList<>();
        for (Integer req: currReqs) {
            if(req!=0) {
                status.add("in_action");
            } else {
                status.add("waiting");
            }
        }
        return status;
    }


     void displayStatus() {
        System.out.print("Request Status: ");
        ArrayList<String> stats = getStatus(getCurrentRequest());

        for (String stat: stats) {
            System.out.print(stat + " ");
        }
        System.out.println();
    }
}
