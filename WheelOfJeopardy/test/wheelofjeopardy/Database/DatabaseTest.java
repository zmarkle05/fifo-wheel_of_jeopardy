package wheelofjeopardy.Database;

import static junit.framework.TestCase.assertNotNull;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zac
 */
public class DatabaseTest {

    /**
     * Test of getQuestion method, of class Database.
     */
    @Test
    public void testGetQuestion() {
        System.out.println("getQuestion");
	String[] categories;
        String csvPath = "database.csv";
        Database instance = new Database(csvPath);
        Question question;
        
        categories = instance.getCategories();
        question = instance.getQuestion(categories[0]);
        assertNotNull(question);
    }

    /**
     * Test of getCategories method, of class Database.
     */
    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
	String[] categories;
        String csvPath = "database.csv";
        Database instance = new Database(csvPath);
        String[] result = instance.getCategories();

        categories = instance.getCategories();
        assertNotNull(categories);
    }
    
    /**
     * Test of addQuestionAnswer method, of class Database.
     */
    @Test
    public void testAddQuestionAnswer() {
        System.out.println("addQuestionAnswer");
        String csvPath = "database.csv";
        Database instance = new Database(csvPath);
        
        // TODO if time for additional functionality
    }
    
    /**
     * Test of writeCSV method, of class Database.
     */
    @Test
    public void testWriteCSV() {
        System.out.println("writeCSV");
        String csvPath = "database.csv";
        Database instance = new Database(csvPath);
        
        // TODO if time for additional functionality
    }    
}
