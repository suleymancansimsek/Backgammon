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

    public void move(Node node, VBox vBox, Pane pane, Pair diceResults){
       // diceResults = Dicee.roll();


        int value1 = diceResults.value1;
        int value2 = diceResults.value2;
        int value3 = value1 + value2;

        drag(node,vBox,pane);

        int initalPosition = getVboxNumber(vBox);
        int targetPosition1;
        int targetPosition2;
        int targetPosition3;

        if (CheckerList.blackCheckers.contains(node)){

            //1. segment
            if (0<initalPosition && initalPosition<6 ){
                if (initalPosition > value1){
                    targetPosition1 = initalPosition - value1;
                    System.out.println(targetPosition1);
                }
                if (initalPosition <= value1){
                    targetPosition1 = value1 + 13 - initalPosition;
                    System.out.println(value1);
                    System.out.println(targetPosition1);

                }
                if (initalPosition > value2){
                    targetPosition2 = initalPosition - value2;
                    System.out.println(targetPosition2);

                }
                if (initalPosition <= value2){
                    targetPosition2 = value2 + 13 - initalPosition;
                    System.out.println(targetPosition2);

                }
                if (initalPosition > value3){
                    targetPosition3 = initalPosition - value3;
                    System.out.println(targetPosition3);

                }
                if (initalPosition <= value3){
                    targetPosition3 = value3 + 13 - initalPosition;
                    System.out.println(targetPosition3);

                }

            }

            // 2. segment
            if (6<initalPosition && initalPosition<13 ){
                if (initalPosition > value1){
                    targetPosition1 = initalPosition - value1;
                }

                if (initalPosition > value2){
                    targetPosition2 = initalPosition - value2;
                }

                if (initalPosition > value3){
                    targetPosition3 = initalPosition - value3;
                }
                if (initalPosition <= value3){
                    targetPosition3 = value3 + 13 - initalPosition;
                }
            }

            // 3. segment
            if (13<initalPosition && initalPosition<19 ){
                if (initalPosition > value1){
                    targetPosition1 = initalPosition + value1;
                }

                if (initalPosition > value2){
                    targetPosition2 = initalPosition + value2;
                }

                if (initalPosition > value3 && !(value3 == 12)){
                    targetPosition3 = initalPosition + value3;
                }
                 if (value3 == 12){
                    System.out.println("you can not play!");
                }
            }

            // 4. segment
            if (19<initalPosition && initalPosition<24 ){
                if (initalPosition > value1 && !(value1 == 6)){
                    targetPosition1 = initalPosition + value1;
                }
                 if (value1 == 6){
                    System.out.println("you can not play!");
                }

                if (initalPosition > value2  && !(value2 == 6)){
                    targetPosition2 = initalPosition - value2;
                }
                 if (value2 == 6){
                    System.out.println("you can not play!");
                }

                if (initalPosition > value3  && !(value3 < 6)){
                    targetPosition3 = initalPosition + value3;
                }
                if (value3 > 6){
                    System.out.println("you can not play!");
                }
            }

        }

        //drop(node);
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
