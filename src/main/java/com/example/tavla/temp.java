//package com.example.tavla;
//
//public class temp {
//                    switch (diceResults.value1){
//        case 1:
//            System.out.println(initalPosition);
//            //targetPosition =
//            break;
//        case 2:
//            System.out.println(initalPosition);
//            break;
//        case 3:
//            System.out.println(initalPosition);
//            break;
//        case 4:
//            System.out.println(initalPosition);
//            break;
//        case 5:
//            System.out.println(initalPosition);
//            break;
//        case 6:
//            System.out.println(initalPosition);
//            break;
//
//    }
//                switch (diceResults.value2){
//        case 1:
//            System.out.println(initalPosition);
//            //targetPosition =
//            break;
//        case 2:
//            System.out.println(initalPosition);
//            break;
//        case 3:
//            System.out.println(initalPosition);
//            break;
//        case 4:
//            System.out.println(initalPosition);
//            break;
//        case 5:
//            System.out.println(initalPosition);
//            break;
//        case 6:
//            System.out.println(initalPosition);
//            break;
//
//    }
//                switch (diceResults.value1 + diceResults.value2){
//        case 1:
//            System.out.println(initalPosition);
//            //targetPosition =
//            break;
//        case 2:
//            System.out.println(initalPosition);
//            break;
//        case 3:
//            System.out.println(initalPosition);
//            break;
//        case 4:
//            System.out.println(initalPosition);
//            break;
//        case 5:
//            System.out.println(initalPosition);
//            break;
//        case 6:
//            System.out.println(initalPosition);
//            break;
//        case 7:
//            System.out.println(initalPosition);
//            //targetPosition =
//            break;
//        case 8:
//            System.out.println(initalPosition);
//            break;
//        case 9:
//            System.out.println(initalPosition);
//            break;
//        case 10:
//            System.out.println(initalPosition);
//            break;
//        case 11:
//            System.out.println(initalPosition);
//            break;
//        case 12:
//            System.out.println(initalPosition);
//            break;
//
//    }
//}

//
//
//if (CheckerList.blackCheckers.contains(circle)){
//
//        //1. segment
//        if (0<initalPosition && initalPosition<7 ){
//        if (initalPosition > value1){
//        targetPosition1 = initalPosition - value1;
//        System.out.println(targetPosition1);
//        }
//        if (initalPosition <= value1){
//        targetPosition1 = value1 + 13 - initalPosition;
//        System.out.println(value1);
//        System.out.println(targetPosition1);
//
//        }
//        if (initalPosition > value2){
//        targetPosition2 = initalPosition - value2;
//        System.out.println(targetPosition2);
//
//        }
//        if (initalPosition <= value2){
//        targetPosition2 = value2 + 13 - initalPosition;
//        System.out.println(targetPosition2);
//
//        }
//        if (initalPosition > value3){
//        targetPosition3 = initalPosition - value3;
//        System.out.println(targetPosition3);
//
//        }
//        if (initalPosition <= value3){
//        targetPosition3 = value3 + 13 - initalPosition;
//        System.out.println(targetPosition3);
//
//        }
//
//        }
//
//        // 2. segment
//        if (6<initalPosition && initalPosition<13 ){
//        if (initalPosition > value1){
//        targetPosition1 = initalPosition - value1;
//        System.out.println("Target POS: " + targetPosition1);
//        }
//
//        if (initalPosition > value2){
//        targetPosition2 = initalPosition - value2;
//        }
//
//        if (initalPosition > value3){
//        targetPosition3 = initalPosition - value3;
//        }
//        if (initalPosition <= value3){
//        targetPosition3 = value3 + 13 - initalPosition;
//        }
//        }
//
//        // 3. segment
//        if (12<initalPosition && initalPosition<19 ){
//        if (initalPosition > value1){
//        targetPosition1 = initalPosition + value1;
//        System.out.println("Target POS: " + targetPosition1);
//        }
//
//        if (initalPosition > value2){
//        targetPosition2 = initalPosition + value2;
//        }
//
//        if (initalPosition > value3 && !(value3 == 12)){
//        targetPosition3 = initalPosition + value3;
//        }
//        if (value3 == 12){
//        System.out.println("you can not play!");
//        }
//        }
//
//        // 4. segment
//        if (18<initalPosition && initalPosition<24 ){
//        if (initalPosition > value1 && !(value1 == 6)){
//        targetPosition1 = initalPosition + value1;
//        }
//        if (value1 == 6){
//        System.out.println("you can not play!");
//        }
//
//        if (initalPosition > value2  && !(value2 == 6)){
//        targetPosition2 = initalPosition - value2;
//        }
//        if (value2 == 6){
//        System.out.println("you can not play!");
//        }
//
//        if (initalPosition > value3  && !(value3 < 6)){
//        targetPosition3 = initalPosition + value3;
//        }
//        if (value3 > 6){
//        System.out.println("you can not play!");
//        }
//        }
//
//        }