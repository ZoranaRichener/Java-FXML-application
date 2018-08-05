/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlcontroller;

import DAOKlase.GalerijaDAO;
import entiteti.Galerija;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import static sun.rmi.registry.RegistryImpl.getID;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class GalerijaFXMLController implements Initializable {

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private AnchorPane imageSlider;

    @FXML
    private AnchorPane imagePane;

    @FXML
    private StackPane imgStackPane;

    @FXML
    private ImageView imageView;

    @FXML
    private Button btnUpload;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnDelete;

    private final GalerijaDAO galerijaDAO = new GalerijaDAO();

    @FXML
    void hendleDeleteBtn(ActionEvent event) throws IOException {

    }

    @FXML
    void hendleSaveBtn(ActionEvent event) throws IOException {

        Galerija novagalerija = new Galerija(getID());

        Image img1 = imageView.getImage();

        ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();

        ImageIO.write(SwingFXUtils.fromFXImage(img1, null), "png", byteOutput);

        byte[] data = byteOutput.toByteArray();

        novagalerija.setSlika(data);

        try {
            galerijaDAO.addGalerija(novagalerija);
        } catch (Exception ex) {
            Logger.getLogger(TehnickiPregledFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void hendleUploadBtn(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG
                = new FileChooser.ExtensionFilter("JPG files (*.JPG)", "*.JPG");
        FileChooser.ExtensionFilter extFilterjpg
                = new FileChooser.ExtensionFilter("jpg files (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterPNG
                = new FileChooser.ExtensionFilter("PNG files (*.PNG)", "*.PNG");
        FileChooser.ExtensionFilter extFilterpng
                = new FileChooser.ExtensionFilter("png files (*.png)", "*.png");
        fileChooser.getExtensionFilters()
                .addAll(extFilterJPG, extFilterjpg, extFilterPNG, extFilterpng);

        //Show open file dialog
        File file = fileChooser.showOpenDialog(null);

        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imageView.setImage(image);
            imageView.setPreserveRatio(true);

        } catch (IOException ex) {
            Logger.getLogger(GalerijaFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private int getID() {

        List<Galerija> allGalerija = galerijaDAO.getAllGalerija();

        int maxID = 0;

        if (allGalerija.isEmpty()) {

            for (Galerija galerija : allGalerija) {
                if (galerija.getGalerijaId() > maxID) {
                    maxID = galerija.getGalerijaId();
                }
            }
        }

        return ++maxID;
    }

}
