/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.databasejpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pl.databasejpa.entities.Dictionary;

/**
 *
 * @author damia
 */
public class HibernateExecutor {

    private final EntityManagerFactory emf;
    private final EntityManager em;
    private long time = 0;

    public HibernateExecutor() {
        emf = Persistence.createEntityManagerFactory("databaseJpa");
        em = emf.createEntityManager();
    }

    public void search(String pharase) {

        long startTime;
        long finishTime;

        Query query = em.createQuery("SELECT d FROM Dictionary d, Records r where r.code=:param and r.dicId=d.id", Dictionary.class);
        query.setParameter("param", pharase);
        startTime = System.currentTimeMillis();
        em.getTransaction().begin();

        query.getResultList();

        em.getTransaction().commit();
        finishTime = System.currentTimeMillis();
        time += finishTime - startTime;

    }

    public void report() {
        System.out.println("HIBERNATE");
        System.out.println("TIME:" + time + "ms");

    }

    public void end() {
        em.close();
        emf.close();
    }

}
