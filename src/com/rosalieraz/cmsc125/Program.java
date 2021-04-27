package com.rosalieraz.cmsc125;

import java.util.*;

public class Program {
    User[] users;
    ArrayList<Request> activeReqs = new ArrayList<>();
    ArrayList<Request> requestSequence = new ArrayList<>();

    //Constructor
    Program(User[] user){
        this.users = user;
    }

    // Getter Functions
//    ArrayList<User> getWaitListed() {
//        return this.waitListed;
//    }
//    ArrayList<Request> getWaitListed() {
//        return this.waitListed;
//    }

    // Setter Functions
    void setRequestSequence(){
        ArrayList<Integer> currReqs = new ArrayList<>();
        int idx = 0;
       while(idx < getMaxSize()) {
           for (User user: users) {
               if(idx < user.userRequests.size()) {
                   if(currReqs.isEmpty() || !currReqs.contains(user.userRequests.get(idx).getResource())) {
                       currReqs.add(user.userRequests.get(idx).getResource());
                       user.userRequests.get(idx).setStatus("in action");
                   } else {
                       user.userRequests.get(idx).setStatus("in waiting");
//                       user.userRequests.get(idx).setWaitingTime(5);
                       //                    this.waitListed.add(user.userRequests.get(idx));
                   }
                   this.requestSequence.add(user.userRequests.get(idx));
               } else {
                   this.requestSequence.add(null);
               }
//            if (currReqs.isEmpty()) {
//                currReqs.add(user.getCurrResource());
////                requestSequence.put(idx, user.getCurrRequest());
//                requestSequence.add(user.getCurrRequest());
//                user.removeDisplayedReq();
//            } else if (!currReqs.contains(user.getCurrResource())) {
//                currReqs.add(user.getCurrResource());
//                requestSequence.add(user.getCurrRequest());
//                user.removeDisplayedReq();
//            } else {
//                currReqs.add(0);
////                idx = currReqs.indexOf(user.getCurrReq());
////                currReqs.get(idx);
//                this.waitListed.add(user.getCurrRequest());
//            }
           }
           idx++;
       }
    }

    //Helper Functions
    int getMaxSize() {
        int maxSize = 0;
        for(User user: users) {
            if(user.userRequests.size() > maxSize)
                maxSize = user.userRequests.size();
        }
        return maxSize;
    }
//    void timer(Request req) {
//        if(req != null) {
//            while( req.getTimeRemaining()!=0) {
//                req.display_time();
//            }
//        }
//    }
//    boolean isRequestFree(Request req) {
//        for (User user: this.users) {
//           if(user.userRequests.contains(req))
//               return true;
//        }
//        return false;
//    }
//    ArrayList<Integer> getCurrentRequest(){
//        ArrayList<Integer> currReqs = new ArrayList<>();
//        for (User user: users) {
//            if(currReqs.isEmpty()) {
//                currReqs.add(user.getCurrResource());
//
//            } else if(!currReqs.contains(user.getCurrResource())) {
//                currReqs.add(user.getCurrResource());
//            } else {
//                currReqs.add(0);
////                this.waitListed.add(user);
//            }
//        }
//        return currReqs;
//    }
//    ArrayList<String> getStatus(ArrayList<Integer> currReqs) {
//        ArrayList<String> status = new ArrayList<>();
//        for (Integer req: currReqs) {
//            if(req!=0) {
//                status.add("in_action");
//            } else {
//                status.add("waiting");
//            }
//        }
//        return status;
//    }
//    ArrayList<String> getStatus(ArrayList<Integer> currReqs) {
//        ArrayList<String> status = new ArrayList<>();
//        for (Integer req: currReqs) {
//            if(req!=0) {
//                 status.add("in_action");
//            } else {
//                status.add("waiting");
//            }
//        }
//        return status;
//    }
//    void displayStatus() {
//        System.out.print("Request Status: ");
//        ArrayList<String> stats = getStatus(getCurrentRequest());
//
//        for (String stat: stats) {
//            System.out.print(stat + " ");
//        }
//        System.out.println();
//    }
//    void displayStatus() {
//        System.out.print("Request Status: ");
//        ArrayList<String> stats = getStatus(setRequestSequence());
//
//        for (String stat: stats) {
//            System.out.print(stat + " ");
//        }
//        System.out.println();
//    }
//    void displayInAction() {
//        ArrayList<String> status = getStatus(getCurrentRequest());
//        for(int i = 0; i < status.size(); i++) {
//            if(status.get(i).equals("in_action")) {
//                users[i].userRequests.get(0).in_action();
//                users[i].removeDisplayedReq();
//            } else {
//                users[i].userRequests.get(0).is_waiting();
//            }
//        }
//    } n
//    void displayInAction() {
//        ArrayList<String> status = getStatus(setRequestSequence());
//        for(int i = 0; i < status.size(); i++) {
//            if(status.get(i).equals("in_action")) {
//                if(!users[i].userRequests.isEmpty())
//                    users[i].userRequests.get(0).in_action();
////                users[i].removeDisplayedReq();
//            } else {
//                if(!users[i].userRequests.isEmpty())
//                    users[i].userRequests.get(0).is_waiting();
//            }
//        }
//    }
//    void displayProgram() {
//        ArrayList<String> status = getStatus(getCurrentRequest());
//        for(int i = 0; i < status.size(); i++) {
//            if(status.get(i).equals("in_action")) {
//                if(i == 0)
//                    users[i].userRequests.get(0).in_action();
//
//                if(users[i].userRequests.get(0).getTimeRemaining() != 0){
//                    users[i].userRequests.get(0).display_time();
//                } else
//                    users[i].userRequests.get(0).displayCompleteReq();
//            }
//        }
//    }
    void displayProgramFlow() {
        int idx;
        setRequestSequence();
//        System.out.println("Array size: " + requestSequence.size());
//        for(Request req: requestSequence) {
//            if(req!=null) {
//                System.out.print(req.getResource() + ":" + req.getStatus() + " | ");
//            }
//        }
//        System.out.println();
        System.out.println("l: " + this.users.length);
        while(!this.requestSequence.isEmpty()) { //while all requests are not yet displayed
            for(int i=0; i<this.users.length+1; i++) { //must print based on the number of users
                if(this.requestSequence.get(i) != null) {
                    switch (this.requestSequence.get(i).getStatus()) {
                        case "in action":
                            if (this.requestSequence.get(i).getTimeRemaining() > 0) { //if the request hasn't been exhausted
                                this.activeReqs.add(this.requestSequence.get(i)); //add to active requests
                                requestSequence.get(i).display_time(); //display time left
                            } else {
                                this.requestSequence.get(i).setStatus("complete"); //set status to complete
                                this.requestSequence.get(i).displayCompleteReq(); //report that the request has been completed
                                this.activeReqs.remove(this.requestSequence.get(i)); //remove from active list of request
                                this.requestSequence.remove(this.requestSequence.get(i)); //remove from the sequence
                            }
                            break;
                        case "in waiting":
                            if(this.requestSequence.get(i).waitingTime == -1) { //if the waiting Time is still set to default
                                idx = activeReqs.indexOf(this.requestSequence.get(i));
                                if(idx != -1)
                                    this.requestSequence.get(i).setWaitingTime(activeReqs.get(idx).getTimeRemaining());
                            }

                            if (this.requestSequence.get(i).waitingTime > 0)
                                this.requestSequence.get(i).is_waiting();
                            else {
                                this.requestSequence.get(i).setStatus("in action");
                            }
                            break;
                    }
                }
            }
            System.out.println();
            System.out.println("-------------------------------------------");
        }
    }
}
