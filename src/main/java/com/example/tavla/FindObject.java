package com.example.tavla;

import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class FindObject {

    private double layoutX;
    private double layoutY;

    //static String name;
    static VBox vBoxtemp;
    public static VBox getObject(Pane pane){

        pane.setOnMouseEntered(mouseEvent->{

            Object target = mouseEvent.getTarget();
            if (target instanceof VBox){
                VBox vBox = (VBox) target;
               vBoxtemp = vBox;
            }
        });

        return vBoxtemp;
    }


}
