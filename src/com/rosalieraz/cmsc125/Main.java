package com.rosalieraz.cmsc125;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int user_count, resource_count, time_length, resource;
        Queue<Request[]> requests = new LinkedList<Request[]>();
        ArrayList<Integer> takenResource = new ArrayList<Integer>();

        user_count = random(5); //generate random number of users that will need a resource
        User[] users = new User[user_count]; //declare an array of User objects

        resource_count = random(5); //generate random number of resource that will be available for the users

        for(int i = 0; i < user_count; i++) {
            /* initialize user object with id and randomly generated request_count out of the resource_count (# of requests available)
             * the limit bound set in the random function is set to be the number of resource available in the program since they can
             * only request a specific resource once
             */
            users[i] = new User(i+1, random(resource_count));

            Request[] reqs = new Request[users[i].getRequestCount()];

            for(int j = 0; j < users[i].getRequestCount(); j++) {
                resource = random(resource_count); //randomize which resource to be requested
                time_length = random(10); // randomize the duration

                if(takenResource.contains(resource)) {
                    resource = random(resource_count);
                }

                reqs[j] = new Request("User " + users[i].getId(), users[i].getId(), resource, time_length); //initialize Request object
                takenResource.add(resource);
            }

            requests.add(reqs);
        }

        System.out.println("USer count: " + user_count);
        System.out.println("Resource count: " + resource_count);
        displayRequests(requests);



//
//        int[] resource = new int[resource_count];
//        for(int i=0; i<user_count; i++) {
//            User user1 = new User(1,resource_count);
//            resource[i] = random();
//        }

//        System.out.println(user_count);
//        System.out.println(resource_count);

//        Frame frame = new Frame();
//
//        JLabel label = new JLabel();
//        label.setSize(50, 50);
//        label.setBackground(Color.gray);
//        label.setText("Sample Text");
//        label.setForeground(Color.BLUE);
//        label.setVerticalAlignment(JLabel.CENTER);
//        label.setHorizontalAlignment(JLabel.CENTER);
//        frame.add(label);

    }

    public static int random(int bound) {
        Random random = new Random();

        return random.nextInt(bound)+1;
    }

    public static void displayRequests(Queue<Request[]> reqs) {
        for (Request[] reqArr: reqs) {
            for (Request req: reqArr) {
                req.display_time();
                if(req.is_completed()) {
                    req.reportRequest();
                }
            }
        }
    }
}


/* REFERENCES:
*
* https://techvidvan.com/tutorials/java-methods/
* https://www.youtube.com/watch?v=xk4_1vDrzzo&t=20013s&ab_channel=BroCode
* https://www.tutorialspoint.com/java-program-to-concatenate-a-string-and-integers
* https://stackoverflow.com/questions/32597399/is-it-possible-to-create-n-number-of-objects-in-java-using-a-for-loop
* https://www.javatpoint.com/for-each-loop
* https://www.javatpoint.com/object-and-class-in-java
* https://techvidvan.com/tutorials/java-methods/
* https://www.tutorialspoint.com/queue-in-java
* https://www.geeksforgeeks.org/queue-interface-java/
*/