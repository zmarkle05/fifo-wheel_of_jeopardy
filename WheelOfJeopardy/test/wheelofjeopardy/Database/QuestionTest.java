/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelofjeopardy.Database;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zac
 */
public class QuestionTest {
    
    private final String question = "What color is the sky?";
    private final String answer   = "Blue";
    private final int value	    = 100;
    private final Question instance = new Question(question, answer, value);
    
    public QuestionTest() {
    }

    /**
     * Test of getAnswer method, of class Question.
     */
    @Test
    public void testGetAnswer() {
        System.out.println("getAnswer");
        assertEquals(answer, instance.getAnswer());
    }

    /**
     * Test of getQuestion method, of class Question.
     */
    @Test
    public void testGetQuestion() {
        System.out.println("getQuestion");
        assertEquals(question, instance.getQuestion());
    }

    /**
     * Test of getPointValue method, of class Question.
     */
    @Test
    public void testGetPointValue() {
        System.out.println("getPointValue");
        assertEquals(value, instance.getAnswer());
    }

    /**
     * Test of isAnswered method, of class Question.
     */
    @Test
    public void testIsAnswered() {
        System.out.println("isAnswered");
        // TODO isAnswered is always false, no interface to change to true
        fail("The target function always returns false");
    }
    
}
