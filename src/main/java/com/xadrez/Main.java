package com.xadrez;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private static float largura = 600f;
    private static Pane root = new Pane();

    public static float getLargura() {
        return largura;
    }

    public static Pane getRoot() {
        return root;
    }

    public void start(Stage stage) {
        LoopPrincipal loop = new LoopPrincipal();

        Scene scene = new Scene(root, largura, largura);
        stage.setScene(scene);
        stage.setTitle("Xadrez");
        stage.setResizable(false);
        stage.show();

        loop.iniciarLoop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}