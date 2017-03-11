package pl.databasejpa;

/**
 *
 * @author damia
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        HibernateExecutor hibernateExecutor = new HibernateExecutor();
        HibernateSearchExecutor hibernateSearchExecutor = new HibernateSearchExecutor();

        hibernateExecutor.search("CODE0");
        hibernateSearchExecutor.search("CODE0");

        hibernateExecutor.search("CODE100");
        hibernateSearchExecutor.search("CODE100");

        hibernateExecutor.search("CODE500");
        hibernateSearchExecutor.search("CODE500");

        hibernateExecutor.search("CODE4000");
        hibernateSearchExecutor.search("CODE4000");

        hibernateExecutor.search("CODE1000");
        hibernateSearchExecutor.search("CODE1000");

        hibernateExecutor.search("CODE25000");
        hibernateSearchExecutor.search("CODE25000");

        hibernateExecutor.search("CODE5");
        hibernateSearchExecutor.search("CODE5");

        hibernateExecutor.search("CODE45000");
        hibernateSearchExecutor.search("CODE45000");

        hibernateExecutor.search("CODE1");
        hibernateSearchExecutor.search("CODE1");

        hibernateExecutor.search("CODE15000");
        hibernateSearchExecutor.search("CODE15000");

        hibernateExecutor.end();
        hibernateSearchExecutor.end();

        hibernateExecutor.report();
        hibernateSearchExecutor.report();

    }

}
