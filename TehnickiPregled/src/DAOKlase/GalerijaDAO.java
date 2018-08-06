package DAOKlase;

import jpacontroleri.GalerijaJpaController;
import entiteti.Galerija;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GalerijaDAO {

    private final GalerijaJpaController galerijaController;
    private final EntityManagerFactory emf;

    public GalerijaDAO() {

        emf = Persistence.createEntityManagerFactory("TehnickiPregledPU");
        galerijaController = new GalerijaJpaController(emf);

    }

    public void addGalerija(Galerija galerija) throws Exception {
        galerijaController.create(galerija);
    }

    public void editGalerija(Galerija galerija) throws Exception {
        galerijaController.edit(galerija);
    }

    public void removeGalerija(int galerijaID) throws Exception {
        galerijaController.destroy(galerijaID);
    }

    public List<Galerija> getAllGalerija() {
        return galerijaController.findGalerijaEntities();
    }

    public Galerija getGalerijaById(int galerijaID) {
        return galerijaController.findGalerija(galerijaID);
    }
    
    public int galerijaCount () {
        
        return galerijaController.getGalerijaCount();
    }
    
}
