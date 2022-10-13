package com.example.tavla;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class TavlaController {
    @FXML
    private Label welcomeText;

    @FXML
    private VBox vbox;


    @FXML
    protected void onNewGameButtonClick() {

       StoneObject stoneObject = new StoneObject();
        Circle stone = stoneObject.getStone(Constants.whiteStoneColor);
        Circle stone1 = stoneObject.getStone(Constants.whiteStoneColor);
        Circle stone2 = stoneObject.getStone(Constants.whiteStoneColor);
        Circle stone3 = stoneObject.getStone(Constants.whiteStoneColor);
        Circle stone4= stoneObject.getStone(Constants.whiteStoneColor);
       vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getChildren().add(stone);
        vbox.getChildren().add(stone1);
        vbox.getChildren().add(stone2);
        vbox.getChildren().add(stone3);
        vbox.getChildren().add(stone4);

    }
}