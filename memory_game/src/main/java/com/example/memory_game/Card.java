package com.example.memory_game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Card extends StackPane {

    private Image faceImage;
    private Image backImage;
    private ImageView imageView;
    private boolean isFlipped;
    private boolean isMatched;

    public Card(Image faceImage, Image backImage, double cardWidth, double cardHeight) {
        this.faceImage = faceImage;
        this.backImage = backImage;
        this.imageView = new ImageView(backImage);
        this.isFlipped = false;
        this.isMatched = false;

        imageView.setFitWidth(cardWidth);
        imageView.setFitHeight(cardHeight);

        this.getChildren().add(imageView);
        this.setPrefSize(cardWidth, cardHeight);
    }

    public void flip() {
        if (!isMatched) {
            if (isFlipped) {
                imageView.setImage(backImage);
            } else {
                imageView.setImage(faceImage);
            }
            isFlipped = !isFlipped;
        }
    }

    public boolean isMatch(Card otherCard) {
        return faceImage.equals(otherCard.faceImage);
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }
    public void setCardWidth(double width) {
        imageView.setFitWidth(width);
    }

    public void setCardHeight(double height) {
        imageView.setFitHeight(height);
    }


//    public void setOnMouseClicked(EventHandler<MouseEvent> eventHandler) {
//        this.setOnMouseClicked(eventHandler);
//    }
//}
}