package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDetailDaoInter;

import com.company.model.UserDetail;
import com.company.util.DmlFunctionUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.RollbackException;
import jakarta.persistence.TypedQuery;

public class UserDetailDaoImpl extends AbstractDAO implements UserDetailDaoInter {
    @Override
    public void saveUserDetail(final UserDetail userDetail) {
        DmlFunctionUtil.saveUtil(createEm(),userDetail);
    }

    @Override
    public void updateUserDetail(final UserDetail userDetail) {
        DmlFunctionUtil.updateUtil(createEm(),userDetail);
    }

    @Override
    public void removeUserDetail(final UserDetail userDetail) {
        EntityManager em = createEm();
        try {
            em.getTransaction().begin();
            if(em.contains(userDetail)){
                em.remove(userDetail);
            }else{
                UserDetail ud = findById(userDetail.getId());
                em.remove(ud);
            }
            em.getTransaction().commit();
            em.close();
        } catch (Exception ex1) {
            System.out.println("Exception: " + ex1);
            try{
                em.getTransaction().rollback();
            }catch (RollbackException ex2){
                System.out.println("Exception: " + ex2);
            }
        }
    }

    @Override
    public UserDetail findById(Integer id) {
        EntityManager em = createEm();
        TypedQuery<UserDetail> query = em.createNamedQuery("UserDetail.findById",UserDetail.class);
        UserDetail ud = query.setParameter("id",id).getSingleResult();
        em.close();
        return ud;
    }

    @Override
    public UserDetail findByUsername(String username) {
        EntityManager em = createEm();
        TypedQuery<UserDetail> typedQuery = em.createNamedQuery("UserDetail.findByUsername",UserDetail.class);
        UserDetail ud = typedQuery.setParameter("username",username).getSingleResult();
        em.close();
        return ud;
    }

    @Override
    public UserDetail findWithAddressByUsername(String username) {
        EntityManager em = createEm();
        TypedQuery<UserDetail> typedQuery = em.createNamedQuery("UserDetail.findWithAddressByUsername", UserDetail.class);
        UserDetail ud = typedQuery.setParameter("username",username).getSingleResult();
        em.close();
        return ud;
    }

    @Override
    public UserDetail findWithAdvertisementByUsername(String username) {
        EntityManager em = createEm();
        TypedQuery<UserDetail> typedQuery = em.createNamedQuery("UserDetail.findWithAdvertisementByUsername",UserDetail.class);
        UserDetail userDetail = typedQuery.setParameter("username",username).getSingleResult();
        return userDetail;
    }
}
