package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.EducationDaoInter;
import com.company.model.Education;
import com.company.util.DmlFunctionUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.RollbackException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EducationDaoImpl extends AbstractDAO implements EducationDaoInter {
    @Override
    public void saveEducation(final Education education) {
        DmlFunctionUtil.saveUtil(createEm(), education);
    }

    @Override
    public void updateEducation(final Education education) {
        DmlFunctionUtil.updateUtil(createEm(),education);
    }

    @Override
    public void removeEducation(final Education education) {
        EntityManager em = createEm();
        try{
            em.getTransaction().begin();
            if(em.contains(education)){
                em.remove(education);
            }else{
                Education ed = findById(education.getId());
                em.remove(ed);
            }
            em.getTransaction().commit();
            em.close();
        }catch (Exception ex1){
            System.out.println("Exception : " + ex1);
            try{
                em.getTransaction().rollback();
            }catch (RollbackException ex2){
                System.out.println("Exception: " + ex2);
            }
        }
    }

    @Override
    public List<Education> findEducations() {
        EntityManager em = createEm();
        TypedQuery<Education> query = em.createNamedQuery("Education.findEducations",Education.class);
        List<Education> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public Education findById(Integer id) {
        EntityManager em = createEm();
        TypedQuery<Education> query = em.createNamedQuery("Education.findById",Education.class);
        Education education = query.setParameter("id",id).getSingleResult();
        em.close();
        return education;
    }

    @Override
    public Education findWithAdvertisementById(Integer id) {
        EntityManager em = createEm();
        TypedQuery<Education> query = em.createNamedQuery("Education.findWithAdvertisementById",Education.class);
        Education education = query.setParameter("id",id).getSingleResult();
        em.close();
        return education;
    }
}
