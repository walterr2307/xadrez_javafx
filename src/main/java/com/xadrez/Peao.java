package com.xadrez;

import javafx.scene.paint.Color;

public class Peao extends Peca {
    private boolean primeira_jogada = true;

    public Peao(int i, int j, String cor) {
        super(i, j, cor);
    }

    protected void mover() {
        if (primeira_jogada)
            primeira_jogada = false;
    }

    public void verificarPassosDisponiveis() {
        int qtd_passos, aux = 1;

        if (cor.equals("preto"))
            aux = -1;

        if (primeira_jogada) {
            if (pecas[i + aux][j] != null || i + aux < 0 || i + aux > 7)
                qtd_passos = 0;
            else if (pecas[i + aux * 2][j] != null)
                qtd_passos = 1;
            else
                qtd_passos = 2;
        } else {
            if (pecas[i + aux][j] != null)
                qtd_passos = 0;
            else
                qtd_passos = 1;
        }

        x_disponiveis.clear();
        y_disponiveis.clear();

        for(int k = 0; k <= qtd_passos; k++){
            x_disponiveis.add(i + k);
            y_disponiveis.add(j);
        }
    }

    protected void colorir() {
        for(int i = 0; i <= x_disponiveis.size(); i++){
            casas[x_disponiveis.get(i)][y_disponiveis.get(i)].setFill(Color.LIGHTGREEN);
        }
    }

    protected void descolorir() {
        for(int i = 0; i <= x_disponiveis.size(); i++){
            int x = x_disponiveis.get(i), y = y_disponiveis.get(i);
            casas[x][y].setFill(Color.web(cores[x][y]));
        }
    }

    protected String definirTipoPeca() {
        return "peao";
    }
}
