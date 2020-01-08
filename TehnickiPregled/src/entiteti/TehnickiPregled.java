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
@Table(name = "tehnicki_pregled")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TehnickiPregled.findAll", query = "SELECT t FROM TehnickiPregled t")
    , @NamedQuery(name = "TehnickiPregled.findByTehnickiPregledId", query = "SELECT t FROM TehnickiPregled t WHERE t.tehnickiPregledId = :tehnickiPregledId")
    , @NamedQuery(name = "TehnickiPregled.findByNazivFirme", query = "SELECT t FROM TehnickiPregled t WHERE t.nazivFirme = :nazivFirme")
    , @NamedQuery(name = "TehnickiPregled.findBySedisteFirme", query = "SELECT t FROM TehnickiPregled t WHERE t.sedisteFirme = :sedisteFirme")
    , @NamedQuery(name = "TehnickiPregled.findBySifraTehnickogPregleda", query = "SELECT t FROM TehnickiPregled t WHERE t.sifraTehnickogPregleda = :sifraTehnickogPregleda")
    , @NamedQuery(name = "TehnickiPregled.findByKontrolor1", query = "SELECT t FROM TehnickiPregled t WHERE t.kontrolor1 = :kontrolor1")
    , @NamedQuery(name = "TehnickiPregled.findByKontrolor2", query = "SELECT t FROM TehnickiPregled t WHERE t.kontrolor2 = :kontrolor2")
    , @NamedQuery(name = "TehnickiPregled.findByUsloviZaVrsenjePregleda", query = "SELECT t FROM TehnickiPregled t WHERE t.usloviZaVrsenjePregleda = :usloviZaVrsenjePregleda")
    , @NamedQuery(name = "TehnickiPregled.findByMestoVrsenjaPregleda", query = "SELECT t FROM TehnickiPregled t WHERE t.mestoVrsenjaPregleda = :mestoVrsenjaPregleda")
    , @NamedQuery(name = "TehnickiPregled.findByVrstaPregleda", query = "SELECT t FROM TehnickiPregled t WHERE t.vrstaPregleda = :vrstaPregleda")
    , @NamedQuery(name = "TehnickiPregled.findByRedniBroj", query = "SELECT t FROM TehnickiPregled t WHERE t.redniBroj = :redniBroj")
    , @NamedQuery(name = "TehnickiPregled.findByIdBroj", query = "SELECT t FROM TehnickiPregled t WHERE t.idBroj = :idBroj")
    , @NamedQuery(name = "TehnickiPregled.findByVrstaVozila", query = "SELECT t FROM TehnickiPregled t WHERE t.vrstaVozila = :vrstaVozila")
    , @NamedQuery(name = "TehnickiPregled.findByIspravnostVozila", query = "SELECT t FROM TehnickiPregled t WHERE t.ispravnostVozila = :ispravnostVozila")
    , @NamedQuery(name = "TehnickiPregled.findByKontrolniBroj", query = "SELECT t FROM TehnickiPregled t WHERE t.kontrolniBroj = :kontrolniBroj")
    , @NamedQuery(name = "TehnickiPregled.findByDatumPregleda", query = "SELECT t FROM TehnickiPregled t WHERE t.datumPregleda = :datumPregleda")
    , @NamedQuery(name = "TehnickiPregled.findByPocetakPregleda", query = "SELECT t FROM TehnickiPregled t WHERE t.pocetakPregleda = :pocetakPregleda")
    , @NamedQuery(name = "TehnickiPregled.findByZavrsetakPregleda", query = "SELECT t FROM TehnickiPregled t WHERE t.zavrsetakPregleda = :zavrsetakPregleda")
    , @NamedQuery(name = "TehnickiPregled.findByPodaciONeispravnosti", query = "SELECT t FROM TehnickiPregled t WHERE t.podaciONeispravnosti = :podaciONeispravnosti")})
