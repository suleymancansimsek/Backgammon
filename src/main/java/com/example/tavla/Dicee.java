package com.example.tavla;

import java.util.Random;

public class Dicee {

    public static PairInteger roll() {

        Random random = new Random();

        int value1  = random.nextInt(6) + 1; // Returns number between 1 and 6
        int value2  = random.nextInt(6) + 1; // Returns number between 1 and 6

        PairInteger pair = new PairInteger(value1,value2);
        return pair;
    }

    public static int singleRoll() {
        Random random = new Random();
        int value1  = random.nextInt(6) + 1; // Returns number between 1 and 6
        return value1;
    }

    public static int decideWho(){
        Random random = new Random();
        int value1  = random.nextInt(2) + 1;
        return value1;
    }

}
