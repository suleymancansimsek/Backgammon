package com.example.tavla;

import javafx.concurrent.Task;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ListenerTask extends Task<VBox> {
    public Pane pane;
    ListenerTask(Pane pane){
        this.pane = pane;
    }

    @Override
    protected VBox call() throws Exception {
        VBox vBox = FindObject.getObject(pane);
        if (vBox == null){

        }
        else {
            System.out.println(vBox.getId());
        }
        return vBox;
    }

}