public class TehnickiPregled implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TEHNICKI_PREGLED_ID")
    private Integer tehnickiPregledId;
    @Basic(optional = false)
    @Column(name = "NAZIV_FIRME")
    private String nazivFirme;
    @Basic(optional = false)
    @Column(name = "SEDISTE_FIRME")
    private String sedisteFirme;
    @Basic(optional = false)
    @Column(name = "SIFRA_TEHNICKOG_PREGLEDA")
    private String sifraTehnickogPregleda;
    @Basic(optional = false)
    @Column(name = "KONTROLOR_1")
    private String kontrolor1;
    @Basic(optional = false)
    @Column(name = "KONTROLOR_2")
    private String kontrolor2;
    @Basic(optional = false)
    @Column(name = "USLOVI_ZA_VRSENJE_PREGLEDA")
    private String usloviZaVrsenjePregleda;
    @Basic(optional = false)
    @Column(name = "MESTO_VRSENJA_PREGLEDA")
    private String mestoVrsenjaPregleda;
    @Basic(optional = false)
    @Column(name = "VRSTA_PREGLEDA")
    private String vrstaPregleda;
    @Basic(optional = false)
    @Column(name = "REDNI_BROJ")
    private String redniBroj;
    @Basic(optional = false)
    @Column(name = "ID_BROJ")
    private String idBroj;
    @Basic(optional = false)
    @Column(name = "VRSTA_VOZILA")
    private String vrstaVozila;
    @Basic(optional = false)
    @Column(name = "ISPRAVNOST_VOZILA")
    private String ispravnostVozila;
    @Column(name = "KONTROLNI_BROJ")
    private String kontrolniBroj;
    @Basic(optional = false)
    @Column(name = "DATUM_PREGLEDA")
    @Temporal(TemporalType.DATE)
    private Date datumPregleda;
    @Basic(optional = false)
    @Column(name = "POCETAK_PREGLEDA")
    private String pocetakPregleda;
    @Basic(optional = false)
    @Column(name = "ZAVRSETAK_PREGLEDA")
    private String zavrsetakPregleda;
    @Column(name = "PODACI_O_NEISPRAVNOSTI")
    private String podaciONeispravnosti;
    @OneToMany(mappedBy = "tehnickiPregledId")
    private List<Galerija> galerijaList;
    @JoinColumn(name = "VOZILO_ID", referencedColumnName = "VOZILO_ID")
    @ManyToOne
    private Vozilo voziloId;
    @JoinColumn(name = "GALERIJA_ID", referencedColumnName = "GALERIJA_ID")
    @ManyToOne
    private Galerija galerijaId;
    @OneToMany(mappedBy = "tehnickiPregledId")
    private List<Vozilo> voziloList;

    public TehnickiPregled() {
    }

    public TehnickiPregled(Integer tehnickiPregledId) {
        this.tehnickiPregledId = tehnickiPregledId;
    }

    public TehnickiPregled(Integer tehnickiPregledId, String nazivFirme, String sedisteFirme, String sifraTehnickogPregleda, String kontrolor1, String kontrolor2, String usloviZaVrsenjePregleda, String mestoVrsenjaPregleda, String vrstaPregleda, String redniBroj, String idBroj, String vrstaVozila, String ispravnostVozila, Date datumPregleda, String pocetakPregleda, String zavrsetakPregleda) {
        this.tehnickiPregledId = tehnickiPregledId;
        this.nazivFirme = nazivFirme;
        this.sedisteFirme = sedisteFirme;
        this.sifraTehnickogPregleda = sifraTehnickogPregleda;
        this.kontrolor1 = kontrolor1;
        this.kontrolor2 = kontrolor2;
        this.usloviZaVrsenjePregleda = usloviZaVrsenjePregleda;
        this.mestoVrsenjaPregleda = mestoVrsenjaPregleda;
        this.vrstaPregleda = vrstaPregleda;
        this.redniBroj = redniBroj;
        this.idBroj = idBroj;
        this.vrstaVozila = vrstaVozila;
        this.ispravnostVozila = ispravnostVozila;
        this.datumPregleda = datumPregleda;
        this.pocetakPregleda = pocetakPregleda;
        this.zavrsetakPregleda = zavrsetakPregleda;
    }

    public Integer getTehnickiPregledId() {
        return tehnickiPregledId;
    }

    public void setTehnickiPregledId(Integer tehnickiPregledId) {
        this.tehnickiPregledId = tehnickiPregledId;
    }

    public String getNazivFirme() {
        return nazivFirme;
    }

    public void setNazivFirme(String nazivFirme) {
        this.nazivFirme = nazivFirme;
    }

    public String getSedisteFirme() {
        return sedisteFirme;
    }

    public void setSedisteFirme(String sedisteFirme) {
        this.sedisteFirme = sedisteFirme;
    }

    public String getSifraTehnickogPregleda() {
        return sifraTehnickogPregleda;
    }

    public void setSifraTehnickogPregleda(String sifraTehnickogPregleda) {
        this.sifraTehnickogPregleda = sifraTehnickogPregleda;
    }

    public String getKontrolor1() {
        return kontrolor1;
    }

    public void setKontrolor1(String kontrolor1) {
        this.kontrolor1 = kontrolor1;
    }

    public String getKontrolor2() {
        return kontrolor2;
    }

    public void setKontrolor2(String kontrolor2) {
        this.kontrolor2 = kontrolor2;
    }

    public String getUsloviZaVrsenjePregleda() {
        return usloviZaVrsenjePregleda;
    }

    public void setUsloviZaVrsenjePregleda(String usloviZaVrsenjePregleda) {
        this.usloviZaVrsenjePregleda = usloviZaVrsenjePregleda;
    }

    public String getMestoVrsenjaPregleda() {
        return mestoVrsenjaPregleda;
    }

    public void setMestoVrsenjaPregleda(String mestoVrsenjaPregleda) {
        this.mestoVrsenjaPregleda = mestoVrsenjaPregleda;
    }

    public String getVrstaPregleda() {
        return vrstaPregleda;
    }

    public void setVrstaPregleda(String vrstaPregleda) {
        this.vrstaPregleda = vrstaPregleda;
    }

    public String getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(String redniBroj) {
        this.redniBroj = redniBroj;
    }

    public String getIdBroj() {
        return idBroj;
    }

    public void setIdBroj(String idBroj) {
        this.idBroj = idBroj;
    }

    public String getVrstaVozila() {
        return vrstaVozila;
    }

    public void setVrstaVozila(String vrstaVozila) {
        this.vrstaVozila = vrstaVozila;
    }

    public String getIspravnostVozila() {
        return ispravnostVozila;
    }

    public void setIspravnostVozila(String ispravnostVozila) {
        this.ispravnostVozila = ispravnostVozila;
    }

    public String getKontrolniBroj() {
        return kontrolniBroj;
    }

    public void setKontrolniBroj(String kontrolniBroj) {
        this.kontrolniBroj = kontrolniBroj;
    }

    public Date getDatumPregleda() {
        return datumPregleda;
    }

    public void setDatumPregleda(Date datumPregleda) {
        this.datumPregleda = datumPregleda;
    }

    public String getPocetakPregleda() {
        return pocetakPregleda;
    }

    public void setPocetakPregleda(String pocetakPregleda) {
        this.pocetakPregleda = pocetakPregleda;
    }

    public String getZavrsetakPregleda() {
        return zavrsetakPregleda;
    }

    public void setZavrsetakPregleda(String zavrsetakPregleda) {
        this.zavrsetakPregleda = zavrsetakPregleda;
    }

    public String getPodaciONeispravnosti() {
        return podaciONeispravnosti;
    }

    public void setPodaciONeispravnosti(String podaciONeispravnosti) {
        this.podaciONeispravnosti = podaciONeispravnosti;
    }

    @XmlTransient
    public List<Galerija> getGalerijaList() {
        return galerijaList;
    }

    public void setGalerijaList(List<Galerija> galerijaList) {
        this.galerijaList = galerijaList;
    }

    public Vozilo getVoziloId() {
        return voziloId;
    }

    public void setVoziloId(Vozilo voziloId) {
        this.voziloId = voziloId;
    }

    public Galerija getGalerijaId() {
        return galerijaId;
    }

    public void setGalerijaId(Galerija galerijaId) {
        this.galerijaId = galerijaId;
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
        hash += (tehnickiPregledId != null ? tehnickiPregledId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TehnickiPregled)) {
            return false;
        }
        TehnickiPregled other = (TehnickiPregled) object;
        if ((this.tehnickiPregledId == null && other.tehnickiPregledId != null) || (this.tehnickiPregledId != null && !this.tehnickiPregledId.equals(other.tehnickiPregledId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiteti.TehnickiPregled[ tehnickiPregledId=" + tehnickiPregledId + " ]";
    }
    
}
