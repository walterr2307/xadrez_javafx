package com.xadrez;

public class LoopPrincipal {

    public void iniciarLoop() {
        for (int j = 0; j < 8; j++) {
            new Peao(j, 1, "branco");
            new Peao(j, 6, "preto");
        }
    }
}
