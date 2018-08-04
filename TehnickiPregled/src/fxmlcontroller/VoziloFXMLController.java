/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class VoziloFXMLController implements Initializable {
    
     @FXML
    private TextField txtMarkaVozila;

    @FXML
    private TextField tztModelVozila;

    @FXML
    private TextField txtTipVozila;

    @FXML
    private TextField txtBrojSasije;

    @FXML
    private TextField txtBrojMotora;

    @FXML
    private TextField txtSnagaMotora;

    @FXML
    private TextField txtZapreminaMotora;

    @FXML
    private TextField txtGodinaProizvodnje;

    @FXML
    private TextField txtZemljaProizvodnje;

    @FXML
    private TextField txtDozvoljenaNosivost;

    @FXML
    private TextField txtMasaPraznogVozila;

    @FXML
    private TextField txtNajvecaDozvoljenaMasa;

    @FXML
    private TextField txtSifraPoslednjegTehnickog;

    @FXML
    private DatePicker datePDatumPoslenjegTehnickog;

    @FXML
    private DatePicker datePDatumIstekaSaobracajne;

    @FXML
    private TextField txtBrojMestaZaSedenje;

    @FXML
    private TextField txtBrojMestaStajanje;

    @FXML
    private TextField txtBojaVozila;

    @FXML
    private TextField txtVrstaBoje;

    @FXML
    private TextField txtVrstaGoriva;

    @FXML
    private TextField txtPredjeniPut;

    @FXML
    private TextField txtKuka;

    @FXML
    private TextField txtBrojOsovina;

    @FXML
    private TextField txtOsnovnaNamena;

    @FXML
    private Button btnSnimiVozilo;

    @FXML
    private Button btnPronadjiVoziloAMSkatalog;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
