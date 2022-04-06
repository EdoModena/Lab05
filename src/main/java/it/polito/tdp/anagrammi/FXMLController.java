package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnanagrammi;

    @FXML
    private Button btnreset;

    @FXML
    private TextArea txtanagrammic;

    @FXML
    private TextArea txtanagrammie;

    @FXML
    private TextField txttext;

    @FXML
    void handleanagrammi(ActionEvent event) {
    	String s=txttext.getText();
    	Map<String,Boolean> anag = new LinkedHashMap<String,Boolean>();
    	anag = model.anagramma(s);
    	for(String st: anag.keySet()) {
    		if(anag.get(st)==true)
    			txtanagrammic.appendText(st+"\n");
    		else
    			txtanagrammie.appendText(st+"\n");
    	}
    }

    @FXML
    void handlereset(ActionEvent event) {
    	txttext.clear();
    	txtanagrammic.clear();
    	txtanagrammie.clear();
    }

    @FXML
    void initialize() {
        assert btnanagrammi != null : "fx:id=\"btnanagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnreset != null : "fx:id=\"btnreset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtanagrammic != null : "fx:id=\"txtanagrammic\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtanagrammie != null : "fx:id=\"txtanagrammie\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txttext != null : "fx:id=\"txttext\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
	}

}
