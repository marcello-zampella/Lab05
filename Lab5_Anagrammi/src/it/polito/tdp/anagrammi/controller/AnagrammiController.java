package it.polito.tdp.anagrammi.controller;

import it.polito.tdp.amagramma.model.Model;
import it.polito.tdp.amagramma.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

    @FXML
    private TextField textField;

    @FXML
    private TextArea txtRisultatoSensato;

    @FXML
    private TextArea txtRisultatoSbagliato;

	private Model model;

    @FXML
    void doAnagramma(ActionEvent event) {
    	this.txtRisultatoSbagliato.clear();
    	this.txtRisultatoSensato.clear();
    	String parola=this.textField.getText();
    	for(Parola parolatemp:model.cercaAnagramma(parola)) {
    		if(parolatemp.isEsiste())
    			this.txtRisultatoSensato.appendText(parolatemp.getParola()+"\n");
    		else
    			this.txtRisultatoSbagliato.appendText(parolatemp.getParola()+"\n");
    	}
    }

    @FXML
    void doClear(ActionEvent event) {
    	this.txtRisultatoSbagliato.clear();
    	this.txtRisultatoSensato.clear();
    	this.textField.clear();
    }

	public void setModel(Model model) {
		this.model=model;
		
	}

}
