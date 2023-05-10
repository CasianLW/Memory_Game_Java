package com.example.memory_game;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.util.Duration;
import javafx.animation.PauseTransition;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Game {

    private Stage gameStage;
    private GridPane board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private List<Card> cards;
    private Card selectedCard;

    public Game(String theme, String difficulty, String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);

    }

    public void start() {
        gameStage.show();
    }

    private List<Card> createCards(String theme, String difficulty) {
        List<Card> cards = new ArrayList<>();
        int pairs;
        switch (difficulty) {
            case "Easy":
                pairs = 12;
                break;
            case "Medium":
                pairs = 18;
                break;
            case "Hard":
                pairs = 24;
                break;
        }


        return cards;
    }

    private GridPane createBoard(String difficulty, List<Card> cards) {
        GridPane board = new GridPane();

        return board;
    }



}
