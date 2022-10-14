package com.example.tavla;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.util.List;

public interface BackGammonChecker {

    void move(int diceResult1, int diceResult2, Node node);

    void newGamePattern(List<VBox> vBoxList);

}
