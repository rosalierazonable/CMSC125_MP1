package com.rosalieraz.cmsc125;

import java.util.*;

public class Program {
    User[] users;
    ArrayList<Request> activeReqs = new ArrayList<>();
    ArrayList<Integer> activeResources = new ArrayList<>();
    ArrayList<Request> requestSequence = new ArrayList<>();

    //Constructor
    Program(User[] user){
        this.users = user;
    }

    // Setter Functions
    void setRequestSequence(){
        ArrayList<Integer> currReqs = new ArrayList<>();
        int idx = 0;
       while(idx < getMaxSize()) {
           for (User user: users) {
               if(idx < user.userRequests.size()) {
                   if (currReqs.isEmpty() || !currReqs.contains(user.userRequests.get(idx).getResource())) {
                       currReqs.add(user.userRequests.get(idx).getResource());
                       user.userRequests.get(idx).setStatus("in action");
                   } else {
                       user.userRequests.get(idx).setStatus("in waiting");
                   }
                   this.requestSequence.add(user.userRequests.get(idx));
               }
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
//    boolean isRequestFree(Request req) {
//        for (User user: this.users) {
//           if(user.userRequests.contains(req))
//               return true;
//        }
//        return false;
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
//    }
    void displayProgramFlow() {
        int idx;
        setRequestSequence();
        while(!this.requestSequence.isEmpty()) { //while all requests are not yet displayed
            for(int i=0; i<this.users.length; i++) { //must print based on the number of users
                if(i < this.requestSequence.size()) {
                    switch (requestSequence.get(i).getStatus()) {
                        case "in action":
                            if (requestSequence.get(i).getTimeRemaining() > 0) { //if the request hasn't been exhausted
                                this.activeReqs.add(this.requestSequence.get(i)); //add to active requests
                                this.activeResources.add(this.requestSequence.get(i).getResource());
                                this.requestSequence.get(i).display_time(); //display time left
                            } else {
                                this.requestSequence.get(i).setStatus("complete"); //set status to complete
                                this.requestSequence.get(i).displayCompleteReq(); //report that the request has been completed
                                this.activeReqs.remove(this.requestSequence.get(i)); //remove from active list of request
                                this.activeResources.remove(this.requestSequence.get(i).getResource()); //remove from active list of request
                                this.requestSequence.remove(this.requestSequence.get(i)); //remove from the sequence
                            }
                            break;
                        case "in waiting":
//                            if(this.requestSequence.get(i).waitingTime == -1) { //if the waiting Time is still set to default
                                idx = this.activeResources.indexOf(this.requestSequence.get(i).getResource());
                                if(idx > -1) {
                                    this.requestSequence.get(i).setWaitingTime(activeReqs.get(idx).getTimeRemaining());
                                }
//                            }

                            if(this.requestSequence.get(i).waitingTime > 0)
                                this.requestSequence.get(i).is_waiting();
                            else {
                                this.activeResources.add(this.requestSequence.get(i).getResource());
                                this.activeReqs.add(this.requestSequence.get(i));
                                this.requestSequence.get(i).setStatus("in action");
                            }
                            break;
                        default:
                            System.out.println("default");
                            break;
                    }
                }
            }
            System.out.println("-------------------------------------------");
            System.out.println();
        }
    }
}
