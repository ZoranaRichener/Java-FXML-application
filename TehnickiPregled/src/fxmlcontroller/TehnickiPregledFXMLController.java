package fxmlcontroller;

import DAOKlase.TehnickiPregledDAO;
import entiteti.TehnickiPregled;
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

    private final TehnickiPregledDAO tehnickiPregledDAO = new TehnickiPregledDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btnSaveTehnickiPregled.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (!txtNaziv_firme.getText().trim().isEmpty()) {

                   TehnickiPregled novitehPregled = new TehnickiPregled(getID());

                   novitehPregled.setNazivFirme(txtNaziv_firme.getText());

                   novitehPregled.setSedisteFirme(txtSediste_firme.getText());
                   
                   novitehPregled.setKontrolor1(txtKontroler_1.getText());
                   
                   novitehPregled.setKontrolor2(txtKontrolor_2.getText());
                   
                   novitehPregled.setSifraTehnickogPregleda(txtSifraTehnickogPregleda.getText());
                   
                   novitehPregled.setUsloviZaVrsenjePregleda(txtUsloviZaVrsenjePregleda.getText());
                   
                   novitehPregled.setMestoVrsenjaPregleda(txtMestoVrsenjaPregleda.getText());
                   
                   novitehPregled.setVrstaPregleda(txtVrstaPregleda.getText());
                   
                   novitehPregled.setRedniBroj(txtRedniBroj.getText());
                   
                   novitehPregled.setIdBroj(txtIDbroj.getText());
                   
                   novitehPregled.setVrstaVozila(txtVrstaVozila.getText());
                   
                   novitehPregled.setIspravnostVozila(txtIspravnostVozila.getText());
                   
                   
                   LocalDate localDate = datePDatumPregleda.getValue();
                   
                   Date date1 = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
                   
                   novitehPregled.setDatumPregleda(date1);
                   
                   novitehPregled.setPocetakPregleda(txtPocetakPregleda.getText());
                   
                   novitehPregled.setZavrsetakPregleda(txtZavrsetakPregleda.getText());
                   
                   novitehPregled.setPodaciONeispravnosti(txtPodaciOneispravnosti.getText());
                   
                  try {
                        tehnickiPregledDAO.addTehnickiPregled(novitehPregled);
                          Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Obavestenje ");
                alert.setHeaderText("");
                alert.setContentText("Podaci o tehnickom pregledu su uspesno sacuvani u bazi");
                alert.showAndWait();
                    } catch (Exception ex) {
                        Logger.getLogger(TehnickiPregledFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

        });

    }

    private int getID() {

        List<TehnickiPregled> allTehnickiPregled = tehnickiPregledDAO.getAllTehnickiPregled();

        int maxID = 0;

        if (allTehnickiPregled.isEmpty()) {

            for (TehnickiPregled tehnicki : allTehnickiPregled) {
                if (tehnicki.getTehnickiPregledId() > maxID) {
                    maxID = tehnicki.getTehnickiPregledId();
                }
            }
        }

        return ++maxID;
    }
}
