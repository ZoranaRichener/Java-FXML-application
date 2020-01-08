/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entiteti;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "vozilo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vozilo.findAll", query = "SELECT v FROM Vozilo v")
    , @NamedQuery(name = "Vozilo.findByVoziloId", query = "SELECT v FROM Vozilo v WHERE v.voziloId = :voziloId")
    , @NamedQuery(name = "Vozilo.findByMarkaVozila", query = "SELECT v FROM Vozilo v WHERE v.markaVozila = :markaVozila")
    , @NamedQuery(name = "Vozilo.findByModleVozila", query = "SELECT v FROM Vozilo v WHERE v.modleVozila = :modleVozila")
    , @NamedQuery(name = "Vozilo.findByTipVozila", query = "SELECT v FROM Vozilo v WHERE v.tipVozila = :tipVozila")
    , @NamedQuery(name = "Vozilo.findByBrojSasije", query = "SELECT v FROM Vozilo v WHERE v.brojSasije = :brojSasije")
    , @NamedQuery(name = "Vozilo.findByBrojMotora", query = "SELECT v FROM Vozilo v WHERE v.brojMotora = :brojMotora")
    , @NamedQuery(name = "Vozilo.findBySnagaMotora", query = "SELECT v FROM Vozilo v WHERE v.snagaMotora = :snagaMotora")
    , @NamedQuery(name = "Vozilo.findByZapremainaMotora", query = "SELECT v FROM Vozilo v WHERE v.zapremainaMotora = :zapremainaMotora")
    , @NamedQuery(name = "Vozilo.findByGodinaProizvodnje", query = "SELECT v FROM Vozilo v WHERE v.godinaProizvodnje = :godinaProizvodnje")
    , @NamedQuery(name = "Vozilo.findByZemljaProizvodnje", query = "SELECT v FROM Vozilo v WHERE v.zemljaProizvodnje = :zemljaProizvodnje")
    , @NamedQuery(name = "Vozilo.findByDozvoljenaNosivost", query = "SELECT v FROM Vozilo v WHERE v.dozvoljenaNosivost = :dozvoljenaNosivost")
    , @NamedQuery(name = "Vozilo.findByMasaPraznogVozila", query = "SELECT v FROM Vozilo v WHERE v.masaPraznogVozila = :masaPraznogVozila")
    , @NamedQuery(name = "Vozilo.findByNajvecaDozvoljenaMasa", query = "SELECT v FROM Vozilo v WHERE v.najvecaDozvoljenaMasa = :najvecaDozvoljenaMasa")
    , @NamedQuery(name = "Vozilo.findBySifraPoslednjegTehnickog", query = "SELECT v FROM Vozilo v WHERE v.sifraPoslednjegTehnickog = :sifraPoslednjegTehnickog")
    , @NamedQuery(name = "Vozilo.findByDatumPoslednjegTehnickog", query = "SELECT v FROM Vozilo v WHERE v.datumPoslednjegTehnickog = :datumPoslednjegTehnickog")
    , @NamedQuery(name = "Vozilo.findByDatumIstekaSaobracajne", query = "SELECT v FROM Vozilo v WHERE v.datumIstekaSaobracajne = :datumIstekaSaobracajne")
    , @NamedQuery(name = "Vozilo.findByBrojMestaUVozilu", query = "SELECT v FROM Vozilo v WHERE v.brojMestaUVozilu = :brojMestaUVozilu")
    , @NamedQuery(name = "Vozilo.findByStajanje", query = "SELECT v FROM Vozilo v WHERE v.stajanje = :stajanje")
    , @NamedQuery(name = "Vozilo.findByOsnovnaNamena", query = "SELECT v FROM Vozilo v WHERE v.osnovnaNamena = :osnovnaNamena")
    , @NamedQuery(name = "Vozilo.findByBojaVozila", query = "SELECT v FROM Vozilo v WHERE v.bojaVozila = :bojaVozila")
    , @NamedQuery(name = "Vozilo.findByVrstaBoja", query = "SELECT v FROM Vozilo v WHERE v.vrstaBoja = :vrstaBoja")
    , @NamedQuery(name = "Vozilo.findByBrojOsovina", query = "SELECT v FROM Vozilo v WHERE v.brojOsovina = :brojOsovina")
    , @NamedQuery(name = "Vozilo.findByVrstaGoriva", query = "SELECT v FROM Vozilo v WHERE v.vrstaGoriva = :vrstaGoriva")
    , @NamedQuery(name = "Vozilo.findByPredjeniPut", query = "SELECT v FROM Vozilo v WHERE v.predjeniPut = :predjeniPut")
    , @NamedQuery(name = "Vozilo.findByKuka", query = "SELECT v FROM Vozilo v WHERE v.kuka = :kuka")
    , @NamedQuery(name = "Vozilo.findByDatumPrveRegistracije", query = "SELECT v FROM Vozilo v WHERE v.datumPrveRegistracije = :datumPrveRegistracije")
    , @NamedQuery(name = "Vozilo.findByDuzinaVozila", query = "SELECT v FROM Vozilo v WHERE v.duzinaVozila = :duzinaVozila")
    , @NamedQuery(name = "Vozilo.findBySirinaVozila", query = "SELECT v FROM Vozilo v WHERE v.sirinaVozila = :sirinaVozila")
    , @NamedQuery(name = "Vozilo.findByVisinaVozila", query = "SELECT v FROM Vozilo v WHERE v.visinaVozila = :visinaVozila")})
