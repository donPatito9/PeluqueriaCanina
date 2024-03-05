/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.DuenioMascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author UserDevs
 */
public class DuenioMascotaJpaController implements Serializable {

    public DuenioMascotaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
     public DuenioMascotaJpaController(){
        emf = Persistence.createEntityManagerFactory("PeluqueriaCaninaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DuenioMascota duenioMascota) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(duenioMascota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DuenioMascota duenioMascota) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            duenioMascota = em.merge(duenioMascota);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = duenioMascota.getIdDuenio();
                if (findDuenioMascota(id) == null) {
                    throw new NonexistentEntityException("The duenioMascota with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DuenioMascota duenioMascota;
            try {
                duenioMascota = em.getReference(DuenioMascota.class, id);
                duenioMascota.getIdDuenio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The duenioMascota with id " + id + " no longer exists.", enfe);
            }
            em.remove(duenioMascota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DuenioMascota> findDuenioMascotaEntities() {
        return findDuenioMascotaEntities(true, -1, -1);
    }

    public List<DuenioMascota> findDuenioMascotaEntities(int maxResults, int firstResult) {
        return findDuenioMascotaEntities(false, maxResults, firstResult);
    }

    private List<DuenioMascota> findDuenioMascotaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DuenioMascota.class));
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

    public DuenioMascota findDuenioMascota(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DuenioMascota.class, id);
        } finally {
            em.close();
        }
    }

    public int getDuenioMascotaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DuenioMascota> rt = cq.from(DuenioMascota.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
