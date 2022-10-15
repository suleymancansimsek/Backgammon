package com.example.tavla;

import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.util.List;

import static java.lang.Integer.parseInt;

public class FindObject {

    private double layoutX;
    private double layoutY;

    //static String name;
    static VBox vBoxtemp;
    static int ID = -1;
    static  Circle circleTemp;


    public static VBox getObject(Pane pane){

        pane.setOnMousePressed(mouseEvent->{

            Object target = mouseEvent.getTarget();
            if (target instanceof VBox){
                VBox vBox = (VBox) target;
               vBoxtemp = vBox;
               System.out.println(vBox.getId());
            }
        });

        return vBoxtemp;
    }

    public static Circle getObjectCircle(Pane pane){

        pane.setOnMousePressed(mouseEvent->{

            Object target = mouseEvent.getTarget();
            if (target instanceof VBox){
                Circle circle = (Circle) target;
                circleTemp = circle;
                System.out.println(circle.getId());
            }
        });

        return circleTemp;
    }

    public static void getCircleObject(Pane pane) throws IOException {

//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(BackgammonController.class.getResource("tavla-view.fxml"));
//        BackgammonController controller = fxmlLoader.getController();
//        fxmlLoader.load();
//
//        List<VBox> vBoxList = controller.getvBoxList();

        pane.setOnMousePressed(mouseEvent->{

            Object target = mouseEvent.getTarget();
            if (target instanceof Circle){
                Circle circle = (Circle) target;
                System.out.println(circle.getId());
                ID = getCircleNumber(circle);
                System.out.println(getVboxNumber(circle.getParent()));

                Pair diceResults = BackgammonController.pair;

                int value1 = diceResults.value1;
                int value2 = diceResults.value2;
                int value3 = value1 + value2;

                int initalPosition = getVboxNumber(circle.getParent());
                int targetPosition1 = 0;
                int targetPosition2;
                int targetPosition3;

                if (CheckerList.blackCheckers.contains(circle)){

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

                VBox targetVbox = BackgammonController.vBoxList.get(targetPosition1);

                targetVbox.getChildren().add(circle);


            }
        });

    }

    public static int getCircleNumber(Circle circle){
        String circleID = circle.getId();
        int number = parseInt(circleID);

        return number;
    }

//    public static int getVboxNumber(Parent vBox){
//        String vBoxIdID = vBox.getId();
//        String vBoxNumber = vBoxIdID.replace("vBox","");
//        //System.out.println(vBoxNumber);
//        int number = parseInt(vBoxIdID);
//        return number;
//    }

    public static int getVboxNumber(Parent vBox){
    String vBoxID = vBox.getId();
    String vBoxNumber = vBoxID.replace("vBox","");
    //System.out.println(vBoxNumber);
    int number = parseInt(vBoxNumber);
//    System.out.println(number);
    return number;
    }

    public static void getVbox(int checkerID){
//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(BackgammonController.class.getResource("/tavla/view.fxml"));
//
//        BackgammonController controller = fxmlLoader.getController();

//            for (int i = 0; i<vBoxList.size(); i++){
//
//                for (int j=0; j<vBoxList.get(i).getChildren().size(); j++){
//                    System.out.println(vBoxList.get(i).getChildren().size());
//                    System.out.println(vBoxList.get(i).getId());
//                    if (vBoxList.get(i).getChildren().get(j).getId().equals(checkerID)){
//                        System.out.println(vBoxList.get(i).getId());
//                    }
//
//                }
//            }

    }


}

