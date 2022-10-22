package com.example.tavla;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

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
//        Image image = new Image("C:\\Users\\suley\\IdeaProjects\\Tavla\\src\\main\\java\\com\\example\\tavla\\backgammon_background.jpg");
//        pane.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT)));
        vBoxListCreate();
        CheckerCreate checkerCreate =  new CheckerCreate();
        checkerCreate.createAllBlackCheckers();
        checkerCreate.createAllWhiteCheckers();
        backgammon.newGamePattern(vBoxList);

//        boolean a= true;
//        boolean b = !a;
//
//        System.out.println(a);
//        System.out.println(b);
        try {
          FindObject.getCircleObject(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label result;

    @FXML
    private VBox vBox1,vBox2,vBox3,vBox4,vBox5,vBox6,vBox7,vBox8,vBox9,vBox10,vBox11,vBox12,vBox13,vBox14,vBox15,vBox16,vBox17,vBox18,vBox19,vBox20,vBox21,vBox22,vBox23,vBox24;

    @FXML
    private Pane pane;

    public static List<VBox> vBoxList = new ArrayList<>();
    Backgammon backgammon = new Backgammon();
    public static PairInteger pair;

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
        PairInteger results = Dicee.roll();
        pair = results;
        result.setText(String.valueOf(results.value1) + " " +String.valueOf(results.value2));

    }

    @FXML
    protected void onPlayer1ButtonClick(){
//        int number = Dicee.singleRoll();
//        result.setText(String.valueOf(number));
    }

    @FXML
    protected void onPlayer2ButtonClick(){
//        int number = Dicee.singleRoll();
//        result.setText(String.valueOf(number));
    }



    public void getVboxID() throws IOException {
        System.out.println(vBoxList.get(4).getChildren().size());

//                        if (vBoxList.get(4).getChildren().get(0).getId().contains("0")){
//                    System.out.println(vBoxList.get(4).getId());
//                }
//        for (int i = 0; i<vBoxList.size(); i++){
//
//            if (vBoxList.get(i).getChildren().contains(FindObject.getObjectCircle(pane))){
//                System.out.println(vBoxList.get(i).getId());
//            }
//        }


    }
}