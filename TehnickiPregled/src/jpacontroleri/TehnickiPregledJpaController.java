/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontroleri;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entiteti.Vozilo;
import entiteti.Galerija;
import entiteti.TehnickiPregled;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpacontroleri.exceptions.NonexistentEntityException;
import jpacontroleri.exceptions.PreexistingEntityException;

/**
 *
 * @author Owner
 */
public class TehnickiPregledJpaController implements Serializable {

    public TehnickiPregledJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TehnickiPregled tehnickiPregled) throws PreexistingEntityException, Exception {
        if (tehnickiPregled.getGalerijaList() == null) {
            tehnickiPregled.setGalerijaList(new ArrayList<Galerija>());
        }
        if (tehnickiPregled.getVoziloList() == null) {
            tehnickiPregled.setVoziloList(new ArrayList<Vozilo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vozilo voziloId = tehnickiPregled.getVoziloId();
            if (voziloId != null) {
                voziloId = em.getReference(voziloId.getClass(), voziloId.getVoziloId());
                tehnickiPregled.setVoziloId(voziloId);
            }
            Galerija galerijaId = tehnickiPregled.getGalerijaId();
            if (galerijaId != null) {
                galerijaId = em.getReference(galerijaId.getClass(), galerijaId.getGalerijaId());
                tehnickiPregled.setGalerijaId(galerijaId);
            }
            List<Galerija> attachedGalerijaList = new ArrayList<Galerija>();
            for (Galerija galerijaListGalerijaToAttach : tehnickiPregled.getGalerijaList()) {
                galerijaListGalerijaToAttach = em.getReference(galerijaListGalerijaToAttach.getClass(), galerijaListGalerijaToAttach.getGalerijaId());
                attachedGalerijaList.add(galerijaListGalerijaToAttach);
            }
            tehnickiPregled.setGalerijaList(attachedGalerijaList);
            List<Vozilo> attachedVoziloList = new ArrayList<Vozilo>();
            for (Vozilo voziloListVoziloToAttach : tehnickiPregled.getVoziloList()) {
                voziloListVoziloToAttach = em.getReference(voziloListVoziloToAttach.getClass(), voziloListVoziloToAttach.getVoziloId());
                attachedVoziloList.add(voziloListVoziloToAttach);
            }
            tehnickiPregled.setVoziloList(attachedVoziloList);
            em.persist(tehnickiPregled);
            if (voziloId != null) {
                voziloId.getTehnickiPregledList().add(tehnickiPregled);
                voziloId = em.merge(voziloId);
            }
            if (galerijaId != null) {
                TehnickiPregled oldTehnickiPregledIdOfGalerijaId = galerijaId.getTehnickiPregledId();
                if (oldTehnickiPregledIdOfGalerijaId != null) {
                    oldTehnickiPregledIdOfGalerijaId.setGalerijaId(null);
                    oldTehnickiPregledIdOfGalerijaId = em.merge(oldTehnickiPregledIdOfGalerijaId);
                }
                galerijaId.setTehnickiPregledId(tehnickiPregled);
                galerijaId = em.merge(galerijaId);
            }
            for (Galerija galerijaListGalerija : tehnickiPregled.getGalerijaList()) {
                TehnickiPregled oldTehnickiPregledIdOfGalerijaListGalerija = galerijaListGalerija.getTehnickiPregledId();
                galerijaListGalerija.setTehnickiPregledId(tehnickiPregled);
                galerijaListGalerija = em.merge(galerijaListGalerija);
                if (oldTehnickiPregledIdOfGalerijaListGalerija != null) {
                    oldTehnickiPregledIdOfGalerijaListGalerija.getGalerijaList().remove(galerijaListGalerija);
                    oldTehnickiPregledIdOfGalerijaListGalerija = em.merge(oldTehnickiPregledIdOfGalerijaListGalerija);
                }
            }
            for (Vozilo voziloListVozilo : tehnickiPregled.getVoziloList()) {
                TehnickiPregled oldTehnickiPregledIdOfVoziloListVozilo = voziloListVozilo.getTehnickiPregledId();
                voziloListVozilo.setTehnickiPregledId(tehnickiPregled);
                voziloListVozilo = em.merge(voziloListVozilo);
                if (oldTehnickiPregledIdOfVoziloListVozilo != null) {
                    oldTehnickiPregledIdOfVoziloListVozilo.getVoziloList().remove(voziloListVozilo);
                    oldTehnickiPregledIdOfVoziloListVozilo = em.merge(oldTehnickiPregledIdOfVoziloListVozilo);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTehnickiPregled(tehnickiPregled.getTehnickiPregledId()) != null) {
                throw new PreexistingEntityException("TehnickiPregled " + tehnickiPregled + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TehnickiPregled tehnickiPregled) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TehnickiPregled persistentTehnickiPregled = em.find(TehnickiPregled.class, tehnickiPregled.getTehnickiPregledId());
            Vozilo voziloIdOld = persistentTehnickiPregled.getVoziloId();
            Vozilo voziloIdNew = tehnickiPregled.getVoziloId();
            Galerija galerijaIdOld = persistentTehnickiPregled.getGalerijaId();
            Galerija galerijaIdNew = tehnickiPregled.getGalerijaId();
            List<Galerija> galerijaListOld = persistentTehnickiPregled.getGalerijaList();
            List<Galerija> galerijaListNew = tehnickiPregled.getGalerijaList();
            List<Vozilo> voziloListOld = persistentTehnickiPregled.getVoziloList();
            List<Vozilo> voziloListNew = tehnickiPregled.getVoziloList();
            if (voziloIdNew != null) {
                voziloIdNew = em.getReference(voziloIdNew.getClass(), voziloIdNew.getVoziloId());
                tehnickiPregled.setVoziloId(voziloIdNew);
            }
            if (galerijaIdNew != null) {
                galerijaIdNew = em.getReference(galerijaIdNew.getClass(), galerijaIdNew.getGalerijaId());
                tehnickiPregled.setGalerijaId(galerijaIdNew);
            }
            List<Galerija> attachedGalerijaListNew = new ArrayList<Galerija>();
            for (Galerija galerijaListNewGalerijaToAttach : galerijaListNew) {
                galerijaListNewGalerijaToAttach = em.getReference(galerijaListNewGalerijaToAttach.getClass(), galerijaListNewGalerijaToAttach.getGalerijaId());
                attachedGalerijaListNew.add(galerijaListNewGalerijaToAttach);
            }
            galerijaListNew = attachedGalerijaListNew;
            tehnickiPregled.setGalerijaList(galerijaListNew);
            List<Vozilo> attachedVoziloListNew = new ArrayList<Vozilo>();
            for (Vozilo voziloListNewVoziloToAttach : voziloListNew) {
                voziloListNewVoziloToAttach = em.getReference(voziloListNewVoziloToAttach.getClass(), voziloListNewVoziloToAttach.getVoziloId());
                attachedVoziloListNew.add(voziloListNewVoziloToAttach);
            }
            voziloListNew = attachedVoziloListNew;
            tehnickiPregled.setVoziloList(voziloListNew);
            tehnickiPregled = em.merge(tehnickiPregled);
            if (voziloIdOld != null && !voziloIdOld.equals(voziloIdNew)) {
                voziloIdOld.getTehnickiPregledList().remove(tehnickiPregled);
                voziloIdOld = em.merge(voziloIdOld);
            }
            if (voziloIdNew != null && !voziloIdNew.equals(voziloIdOld)) {
                voziloIdNew.getTehnickiPregledList().add(tehnickiPregled);
                voziloIdNew = em.merge(voziloIdNew);
            }
            if (galerijaIdOld != null && !galerijaIdOld.equals(galerijaIdNew)) {
                galerijaIdOld.setTehnickiPregledId(null);
                galerijaIdOld = em.merge(galerijaIdOld);
            }
            if (galerijaIdNew != null && !galerijaIdNew.equals(galerijaIdOld)) {
                TehnickiPregled oldTehnickiPregledIdOfGalerijaId = galerijaIdNew.getTehnickiPregledId();
                if (oldTehnickiPregledIdOfGalerijaId != null) {
                    oldTehnickiPregledIdOfGalerijaId.setGalerijaId(null);
                    oldTehnickiPregledIdOfGalerijaId = em.merge(oldTehnickiPregledIdOfGalerijaId);
                }
                galerijaIdNew.setTehnickiPregledId(tehnickiPregled);
                galerijaIdNew = em.merge(galerijaIdNew);
            }
            for (Galerija galerijaListOldGalerija : galerijaListOld) {
                if (!galerijaListNew.contains(galerijaListOldGalerija)) {
                    galerijaListOldGalerija.setTehnickiPregledId(null);
                    galerijaListOldGalerija = em.merge(galerijaListOldGalerija);
                }
            }
            for (Galerija galerijaListNewGalerija : galerijaListNew) {
                if (!galerijaListOld.contains(galerijaListNewGalerija)) {
                    TehnickiPregled oldTehnickiPregledIdOfGalerijaListNewGalerija = galerijaListNewGalerija.getTehnickiPregledId();
                    galerijaListNewGalerija.setTehnickiPregledId(tehnickiPregled);
                    galerijaListNewGalerija = em.merge(galerijaListNewGalerija);
                    if (oldTehnickiPregledIdOfGalerijaListNewGalerija != null && !oldTehnickiPregledIdOfGalerijaListNewGalerija.equals(tehnickiPregled)) {
                        oldTehnickiPregledIdOfGalerijaListNewGalerija.getGalerijaList().remove(galerijaListNewGalerija);
                        oldTehnickiPregledIdOfGalerijaListNewGalerija = em.merge(oldTehnickiPregledIdOfGalerijaListNewGalerija);
                    }
                }
            }
            for (Vozilo voziloListOldVozilo : voziloListOld) {
                if (!voziloListNew.contains(voziloListOldVozilo)) {
                    voziloListOldVozilo.setTehnickiPregledId(null);
                    voziloListOldVozilo = em.merge(voziloListOldVozilo);
                }
            }
            for (Vozilo voziloListNewVozilo : voziloListNew) {
                if (!voziloListOld.contains(voziloListNewVozilo)) {
                    TehnickiPregled oldTehnickiPregledIdOfVoziloListNewVozilo = voziloListNewVozilo.getTehnickiPregledId();
                    voziloListNewVozilo.setTehnickiPregledId(tehnickiPregled);
                    voziloListNewVozilo = em.merge(voziloListNewVozilo);
                    if (oldTehnickiPregledIdOfVoziloListNewVozilo != null && !oldTehnickiPregledIdOfVoziloListNewVozilo.equals(tehnickiPregled)) {
                        oldTehnickiPregledIdOfVoziloListNewVozilo.getVoziloList().remove(voziloListNewVozilo);
                        oldTehnickiPregledIdOfVoziloListNewVozilo = em.merge(oldTehnickiPregledIdOfVoziloListNewVozilo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tehnickiPregled.getTehnickiPregledId();
                if (findTehnickiPregled(id) == null) {
                    throw new NonexistentEntityException("The tehnickiPregled with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TehnickiPregled tehnickiPregled;
            try {
                tehnickiPregled = em.getReference(TehnickiPregled.class, id);
                tehnickiPregled.getTehnickiPregledId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tehnickiPregled with id " + id + " no longer exists.", enfe);
            }
            Vozilo voziloId = tehnickiPregled.getVoziloId();
            if (voziloId != null) {
                voziloId.getTehnickiPregledList().remove(tehnickiPregled);
                voziloId = em.merge(voziloId);
            }
            Galerija galerijaId = tehnickiPregled.getGalerijaId();
            if (galerijaId != null) {
                galerijaId.setTehnickiPregledId(null);
                galerijaId = em.merge(galerijaId);
            }
            List<Galerija> galerijaList = tehnickiPregled.getGalerijaList();
            for (Galerija galerijaListGalerija : galerijaList) {
                galerijaListGalerija.setTehnickiPregledId(null);
                galerijaListGalerija = em.merge(galerijaListGalerija);
            }
            List<Vozilo> voziloList = tehnickiPregled.getVoziloList();
            for (Vozilo voziloListVozilo : voziloList) {
                voziloListVozilo.setTehnickiPregledId(null);
                voziloListVozilo = em.merge(voziloListVozilo);
            }
            em.remove(tehnickiPregled);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TehnickiPregled> findTehnickiPregledEntities() {
        return findTehnickiPregledEntities(true, -1, -1);
    }

    public List<TehnickiPregled> findTehnickiPregledEntities(int maxResults, int firstResult) {
        return findTehnickiPregledEntities(false, maxResults, firstResult);
    }

    private List<TehnickiPregled> findTehnickiPregledEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TehnickiPregled.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TehnickiPregled findTehnickiPregled(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TehnickiPregled.class, id);
        } finally {
            em.close();
        }
    }

    public int getTehnickiPregledCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TehnickiPregled> rt = cq.from(TehnickiPregled.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
