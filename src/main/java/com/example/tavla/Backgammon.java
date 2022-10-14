package com.example.tavla;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

public class Backgammon implements BackGammonChecker{

//    DraggableObject draggableObject =  new DraggableObject();
    private double mouseAnchorX;
    private double mouseAnchory;

    @Override
    public void move(int diceResult1, int diceResult2, Node node, VBox vBox, Pane pane) {
//        draggableObject.makeDraggable(node);

    }

    @Override
    public void newGamePattern(List<VBox> vBoxList) {
//        for (int i=0; i<vBoxList.size(); i++){
//            vBoxList.get(i).getChildren().add(Li);
//        }
        vBoxList.get(0).getChildren().add(CheckerList.blackCheckers.get(0));
        vBoxList.get(0).getChildren().add(CheckerList.blackCheckers.get(1));
        vBoxList.get(0).getChildren().add(CheckerList.blackCheckers.get(2));
        vBoxList.get(0).getChildren().add(CheckerList.blackCheckers.get(3));
        vBoxList.get(0).getChildren().add(CheckerList.blackCheckers.get(4));

        vBoxList.get(4).getChildren().add(CheckerList.whiteCheckers.get(0));
        vBoxList.get(4).getChildren().add(CheckerList.whiteCheckers.get(1));
        vBoxList.get(4).getChildren().add(CheckerList.whiteCheckers.get(2));

        vBoxList.get(6).getChildren().add(CheckerList.whiteCheckers.get(3));
        vBoxList.get(6).getChildren().add(CheckerList.whiteCheckers.get(4));
        vBoxList.get(6).getChildren().add(CheckerList.whiteCheckers.get(5));
        vBoxList.get(6).getChildren().add(CheckerList.whiteCheckers.get(6));
        vBoxList.get(6).getChildren().add(CheckerList.whiteCheckers.get(7));

        vBoxList.get(11).getChildren().add(CheckerList.blackCheckers.get(5));
        vBoxList.get(11).getChildren().add(CheckerList.blackCheckers.get(6));

        vBoxList.get(12).getChildren().add(CheckerList.whiteCheckers.get(8));
        vBoxList.get(12).getChildren().add(CheckerList.whiteCheckers.get(9));
        vBoxList.get(12).getChildren().add(CheckerList.whiteCheckers.get(10));
        vBoxList.get(12).getChildren().add(CheckerList.whiteCheckers.get(11));
        vBoxList.get(12).getChildren().add(CheckerList.whiteCheckers.get(12));

        vBoxList.get(16).getChildren().add(CheckerList.blackCheckers.get(7));
        vBoxList.get(16).getChildren().add(CheckerList.blackCheckers.get(8));
        vBoxList.get(16).getChildren().add(CheckerList.blackCheckers.get(9));

        vBoxList.get(18).getChildren().add(CheckerList.blackCheckers.get(10));
        vBoxList.get(18).getChildren().add(CheckerList.blackCheckers.get(11));
        vBoxList.get(18).getChildren().add(CheckerList.blackCheckers.get(12));
        vBoxList.get(18).getChildren().add(CheckerList.blackCheckers.get(13));
        vBoxList.get(18).getChildren().add(CheckerList.blackCheckers.get(14));

        vBoxList.get(23).getChildren().add(CheckerList.whiteCheckers.get(13));
        vBoxList.get(23).getChildren().add(CheckerList.whiteCheckers.get(14));

    }

}
