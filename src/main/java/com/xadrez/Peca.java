package com.xadrez;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Peca {
    protected Tabuleiro tabuleiro = Tabuleiro.instanciar();
    protected int i, j;
    protected float largura = Main.getLargura() / 8f;
    protected Pane root = Main.getRoot();
    protected String cor, tipo_peca = definirTipoPeca();
    protected String[][] cores = tabuleiro.getCores();
    protected ImageView img;
    protected Button btn;
    protected Peca[][] pecas = tabuleiro.getPecas();
    protected Rectangle[][] casas = tabuleiro.getCasas();
    protected ArrayList<Integer> x_disponiveis = new ArrayList<>();
    protected ArrayList<Integer> y_disponiveis = new ArrayList<>();

    public Peca(int i, int j, String cor) {
        this.i = i;
        this.j = j;
        this.cor = cor;
        this.img = definirImagem();
        this.btn = definirBotao();
        btn.setOnAction(e -> mover());
        btn.setOnMouseEntered(e -> colorir());
        btn.setOnMouseExited(e -> descolorir());
    }

    protected ImageView definirImagem() {
        try {
            ImageView img = new ImageView(new Image(Objects.requireNonNull(getClass().
                    getResource("/" + tipo_peca + "_" + cor + ".png")).toExternalForm()));
            img.setFitWidth(largura);
            img.setFitHeight(largura);
            img.setLayoutX(i * largura);
            img.setLayoutY(j * largura);
            root.getChildren().add(img);
            return img;
        } catch (NullPointerException e) {
            System.err.println("Erro: Imagem não encontrada no classpath.");
        } catch (Exception e) {
            System.err.println("Erro ao carregar a imagem: " + e.getMessage());
        }

        return null;
    }

    protected abstract void mover();

    protected abstract void colorir();

    protected abstract void descolorir();

    protected abstract String definirTipoPeca();

    protected Button definirBotao() {
        Button btn = new Button();
        btn.setPrefSize(largura, largura);
        btn.setLayoutX(i * largura);
        btn.setLayoutY(j * largura);
        btn.setOpacity(0f);
        root.getChildren().add(btn);
        return btn;
    }

    public abstract void verificarPassosDisponiveis();
}
