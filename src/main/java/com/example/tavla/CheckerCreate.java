package com.example.tavla;

import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class CheckerCreate {

    Circle checker;


    public Circle createSingleChecker(String color){
        checker = new Circle(20, Paint.valueOf(color));
        return checker;
    }

    public void createAllWhiteCheckers(){

        for (int i=0; i<15; i++){
            CheckerList.whiteCheckers.add(createSingleChecker(Constants.whiteStoneColor));
        }
    }

    public void createAllBlackCheckers(){

        for (int i=0; i<15; i++){
            CheckerList.blackCheckers.add(createSingleChecker(Constants.blackStoneColor));
        }
    }

}
