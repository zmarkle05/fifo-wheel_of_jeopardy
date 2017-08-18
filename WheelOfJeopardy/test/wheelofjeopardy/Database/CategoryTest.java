package wheelofjeopardy.Database;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zac
 */
public class CategoryTest {
    
    public CategoryTest() {
    }
    
    /**
     * Test of getCatName method, of class Category.
     */
    @Test
    public void testGetCatName() {
        System.out.println("getCatName");
        String expResult = "Sports";
        Category instance = new Category(expResult);
        String result = instance.getCatName();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of outOfQuestions, addQuestion, retrieveQuestion, and removeQuestion
     * methods, of class Category.
     */
    @Test
    public void testQuestionHandling() {
        System.out.println("QuestionHandling");
        String catName = "Sports";
        Category instance = new Category(catName);
        String ques = "What color is the sky?";
	String answ = "Blue";
        
        assertTrue(instance.outOfQuestions());

        // Add question
        instance.addQuestion(ques, answ);
        assertFalse(instance.outOfQuestions());

        // Retrieve question
        Question question = instance.retrieveQuestion();
        assertEquals(ques, question.getQuestion());
        assertEquals(answ, question.getAnswer());
        assertFalse(instance.outOfQuestions());

        // Remove question
        question = instance.removeQuestion();
        assertEquals(ques, question.getQuestion());
        assertEquals(answ, question.getAnswer());
        assertTrue(instance.outOfQuestions());
        
        // Remove question (no question)
        question = instance.removeQuestion();
        assertNotNull(question);
    }    
}
