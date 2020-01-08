/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entiteti;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo
 */
@Entity
@Table(name = "klijent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klijent.findAll", query = "SELECT k FROM Klijent k")
    , @NamedQuery(name = "Klijent.findByKlijentiId", query = "SELECT k FROM Klijent k WHERE k.klijentiId = :klijentiId")
    , @NamedQuery(name = "Klijent.findByIme", query = "SELECT k FROM Klijent k WHERE k.ime = :ime")
    , @NamedQuery(name = "Klijent.findByPrezime", query = "SELECT k FROM Klijent k WHERE k.prezime = :prezime")
    , @NamedQuery(name = "Klijent.findByJmbg", query = "SELECT k FROM Klijent k WHERE k.jmbg = :jmbg")
    , @NamedQuery(name = "Klijent.findByBrojLicneKarte", query = "SELECT k FROM Klijent k WHERE k.brojLicneKarte = :brojLicneKarte")
    , @NamedQuery(name = "Klijent.findByAdresa", query = "SELECT k FROM Klijent k WHERE k.adresa = :adresa")
    , @NamedQuery(name = "Klijent.findByOpstina", query = "SELECT k FROM Klijent k WHERE k.opstina = :opstina")
    , @NamedQuery(name = "Klijent.findByBrojMobilnog", query = "SELECT k FROM Klijent k WHERE k.brojMobilnog = :brojMobilnog")})
public class Klijent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KLIJENTI_ID")
    private Integer klijentiId;
    @Basic(optional = false)
    @Column(name = "IME")
    private String ime;
    @Basic(optional = false)
    @Column(name = "PREZIME")
    private String prezime;
    @Basic(optional = false)
    @Column(name = "JMBG")
    private String jmbg;
    @Basic(optional = false)
    @Column(name = "BROJ_LICNE_KARTE")
    private String brojLicneKarte;
    @Column(name = "ADRESA")
    private String adresa;
    @Column(name = "OPSTINA")
    private String opstina;
    @Basic(optional = false)
    @Column(name = "BROJ_MOBILNOG")
    private String brojMobilnog;
    @JoinColumn(name = "VOZILO_ID", referencedColumnName = "VOZILO_ID")
    @ManyToOne
    private Vozilo voziloId;
    @OneToMany(mappedBy = "klijentiId")
    private List<Vozilo> voziloList;

    public Klijent() {
    }

    public Klijent(Integer klijentiId) {
        this.klijentiId = klijentiId;
    }

    public Klijent(Integer klijentiId, String ime, String prezime, String jmbg, String brojLicneKarte, String brojMobilnog) {
        this.klijentiId = klijentiId;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.brojLicneKarte = brojLicneKarte;
        this.brojMobilnog = brojMobilnog;
    }

    public Integer getKlijentiId() {
        return klijentiId;
    }

    public void setKlijentiId(Integer klijentiId) {
        this.klijentiId = klijentiId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getBrojLicneKarte() {
        return brojLicneKarte;
    }

    public void setBrojLicneKarte(String brojLicneKarte) {
        this.brojLicneKarte = brojLicneKarte;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getOpstina() {
        return opstina;
    }

    public void setOpstina(String opstina) {
        this.opstina = opstina;
    }

    public String getBrojMobilnog() {
        return brojMobilnog;
    }

    public void setBrojMobilnog(String brojMobilnog) {
        this.brojMobilnog = brojMobilnog;
    }

    public Vozilo getVoziloId() {
        return voziloId;
    }

    public void setVoziloId(Vozilo voziloId) {
        this.voziloId = voziloId;
    }

    @XmlTransient
    public List<Vozilo> getVoziloList() {
        return voziloList;
    }

    public void setVoziloList(List<Vozilo> voziloList) {
        this.voziloList = voziloList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (klijentiId != null ? klijentiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klijent)) {
            return false;
        }
        Klijent other = (Klijent) object;
        if ((this.klijentiId == null && other.klijentiId != null) || (this.klijentiId != null && !this.klijentiId.equals(other.klijentiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiteti.Klijent[ klijentiId=" + klijentiId + " ]";
    }
    
}
