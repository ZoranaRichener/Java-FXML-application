/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontroleri;

import entiteti.Galerija;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entiteti.TehnickiPregled;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpacontroleri.exceptions.NonexistentEntityException;

/**
 *
 * @author Lenovo
 */
public class GalerijaJpaController implements Serializable {

    public GalerijaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Galerija galerija) {
        if (galerija.getTehnickiPregledList() == null) {
            galerija.setTehnickiPregledList(new ArrayList<TehnickiPregled>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TehnickiPregled tehnickiPregledId = galerija.getTehnickiPregledId();
            if (tehnickiPregledId != null) {
                tehnickiPregledId = em.getReference(tehnickiPregledId.getClass(), tehnickiPregledId.getTehnickiPregledId());
                galerija.setTehnickiPregledId(tehnickiPregledId);
            }
            List<TehnickiPregled> attachedTehnickiPregledList = new ArrayList<TehnickiPregled>();
            for (TehnickiPregled tehnickiPregledListTehnickiPregledToAttach : galerija.getTehnickiPregledList()) {
                tehnickiPregledListTehnickiPregledToAttach = em.getReference(tehnickiPregledListTehnickiPregledToAttach.getClass(), tehnickiPregledListTehnickiPregledToAttach.getTehnickiPregledId());
                attachedTehnickiPregledList.add(tehnickiPregledListTehnickiPregledToAttach);
            }
            galerija.setTehnickiPregledList(attachedTehnickiPregledList);
            em.persist(galerija);
            if (tehnickiPregledId != null) {
                tehnickiPregledId.getGalerijaList().add(galerija);
                tehnickiPregledId = em.merge(tehnickiPregledId);
            }
            for (TehnickiPregled tehnickiPregledListTehnickiPregled : galerija.getTehnickiPregledList()) {
                Galerija oldGalerijaIdOfTehnickiPregledListTehnickiPregled = tehnickiPregledListTehnickiPregled.getGalerijaId();
                tehnickiPregledListTehnickiPregled.setGalerijaId(galerija);
                tehnickiPregledListTehnickiPregled = em.merge(tehnickiPregledListTehnickiPregled);
                if (oldGalerijaIdOfTehnickiPregledListTehnickiPregled != null) {
                    oldGalerijaIdOfTehnickiPregledListTehnickiPregled.getTehnickiPregledList().remove(tehnickiPregledListTehnickiPregled);
                    oldGalerijaIdOfTehnickiPregledListTehnickiPregled = em.merge(oldGalerijaIdOfTehnickiPregledListTehnickiPregled);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Galerija galerija) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Galerija persistentGalerija = em.find(Galerija.class, galerija.getGalerijaId());
            TehnickiPregled tehnickiPregledIdOld = persistentGalerija.getTehnickiPregledId();
            TehnickiPregled tehnickiPregledIdNew = galerija.getTehnickiPregledId();
            List<TehnickiPregled> tehnickiPregledListOld = persistentGalerija.getTehnickiPregledList();
            List<TehnickiPregled> tehnickiPregledListNew = galerija.getTehnickiPregledList();
            if (tehnickiPregledIdNew != null) {
                tehnickiPregledIdNew = em.getReference(tehnickiPregledIdNew.getClass(), tehnickiPregledIdNew.getTehnickiPregledId());
                galerija.setTehnickiPregledId(tehnickiPregledIdNew);
            }
            List<TehnickiPregled> attachedTehnickiPregledListNew = new ArrayList<TehnickiPregled>();
            for (TehnickiPregled tehnickiPregledListNewTehnickiPregledToAttach : tehnickiPregledListNew) {
                tehnickiPregledListNewTehnickiPregledToAttach = em.getReference(tehnickiPregledListNewTehnickiPregledToAttach.getClass(), tehnickiPregledListNewTehnickiPregledToAttach.getTehnickiPregledId());
                attachedTehnickiPregledListNew.add(tehnickiPregledListNewTehnickiPregledToAttach);
            }
            tehnickiPregledListNew = attachedTehnickiPregledListNew;
            galerija.setTehnickiPregledList(tehnickiPregledListNew);
            galerija = em.merge(galerija);
            if (tehnickiPregledIdOld != null && !tehnickiPregledIdOld.equals(tehnickiPregledIdNew)) {
                tehnickiPregledIdOld.getGalerijaList().remove(galerija);
                tehnickiPregledIdOld = em.merge(tehnickiPregledIdOld);
            }
            if (tehnickiPregledIdNew != null && !tehnickiPregledIdNew.equals(tehnickiPregledIdOld)) {
                tehnickiPregledIdNew.getGalerijaList().add(galerija);
                tehnickiPregledIdNew = em.merge(tehnickiPregledIdNew);
            }
            for (TehnickiPregled tehnickiPregledListOldTehnickiPregled : tehnickiPregledListOld) {
                if (!tehnickiPregledListNew.contains(tehnickiPregledListOldTehnickiPregled)) {
                    tehnickiPregledListOldTehnickiPregled.setGalerijaId(null);
                    tehnickiPregledListOldTehnickiPregled = em.merge(tehnickiPregledListOldTehnickiPregled);
                }
            }
            for (TehnickiPregled tehnickiPregledListNewTehnickiPregled : tehnickiPregledListNew) {
                if (!tehnickiPregledListOld.contains(tehnickiPregledListNewTehnickiPregled)) {
                    Galerija oldGalerijaIdOfTehnickiPregledListNewTehnickiPregled = tehnickiPregledListNewTehnickiPregled.getGalerijaId();
                    tehnickiPregledListNewTehnickiPregled.setGalerijaId(galerija);
                    tehnickiPregledListNewTehnickiPregled = em.merge(tehnickiPregledListNewTehnickiPregled);
                    if (oldGalerijaIdOfTehnickiPregledListNewTehnickiPregled != null && !oldGalerijaIdOfTehnickiPregledListNewTehnickiPregled.equals(galerija)) {
                        oldGalerijaIdOfTehnickiPregledListNewTehnickiPregled.getTehnickiPregledList().remove(tehnickiPregledListNewTehnickiPregled);
                        oldGalerijaIdOfTehnickiPregledListNewTehnickiPregled = em.merge(oldGalerijaIdOfTehnickiPregledListNewTehnickiPregled);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = galerija.getGalerijaId();
                if (findGalerija(id) == null) {
                    throw new NonexistentEntityException("The galerija with id " + id + " no longer exists.");
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
            Galerija galerija;
            try {
                galerija = em.getReference(Galerija.class, id);
                galerija.getGalerijaId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The galerija with id " + id + " no longer exists.", enfe);
            }
            TehnickiPregled tehnickiPregledId = galerija.getTehnickiPregledId();
            if (tehnickiPregledId != null) {
                tehnickiPregledId.getGalerijaList().remove(galerija);
                tehnickiPregledId = em.merge(tehnickiPregledId);
            }
            List<TehnickiPregled> tehnickiPregledList = galerija.getTehnickiPregledList();
            for (TehnickiPregled tehnickiPregledListTehnickiPregled : tehnickiPregledList) {
                tehnickiPregledListTehnickiPregled.setGalerijaId(null);
                tehnickiPregledListTehnickiPregled = em.merge(tehnickiPregledListTehnickiPregled);
            }
            em.remove(galerija);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Galerija> findGalerijaEntities() {
        return findGalerijaEntities(true, -1, -1);
    }

    public List<Galerija> findGalerijaEntities(int maxResults, int firstResult) {
        return findGalerijaEntities(false, maxResults, firstResult);
    }

    private List<Galerija> findGalerijaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Galerija.class));
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

    public Galerija findGalerija(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Galerija.class, id);
        } finally {
            em.close();
        }
    }

    public int getGalerijaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Galerija> rt = cq.from(Galerija.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
