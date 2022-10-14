package com.example.tavla;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class DraggableObject {

    private double mouseAnchorX;
    private double mouseAnchory;

    public void makeDraggableStone(Node node , VBox vBox, Pane pane, VBox vBox2){

        node.setOnMousePressed(mouseEvent -> {
            vBox.getChildren().remove(0);
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

        node.setOnMouseReleased(mouseEvent -> {
            //vBox2.getChildren().add(node);
        });
    }
}
