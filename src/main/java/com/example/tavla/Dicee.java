package com.example.tavla;

import java.util.Random;

public class Dicee {

    public static Pair roll() {

        Random random = new Random();

        int value1  = random.nextInt(6) + 1; // Returns number between 1 and 6
        int value2  = random.nextInt(6) + 1; // Returns number between 1 and 6

        Pair pair = new Pair(value1,value2);
        return pair;
    }

}