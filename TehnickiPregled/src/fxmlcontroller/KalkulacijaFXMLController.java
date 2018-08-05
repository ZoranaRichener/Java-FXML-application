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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class KalkulacijaFXMLController implements Initializable {
    @FXML
    private TextField txtFieldIzracuanvanja;

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
        txtFieldIzracuanvanja.setText(izracunajCenuReg());
        

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
      lblGodiste.setText(cbGodiste.getValue().toString());
    }
    public void cbSnagaMotoraChanage(ActionEvent event){
      lblSnagaMotora.setText(cbSnagaMotora.getValue().toString());
    }
     public void cbZapreminaChanage(ActionEvent event){
      lblZapremina.setText(cbZapremina.getValue().toString());
    }
    
    public int kvotaOpstine(String opstina){
        int kvota=0;
        
        if(cbVozilo.getValue().equals("Beogarg")){
            kvota=5;
        }else if(cbVozilo.getValue().equals("Novi Sad")){
            kvota=4;
        }else if(cbVozilo.getValue().equals("Nis")){
            kvota=3;
        }else if(cbVozilo.getValue().equals("Sabac")){
            kvota=2;
        }else{
            kvota=1;
        }
        return kvota;
    }
    
    public int kvotaVozila(String vozila){
        int kvota=0;
        
        if(cbOpstina.getValue().equals("Teretno")){
            kvota=6;
        }else if(cbOpstina.getValue().equals("Autobus")){
            kvota=5;
        }else if(cbOpstina.getValue().equals("Tegljac")){
            kvota=4;
        }else if(cbOpstina.getValue().equals("Putnicko")){
            kvota=3;
        }else if(cbOpstina.getValue().equals("Motorcikl")){
            kvota=2;
        }else{
            kvota=1;
        }
        return kvota;
   }
    
    public int kvotaGodista(Integer god){
       int kvota=0;
        int godiste=cbGodiste.getValue();
        
        if(godiste>=1999 && godiste<=2003){
            kvota =1;
        }else if(godiste>2003 && godiste<=2007){
        kvota=2;
    }else if(godiste>2007 && godiste<=2011){
        kvota=3;
    }else if(godiste>2011 && godiste<=2015){
        kvota=4;
    }else if(godiste>2015 && godiste<=2017){
        kvota=5;
    }else{
        kvota =6;
    }
        return kvota;
        
    }
    
    public int kvotaZapremine(Integer zap){
        int kvota=0;
        int zapremina=cbZapremina.getValue();
        
        if(zapremina>=1 && zapremina<=30){
            kvota =1;
        }else if(zapremina>30 && zapremina<=60){
            kvota = 2;
        }else if(zapremina>60 && zapremina<=90){
            kvota =3;
        }else if(zapremina>90 && zapremina<=120){
            kvota = 4;
        }else if(zapremina>120 && zapremina<=150){
            kvota = 5;
        }else{
            kvota =6;
        }
        return kvota;
    }
    public int kvotaSnageMot(Integer snaga){
        int kvota=0;
        int snagaM=cbSnagaMotora.getValue();
        
         if(snagaM>=1 && snagaM<=30){
            kvota =1;
        }else if(snagaM>30 && snagaM<=60){
            kvota = 2;
        }else if(snagaM>60 && snagaM<=90){
            kvota =3;
        }else if(snagaM>90 && snagaM<=120){
            kvota = 4;
        }else if(snagaM>120 && snagaM<=150){
            kvota = 5;
        }else{
            kvota =6;
        }
        return kvota;
        
    }
    
    public String izracunajCenuReg(){
        int cena=0;
        int premSt=0;
        int saobracajna=0;
        int tablice=0;
        
        if(cbPremijskiStepen.isSelected()){
            premSt=3000;
        }
        if(cbTablice.isSelected()){
            tablice=4000;
        }
        if(cbSaobracajna.isSelected()){
            tablice=5000;
        }
        cena=(kvotaOpstine(cbOpstina.getValue())*kvotaVozila(cbVozilo.getValue())*kvotaGodista(cbGodiste.getValue())*
                kvotaZapremine(cbZapremina.getValue())*kvotaSnageMot(cbSnagaMotora.getValue()))*50+premSt+saobracajna+tablice+10000;
        
        return cena+" dinara";
        
    }
    
            
    
}
