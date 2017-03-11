/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.databasejpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import pl.databasejpa.entities.Dictionary;

/**
 *
 * @author damia
 */
public class HibernateSearchExecutor {

    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final FullTextEntityManager fullTextEntityManager;
    private long time = 0;

    public HibernateSearchExecutor() throws InterruptedException {
        emf = Persistence.createEntityManagerFactory("databaseJpa");
        em = emf.createEntityManager();
        fullTextEntityManager = Search.getFullTextEntityManager(em);
        fullTextEntityManager.createIndexer().startAndWait();
    }

    public void search(String phrase) {

        long startTime;
        long finishTime;

        QueryBuilder qb = fullTextEntityManager.getSearchFactory()
                .buildQueryBuilder().forEntity(Dictionary.class).get();
        org.apache.lucene.search.Query luceneQuery = qb
                .keyword()
                .onFields("recordsList.code")
                .matching(phrase)
                .createQuery();

        javax.persistence.Query jpaQuery
                = fullTextEntityManager.createFullTextQuery(luceneQuery, Dictionary.class);

        startTime = System.currentTimeMillis();
        em.getTransaction().begin();

        jpaQuery.getResultList();

        em.getTransaction().commit();
        finishTime = System.currentTimeMillis();
        time += finishTime - startTime;

    }

    public void report() {
        System.out.println("HIBERNATE SEARCH");
        System.out.println("TIME:" + time + "ms");

    }

    public void end() {
        em.close();
        emf.close();
    }

}
