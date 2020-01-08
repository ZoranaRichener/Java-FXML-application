/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlcontroller;

import DAOKlase.KlijentDAO;
import entiteti.Klijent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class KlijentFXMLController implements Initializable {

    @FXML
    private TextField txtIme;

    @FXML
    private TextField txtPrezime;

    @FXML
    private TextField txtJMBG;

    @FXML
    private TextField txtBrojLicneKarte;

    @FXML
    private TextField txtAdresa;

    @FXML
    private TextField txtOpstina;

    @FXML
    private TextField txtBrojMobilnog;

    @FXML
    private Button btnSave;

    private final KlijentDAO klijentDAO = new KlijentDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                  
                    Klijent noviKlijent = new Klijent(getID());

                    noviKlijent.setIme(txtIme.getText());

                    noviKlijent.setPrezime(txtPrezime.getText());

                    noviKlijent.setJmbg(txtJMBG.getText());

                    noviKlijent.setBrojLicneKarte(txtBrojLicneKarte.getText());

                    noviKlijent.setAdresa(txtAdresa.getText());

                    noviKlijent.setOpstina(txtOpstina.getText());

                    noviKlijent.setBrojMobilnog(txtBrojMobilnog.getText());
                    
                  //  Alert alert = new Alert(AlertType.CONFIRMATION);
          //  alert.setTitle("Podaci su uspesno sacuvani");
          //  alert.setHeaderText("Look, a Confirmation Dialog");
           // alert.setContentText("Are you ok with this?");

                    try {
                        klijentDAO.addKlijent(noviKlijent);
                        
                         Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Obavestenje ");
                alert.setHeaderText("");
                alert.setContentText("Podaci su uspesno sacuvani u bazi");
                alert.showAndWait();
                        
                       // Alert alert = new Alert(AlertType.CONFIRMATION);
           // alert.setTitle("Podaci su uspesno sacuvani");
          //  alert.setHeaderText("Look, a Confirmation Dialog");
           // alert.setContentText("Are you ok with this?");
                      
                    } catch (Exception ex) {
                        Logger.getLogger(TehnickiPregledFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                
            }

        });

    }

    private int getID() {

        List<Klijent> allKlijent = klijentDAO.getAllKlijent();

        int maxID = 0;

        if (allKlijent.isEmpty()) {

            for (Klijent klijent : allKlijent) {
                if (klijent.getKlijentiId() > maxID) {
                    maxID = klijent.getKlijentiId();
                }
            }
        }

        return ++maxID;
    }

}
