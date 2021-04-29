package com.rosalieraz.cmsc125;

import java.lang.reflect.Array;
import java.util.*;

public class Program {
    User[] users;
    ArrayList<Request> activeReqs = new ArrayList<>();
    ArrayList<Integer> activeResources = new ArrayList<>();
    ArrayList<Integer> toBeDisplayed = new ArrayList<>();
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
    void getResourceToBeDisplayed() {
        ArrayList<Integer> toBeDisplayed = new ArrayList<>();
        for(Request res: this.requestSequence){
            toBeDisplayed.add(res.getResource());
        }
        this.toBeDisplayed = toBeDisplayed;
    }
    boolean isRequestFree(Request req) {
        return !this.requestSequence.contains(req) && !this.activeReqs.contains(req);
    }
    void displayInAction() {
        boolean isWaiting = false;
        setRequestSequence();
        for(Request req: this.requestSequence) {
            if(req.getStatus().equals("in action")) {
                req.in_action();
            } else {
                isWaiting = true;
            }
        }
        if(isWaiting)
            System.out.println("The rest of the requests will have to wait for other resources to be available.");
        System.out.println();
    }
    void displayProgramFlow() {
        Request temp = null;
        int idx;
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

                                temp = this.requestSequence.get(i); //keeps track of the current request

                                this.activeResources.remove(this.requestSequence.get(i).getResource()); //remove from active list of request
                                this.activeReqs.remove(this.requestSequence.get(i)); //remove from active list of request
                                this.requestSequence.remove(this.requestSequence.get(i)); //remove from the sequence

                                this.getResourceToBeDisplayed(); //set list of requests that are yet to be displayed
                                if(this.toBeDisplayed.contains(temp.getResource()) & this.requestSequence.size()!=1) { //check whether the resource that has just been completed still has existing request for it
                                    System.out.println("----- Preparing next user request on resource " + temp.getResource() + " -----");
                                } else {
                                    System.out.println("Resource " + temp.getResource() + " is now FREE. No more existing user request for this resource.");
                                }
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
                                this.requestSequence.get(i).is_waiting();
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
            System.out.println("__________________________________________________");
            System.out.println();
        }
    }
}
