package com.example.tavla;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BackgammonController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //draggableObject.makeDraggableStone(result);
        vBoxListCreate();
        CheckerCreate checkerCreate =  new CheckerCreate();
        checkerCreate.createAllBlackCheckers();
        checkerCreate.createAllWhiteCheckers();
    }

    @FXML
    private Label welcomeText,result;

    @FXML
    private VBox vBox1,vBox2,vBox3,vBox4,vBox5,vBox6,vBox7,vBox8,vBox9,vBox10,vBox11,vBox12,vBox13,vBox14,vBox15,vBox16,vBox17,vBox18,vBox19,vBox20,vBox21,vBox22,vBox23,vBox24;

    @FXML
    private Pane pane;

    List<VBox> vBoxList = new ArrayList<>();
    Backgammon backgammon = new Backgammon();

    public void vBoxListCreate(){
        vBoxList.add(vBox1);
        vBoxList.add(vBox2);
        vBoxList.add(vBox3);
        vBoxList.add(vBox4);
        vBoxList.add(vBox5);
        vBoxList.add(vBox6);
        vBoxList.add(vBox7);
        vBoxList.add(vBox8);
        vBoxList.add(vBox9);
        vBoxList.add(vBox10);
        vBoxList.add(vBox11);
        vBoxList.add(vBox12);
        vBoxList.add(vBox13);
        vBoxList.add(vBox14);
        vBoxList.add(vBox15);
        vBoxList.add(vBox16);
        vBoxList.add(vBox17);
        vBoxList.add(vBox18);
        vBoxList.add(vBox19);
        vBoxList.add(vBox20);
        vBoxList.add(vBox21);
        vBoxList.add(vBox22);
        vBoxList.add(vBox23);
        vBoxList.add(vBox24);
    }

    DraggableObject draggableObject = new DraggableObject();
//    StoneObject stoneObject = new StoneObject();
//    Circle stone = stoneObject.getStone(Constants.whiteStoneColor);

    @FXML
    protected void onNewGameButtonClick() {

//        vbox.getChildren().add(stone);
//        draggableObject.makeDraggableStone(stone,vbox,pane,vBox2);
        backgammon.newGamePattern(vBoxList);

    }


}