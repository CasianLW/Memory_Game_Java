package com.example.memory_game;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private ComboBox<String> themeComboBox;
    @FXML
    private ComboBox<String> difficultyComboBox;
    @FXML
    private TextField player1NameTextField;
    @FXML
    private TextField player2NameTextField;
    @FXML
    private Button startGameButton;

    @FXML
    public void initialize() {
        // Ajoutez les thèmes et les difficultés à leurs ComboBox respectives
        themeComboBox.getItems().addAll("StarWars", "Rappers", "Cars");
        difficultyComboBox.getItems().addAll("Easy", "Medium", "Hard");

        // Désactivez le bouton "Start Game" si les noms des joueurs sont vides
        startGameButton.disableProperty().bind(
                player1NameTextField.textProperty().isEmpty().or(
                        player2NameTextField.textProperty().isEmpty()).or(
                        themeComboBox.valueProperty().isNull()).or(
                        difficultyComboBox.valueProperty().isNull())
        );
    }

    @FXML
    public void onStartGameButtonClicked() {
        // Récupérez les informations sélectionnées par l'utilisateur
        String theme = themeComboBox.getSelectionModel().getSelectedItem();
        String difficulty = difficultyComboBox.getSelectionModel().getSelectedItem();
        String player1Name = player1NameTextField.getText();
        String player2Name = player2NameTextField.getText();

        // Initialisez la partie en fonction des informations récupérées
        // (vous devrez adapter les paramètres en fonction de votre implémentation de la classe Game)
        Game game = new Game(theme, difficulty, player1Name, player2Name);

        // Lancez le jeu et fermez la fenêtre principale
        game.start();

        Stage stage = (Stage) startGameButton.getScene().getWindow();
        stage.close();
    }
}
