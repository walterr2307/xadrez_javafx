package com.xadrez;


import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Movimento {
    private Movimento instancia;

    private Movimento() {
    }

    public Movimento instanciar() {
        if (instancia == null)
            instancia = new Movimento();

        return instancia;
    }

    private void mover(float dx, float dy, ImageView img) {
        TranslateTransition mover = new TranslateTransition(Duration.seconds(0.5f), img);
        mover.setByX(dx);
        mover.setByY(dy);
        mover.setCycleCount(1);
        mover.play();
    }
}
