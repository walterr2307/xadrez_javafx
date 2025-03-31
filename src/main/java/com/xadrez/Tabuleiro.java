package com.xadrez;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Tabuleiro extends Application {
    private static Tabuleiro instancia;
    private static Pane root = new Pane();
    private static float largura = 720f;
    private Rectangle[][] casas = gerarCasas();

    private Tabuleiro() {
    }

    public void start(Stage stage) {
        Scene scene = new Scene(root, largura, largura);
        stage.setScene(scene);
        stage.setTitle("Xadrez");
        stage.setResizable(false);
        stage.show();
    }
    public static Tabuleiro instanciar() {
        if (instancia == null)
            instancia = new Tabuleiro();

        return instancia;
    }

    private Rectangle[][] gerarCasas() {
        float largura = Tabuleiro.largura / 8f;
        String cor = "#B25A30";
        Rectangle[][] casas = new Rectangle[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                casas[i][j] = new Rectangle(i * largura, j * largura, largura, largura);
                casas[i][j].setFill(Color.web(cor));
                root.getChildren().add(casas[i][j]);

                if (cor.equals("#B25A30"))
                    cor = "#F5F5DC";
                else
                    cor = "#B25A30";
            }
        }

        return casas;
    }

    public float getLargura() {
        return largura;
    }

    public Pane getRoot() {
        return root;
    }

    public Rectangle[][] getCasas() {
        return casas;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
