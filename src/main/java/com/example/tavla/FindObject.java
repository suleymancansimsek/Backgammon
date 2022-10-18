package com.example.tavla;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class FindObject {

    public static void getvBoxObject(Pane pane,Circle circle){

            pane.setOnMousePressed(mouseEvent->{

                Object target = mouseEvent.getTarget();
                if (target instanceof VBox ){
                    VBox vBox = (VBox) target;

//                System.out.println(vBox.getId());
//
//                System.out.println(vBox.getBackground().getFills().get(0).getFill().toString());
//                System.out.println(vBox.getBackground().getFills().get(0).getFill().toString().equals("0x90ee90ff"));

                    if (vBox.getBackground().getFills().get(0).getFill().toString().equals("0x90ee90ff")){
                        vBox.getChildren().add(circle);
                        counter++;
                        turnOffGreenVboxs();
                        greenVboxs.clear();
                        try {
                            getCircleObject(pane);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else{
                        System.out.println("hata");
                    }
//                vBox.getChildren().add(circle);

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

    static int counter=0;

    public static void getCircleObject(Pane pane) throws IOException {
        pane.setOnMousePressed(mouseEvent->{
            Object target = mouseEvent.getTarget();
            if (target instanceof Circle){
                Circle circle = (Circle) target;
                System.out.println(circle.getId());
                System.out.println(getVboxNumber(circle.getParent()));
                System.out.println(circle.getFill().toString());
                PairInteger diceResults = BackgammonController.pair;

//                System.out.println(initalPosition);
                int targetPosition1;
                int targetPosition2;
                int targetPosition3;

                switch (playerColor(circle)){
                    case UNKNOWN -> {
                        System.out.println("unknown checker error");
                        break;
                    }
                    case WHITE -> {
                        move(pane,circle,diceResults);
                        break;}
                    case BLACK -> {
                        move(pane,circle,diceResults);
                        break;
                    }
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

    public static List<String> getAllGreenVboxs(){
        List<String> allGreenVboxs = new ArrayList<>();
        for (PairVboxColor pairVboxColor: greenVboxs) {
            VBox vBox = pairVboxColor.value1;
            allGreenVboxs.add(vBox.getId());
        }
        return allGreenVboxs;
    }

    public static Players playerColor(Circle circle){
        if (circle.getFill().toString().equals("0xfce700ff")){
            return Players.BLACK;
        }
        else if(circle.getFill().toString().equals("0xf637ecff")){
            return Players.WHITE;
        }
        else{
            return Players.UNKNOWN;
        }
    }

    public static void move(Pane pane, Circle circle, PairInteger diceResults){
        int value1 = diceResults.value1;
        int value2 = diceResults.value2;
        int value3 = value1 + value2;
        int initalPosition = getVboxNumber(circle.getParent()) ;

        int targetPOS1 = value1 + initalPosition - 1;
        int targetPOS2 = value2 + initalPosition - 1;
        int targetPOS3 = value3 + initalPosition - 1;

        targetPOSGenerator(targetPOS1,targetPOS2,targetPOS3);

        VBox targetVbox1 = BackgammonController.vBoxList.get(targetPOS1);
        VBox targetVbox2 = BackgammonController.vBoxList.get(targetPOS2);
        VBox targetVbox3 = BackgammonController.vBoxList.get(targetPOS3);

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


        greenVboxs.add(vBoxColors1);
        greenVboxs.add(vBoxColors2);
        greenVboxs.add(vBoxColors3);

        getvBoxObject(pane,circle);
    }

    public static List<Integer> targetPOSGenerator(int targetPOS1, int targetPOS2, int targetPOS3){
        List<Integer> targetPOSs = new ArrayList<>();
        if (posControl(targetPOS1) != -1 ){
            targetPOSs.add(targetPOS1);
        }
        if (posControl(targetPOS2) != -1 ){
            targetPOSs.add(targetPOS2);
        }
        if (posControl(targetPOS2) != -1 ){
            targetPOSs.add(targetPOS2);
        }

        return targetPOSs;
    }

    public static int posControl(int pos){
        if (pos<25 && pos>0){
            return pos;
        }
        return -1;
    }

}

