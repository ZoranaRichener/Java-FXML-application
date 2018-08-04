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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Owner
 */
@Entity
@Table(name = "galerija")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Galerija.findAll", query = "SELECT g FROM Galerija g")
    , @NamedQuery(name = "Galerija.findByGalerijaId", query = "SELECT g FROM Galerija g WHERE g.galerijaId = :galerijaId")})
public class Galerija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "GALERIJA_ID")
    private Integer galerijaId;
    @Basic(optional = false)
    @Lob
    @Column(name = "SLIKA")
    private byte[] slika;
    @JoinColumn(name = "TEHNICKI_PREGLED_ID", referencedColumnName = "TEHNICKI_PREGLED_ID")
    @ManyToOne
    private TehnickiPregled tehnickiPregledId;
    @OneToMany(mappedBy = "galerijaId")
    private List<TehnickiPregled> tehnickiPregledList;

    public Galerija() {
    }

    public Galerija(Integer galerijaId) {
        this.galerijaId = galerijaId;
    }

    public Galerija(Integer galerijaId, byte[] slika) {
        this.galerijaId = galerijaId;
        this.slika = slika;
    }

    public Integer getGalerijaId() {
        return galerijaId;
    }

    public void setGalerijaId(Integer galerijaId) {
        this.galerijaId = galerijaId;
    }

    public byte[] getSlika() {
        return slika;
    }

    public void setSlika(byte[] slika) {
        this.slika = slika;
    }

    public TehnickiPregled getTehnickiPregledId() {
        return tehnickiPregledId;
    }

    public void setTehnickiPregledId(TehnickiPregled tehnickiPregledId) {
        this.tehnickiPregledId = tehnickiPregledId;
    }

    @XmlTransient
    public List<TehnickiPregled> getTehnickiPregledList() {
        return tehnickiPregledList;
    }

    public void setTehnickiPregledList(List<TehnickiPregled> tehnickiPregledList) {
        this.tehnickiPregledList = tehnickiPregledList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (galerijaId != null ? galerijaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Galerija)) {
            return false;
        }
        Galerija other = (Galerija) object;
        if ((this.galerijaId == null && other.galerijaId != null) || (this.galerijaId != null && !this.galerijaId.equals(other.galerijaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entiteti.Galerija[ galerijaId=" + galerijaId + " ]";
    }
    
}
