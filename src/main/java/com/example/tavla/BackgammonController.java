package com.example.tavla;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BackgammonController implements Initializable{
    CheckerMove checkerMove =  new CheckerMove();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //draggableObject.makeDraggableStone(result);
        vBoxListCreate();
        CheckerCreate checkerCreate =  new CheckerCreate();
        checkerCreate.createAllBlackCheckers();
        checkerCreate.createAllWhiteCheckers();
        backgammon.newGamePattern(getvBoxList());

        try {
            FindObject.getCircleObject(pane , vBox1);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        ListenerTask listenerTask =  new ListenerTask(pane);
//        try {
//            listenerTask.call();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        CheckerMove checkerMove =  new CheckerMove(CheckerList.blackCheckers.get(1),vBox1,pane);

        //CheckerMove.getVboxNumber(vBox12);
      //  checkerMove.move(CheckerList.blackCheckers.get(0), FindObject.getObject(pane),pane,results);
    }

    @FXML
    private Label result;

    @FXML
    private VBox vBox1,vBox2,vBox3,vBox4,vBox5,vBox6,vBox7,vBox8,vBox9,vBox10,vBox11,vBox12,vBox13,vBox14,vBox15,vBox16,vBox17,vBox18,vBox19,vBox20,vBox21,vBox22,vBox23,vBox24;

    @FXML
    private Pane pane;

    private List<VBox> vBoxList = new ArrayList<>();
    Backgammon backgammon = new Backgammon();
    Pair pair;

    public void vBoxListCreate(){
        getvBoxList().add(vBox1);
        getvBoxList().add(vBox2);
        getvBoxList().add(vBox3);
        getvBoxList().add(vBox4);
        getvBoxList().add(vBox5);
        getvBoxList().add(vBox6);
        getvBoxList().add(vBox7);
        getvBoxList().add(vBox8);
        getvBoxList().add(vBox9);
        getvBoxList().add(vBox10);
        getvBoxList().add(vBox11);
        getvBoxList().add(vBox12);
        getvBoxList().add(vBox13);
        getvBoxList().add(vBox14);
        getvBoxList().add(vBox15);
        getvBoxList().add(vBox16);
        getvBoxList().add(vBox17);
        getvBoxList().add(vBox18);
        getvBoxList().add(vBox19);
        getvBoxList().add(vBox20);
        getvBoxList().add(vBox21);
        getvBoxList().add(vBox22);
        getvBoxList().add(vBox23);
        getvBoxList().add(vBox24);
    }

//    StoneObject stoneObject = new StoneObject();
//    Circle stone = stoneObject.getStone(Constants.whiteStoneColor);

    @FXML
    protected void onNewGameButtonClick() {

//        vbox.getChildren().add(stone);
        checkerMove.drag(CheckerList.blackCheckers.get(0),vBox1,pane);
        checkerMove.drop(CheckerList.blackCheckers.get(0),vBox4);
    }

    @FXML
    protected void onDiceeButtonClick(){
         //it gives us 2 dicees values
        Pair results = Dicee.roll();
        pair = results;
        result.setText(String.valueOf(results.value1) + " " +String.valueOf(results.value2));

    }

    @FXML
    protected void onPlayer1ButtonClick(){
        FindObject.getObject(pane);
        if (getvBoxList().contains(FindObject.getObject(pane))){
            System.out.println(FindObject.getObject(pane));
            //checkerMove.move(CheckerList.blackCheckers.get(0), FindObject.getObject(pane),pane,pair);
        }


    }

    @FXML
    protected void onPlayer2ButtonClick(){
//        FindObject.getObject(pane);
//        if (vBoxList.contains(FindObject.getObject(pane))){
//            checkerMove.move(CheckerList.blackCheckers.get(0), FindObject.getObject(pane),pane,pair);
//        }

    }


    public List<VBox> getvBoxList() {
        return vBoxList;
    }

    public void setvBoxList(List<VBox> vBoxList) {
        this.vBoxList = vBoxList;
    }

    public String getVboxID(int checkerID){
        List<VBox> vBoxList = getvBoxList();

        for (int i = 0; i<vBoxList.size(); i++){

            for (int j=0; j<vBoxList.get(i).getChildren().size(); j++){


                if (vBoxList.get(i).getChildren().get(j).getId().equals(checkerID)){
                    System.out.println(vBoxList.get(i).getId());
                    return vBoxList.get(i).getId();
                }

            }
        }
        return "";
    }
}