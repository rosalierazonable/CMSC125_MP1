package com.rosalieraz.cmsc125;

import java.util.*;

public class Program {
    User[] users;
    ArrayList<User> waitListed = new ArrayList<>();
    LinkedHashMap<Integer, Request> requestSequence = new LinkedHashMap<>();

    //Constructor
    Program(User[] user){
        this.users = user;
    }

    // Getter Functions
    ArrayList<User> getWaitListed() {
        return this.waitListed;
    }

    //Helper Functions
    void timer(Request req) {
        if(req != null) {
            while( req.getTimeRemaining()!=0) {
                req.display_time();
            }
        }
    }
    boolean isRequestFree(Request req) {
        for (User user: this.users) {
           if(user.userRequests.contains(req))
               return true;
        }
        return false;
    }
    ArrayList<Integer> getCurrentRequest(){
        ArrayList<Integer> currReqs = new ArrayList<>();
        for (User user: users) {
            if(currReqs.isEmpty()) {
                currReqs.add(user.getCurrReq());

            } else if(!currReqs.contains(user.getCurrReq())) {
                currReqs.add(user.getCurrReq());
            } else {
                currReqs.add(0);
//                idx = currReqs.indexOf(user.getCurrReq());
//                currReqs.get(idx);
                this.waitListed.add(user);
            }
        }
        return currReqs;
    }
//    void setRequestSequence(){
//        ArrayList<Integer> currReqs = new ArrayList<>();
//        for (User user: users) {
//            if(currReqs.isEmpty()) {
//                currReqs.add(user.getCurrReq());
//            } else if(!currReqs.contains(user.getCurrReq())) {
//                currReqs.add(user.getCurrReq());
//            } else {
//                currReqs.add(0);
////                idx = currReqs.indexOf(user.getCurrReq());
////                currReqs.get(idx);
//                this.waitListed.add(user);
//            }
//        }
//        return currReqs;
//    }
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
    void displayInAction() {
        ArrayList<String> status = getStatus(getCurrentRequest());
        for(int i = 0; i < status.size(); i++) {
            if(status.get(i).equals("in_action")) {
                users[i].userRequests.get(0).in_action();
                users[i].removeDisplayedReq();
            } else {
                users[i].userRequests.get(0).is_waiting();
            }
        }
    }
    void displayProgram() {
        ArrayList<String> status = getStatus(getCurrentRequest());
        for(int i = 0; i < status.size(); i++) {
            if(status.get(i).equals("in_action")) {
                if(i == 0)
                    users[i].userRequests.get(0).in_action();

                if(users[i].userRequests.get(0).getTimeRemaining() != 0){
                    users[i].userRequests.get(0).display_time();
                } else
                    users[i].userRequests.get(0).displayCompleteReq();
            }
        }
    }
}
