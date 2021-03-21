package com.rosalieraz.cmsc125;

import java.util.Random;

public class Main {
    static Random random = new Random();
//    static int user_count, resource_count;

    public static void main(String[] args) {

//        user_count = random();
//        resource_count = random();
//
//        int[] resource = new int[resource_count];
//        for(int i=0; i<user_count; i++) {
//            User user1 = new User(1,resource_count);
//            resource[i] = random();
//        }

//        System.out.println(user_count);
//        System.out.println(resource_count);
        Frame frame = new Frame();
    }

    static int random() {
        return random.nextInt(5)+1;
    }
}
