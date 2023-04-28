package com.company.util;

import com.company.dao.inter.AbstractDAO;
import com.company.model.DMLable;
import com.company.model.Education;
import jakarta.persistence.EntityManager;
import jakarta.persistence.RollbackException;

public class DmlFunctionUtil  {
    public static void saveUtil(EntityManager em, DMLable obj){
        try{
            em.getTransaction().begin();
            em.persist(obj);
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

    public static void updateUtil(EntityManager em, DMLable obj){
        try{
            em.getTransaction().begin();
            em.merge(obj);
            em.flush();
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

}
