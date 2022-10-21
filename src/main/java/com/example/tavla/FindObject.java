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

    public static List<PairVboxColor> greenVboxs = new ArrayList<>();

    public static void getvBoxObject(Pane pane,Circle circle){

            pane.setOnMousePressed(mouseEvent->{

                Object target = mouseEvent.getTarget();
                if (target instanceof VBox ){
                    VBox vBox = (VBox) target;

                    if (vBox.getBackground().getFills().get(0).getFill().toString().equals("0x90ee90ff")){
                        vBox.getChildren().add(circle);
                        System.out.println("Greenbox size: " + greenVboxs.size());

                        for (int i = 0; i<greenVboxs.size(); i++) {
                            System.out.println("deneme");
                            greenVboxs.get(i).value1.setBackground(new Background(new BackgroundFill(Paint.valueOf(greenVboxs.get(i).value2), CornerRadii.EMPTY, Insets.EMPTY)));
                        }
                        greenVboxs.clear();
                    }else{
                        System.out.println("hata");
                    }

                    try {
                        getCircleObject(pane);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });


    }
    static Player playerBlack = new Player(Players.BLACK);
    static Player playerWhite = new Player(Players.WHITE);

    public static void getCircleObject(Pane pane) throws IOException {
        pane.setOnMousePressed(mouseEvent->{
            Object target = mouseEvent.getTarget();
            if (target instanceof Circle){
                Circle circle = (Circle) target;
                System.out.println("checker ID: " + circle.getId());
//                System.out.println(getVboxNumber(circle.getParent()));
//                System.out.println(circle.getFill().toString());
                PairInteger diceResults = BackgammonController.pair;

                Player player = whoPlayFirst(playerBlack,playerWhite);
              System.out.println("Player right: " + player.playRight);
                if (player.playRight > 0){
                    player.play(pane,circle,diceResults);
                    player.playRight-- ;
                }
                if (player.playRight == 0){
                    System.out.println("switched other player");
                    switchOtherPlayer(player);
                }

            }
        });

    }

    public static void moveBlack(Pane pane, Circle circle, PairInteger diceResults){
        int value1 = diceResults.value1;
        int value2 = diceResults.value2;
        int value3 = value1 + value2;
        int initalPosition = getVboxNumber(circle.getParent()) ;

        int targetPOS1 = value1 + initalPosition - 1;
        int targetPOS2 = value2 + initalPosition - 1;
        int targetPOS3 = value3 + initalPosition - 1;

        List<Integer> targetPositions = targetPOSGenerator(targetPOS1,targetPOS2,targetPOS3);
        List<PairVboxColor> pairVboxColorList = new ArrayList<>();
        List<VBox> vBoxList =  new ArrayList<>();

        for (int pos:
             targetPositions) {
            vBoxList.add(BackgammonController.vBoxList.get(pos));
        }

        for (VBox vbox:
                vBoxList) {
                pairVboxColorList.add(new PairVboxColor(vbox,vbox.getBackground().getFills().get(0).getFill().toString()));
            }

        for (PairVboxColor pVoxColor :
                pairVboxColorList) {
                greenVboxs.add(pVoxColor);
                System.out.println("vbox id: " + pVoxColor.value1.getId() + "  " + "vbox ilk rengi: " + pVoxColor.value2);
            }
        targetPositions.clear();
        vBoxList.clear();
        pairVboxColorList.clear();
        System.out.println(greenVboxs.size());

        for (PairVboxColor i:
             greenVboxs) {
            setVboxBackgroundColorLightGreen(i.value1);
        }

        getvBoxObject(pane,circle);

    }
    public static void moveWhite(Pane pane, Circle circle, PairInteger diceResults){
        int value1 = diceResults.value1;
        int value2 = diceResults.value2;
        int value3 = value1 + value2;
        int initalPosition = getVboxNumber(circle.getParent()) ;

        int targetPOS1 = initalPosition - value1 - 1;
        int targetPOS2 = initalPosition - value2 - 1;
        int targetPOS3 = initalPosition - value3  - 1;

        List<Integer> targetPositions = targetPOSGenerator(targetPOS1,targetPOS2,targetPOS3);
        List<PairVboxColor> pairVboxColorList = new ArrayList<>();
        List<VBox> vBoxList =  new ArrayList<>();

        for (int pos:
                targetPositions) {
            vBoxList.add(BackgammonController.vBoxList.get(pos));
        }

        for (VBox vbox:
                vBoxList) {
            pairVboxColorList.add(new PairVboxColor(vbox,vbox.getBackground().getFills().get(0).getFill().toString()));
        }

        for (PairVboxColor pVoxColor :
                pairVboxColorList) {
            greenVboxs.add(pVoxColor);
            System.out.println("vbox id: " + pVoxColor.value1.getId() + "  " + "vbox ilk rengi: " + pVoxColor.value2);
        }
        targetPositions.clear();
        vBoxList.clear();
        pairVboxColorList.clear();
        System.out.println(greenVboxs.size());

        for (PairVboxColor i:
                greenVboxs) {
            setVboxBackgroundColorLightGreen(i.value1);
        }

        getvBoxObject(pane,circle);

    }


    public static int posControl(int pos){
        if (pos<24 && pos>0){
            return pos;
        }
        return -1;
    }

    public static List<Integer> targetPOSGenerator(int targetPOS1, int targetPOS2, int targetPOS3){
        List<Integer> targetPOSs = new ArrayList<>();
        if (posControl(targetPOS1) != -1 ){
            targetPOSs.add(targetPOS1);
        }
        if (posControl(targetPOS2) != -1 ){
            targetPOSs.add(targetPOS2);
        }
        if (posControl(targetPOS3) != -1 ){
            targetPOSs.add(targetPOS3);
        }

        return targetPOSs;
    }


    public static void setVboxBackgroundColor(VBox vBox, String colorCode){
        System.out.println(vBox.getBackground().getFills().get(0).getFill().toString());
        vBox.setBackground(new Background(new BackgroundFill(Paint.valueOf(colorCode), CornerRadii.EMPTY, Insets.EMPTY)));
        System.out.println(vBox.getBackground().getFills().get(0).getFill().toString());

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
        System.out.println("ısık kapatma çalıştı");
        for (PairVboxColor vBox: greenVboxs) {
            setVboxBackgroundColor(vBox.value1, vBox.value2);
        }
    }

    public static Players playerColor(Circle circle){
        if (circle.getFill().toString().equals("0xfce700ff")){
            System.out.println("Player Black");
            return Players.BLACK;
        }
        else if(circle.getFill().toString().equals("0xf637ecff")){
            System.out.println("Player White");
            return Players.WHITE;
        }
        else{
            return Players.UNKNOWN;
        }
    }

    static Player whoPlayFirst(Player playerBlack,Player playerWhite){
        int number = Dicee.decideWho();
        System.out.println(number);
        switch (number){
            case 1:
                System.out.println("player black");
                return playerBlack;
            case 2:
                System.out.println("player white");
                return playerWhite;
        }
        return playerBlack;
    }

    static Player switchOtherPlayer(Player player){
        Player tempPlayer = new Player();
        if (player == playerBlack){
            tempPlayer = playerWhite;
        }
        if (player == playerWhite){
            tempPlayer = playerBlack;
        }
        return tempPlayer;
    }
}