public class Vozilo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "VOZILO_ID")
    private Integer voziloId;
    @Basic(optional = false)
    @Column(name = "MARKA_VOZILA")
    private String markaVozila;
    @Basic(optional = false)
    @Column(name = "MODLE_VOZILA")
    private String modleVozila;
    @Basic(optional = false)
    @Column(name = "TIP_VOZILA")
    private String tipVozila;
    @Basic(optional = false)
    @Column(name = "BROJ_SASIJE")
    private String brojSasije;
    @Basic(optional = false)
    @Column(name = "BROJ_MOTORA")
    private String brojMotora;
    @Basic(optional = false)
    @Column(name = "SNAGA_MOTORA")
    private String snagaMotora;
    @Basic(optional = false)
    @Column(name = "ZAPREMAINA_MOTORA")
    private String zapremainaMotora;
    @Basic(optional = false)
    @Column(name = "GODINA_PROIZVODNJE")
    private String godinaProizvodnje;
    @Column(name = "ZEMLJA_PROIZVODNJE")
    private String zemljaProizvodnje;
    @Basic(optional = false)
    @Column(name = "DOZVOLJENA_NOSIVOST")
    private String dozvoljenaNosivost;
    @Basic(optional = false)
    @Column(name = "MASA_PRAZNOG_VOZILA")
    private String masaPraznogVozila;
    @Basic(optional = false)
    @Column(name = "NAJVECA_DOZVOLJENA_MASA")
    private String najvecaDozvoljenaMasa;
    @Basic(optional = false)
    @Column(name = "SIFRA_POSLEDNJEG_TEHNICKOG")
    private String sifraPoslednjegTehnickog;
    @Basic(optional = false)
    @Column(name = "DATUM_POSLEDNJEG_TEHNICKOG")
    @Temporal(TemporalType.DATE)
    private Date datumPoslednjegTehnickog;
    @Basic(optional = false)
    @Column(name = "DATUM_ISTEKA_SAOBRACAJNE")
    @Temporal(TemporalType.DATE)
    private Date datumIstekaSaobracajne;
    @Basic(optional = false)
    @Column(name = "BROJ_MESTA_U_VOZILU")
    private String brojMestaUVozilu;
    @Basic(optional = false)
    @Column(name = "STAJANJE")
    private String stajanje;
    @Basic(optional = false)
    @Column(name = "OSNOVNA_NAMENA")
    private String osnovnaNamena;
    @Basic(optional = false)
    @Column(name = "BOJA_VOZILA")
    private String bojaVozila;
    @Basic(optional = false)
    @Column(name = "VRSTA_BOJA")
    private String vrstaBoja;
    @Basic(optional = false)
    @Column(name = "BROJ_OSOVINA")
    private String brojOsovina;
    @Basic(optional = false)
    @Column(name = "VRSTA_GORIVA")
    private String vrstaGoriva;
    @Basic(optional = false)
    @Column(name = "PREDJENI_PUT")
    private String predjeniPut;
    @Basic(optional = false)
    @Column(name = "KUKA")
    private String kuka;
    @Basic(optional = false)
    @Column(name = "DATUM_PRVE_REGISTRACIJE")
    @Temporal(TemporalType.DATE)
    private Date datumPrveRegistracije;
    @Column(name = "DUZINA_VOZILA")
    private String duzinaVozila;
    @Column(name = "SIRINA_VOZILA")
    private String sirinaVozila;
    @Column(name = "VISINA_VOZILA")
    private String visinaVozila;
    @OneToMany(mappedBy = "voziloId")
    private List<TehnickiPregled> tehnickiPregledList;
    @OneToMany(mappedBy = "voziloId")
    private List<Klijent> klijentList;
    @JoinColumn(name = "KLIJENTI_ID", referencedColumnName = "KLIJENTI_ID")
    @ManyToOne
    private Klijent klijentiId;
    @JoinColumn(name = "TEHNICKI_PREGLED_ID", referencedColumnName = "TEHNICKI_PREGLED_ID")
    @ManyToOne
    private TehnickiPregled tehnickiPregledId;

    public Vozilo() {
    }

    public Vozilo(Integer voziloId) {
        this.voziloId = voziloId;
    }

    public Vozilo(Integer voziloId, String markaVozila, String modleVozila, String tipVozila, String brojSasije, String brojMotora, String snagaMotora, String zapremainaMotora, String godinaProizvodnje, String dozvoljenaNosivost, String masaPraznogVozila, String najvecaDozvoljenaMasa, String sifraPoslednjegTehnickog, Date datumPoslednjegTehnickog, Date datumIstekaSaobracajne, String brojMestaUVozilu, String stajanje, String osnovnaNamena, String bojaVozila, String vrstaBoja, String brojOsovina, String vrstaGoriva, String predjeniPut, String kuka, Date datumPrveRegistracije) {
        this.voziloId = voziloId;
        this.markaVozila = markaVozila;
        this.modleVozila = modleVozila;
        this.tipVozila = tipVozila;
        this.brojSasije = brojSasije;
        this.brojMotora = brojMotora;
        this.snagaMotora = snagaMotora;
        this.zapremainaMotora = zapremainaMotora;
        this.godinaProizvodnje = godinaProizvodnje;
        this.dozvoljenaNosivost = dozvoljenaNosivost;
        this.masaPraznogVozila = masaPraznogVozila;
        this.najvecaDozvoljenaMasa = najvecaDozvoljenaMasa;
        this.sifraPoslednjegTehnickog = sifraPoslednjegTehnickog;
        this.datumPoslednjegTehnickog = datumPoslednjegTehnickog;
        this.datumIstekaSaobracajne = datumIstekaSaobracajne;
        this.brojMestaUVozilu = brojMestaUVozilu;
        this.stajanje = stajanje;
        this.osnovnaNamena = osnovnaNamena;
        this.bojaVozila = bojaVozila;
        this.vrstaBoja = vrstaBoja;
        this.brojOsovina = brojOsovina;
        this.vrstaGoriva = vrstaGoriva;
        this.predjeniPut = predjeniPut;
        this.kuka = kuka;
        this.datumPrveRegistracije = datumPrveRegistracije;
    }

    public Integer getVoziloId() {
        return voziloId;
    }

    public void setVoziloId(Integer voziloId) {
        this.voziloId = voziloId;
    }

    public String getMarkaVozila() {
        return markaVozila;
    }

    public void setMarkaVozila(String markaVozila) {
        this.markaVozila = markaVozila;
    }

    public String getModleVozila() {
        return modleVozila;
    }

    public void setModleVozila(String modleVozila) {
        this.modleVozila = modleVozila;
    }

    public String getTipVozila() {
        return tipVozila;
    }

    public void setTipVozila(String tipVozila) {
        this.tipVozila = tipVozila;
    }

    public String getBrojSasije() {
        return brojSasije;
    }

    public void setBrojSasije(String brojSasije) {
        this.brojSasije = brojSasije;
    }

    public String getBrojMotora() {
        return brojMotora;
    }

    public void setBrojMotora(String brojMotora) {
        this.brojMotora = brojMotora;
    }

    public String getSnagaMotora() {
        return snagaMotora;
    }

    public void setSnagaMotora(String snagaMotora) {
        this.snagaMotora = snagaMotora;
    }

    public String getZapremainaMotora() {
        return zapremainaMotora;
    }

    public void setZapremainaMotora(String zapremainaMotora) {
        this.zapremainaMotora = zapremainaMotora;
    }

    public String getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(String godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public String getZemljaProizvodnje() {
        return zemljaProizvodnje;
    }

    public void setZemljaProizvodnje(String zemljaProizvodnje) {
        this.zemljaProizvodnje = zemljaProizvodnje;
    }

    public String getDozvoljenaNosivost() {
        return dozvoljenaNosivost;
    }

    public void setDozvoljenaNosivost(String dozvoljenaNosivost) {
        this.dozvoljenaNosivost = dozvoljenaNosivost;
    }

    public String getMasaPraznogVozila() {
        return masaPraznogVozila;
    }

    public void setMasaPraznogVozila(String masaPraznogVozila) {
        this.masaPraznogVozila = masaPraznogVozila;
    }

    public String getNajvecaDozvoljenaMasa() {
        return najvecaDozvoljenaMasa;
    }

    public void setNajvecaDozvoljenaMasa(String najvecaDozvoljenaMasa) {
        this.najvecaDozvoljenaMasa = najvecaDozvoljenaMasa;
    }

    public String getSifraPoslednjegTehnickog() {
        return sifraPoslednjegTehnickog;
    }

    public void setSifraPoslednjegTehnickog(String sifraPoslednjegTehnickog) {
        this.sifraPoslednjegTehnickog = sifraPoslednjegTehnickog;
    }

    public Date getDatumPoslednjegTehnickog() {
        return datumPoslednjegTehnickog;
    }

    public void setDatumPoslednjegTehnickog(Date datumPoslednjegTehnickog) {
        this.datumPoslednjegTehnickog = datumPoslednjegTehnickog;
    }

    public Date getDatumIstekaSaobracajne() {
        return datumIstekaSaobracajne;
    }

    public void setDatumIstekaSaobracajne(Date datumIstekaSaobracajne) {
        this.datumIstekaSaobracajne = datumIstekaSaobracajne;
    }

    public String getBrojMestaUVozilu() {
        return brojMestaUVozilu;
    }

    public void setBrojMestaUVozilu(String brojMestaUVozilu) {
        this.brojMestaUVozilu = brojMestaUVozilu;
    }

    public String getStajanje() {
        return stajanje;
    }

    public void setStajanje(String stajanje) {
        this.stajanje = stajanje;
    }

    public String getOsnovnaNamena() {
        return osnovnaNamena;
    }

    public void setOsnovnaNamena(String osnovnaNamena) {
        this.osnovnaNamena = osnovnaNamena;
    }

    public String getBojaVozila() {
        return bojaVozila;
    }

    public void setBojaVozila(String bojaVozila) {
        this.bojaVozila = bojaVozila;
    }

    public String getVrstaBoja() {
        return vrstaBoja;
    }

    public void setVrstaBoja(String vrstaBoja) {
        this.vrstaBoja = vrstaBoja;
    }

    public String getBrojOsovina() {
        return brojOsovina;
    }

    public void setBrojOsovina(String brojOsovina) {
        this.brojOsovina = brojOsovina;
    }

    public String getVrstaGoriva() {
        return vrstaGoriva;
    }

    public void setVrstaGoriva(String vrstaGoriva) {
        this.vrstaGoriva = vrstaGoriva;
    }

    public String getPredjeniPut() {
        return predjeniPut;
    }

    public void setPredjeniPut(String predjeniPut) {
        this.predjeniPut = predjeniPut;
    }

    public String getKuka() {
        return kuka;
    }

    public void setKuka(String kuka) {
        this.kuka = kuka;
    }

    public Date getDatumPrveRegistracije() {
        return datumPrveRegistracije;
    }

    public void setDatumPrveRegistracije(Date datumPrveRegistracije) {
        this.datumPrveRegistracije = datumPrveRegistracije;
    }

    public String getDuzinaVozila() {
        return duzinaVozila;
    }

    public void setDuzinaVozila(String duzinaVozila) {
        this.duzinaVozila = duzinaVozila;
    }

    public String getSirinaVozila() {
        return sirinaVozila;
    }

    public void setSirinaVozila(String sirinaVozila) {
        this.sirinaVozila = sirinaVozila;
    }

    public String getVisinaVozila() {
        return visinaVozila;
    }

    public void setVisinaVozila(String visinaVozila) {
        this.visinaVozila = visinaVozila;
    }

    @XmlTransient
    public List<TehnickiPregled> getTehnickiPregledList() {
        return tehnickiPregledList;
    }

    public void setTehnickiPregledList(List<TehnickiPregled> tehnickiPregledList) {
        this.tehnickiPregledList = tehnickiPregledList;
    }

    @XmlTransient
    public List<Klijent> getKlijentList() {
        return klijentList;
    }

    public void setKlijentList(List<Klijent> klijentList) {
        this.klijentList = klijentList;
    }

    public Klijent getKlijentiId() {
        return klijentiId;
    }

    public void setKlijentiId(Klijent klijentiId) {
        this.klijentiId = klijentiId;
    }

    public TehnickiPregled getTehnickiPregledId() {
        return tehnickiPregledId;
    }

    public void setTehnickiPregledId(TehnickiPregled tehnickiPregledId) {
        this.tehnickiPregledId = tehnickiPregledId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (voziloId != null ? voziloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vozilo)) {
            return false;
        }
        Vozilo other = (Vozilo) object;
        if ((this.voziloId == null && other.voziloId != null) || (this.voziloId != null && !this.voziloId.equals(other.voziloId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiteti.Vozilo[ voziloId=" + voziloId + " ]";
    }
    
}
