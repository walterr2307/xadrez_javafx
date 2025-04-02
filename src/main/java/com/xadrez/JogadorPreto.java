package com.xadrez;

public class JogadorPreto extends Jogador {

    protected void gerarPecas() {
        for (int i = 0; i < 8; i++)
            new Peao(i, 6, "preto").verificarPassosDisponiveis();
    }
}
