package com.xadrez;

import javafx.scene.paint.Color;

public class Peao extends Peca {
    private boolean primeira_jogada = true;
    private int aux;

    public Peao(int i, int j, String cor) {
        super(i, j, cor);

        if (cor.equals("branco"))
            aux = 1;
        else
            aux = -1;
    }

    protected void mover() {

        if (primeira_jogada)
            primeira_jogada = false;
    }

    public void verificarPassosDisponiveis() {
        int qtd_passos;

        if (primeira_jogada) {
            if (pecas[i][j + aux] != null)
                qtd_passos = 0;
            else if (pecas[i][j + aux * 2] != null)
                qtd_passos = 1;
            else
                qtd_passos = 2;
        } else {
            if (pecas[i][j + aux] != null || j + aux < 0 || j + aux > 7)
                qtd_passos = 0;
            else
                qtd_passos = 1;
        }

        x_disponiveis.clear();
        y_disponiveis.clear();

        for (int k = 0; k <= qtd_passos; k++) {
            x_disponiveis.add(i);
            y_disponiveis.add(j + aux * k);
        }
    }

    protected void colorir() {
        for (int i = 0; i < x_disponiveis.size(); i++) {
            int x = x_disponiveis.get(i), y = y_disponiveis.get(i);
            casas[x][y].setFill(Color.LIGHTGREEN);
        }
    }

    protected void descolorir() {
        for (int i = 0; i < x_disponiveis.size(); i++) {
            int x = x_disponiveis.get(i), y = y_disponiveis.get(i);
            casas[x][y].setFill(Color.web(cores[x][y]));
        }
    }

    protected String definirTipoPeca() {
        return "peao";
    }
}
