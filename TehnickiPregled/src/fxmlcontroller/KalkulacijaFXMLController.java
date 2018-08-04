/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class KalkulacijaFXMLController implements Initializable {

   @FXML
    private ComboBox<String> cbOpstina;

    @FXML
    private Label lblOpstina;

    @FXML
    private ComboBox<String> cbVozilo;

    @FXML
    private Label lblVozilo;

    @FXML
    private ComboBox<Integer> cbGodiste;

    @FXML
    private Label lblGodiste;

    @FXML
    private ComboBox<Integer> cbSnagaMotora;

    @FXML
    private Label lblSnagaMotora;

    @FXML
    private ComboBox<Integer> cbZapremina;

    @FXML
    private Label lblZapremina;

    @FXML
    private CheckBox cbSaobracajna;

    @FXML
    private Label lblSaobracajna;

    @FXML
    private CheckBox cbTablice;

    @FXML
    private Label lblTablice;

    @FXML
    private CheckBox cbPremijskiStepen;

    @FXML
    private Label lblPremijskiStepen;

    @FXML
    private Button btnCalculate;

    //hendler za Izracunaj dugme 
    @FXML
    void handleCalculateBtn(ActionEvent event) {

    }

    ObservableList<String> listaOpstina = FXCollections.observableArrayList("Beograg", "Nis", "Novi Sad", "Indjija", "Sabac");
    ObservableList<String> listaVozila = FXCollections.observableArrayList("Putnicko", "Teretno", "Motorcikl", "Prikljucno vozilo", "Tegljac", "Autobus");
    ObservableList<Integer> listaGodista = FXCollections.observableArrayList(1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018);
    ObservableList<Integer> listaZapremina = FXCollections.observableArrayList(1, 2, 3, 5, 6, 7, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167);
    ObservableList<Integer> listaSnagaMotora = FXCollections.observableArrayList(1, 2, 3, 5, 6, 7, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbOpstina.setItems(listaOpstina);
        cbVozilo.setItems(listaVozila);
        cbGodiste.setItems(listaGodista);
        cbZapremina.setItems(listaZapremina);
        cbSnagaMotora.setItems(listaSnagaMotora);

    }
    
    public void cbOpstinaChange(ActionEvent event){
      lblOpstina.setText(cbOpstina.getValue());
    }
    
    public void cbVoziloChange(ActionEvent event){
      lblVozilo.setText(cbVozilo.getValue());
    }
    public void cbGodisteChanage(ActionEvent event){
      lblGodiste.setText(cbGodiste.getClass().toString());
    }

}
