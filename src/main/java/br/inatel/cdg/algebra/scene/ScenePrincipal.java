package br.inatel.cdg.algebra.scene;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
// model
import br.inatel.cdg.algebra.model.Ponto;
import br.inatel.cdg.algebra.model.Reta;

public class ScenePrincipal {
    private Button btnCoeficienteLinear, btnCoeficienteAngular;
    private Label labelP1X, labelP1Y, labelP2X, labelP2Y;
    private TextField textInputP1X, textInputyP1Y, textInputP2X, textInputP2Y;
    private TextField textOutputCoeficienteAngular, textOutputCoeficienteLinear;

    public void criaScenePrincipal(Stage stage) {

        // labels e valores
        labelP1X = new Label("Ponto P1.X");
        textInputP1X = new TextField();
        labelP1Y = new Label("Ponto P1.Y");
        textInputyP1Y = new TextField();
        labelP2X = new Label("Ponto P2.X");
        textInputP2X = new TextField();
        labelP2Y = new Label("Ponto P2.Y");
        textInputP2Y = new TextField();
        // HBox
        HBox grupoHorizontal1 = new HBox(labelP1X, textInputP1X);
        HBox grupoHorizontal2 = new HBox(labelP1Y, textInputyP1Y);
        HBox grupoHorizontal3 = new HBox(labelP2X, textInputP2X);
        HBox grupoHorizontal4 = new HBox(labelP2Y, textInputP2Y);
        HBox grupoHorizontal5 = new HBox(textOutputCoeficienteLinear, textOutputCoeficienteAngular);
        HBox grupoHorizontal6 = new HBox(btnCoeficienteLinear, btnCoeficienteAngular);
        // Caixas para exibir o resultado
        textOutputCoeficienteLinear = new TextField();
        textOutputCoeficienteAngular = new TextField();
        // Não permitir edição
        textOutputCoeficienteLinear.setEditable(false);
        textOutputCoeficienteAngular.setEditable(false);
        textOutputCoeficienteLinear.setText("Coef Linear: ");
        textOutputCoeficienteAngular.setText("Coef Angular: ");
        // Criação dos botões
        btnCoeficienteLinear = new Button("Calcula Coeficiente Linear");
        btnCoeficienteAngular = new Button("Calcula Coeficiente Angular");
        // Ações dos botões
        btnCoeficienteLinear.setOnAction(MostrarCoeficienteLinear -> {
            double p1X, p1Y, p2X, p2Y;
            p1X = Double.parseDouble(textInputP1X.getText());
            p2X = Double.parseDouble(textInputP2X.getText());
            p1Y = Double.parseDouble(textInputyP1Y.getText());
            p2Y = Double.parseDouble(textInputP2Y.getText());
            Reta reta = criarReta(p1X, p1Y, p2X, p2Y);
            textOutputCoeficienteLinear.setText(String.valueOf(reta.getCoeficienteLinear()));
        });
        btnCoeficienteAngular.setOnAction(MostrarCoeficienteAngular -> {
            double p1X, p1Y, p2X, p2Y;
            p1X = Double.parseDouble(textInputP1X.getText());
            p2X = Double.parseDouble(textInputP2X.getText());
            p1Y = Double.parseDouble(textInputyP1Y.getText());
            p2Y = Double.parseDouble(textInputP2Y.getText());
            Reta reta = criarReta(p1X, p1Y, p2X, p2Y);
            textOutputCoeficienteAngular.setText(String.valueOf(reta.getCoeficienteAngular()));
        });

        VBox layoutFinal = new VBox(grupoHorizontal1, grupoHorizontal2,
                grupoHorizontal3, grupoHorizontal4, grupoHorizontal5, grupoHorizontal6);
        Scene scene = new Scene(layoutFinal, 300, 200);

        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();
    }

    public Reta criarReta(double p1X, double p1Y, double p2X, double p2Y) {
        Ponto p1 = new Ponto(p1X, p1Y);
        Ponto p2 = new Ponto(p2X, p2Y);
        return new Reta(p1, p2);
    }
}
