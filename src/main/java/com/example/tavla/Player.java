package com.example.tavla;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.util.Random;

public class Player {
    int playRight = 2;
    Players players;
    static boolean blackturn;
    static boolean whiteturn = !blackturn;

    Player(Players players){
        this.players=players;
    }
    Player(){

    }
    void resetPlayerRight(){
        playRight = 2;
    }

    void play(Pane pane, Circle circle, PairInteger diceResults){

            switch (this.players){
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
    }


}
