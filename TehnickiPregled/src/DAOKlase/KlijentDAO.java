package DAOKlase;

import jpacontroleri.KlijentJpaController;
import entiteti.Klijent;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class KlijentDAO {

    private final KlijentJpaController klijentController;
    private final EntityManagerFactory emf;

    public KlijentDAO() {

        emf = Persistence.createEntityManagerFactory("TehnickiPregledPU");
        klijentController = new KlijentJpaController(emf);

    }

    public void addKlijent(Klijent klijent) throws Exception {
        klijentController.create(klijent);
    }

    public void editGalerija(Klijent klijent) throws Exception {
        klijentController.edit(klijent);
    }

    public void removeKlijent(int klijentID) throws Exception {
        klijentController.destroy(klijentID);
    }

    public List<Klijent> getAllKlijent() {
        return klijentController.findKlijentEntities();
    }

    public Klijent getKlijentById(int klijentID) {
        return klijentController.findKlijent(klijentID);
    }
}
