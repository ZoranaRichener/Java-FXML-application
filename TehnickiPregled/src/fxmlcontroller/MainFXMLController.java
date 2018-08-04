/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;

/**
 *
 * @author Owner
 */
public class MainFXMLController implements Initializable {
    
   
   @FXML
    private Tab tabKlijent;

    @FXML
    private Tab tabVozila;

    @FXML
    private Tab tabTehnicki;

    @FXML
    private Tab tabGalerija;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
