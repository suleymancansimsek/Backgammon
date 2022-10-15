package com.example.tavla;

import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class CheckerCreate {

    Circle checker;


    public Circle createSingleChecker(String color, String ID){
        checker = new Circle(20, Paint.valueOf(color));
        checker.setId(ID);
        return checker;
    }

    public void createAllWhiteCheckers(){

        for (int i=0; i<15; i++){
            String ID = String.valueOf(i);
            CheckerList.whiteCheckers.add(createSingleChecker(Constants.whiteStoneColor,ID));
        }
    }

    public void createAllBlackCheckers(){

        for (int i=0; i<15; i++){
            String ID = String.valueOf(i + 15);
            CheckerList.blackCheckers.add(createSingleChecker(Constants.blackStoneColor,ID));
        }
    }

}
