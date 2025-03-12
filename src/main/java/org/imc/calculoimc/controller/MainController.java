package org.imc.calculoimc.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.imc.calculoimc.model.Pessoa;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
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


    private  Pessoa pessoa;
    private List<Pessoa> lerPessoa;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        this.btnIMC.setDisable(true);
        this.btnNovo.setDisable(true);
        this.btnCarregar.setDisable(true);
        this.pessoa = new Pessoa();
        this.listPessoas = new ArrayList<Pessoa>();

    }

    @FXML
    public void onBtnCalcularImc(){
        System.out.println("Calcular IMC");
        lerFormulario();

        this.pessoa.setImc(this.pessoa.getPeso()/this.pessoa.getAltura()*(this.pessoa.getAltura()));
        this.lbIMC.setText(String.format("%.2f", this.pessoa.getImc()));

    }
    @FXML
    public void onBtnNovo(){
        System.out.println("Novo");
    }

    @FXML
    public void onBtnSalvar(){
        System.out.println("Salvar dados");
        this.btnNovo.setDisable(false);
        this.btnIMC.setDisable(false);
        this.btnCarregar.setDisable(false);
    }
    @FXML
    public void onBtnCarregar(){
        System.out.println("Carregar dados");
    }


    public Pessoa lerFormulario(){
        this.pessoa.setNome(this.txtNome.getText());
        this.pessoa.setAltura(Float.parseFloat(this.txtAltura.getText()));
        this.pessoa.setPeso(Float.parseFloat(this.txtPeso.getText()));
        System.out.println(this.pessoa.toString());
        return this.pessoa;
    }
    public void limparFormulario(){
        this.txtNome.setText("");//setText: envia uma string vazia
        this.txtAltura.setText("");
        this.txtPeso.setText("");
    }
}
