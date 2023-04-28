package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.AdvertisemenDaoInter;
import com.company.model.Advertisement;
import com.company.util.DmlFunctionUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.RollbackException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AdvertisementDaoImpl extends AbstractDAO implements AdvertisemenDaoInter {
    @Override
    public void saveAdvertisement(final Advertisement advertisement) {
        DmlFunctionUtil.saveUtil(createEm(),advertisement);
    }

    @Override
    public void updateAdvertisement(final Advertisement advertisement) {
        DmlFunctionUtil.updateUtil(createEm(),advertisement);
    }

    @Override
    public void removeAdvertisement(final Advertisement advertisement) {
        EntityManager em = createEm();
        try{
            em.getTransaction().begin();

            if(em.contains(advertisement)){
                em.remove(advertisement);
            }else{
                Advertisement deleteAdvertisement = this.findById(advertisement.getId());
                em.remove(deleteAdvertisement);
            }
            em.getTransaction().commit();
            em.close();
        }catch (Exception ex){
            System.out.println("Exception: " +ex);
            try {
                em.getTransaction().rollback();
            }catch (RollbackException ex2){
                System.out.println("Exception: " + ex2);
            }
        }
    }

    @Override
    public Advertisement findById(Integer id) {
        EntityManager em = createEm();
        TypedQuery<Advertisement> query = em.createNamedQuery("Advertisement.findById",Advertisement.class);
        Advertisement advertisement = query.setParameter("id",id).getSingleResult();
        em.close();
        return advertisement;
    }

    @Override
    public Advertisement findByUsername(String username) {
        EntityManager em = createEm();
        TypedQuery<Advertisement> query = em.createNamedQuery("Advertisement.findByUsername",Advertisement.class);
        Advertisement advertisement = query.setParameter("username",username).getSingleResult();
        em.close();
        return advertisement;
    }

    @Override
    public List<Advertisement> findAdvertisements() {
        EntityManager em = createEm();
        TypedQuery<Advertisement> query = em.createNamedQuery("Advertisement.findAdvertisements",Advertisement.class);
        List<Advertisement> advertisement = query.getResultList();
        em.close();
        return advertisement;
    }
}
