package com.company.dao.inter;

import com.company.model.DMLable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class AbstractDAO {
    private static EntityManagerFactory emf = null;
    public static EntityManager createEm(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("Persistence-unit");
        }
        return emf.createEntityManager();
    }

}
