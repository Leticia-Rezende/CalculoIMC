package org.imc.calculoimc.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.imc.calculoimc.model.Pessoa;
import org.imc.calculoimc.utils.IDGenerator;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private Pessoa pessoa;
   List<Pessoa> listPessoas;
    @FXML
    TextField txtNome;
    @FXML
    TextField txtAltura;
    @FXML
    TextField txtPeso;
    @FXML
    public Label lbIMC;

    @FXML
    Button btnNovo;
    @FXML
    Button btnIMC;
    @FXML
    Button btnSalvar;

    @FXML
    Button btnCarregar;

    @FXML
    Label labelTipoDeImc;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        //this.btnIMC.setDisable(false);
        this.btnNovo.setDisable(true);
        this.btnCarregar.setDisable(true);
        this.pessoa = new Pessoa();
        this.listPessoas = new ArrayList<Pessoa>();

    }

    @FXML
    public void onBtnCalcularImc(){
        System.out.println("Calcular IMC");
        lerFormulario();
        this.pessoa.setImc((float) (this.pessoa.getPeso() / Math.pow(this.pessoa.getAltura(), 2)));

        this.lbIMC.setText(String.format("%.2f", this.pessoa.getImc()));
        this.pessoa.setClassificacao(classificarIMC(this.pessoa.getImc()));
        this.labelTipoDeImc.setText(classificarIMC((this.pessoa.getImc())));



    }
    @FXML
    public void onBtnNovo(){
        this.pessoa = new Pessoa();
        this.pessoa.setId(IDGenerator.generateID());
        limparFormulario();
        System.out.println("Novo");
    }

    @FXML
    public void onBtnSalvar(){
        System.out.println("Salvar dados");
        this.btnNovo.setDisable(false);
        this.btnIMC.setDisable(false);
        this.btnCarregar.setDisable(false);
        this.listPessoas.add(this.pessoa);
    }
    @FXML
    public void onBtnCarregar(){
        System.out.println("Carregar dados");
    }


    public Pessoa lerFormulario(){
        this.pessoa.setNome(this.txtNome.getText());
        this.pessoa.setAltura(Float.parseFloat(this.txtAltura.getText()));
        this.pessoa.setPeso(Float.parseFloat(this.txtPeso.getText()));
        this.pessoa.setImc((float) (this.pessoa.getPeso() / Math.pow(this.pessoa.getAltura(), 2)));
        System.out.println(this.pessoa.toString());
        return this.pessoa;

    }
    public void limparFormulario(){
        this.txtNome.setText("");//setText: envia uma string vazia
        this.txtAltura.setText("");
        this.txtPeso.setText("");
    }
    private String classificarIMC(float imc) {
        if (imc < 18.5) {
            return "Abaixo do Peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Peso Normal";
        } else if (imc >= 25 && imc < 29.9) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc < 34.9) {
            return "Obesidade Grau 1";
        } else if (imc >= 35 && imc < 39.9) {
            return "Obesidade Grau 2";
        } else {
            return "Obesidade Grau 3";
        }
    }

}
