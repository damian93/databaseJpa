/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.databasejpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pl.databasejpa.entities.Dictionary;
import pl.databasejpa.utils.DictionaryCreator;

/**
 *
 * @author damia
 */
public class DictionarySaver {

    public static void save() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("databaseJpa");
        EntityManager em = emf.createEntityManager();
        
        long startTime;
        long finishTime;
        List<Dictionary> dicList = DictionaryCreator.createDictionaries(50, 1000);

        startTime = System.currentTimeMillis();
        em.getTransaction().begin();

        for (int i = 0; i < dicList.size(); i++) {
            em.persist(dicList.get(i));
            if (i % 200 == 0) {
                em.flush();
                em.clear();
            }
        }

        em.getTransaction().commit();
        finishTime = System.currentTimeMillis();
        System.out.println("TIME:" + (finishTime - startTime));
        em.close();
        emf.close();
    }
}
