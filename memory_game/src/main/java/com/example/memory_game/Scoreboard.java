package com.example.memory_game;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Scoreboard extends VBox {

    private Player player1;
    private Player player2;
    private Label player1Label;
    private Label player2Label;

    public Scoreboard(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        HBox playerNameLabels = new HBox();
        playerNameLabels.setSpacing(20);
        playerNameLabels.setAlignment(Pos.CENTER);

        Label player1Name = new Label(player1.getName());
        Label player2Name = new Label(player2.getName());
        playerNameLabels.getChildren().addAll(player1Name, player2Name);

        HBox playerScoreLabels = new HBox();
        playerScoreLabels.setSpacing(20);
        playerScoreLabels.setAlignment(Pos.CENTER);

        player1Label = new Label("0");
        player2Label = new Label("0");
        playerScoreLabels.getChildren().addAll(player1Label, player2Label);

        this.getChildren().addAll(playerNameLabels, playerScoreLabels);
    }

    public void updateScores() {
        player1Label.setText(String.valueOf(player1.getPoints()));
        player2Label.setText(String.valueOf(player2.getPoints()));
    }
}
