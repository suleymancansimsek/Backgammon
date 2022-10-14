package com.example.tavla;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import static java.lang.Integer.parseInt;

public class CheckerMove implements DragDrop{

    private double mouseAnchorX;
    private double mouseAnchory;

//    CheckerMove(Node node, VBox vBox /*, VBox targetVbox */, Pane pane /*, Pair diceResults */){
//        vBox.getChildren().remove(node);
//        pane.getChildren().add(node);
//        Drag(node);
//
//    }

    public void move(Node node, VBox vBox, Pane pane, VBox targetVbox,Pair diceResults){
        diceResults = Dicee.roll();

        int value1 = diceResults.value1;
        int value2 = diceResults.value2;

        drag(node,vBox,pane);
        int initalPosition;
        int targetPosition;
        if (CheckerList.whiteCheckers.contains(node)){
            getVboxNumber(vBox);
        }

        drop(node,targetVbox);
    }

    @Override
    public void drag(Node node, VBox vBox, Pane pane) {
        node.setOnMousePressed(mouseEvent -> {
            vBox.getChildren().remove(node);
            pane.getChildren().add(node);
            mouseAnchorX = mouseEvent.getX();
            mouseAnchory = mouseEvent.getY();
            //double vboxX = anotherVbox.getLayoutX();
            //double vboxY = anotherVbox.getLayoutY();
//            System.out.println(vboxX);
//            System.out.println(vboxY);

        });

        node.setOnMouseDragged(mouseEvent -> {
            node.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX);
            node.setLayoutY(mouseEvent.getSceneY() - mouseAnchory);
        });
    }

    @Override
    public void drop(Node node , VBox targetVbox) {
        node.setOnMouseReleased(mouseEvent -> {
            targetVbox.getChildren().add(node);
        });
    }

    public  int getVboxNumber(VBox vBox){
        String vBoxID = vBox.getId();
        String vBoxNumber = vBoxID.replace("vBox","");
        //System.out.println(vBoxNumber);
        int number = parseInt(vBoxNumber);
        System.out.println(number);
        return number;
    }


}
