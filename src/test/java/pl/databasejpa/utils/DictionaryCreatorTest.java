package pl.databasejpa.utils;

import pl.databasejpa.utils.DictionaryCreator;
import pl.databasejpa.entities.Dictionary;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author damia
 */
public class DictionaryCreatorTest {

    public DictionaryCreatorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createDictionaries method, of class DictionaryCreator.
     */
    @Test
    public void testCreateDictionaries() {
        System.out.println("createDictionaries");
        int dicNumber = 2;
        int recNumber = 500;
        List<Dictionary> result = DictionaryCreator.createDictionaries(dicNumber, recNumber);
        assertEquals(dicNumber, result.size());
        for (Dictionary d : result) {
            assertEquals(recNumber, d.getRecordsList().size());
        }
    }

}
