module com.example.memory_game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.memory_game to javafx.fxml;
    exports com.example.memory_game;
}