package com.xadrez;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tabuleiro {
    private static Tabuleiro instancia;
    private float largura = Main.getLargura() / 8f;
    private Pane root = Main.getRoot();
    private String[][] cores = new String[8][8];
    private Peca[][] pecas = new Peca[8][8];
    private Rectangle[][] casas;
    private Button[][] botoes = gerarBotoes();

    private Tabuleiro() {
        casas = gerarCasas();
    }

    public static Tabuleiro instanciar() {
        if (instancia == null)
            instancia = new Tabuleiro();

        return instancia;
    }

    private Rectangle[][] gerarCasas() {
        String cor = "#B25A30";
        Rectangle[][] casas = new Rectangle[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                casas[i][j] = new Rectangle(i * largura, j * largura, largura, largura);
                casas[i][j].setFill(Color.web(cor));
                cor = trocarCor(cor);
                cores[i][j] = cor;
                root.getChildren().add(casas[i][j]);
            }
            cor = trocarCor(cor);
        }

        return casas;
    }

    private Button[][] gerarBotoes() {
        Button[][] botoes = new Button[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                botoes[i][j] = new Button();
                botoes[i][j].setPrefSize(largura, largura);
                botoes[i][j].setLayoutX(i * largura);
                botoes[i][j].setLayoutY(j * largura);
                botoes[i][j].setOpacity(0f);
                botoes[i][j].setViewOrder(-1f);
                root.getChildren().add(botoes[i][j]);
            }
        }

        return botoes;
    }

    private String trocarCor(String cor) {
        if (cor.equals("#B25A30"))
            return "#F5F5DC";
        else
            return "#B25A30";
    }

    public String[][] getCores() {
        return cores;
    }

    public Peca[][] getPecas() {
        return pecas;
    }

    public Rectangle[][] getCasas() {
        return casas;
    }

    public Button getBotao(int i, int j) {
        return botoes[i][j];
    }
}
