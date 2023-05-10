package com.example.memory_game;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.util.Duration;
import javafx.animation.PauseTransition;

import javafx.stage.Modality;


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
        currentPlayer = player1;
        selectedCard = null;

        // Créez les cartes en fonction du thème et de la difficulté choisie
        cards = createCards(theme, difficulty);

        // Créez le plateau de jeu et ajoutez les cartes
        board = createBoard(difficulty, cards);

        // Créez la scène de jeu et ajoutez le plateau
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);
        Label currentPlayerLabel = new Label("Current Player: " + currentPlayer.getName());
        root.getChildren().addAll(currentPlayerLabel, board);

//        Scene gameScene = new Scene(root);
        Scene gameScene = new Scene(root, 1600, 800); // Changer 800 et 600 par les dimensions souhaitées


        gameStage = new Stage();
        gameStage.setScene(gameScene);
        gameStage.setTitle("Memory Game");
        gameStage.setFullScreen(false); // Désactiver le mode plein écran
//        gameStage.initModality(Modality.APPLICATION_MODAL);

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
            default:
                throw new IllegalArgumentException("Invalid difficulty: " + difficulty);
        }


        // Créez les paires de cartes en fonction du thème
        for (int i = 0; i < pairs; i++) {
//            String imagePath = "/cardImages/" + theme + "/"+ i + ".png";
//            String imageBPath = "/cardImages/" + theme + "/card_back.png";
//            System.out.println("Image path: " + imagePath);
//            Image cardBackImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imageBPath)));
//            Image cardFaceImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
            Image cardFaceImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/cardImages/" + theme +"/"+ i + ".png")));
//            Image cardFaceImage = new Image("src/main/resources/cardImages/" + theme + i + ".png");
            Image cardBackImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/cardImages/" + theme + "/card_back.png")));

            Card card1 = new Card(cardFaceImage, cardBackImage);
            Card card2 = new Card(cardFaceImage, cardBackImage);

            card1.setOnMouseClicked(event -> onCardClicked(card1));
            card2.setOnMouseClicked(event -> onCardClicked(card2));

            cards.add(card1);
            cards.add(card2);
        }

        // Mélangez les cartes avant de les ajouter au plateau
        Collections.shuffle(cards);

        return cards;
    }

    private GridPane createBoard(String difficulty, List<Card> cards) {
        GridPane board = new GridPane();
        board.setHgap(5);
        board.setVgap(5);
        board.setAlignment(Pos.CENTER);

        int rows, cols;
        switch (difficulty) {
            case "Easy":
                rows = 4;
                cols = 6;
                break;
            case "Medium":
                rows = 4;
                cols = 8;
                break;
            case "Hard":
                rows = 6;
                cols = 8;
                break;
            default:
                throw new IllegalArgumentException("Invalid difficulty: " + difficulty);
        }

        int cardIndex = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Card card = cards.get(cardIndex++);
                board.add(card, j, i);
            }
        }

        return board;
    }

    private void onCardClicked(Card clickedCard) {
        if (selectedCard == null) {
            selectedCard = clickedCard;
            clickedCard.flip();
        } else if (selectedCard != clickedCard) {
            clickedCard.flip();
            if (selectedCard.isMatch(clickedCard)) {
                currentPlayer.addPoint();
                selectedCard.setMatched(true);
                clickedCard.setMatched(true);
                checkIfGameOver();
            } else {
                // Temporisez avant de retourner les cartes
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(event -> {
                    if (this.selectedCard != null) {
                        this.selectedCard.flip();
                    }
//                    selectedCard.flip();
                    clickedCard.flip();
                });
                pause.play();

                // Changez de joueur
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
            selectedCard = null;
        }
    }

    private void checkIfGameOver() {
        boolean allCardsMatched = cards.stream().allMatch(Card::isMatched);

        if (allCardsMatched) {
            // Affichez un message indiquant que le jeu est terminé et déclarez le gagnant
            Alert gameOverAlert = new Alert(Alert.AlertType.INFORMATION);
            gameOverAlert.setTitle("Game Over");
            gameOverAlert.setHeaderText(null);

            if (player1.getPoints() > player2.getPoints()) {
                gameOverAlert.setContentText(player1.getName() + " wins!");
            } else if (player1.getPoints() < player2.getPoints()) {
                gameOverAlert.setContentText(player2.getName() + " wins!");
            } else {
                gameOverAlert.setContentText("It's a draw!");
            }

            gameOverAlert.showAndWait();
            gameStage.close();
        }
    }
}
