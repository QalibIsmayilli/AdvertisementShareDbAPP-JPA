package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import com.company.model.User;
import com.company.model.UserInfo;
import com.company.util.DmlFunctionUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.RollbackException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {
    @Override
    public void saveUser(final User u) {
        DmlFunctionUtil.saveUtil(createEm(),u);
    }

    @Override
    public void updateUser(final User u) {
        DmlFunctionUtil.updateUtil(createEm(),u);

    }

    @Override
    public void removeUser(final User u) {
        EntityManager em = createEm();
        try {
            em.getTransaction().begin();
            if(em.contains(u)){
                em.remove(u);
            }else{
                User user = findById(u.getId());
                em.remove(user);
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
    public List<User> findUsers() {
        EntityManager em = createEm();
        TypedQuery<User> query = em.createNamedQuery("User.findUsers", User.class);
        List<User> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public List<User> findUsers(int minResult, int macResult) {
        EntityManager em = createEm();
        TypedQuery<User> query = em.createNamedQuery("User.findUsers", User.class);
        List<User> list = query.setFirstResult(minResult).setMaxResults(macResult).getResultList();
        em.close();
        return list;
    }

    @Override
    public User findById(Integer id) {
        EntityManager em = createEm();
        TypedQuery<User> query = em.createNamedQuery("User.findUserById", User.class);
        User user = query.setParameter("id",id).getSingleResult();
        em.close();
        return user;
    }

    @Override
    public User findUserByUsername(String username) {
        EntityManager em = createEm();
        TypedQuery<User> query = em.createNamedQuery("User.findUserByUsername", User.class);
        User user = query.setParameter("username",username).getSingleResult();
        em.close();
        return user;
    }

    @Override
    public User findWithUserDetailByUsername(String username) {
        EntityManager em = createEm();
        TypedQuery<User> query = em.createNamedQuery("User.findWithUserDetailByUsername", User.class);
        User user = query.setParameter("username",username).getSingleResult();

        em.close();
        return user;
    }

    @Override
    public int countOfUsers() {
        EntityManager em = createEm();
        TypedQuery<Integer> query = em.createNamedQuery("User.count", Integer.class);
        int count = query.getSingleResult();
        em.close();
        return count;
    }

    @Override
    public UserInfo findUserInfoByUsername() {
        EntityManager em = createEm();
        TypedQuery<UserInfo> query = em.createNamedQuery("User.findUserInfoByUsername", UserInfo.class);
        UserInfo userInfo = query.getSingleResult();
        em.close();
        return userInfo;
    }
}
