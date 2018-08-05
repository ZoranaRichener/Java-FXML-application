/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlcontroller;

import java.net.URL;
import java.util.ArrayList;
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

    ObservableList<String> listaOpstina = FXCollections.observableArrayList("Beograd", "Nis", "Novi Sad", "Indjija", "Sabac");
    ObservableList<String> listaVozila = FXCollections.observableArrayList("Putnicko", "Teretno", "Motorcikl", "Prikljucno vozilo", "Tegljac", "Autobus");
    ObservableList<Integer> listaGodista = FXCollections.observableArrayList(1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018);
    ObservableList<Integer> listaZapremina = FXCollections.observableArrayList(br());
    //lista sa 500 brojeva
    ObservableList<Integer> listaSnagaMotora = FXCollections.observableArrayList(br());

   
  
     //metoda za dodavanje 500 broeva u listu
    public ArrayList<Integer> br() {
        ArrayList<Integer> brojevi = new ArrayList();
        for (int i = 0; i < 500; i++) {
            brojevi.add(i);
        }
        return brojevi;
    }


     
     
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
        
        if(cbOpstina.getValue().equals("Beogard")){
            kvota=5;
        }else if(cbOpstina.getValue().equals("Novi Sad")){
            kvota=4;
        }else if(cbOpstina.getValue().equals("Nis")){
            kvota=3;
        }else if(cbOpstina.getValue().equals("Sabac")){
            kvota=2;
        }else{
            kvota=1;
        }
        return kvota;
    }
    
    public int kvotaVozila(String vozila){
        int kvota=0;
        
        if(cbVozilo.getValue().equals("Teretno")){
            kvota=6;
        }else if(cbVozilo.getValue().equals("Autobus")){
            kvota=5;
        }else if(cbVozilo.getValue().equals("Tegljac")){
            kvota=4;
        }else if(cbVozilo.getValue().equals("Putnicko")){
            kvota=3;
        }else if(cbVozilo.getValue().equals("Motorcikl")){
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
        
        if(zapremina>=1 && zapremina<=50){
            kvota =1;
        }else if(zapremina>=50 && zapremina<=100){
            kvota = 2;
        }else if(zapremina>100 && zapremina<=200){
            kvota =3;
        }else if(zapremina>200 && zapremina<=300){
            kvota = 4;
        }else if(zapremina>300 && zapremina<=400){
            kvota = 5;
        }else{
            kvota =6;
        }
        return kvota;
    }
    public int kvotaSnageMot(Integer snaga){
        int kvota=0;
        int snagaM=cbSnagaMotora.getValue();
        
         if(snagaM>=1 && snagaM<=50){
            kvota =1;
        }else if(snagaM>50 && snagaM<=100){
            kvota = 2;
        }else if(snagaM>100 && snagaM<=200){
            kvota =3;
        }else if(snagaM>200 && snagaM<=300){
            kvota = 4;
        }else if(snagaM>300 && snagaM<=400){
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
            saobracajna=5000;
        }
        cena=(kvotaOpstine(cbOpstina.getValue())*kvotaVozila(cbVozilo.getValue())*kvotaGodista(cbGodiste.getValue())*
                kvotaZapremine(cbZapremina.getValue())*kvotaSnageMot(cbSnagaMotora.getValue()))*50+premSt+saobracajna+tablice+10000;
        
        return cena+" dinara";
        
    }
    
            
    
}
