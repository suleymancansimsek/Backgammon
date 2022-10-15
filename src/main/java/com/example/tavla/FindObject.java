package com.example.tavla;

import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class FindObject {

    private double layoutX;
    private double layoutY;

    //static String name;
    static VBox vBoxtemp;
    static Circle circleTemp;


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

    public static Circle getCircleObject(Pane pane, VBox vBox) throws IOException {

//        FXMLLoader fxmlLoader = new FXMLLoader();
//        fxmlLoader.setLocation(BackgammonController.class.getResource("tavla-view.fxml"));
//        BackgammonController controller = fxmlLoader.getController();
//        VBox vBox = fxmlLoader.load();

        pane.setOnMousePressed(mouseEvent->{

            Object target = mouseEvent.getTarget();
            if (target instanceof Circle){
                Circle circle = (Circle) target;
                circleTemp = circle;
                System.out.println(circle.getId());
                getCircleNumber(circle);
//                controller.getVboxID(getCircleNumber(circle));


//                getVbox(getCircleNumber(circle));
//                    for (int i = 0; i<CheckerList.blackCheckers.size(); i++){
//                        if (CheckerList.blackCheckers.get(i) == circle){
////                            circleTemp = CheckerList.blackCheckers.get(i);
//                        }
//
//                    }
//                CheckerMove checkerMove =  new CheckerMove();
//                checkerMove.move(circle,circle.get);
            }
        });

        return circleTemp;
    }

    public static int getCircleNumber(Circle circle){
        String circleID = circle.getId();
        int number = parseInt(circleID);

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

