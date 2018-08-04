package DAOKlase;

import jpacontroleri.VoziloJpaController;
import entiteti.Vozilo;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VoziloDAO {

    private final VoziloJpaController voziloController;
    private final EntityManagerFactory emf;

    public VoziloDAO() {

        emf = Persistence.createEntityManagerFactory("TehnickiPregledPU");
        voziloController = new VoziloJpaController(emf);

    }

    public void addVozilo(Vozilo vozilo) throws Exception {
        voziloController.create(vozilo);
    }

    public void editVozilo(Vozilo vozilo) throws Exception {
        voziloController.edit(vozilo);
    }

    public void removeVozilo(int voziloID) throws Exception {
        voziloController.destroy(voziloID);
    }

    public List<Vozilo> getAllVozilo() {
        return voziloController.findVoziloEntities();
    }

    public Vozilo getVoziloById(int voziloID) {
        return voziloController.findVozilo(voziloID);
    }
}
