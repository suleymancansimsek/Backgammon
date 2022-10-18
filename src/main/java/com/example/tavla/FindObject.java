package com.example.tavla;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class FindObject {

    private double layoutX;
    private double layoutY;

    //static String name;
//    static Circle tempCircle;

    public static void getvBoxObject(Pane pane,Circle circle){

        pane.setOnMousePressed(mouseEvent->{

            Object target = mouseEvent.getTarget();
            if (target instanceof VBox ){
                VBox vBox = (VBox) target;

                System.out.println(vBox.getId());
                vBox.getChildren().add(circle);
                turnOffGreenVboxs();
                greenVboxs.clear();
            }
        });
    }

//    public static Circle getObjectCircle(Pane pane){
//
//        pane.setOnMousePressed(mouseEvent->{
//
//            Object target = mouseEvent.getTarget();
//            if (target instanceof VBox){
//                Circle circle = (Circle) target;
//                circleTemp = circle;
//                System.out.println(circle.getId());
//            }
//        });
//
//        return circleTemp;
//    }
    public static List<PairVboxColor> greenVboxs = new ArrayList<>();

    public static void getCircleObject(Pane pane) throws IOException {

        pane.setOnMousePressed(mouseEvent->{
            Object target = mouseEvent.getTarget();
            if (target instanceof Circle){
                Circle circle = (Circle) target;
                System.out.println(circle.getId());
                System.out.println(getVboxNumber(circle.getParent()));
//                tempCircle = circle;

                PairInteger diceResults = BackgammonController.pair;

                int value1 = diceResults.value1;
                int value2 = diceResults.value2;
                int value3 = value1 + value2;
                int initalPosition = getVboxNumber(circle.getParent()) ;

//                System.out.println(initalPosition);
                int targetPosition1;
                int targetPosition2;
                int targetPosition3;


                // for blacks
                if (circle.getFill().toString().equals("0xfce700ff")){

                    VBox targetVbox1 = BackgammonController.vBoxList.get(value1 + initalPosition - 1);
                    VBox targetVbox2 = BackgammonController.vBoxList.get(value2 + initalPosition - 1);
                    VBox targetVbox3 = BackgammonController.vBoxList.get(value3 + initalPosition - 1);

                    String target1Color = targetVbox1.getBackground().getFills().get(0).getFill().toString();
                    String target2Color = targetVbox2.getBackground().getFills().get(0).getFill().toString();
                    String target3Color = targetVbox3.getBackground().getFills().get(0).getFill().toString();

                    PairVboxColor vBoxColors1 = new PairVboxColor(targetVbox1,target1Color);
                    PairVboxColor vBoxColors2 = new PairVboxColor(targetVbox2,target2Color);
                    PairVboxColor vBoxColors3 = new PairVboxColor(targetVbox3,target3Color);

                    setVboxBackgroundColorLightGreen(targetVbox1);
                    setVboxBackgroundColorLightGreen(targetVbox2);
                    setVboxBackgroundColorLightGreen(targetVbox3);

                    for (PairVboxColor i: greenVboxs) {
                        setVboxBackgroundColor(i.value1,i.value2);

                    }

                    greenVboxs.clear();

                    greenVboxs.add(vBoxColors1);
                    greenVboxs.add(vBoxColors2);
                    greenVboxs.add(vBoxColors3);

                    getvBoxObject(pane,circle);


                }



            }
        });

    }


    public static void setVboxBackgroundColor(VBox vBox, String colorCode){
        vBox.setBackground(new Background(new BackgroundFill(Paint.valueOf(colorCode), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public static void setVboxBackgroundColorLightGreen(VBox vBox){
        vBox.setBackground(new Background(new BackgroundFill(Color.LIGHTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public static int getCircleNumber(Circle circle){
        String circleID = circle.getId();
        int number = parseInt(circleID);

        return number;
    }

    public static int getVboxNumber(Parent vBox){
    String vBoxID = vBox.getId();
    String vBoxNumber = vBoxID.replace("vBox","");
    //System.out.println(vBoxNumber);
    int number = parseInt(vBoxNumber);
//    System.out.println(number);
    return number;
    }

    public static void turnOffGreenVboxs(){
        for (PairVboxColor vBox: greenVboxs) {
            setVboxBackgroundColor(vBox.value1, vBox.value2);
        }
    }



}

