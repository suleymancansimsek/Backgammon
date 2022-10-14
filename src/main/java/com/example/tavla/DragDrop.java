package com.example.tavla;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public interface DragDrop {

    void drag(Node node, VBox vBox, Pane pane);
    void drop(Node node, VBox targetVbox);
//    void removeObject(Node node);
}
