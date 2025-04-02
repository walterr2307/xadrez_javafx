package com.xadrez;

public class JogadorBranco extends Jogador {

    protected void gerarPecas() {
        for (int i = 0; i < 8; i++)
            new Peao(i, 1, "branco").verificarPassosDisponiveis();
    }
}
