/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlcontroller;

import DAOKlase.VoziloDAO;
import entiteti.Vozilo;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    private DatePicker datePDatumPrvaReg;
    
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

    private final VoziloDAO voziloDAO = new VoziloDAO();

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btnSnimiVozilo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Vozilo noviVozilo = new Vozilo(getID());

                noviVozilo.setMarkaVozila(txtMarkaVozila.getText());

                noviVozilo.setModleVozila(tztModelVozila.getText());

                noviVozilo.setTipVozila(txtTipVozila.getText());

                noviVozilo.setBrojSasije(txtBrojSasije.getText());

                noviVozilo.setBrojMotora(txtBrojMotora.getText());

                noviVozilo.setSnagaMotora(txtSnagaMotora.getText());

                noviVozilo.setZapremainaMotora(txtZapreminaMotora.getText());

                noviVozilo.setGodinaProizvodnje(txtGodinaProizvodnje.getText());

                noviVozilo.setZemljaProizvodnje(txtZemljaProizvodnje.getText());

                noviVozilo.setDozvoljenaNosivost(txtDozvoljenaNosivost.getText());

                noviVozilo.setMasaPraznogVozila(txtMasaPraznogVozila.getText());

                noviVozilo.setNajvecaDozvoljenaMasa(txtNajvecaDozvoljenaMasa.getText());

                noviVozilo.setSifraPoslednjegTehnickog(txtSifraPoslednjegTehnickog.getText());

                noviVozilo.setBrojMestaUVozilu(txtBrojMestaZaSedenje.getText());

                noviVozilo.setStajanje(txtBrojMestaStajanje.getText());

                noviVozilo.setBojaVozila(txtBojaVozila.getText());

                noviVozilo.setVrstaBoja(txtVrstaBoje.getText());

                noviVozilo.setVrstaGoriva(txtVrstaGoriva.getText());

                noviVozilo.setPredjeniPut(txtPredjeniPut.getText());

                noviVozilo.setKuka(txtKuka.getText());

                noviVozilo.setBrojOsovina(txtBrojOsovina.getText());

                noviVozilo.setOsnovnaNamena(txtOsnovnaNamena.getText());

                LocalDate localDate = datePDatumPoslenjegTehnickog.getValue();

                Date date1 = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

                noviVozilo.setDatumPoslednjegTehnickog(date1);
                
                
                LocalDate localDate2 = datePDatumIstekaSaobracajne.getValue();

                Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());

                noviVozilo.setDatumIstekaSaobracajne(date2);
                
                
                LocalDate localDate3 = datePDatumPrvaReg.getValue();

                Date date3 = Date.from(localDate3.atStartOfDay(ZoneId.systemDefault()).toInstant());

                noviVozilo.setDatumPrveRegistracije(date3);
                
                

                try {
                    voziloDAO.addVozilo(noviVozilo);
                    
                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Obavestenje ");
                alert.setHeaderText("");
                alert.setContentText("Podaci O vozilu su uspesno sacuvani u bazi");
                alert.showAndWait();
                    
                } catch (Exception ex) {
                    Logger.getLogger(TehnickiPregledFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

    }

    private int getID() {

        List<Vozilo> allVozilo = voziloDAO.getAllVozilo();

        int maxID = 0;

        if (allVozilo.isEmpty()) {

            for (Vozilo vozilo : allVozilo) {
                if (vozilo.getVoziloId() > maxID) {
                    maxID = vozilo.getVoziloId();
                }
            }
        }

        return ++maxID;
    }

}
