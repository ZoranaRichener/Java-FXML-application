package DAOKlase;

import jpacontroleri.TehnickiPregledJpaController;
import entiteti.TehnickiPregled;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TehnickiPregledDAO {

    private final TehnickiPregledJpaController tehnickiPregledController;
    private final EntityManagerFactory emf;

    public TehnickiPregledDAO() {

        emf = Persistence.createEntityManagerFactory("TehnickiPregledPU");
        tehnickiPregledController = new TehnickiPregledJpaController(emf);

    }

    public void addTehnickiPregled(TehnickiPregled tehnickiPregled) throws Exception {
        tehnickiPregledController.create(tehnickiPregled);
    }

    public void editTehnickiPregled(TehnickiPregled tehnickiPregled) throws Exception {
        tehnickiPregledController.edit(tehnickiPregled);
    }

    public void removeTehnickiPregled(int tehnickiPregledID) throws Exception {
        tehnickiPregledController.destroy(tehnickiPregledID);
    }

    public List<TehnickiPregled> getAllTehnickiPregled() {
        return tehnickiPregledController.findTehnickiPregledEntities();
    }

    public TehnickiPregled getTehnickiPregledById(int tehnickiPregledID) {
        return tehnickiPregledController.findTehnickiPregled(tehnickiPregledID);
    }
}
