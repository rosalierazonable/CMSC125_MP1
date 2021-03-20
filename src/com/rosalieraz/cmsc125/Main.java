package com.rosalieraz.cmsc125;

import java.util.Random;
import java.util.Queue;

public class Main {
    static Random random = new Random();
    static int user_count, resource_count;

    public static void main(String[] args) {

        user_count = random();
        resource_count = random();

        System.out.println(user_count);
        System.out.println(resource_count);
    }

    static int random() {
        return random.nextInt(5)+1;
    }
}
