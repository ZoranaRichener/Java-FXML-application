/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class TehnickiPregledFXMLController implements Initializable {
    
      @FXML
    private TextField txtNaziv_firme;

    @FXML
    private TextField txtSediste_firme;

    @FXML
    private TextField txtKontroler_1;

    @FXML
    private TextField txtKontrolor_2;

    @FXML
    private TextField txtSifraTehnickogPregleda;

    @FXML
    private VBox btnSnimiSve;

    @FXML
    private TextField txtUsloviZaVrsenjePregleda;

    @FXML
    private TextField txtMestoVrsenjaPregleda;

    @FXML
    private TextField txtVrstaPregleda;

    @FXML
    private TextField txtRedniBroj;

    @FXML
    private TextField txtIDbroj;

    @FXML
    private TextField txtVrstaVozila;

    @FXML
    private TextField txtIspravnostVozila;
    
//dugme na koje se pamte svi podaci o vozilu,klijentima ,tehnickom pregledu i eventualno i slike kasnije
    @FXML
    private Button btnSaveALL;
    
    //dugme na koje pamtis samo podatke o tehnickom pregledu
     @FXML
    private Button btnSaveTehnickiPregled;

    @FXML
    private DatePicker datePDatumPregleda;

    @FXML
    private TextField txtPocetakPregleda;

    @FXML
    private TextField txtZavrsetakPregleda;

    @FXML
    private TextArea txtPodaciOneispravnosti;

    /**
     * Initializes the controller class.
     */
    
   
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
