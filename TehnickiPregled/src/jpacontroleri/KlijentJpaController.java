/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontroleri;

import entiteti.Klijent;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class KlijentJpaController implements Serializable {

    public KlijentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Klijent klijent) {
        if (klijent.getVoziloList() == null) {
            klijent.setVoziloList(new ArrayList<Vozilo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vozilo voziloId = klijent.getVoziloId();
            if (voziloId != null) {
                voziloId = em.getReference(voziloId.getClass(), voziloId.getVoziloId());
                klijent.setVoziloId(voziloId);
            }
            List<Vozilo> attachedVoziloList = new ArrayList<Vozilo>();
            for (Vozilo voziloListVoziloToAttach : klijent.getVoziloList()) {
                voziloListVoziloToAttach = em.getReference(voziloListVoziloToAttach.getClass(), voziloListVoziloToAttach.getVoziloId());
                attachedVoziloList.add(voziloListVoziloToAttach);
            }
            klijent.setVoziloList(attachedVoziloList);
            em.persist(klijent);
            if (voziloId != null) {
                voziloId.getKlijentList().add(klijent);
                voziloId = em.merge(voziloId);
            }
            for (Vozilo voziloListVozilo : klijent.getVoziloList()) {
                Klijent oldKlijentiIdOfVoziloListVozilo = voziloListVozilo.getKlijentiId();
                voziloListVozilo.setKlijentiId(klijent);
                voziloListVozilo = em.merge(voziloListVozilo);
                if (oldKlijentiIdOfVoziloListVozilo != null) {
                    oldKlijentiIdOfVoziloListVozilo.getVoziloList().remove(voziloListVozilo);
                    oldKlijentiIdOfVoziloListVozilo = em.merge(oldKlijentiIdOfVoziloListVozilo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Klijent klijent) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Klijent persistentKlijent = em.find(Klijent.class, klijent.getKlijentiId());
            Vozilo voziloIdOld = persistentKlijent.getVoziloId();
            Vozilo voziloIdNew = klijent.getVoziloId();
            List<Vozilo> voziloListOld = persistentKlijent.getVoziloList();
            List<Vozilo> voziloListNew = klijent.getVoziloList();
            if (voziloIdNew != null) {
                voziloIdNew = em.getReference(voziloIdNew.getClass(), voziloIdNew.getVoziloId());
                klijent.setVoziloId(voziloIdNew);
            }
            List<Vozilo> attachedVoziloListNew = new ArrayList<Vozilo>();
            for (Vozilo voziloListNewVoziloToAttach : voziloListNew) {
                voziloListNewVoziloToAttach = em.getReference(voziloListNewVoziloToAttach.getClass(), voziloListNewVoziloToAttach.getVoziloId());
                attachedVoziloListNew.add(voziloListNewVoziloToAttach);
            }
            voziloListNew = attachedVoziloListNew;
            klijent.setVoziloList(voziloListNew);
            klijent = em.merge(klijent);
            if (voziloIdOld != null && !voziloIdOld.equals(voziloIdNew)) {
                voziloIdOld.getKlijentList().remove(klijent);
                voziloIdOld = em.merge(voziloIdOld);
            }
            if (voziloIdNew != null && !voziloIdNew.equals(voziloIdOld)) {
                voziloIdNew.getKlijentList().add(klijent);
                voziloIdNew = em.merge(voziloIdNew);
            }
            for (Vozilo voziloListOldVozilo : voziloListOld) {
                if (!voziloListNew.contains(voziloListOldVozilo)) {
                    voziloListOldVozilo.setKlijentiId(null);
                    voziloListOldVozilo = em.merge(voziloListOldVozilo);
                }
            }
            for (Vozilo voziloListNewVozilo : voziloListNew) {
                if (!voziloListOld.contains(voziloListNewVozilo)) {
                    Klijent oldKlijentiIdOfVoziloListNewVozilo = voziloListNewVozilo.getKlijentiId();
                    voziloListNewVozilo.setKlijentiId(klijent);
                    voziloListNewVozilo = em.merge(voziloListNewVozilo);
                    if (oldKlijentiIdOfVoziloListNewVozilo != null && !oldKlijentiIdOfVoziloListNewVozilo.equals(klijent)) {
                        oldKlijentiIdOfVoziloListNewVozilo.getVoziloList().remove(voziloListNewVozilo);
                        oldKlijentiIdOfVoziloListNewVozilo = em.merge(oldKlijentiIdOfVoziloListNewVozilo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = klijent.getKlijentiId();
                if (findKlijent(id) == null) {
                    throw new NonexistentEntityException("The klijent with id " + id + " no longer exists.");
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
            Klijent klijent;
            try {
                klijent = em.getReference(Klijent.class, id);
                klijent.getKlijentiId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The klijent with id " + id + " no longer exists.", enfe);
            }
            Vozilo voziloId = klijent.getVoziloId();
            if (voziloId != null) {
                voziloId.getKlijentList().remove(klijent);
                voziloId = em.merge(voziloId);
            }
            List<Vozilo> voziloList = klijent.getVoziloList();
            for (Vozilo voziloListVozilo : voziloList) {
                voziloListVozilo.setKlijentiId(null);
                voziloListVozilo = em.merge(voziloListVozilo);
            }
            em.remove(klijent);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Klijent> findKlijentEntities() {
        return findKlijentEntities(true, -1, -1);
    }

    public List<Klijent> findKlijentEntities(int maxResults, int firstResult) {
        return findKlijentEntities(false, maxResults, firstResult);
    }

    private List<Klijent> findKlijentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Klijent.class));
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

    public Klijent findKlijent(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Klijent.class, id);
        } finally {
            em.close();
        }
    }

    public int getKlijentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Klijent> rt = cq.from(Klijent.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
