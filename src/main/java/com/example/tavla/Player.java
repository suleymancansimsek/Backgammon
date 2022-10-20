package com.example.tavla;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class Player {
    int playRight=2;


    void resetPlayerRight(){
        playRight = 2;
    }

    void play(Pane pane, Circle circle, PairInteger diceResults){

        if (playRight>0){
            switch (FindObject.playerColor(circle)){
                case UNKNOWN -> {
                    System.out.println("unknown checker error");
                    break;
                }
                case WHITE -> {
                    FindObject.moveWhite(pane,circle,diceResults);
                    break;}
                case BLACK -> {
                    FindObject.moveBlack(pane,circle,diceResults);
                    break;
                }
            }
            playRight--;
        }
        if (playRight == 0){
            System.out.println("Other player turn");
            resetPlayerRight();
        }

    }
}
