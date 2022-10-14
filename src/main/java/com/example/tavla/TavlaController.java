package com.example.tavla;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class TavlaController implements Initializable {
    @FXML
    private Label welcomeText,result;

    @FXML
    private VBox vbox,vBox2;

    @FXML
    private Pane pane;

    DraggableObject draggableObject = new DraggableObject();
    StoneObject stoneObject = new StoneObject();
    Circle stone = stoneObject.getStone(Constants.whiteStoneColor);

    @FXML
    protected void onNewGameButtonClick() {

       vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getChildren().add(stone);
        draggableObject.makeDraggableStone(stone,vbox,pane,vBox2);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //draggableObject.makeDraggableStone(result);
    }
}