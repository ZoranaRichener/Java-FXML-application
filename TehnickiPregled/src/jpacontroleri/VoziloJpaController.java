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
import entiteti.Klijent;
import entiteti.TehnickiPregled;
import entiteti.Vozilo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpacontroleri.exceptions.NonexistentEntityException;

/**
 *
 * @author Owner
 */
public class VoziloJpaController implements Serializable {

    public VoziloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vozilo vozilo) {
        if (vozilo.getTehnickiPregledList() == null) {
            vozilo.setTehnickiPregledList(new ArrayList<TehnickiPregled>());
        }
        if (vozilo.getKlijentList() == null) {
            vozilo.setKlijentList(new ArrayList<Klijent>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Klijent klijentiId = vozilo.getKlijentiId();
            if (klijentiId != null) {
                klijentiId = em.getReference(klijentiId.getClass(), klijentiId.getKlijentiId());
                vozilo.setKlijentiId(klijentiId);
            }
            TehnickiPregled tehnickiPregledId = vozilo.getTehnickiPregledId();
            if (tehnickiPregledId != null) {
                tehnickiPregledId = em.getReference(tehnickiPregledId.getClass(), tehnickiPregledId.getTehnickiPregledId());
                vozilo.setTehnickiPregledId(tehnickiPregledId);
            }
            List<TehnickiPregled> attachedTehnickiPregledList = new ArrayList<TehnickiPregled>();
            for (TehnickiPregled tehnickiPregledListTehnickiPregledToAttach : vozilo.getTehnickiPregledList()) {
                tehnickiPregledListTehnickiPregledToAttach = em.getReference(tehnickiPregledListTehnickiPregledToAttach.getClass(), tehnickiPregledListTehnickiPregledToAttach.getTehnickiPregledId());
                attachedTehnickiPregledList.add(tehnickiPregledListTehnickiPregledToAttach);
            }
            vozilo.setTehnickiPregledList(attachedTehnickiPregledList);
            List<Klijent> attachedKlijentList = new ArrayList<Klijent>();
            for (Klijent klijentListKlijentToAttach : vozilo.getKlijentList()) {
                klijentListKlijentToAttach = em.getReference(klijentListKlijentToAttach.getClass(), klijentListKlijentToAttach.getKlijentiId());
                attachedKlijentList.add(klijentListKlijentToAttach);
            }
            vozilo.setKlijentList(attachedKlijentList);
            em.persist(vozilo);
            if (klijentiId != null) {
                Vozilo oldVoziloIdOfKlijentiId = klijentiId.getVoziloId();
                if (oldVoziloIdOfKlijentiId != null) {
                    oldVoziloIdOfKlijentiId.setKlijentiId(null);
                    oldVoziloIdOfKlijentiId = em.merge(oldVoziloIdOfKlijentiId);
                }
                klijentiId.setVoziloId(vozilo);
                klijentiId = em.merge(klijentiId);
            }
            if (tehnickiPregledId != null) {
                Vozilo oldVoziloIdOfTehnickiPregledId = tehnickiPregledId.getVoziloId();
                if (oldVoziloIdOfTehnickiPregledId != null) {
                    oldVoziloIdOfTehnickiPregledId.setTehnickiPregledId(null);
                    oldVoziloIdOfTehnickiPregledId = em.merge(oldVoziloIdOfTehnickiPregledId);
                }
                tehnickiPregledId.setVoziloId(vozilo);
                tehnickiPregledId = em.merge(tehnickiPregledId);
            }
            for (TehnickiPregled tehnickiPregledListTehnickiPregled : vozilo.getTehnickiPregledList()) {
                Vozilo oldVoziloIdOfTehnickiPregledListTehnickiPregled = tehnickiPregledListTehnickiPregled.getVoziloId();
                tehnickiPregledListTehnickiPregled.setVoziloId(vozilo);
                tehnickiPregledListTehnickiPregled = em.merge(tehnickiPregledListTehnickiPregled);
                if (oldVoziloIdOfTehnickiPregledListTehnickiPregled != null) {
                    oldVoziloIdOfTehnickiPregledListTehnickiPregled.getTehnickiPregledList().remove(tehnickiPregledListTehnickiPregled);
                    oldVoziloIdOfTehnickiPregledListTehnickiPregled = em.merge(oldVoziloIdOfTehnickiPregledListTehnickiPregled);
                }
            }
            for (Klijent klijentListKlijent : vozilo.getKlijentList()) {
                Vozilo oldVoziloIdOfKlijentListKlijent = klijentListKlijent.getVoziloId();
                klijentListKlijent.setVoziloId(vozilo);
                klijentListKlijent = em.merge(klijentListKlijent);
                if (oldVoziloIdOfKlijentListKlijent != null) {
                    oldVoziloIdOfKlijentListKlijent.getKlijentList().remove(klijentListKlijent);
                    oldVoziloIdOfKlijentListKlijent = em.merge(oldVoziloIdOfKlijentListKlijent);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vozilo vozilo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vozilo persistentVozilo = em.find(Vozilo.class, vozilo.getVoziloId());
            Klijent klijentiIdOld = persistentVozilo.getKlijentiId();
            Klijent klijentiIdNew = vozilo.getKlijentiId();
            TehnickiPregled tehnickiPregledIdOld = persistentVozilo.getTehnickiPregledId();
            TehnickiPregled tehnickiPregledIdNew = vozilo.getTehnickiPregledId();
            List<TehnickiPregled> tehnickiPregledListOld = persistentVozilo.getTehnickiPregledList();
            List<TehnickiPregled> tehnickiPregledListNew = vozilo.getTehnickiPregledList();
            List<Klijent> klijentListOld = persistentVozilo.getKlijentList();
            List<Klijent> klijentListNew = vozilo.getKlijentList();
            if (klijentiIdNew != null) {
                klijentiIdNew = em.getReference(klijentiIdNew.getClass(), klijentiIdNew.getKlijentiId());
                vozilo.setKlijentiId(klijentiIdNew);
            }
            if (tehnickiPregledIdNew != null) {
                tehnickiPregledIdNew = em.getReference(tehnickiPregledIdNew.getClass(), tehnickiPregledIdNew.getTehnickiPregledId());
                vozilo.setTehnickiPregledId(tehnickiPregledIdNew);
            }
            List<TehnickiPregled> attachedTehnickiPregledListNew = new ArrayList<TehnickiPregled>();
            for (TehnickiPregled tehnickiPregledListNewTehnickiPregledToAttach : tehnickiPregledListNew) {
                tehnickiPregledListNewTehnickiPregledToAttach = em.getReference(tehnickiPregledListNewTehnickiPregledToAttach.getClass(), tehnickiPregledListNewTehnickiPregledToAttach.getTehnickiPregledId());
                attachedTehnickiPregledListNew.add(tehnickiPregledListNewTehnickiPregledToAttach);
            }
            tehnickiPregledListNew = attachedTehnickiPregledListNew;
            vozilo.setTehnickiPregledList(tehnickiPregledListNew);
            List<Klijent> attachedKlijentListNew = new ArrayList<Klijent>();
            for (Klijent klijentListNewKlijentToAttach : klijentListNew) {
                klijentListNewKlijentToAttach = em.getReference(klijentListNewKlijentToAttach.getClass(), klijentListNewKlijentToAttach.getKlijentiId());
                attachedKlijentListNew.add(klijentListNewKlijentToAttach);
            }
            klijentListNew = attachedKlijentListNew;
            vozilo.setKlijentList(klijentListNew);
            vozilo = em.merge(vozilo);
            if (klijentiIdOld != null && !klijentiIdOld.equals(klijentiIdNew)) {
                klijentiIdOld.setVoziloId(null);
                klijentiIdOld = em.merge(klijentiIdOld);
            }
            if (klijentiIdNew != null && !klijentiIdNew.equals(klijentiIdOld)) {
                Vozilo oldVoziloIdOfKlijentiId = klijentiIdNew.getVoziloId();
                if (oldVoziloIdOfKlijentiId != null) {
                    oldVoziloIdOfKlijentiId.setKlijentiId(null);
                    oldVoziloIdOfKlijentiId = em.merge(oldVoziloIdOfKlijentiId);
                }
                klijentiIdNew.setVoziloId(vozilo);
                klijentiIdNew = em.merge(klijentiIdNew);
            }
            if (tehnickiPregledIdOld != null && !tehnickiPregledIdOld.equals(tehnickiPregledIdNew)) {
                tehnickiPregledIdOld.setVoziloId(null);
                tehnickiPregledIdOld = em.merge(tehnickiPregledIdOld);
            }
            if (tehnickiPregledIdNew != null && !tehnickiPregledIdNew.equals(tehnickiPregledIdOld)) {
                Vozilo oldVoziloIdOfTehnickiPregledId = tehnickiPregledIdNew.getVoziloId();
                if (oldVoziloIdOfTehnickiPregledId != null) {
                    oldVoziloIdOfTehnickiPregledId.setTehnickiPregledId(null);
                    oldVoziloIdOfTehnickiPregledId = em.merge(oldVoziloIdOfTehnickiPregledId);
                }
                tehnickiPregledIdNew.setVoziloId(vozilo);
                tehnickiPregledIdNew = em.merge(tehnickiPregledIdNew);
            }
            for (TehnickiPregled tehnickiPregledListOldTehnickiPregled : tehnickiPregledListOld) {
                if (!tehnickiPregledListNew.contains(tehnickiPregledListOldTehnickiPregled)) {
                    tehnickiPregledListOldTehnickiPregled.setVoziloId(null);
                    tehnickiPregledListOldTehnickiPregled = em.merge(tehnickiPregledListOldTehnickiPregled);
                }
            }
            for (TehnickiPregled tehnickiPregledListNewTehnickiPregled : tehnickiPregledListNew) {
                if (!tehnickiPregledListOld.contains(tehnickiPregledListNewTehnickiPregled)) {
                    Vozilo oldVoziloIdOfTehnickiPregledListNewTehnickiPregled = tehnickiPregledListNewTehnickiPregled.getVoziloId();
                    tehnickiPregledListNewTehnickiPregled.setVoziloId(vozilo);
                    tehnickiPregledListNewTehnickiPregled = em.merge(tehnickiPregledListNewTehnickiPregled);
                    if (oldVoziloIdOfTehnickiPregledListNewTehnickiPregled != null && !oldVoziloIdOfTehnickiPregledListNewTehnickiPregled.equals(vozilo)) {
                        oldVoziloIdOfTehnickiPregledListNewTehnickiPregled.getTehnickiPregledList().remove(tehnickiPregledListNewTehnickiPregled);
                        oldVoziloIdOfTehnickiPregledListNewTehnickiPregled = em.merge(oldVoziloIdOfTehnickiPregledListNewTehnickiPregled);
                    }
                }
            }
            for (Klijent klijentListOldKlijent : klijentListOld) {
                if (!klijentListNew.contains(klijentListOldKlijent)) {
                    klijentListOldKlijent.setVoziloId(null);
                    klijentListOldKlijent = em.merge(klijentListOldKlijent);
                }
            }
            for (Klijent klijentListNewKlijent : klijentListNew) {
                if (!klijentListOld.contains(klijentListNewKlijent)) {
                    Vozilo oldVoziloIdOfKlijentListNewKlijent = klijentListNewKlijent.getVoziloId();
                    klijentListNewKlijent.setVoziloId(vozilo);
                    klijentListNewKlijent = em.merge(klijentListNewKlijent);
                    if (oldVoziloIdOfKlijentListNewKlijent != null && !oldVoziloIdOfKlijentListNewKlijent.equals(vozilo)) {
                        oldVoziloIdOfKlijentListNewKlijent.getKlijentList().remove(klijentListNewKlijent);
                        oldVoziloIdOfKlijentListNewKlijent = em.merge(oldVoziloIdOfKlijentListNewKlijent);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vozilo.getVoziloId();
                if (findVozilo(id) == null) {
                    throw new NonexistentEntityException("The vozilo with id " + id + " no longer exists.");
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
            Vozilo vozilo;
            try {
                vozilo = em.getReference(Vozilo.class, id);
                vozilo.getVoziloId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vozilo with id " + id + " no longer exists.", enfe);
            }
            Klijent klijentiId = vozilo.getKlijentiId();
            if (klijentiId != null) {
                klijentiId.setVoziloId(null);
                klijentiId = em.merge(klijentiId);
            }
            TehnickiPregled tehnickiPregledId = vozilo.getTehnickiPregledId();
            if (tehnickiPregledId != null) {
                tehnickiPregledId.setVoziloId(null);
                tehnickiPregledId = em.merge(tehnickiPregledId);
            }
            List<TehnickiPregled> tehnickiPregledList = vozilo.getTehnickiPregledList();
            for (TehnickiPregled tehnickiPregledListTehnickiPregled : tehnickiPregledList) {
                tehnickiPregledListTehnickiPregled.setVoziloId(null);
                tehnickiPregledListTehnickiPregled = em.merge(tehnickiPregledListTehnickiPregled);
            }
            List<Klijent> klijentList = vozilo.getKlijentList();
            for (Klijent klijentListKlijent : klijentList) {
                klijentListKlijent.setVoziloId(null);
                klijentListKlijent = em.merge(klijentListKlijent);
            }
            em.remove(vozilo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vozilo> findVoziloEntities() {
        return findVoziloEntities(true, -1, -1);
    }

    public List<Vozilo> findVoziloEntities(int maxResults, int firstResult) {
        return findVoziloEntities(false, maxResults, firstResult);
    }

    private List<Vozilo> findVoziloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vozilo.class));
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

    public Vozilo findVozilo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vozilo.class, id);
        } finally {
            em.close();
        }
    }

    public int getVoziloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vozilo> rt = cq.from(Vozilo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
