package com.xadrez;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public abstract class Peca {
    protected int i, j;
    protected String cor;
    protected ImageView img = definirImagem();
    protected Button btn = definirBotao();
    protected Rectangle[] casas;

    public Peca(int i, int j, String cor) {
        this.i = i;
        this.j = j;
        this.cor = cor;
        btn.setOnAction(e -> mover());
        btn.setOnMouseEntered(e -> colorir());
        btn.setOnMouseExited(e -> descolorir());
    }

    protected abstract ImageView definirImagem();

    protected abstract void mover();

    protected abstract void colorir();

    protected abstract void descolorir();

    protected Button definirBotao() {
        return new Button();
    }
}
