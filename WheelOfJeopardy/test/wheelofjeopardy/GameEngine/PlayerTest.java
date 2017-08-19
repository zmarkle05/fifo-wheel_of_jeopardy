/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelofjeopardy.GameEngine;

import java.util.HashSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zac
 */
public class PlayerTest {
    
    public PlayerTest() {
    }

    /**
     * Test of isTurn, getName, setTurn methods, of class Player.
     */
    @Test
    public void testTurn() {
        System.out.println("Turn");
        String name = "Bob";
        Player instance = new Player(name, true);
        assertEquals(name, instance.getName());
        assertTrue(instance.isTurn());
        
        instance.setTurn(false);
        assertFalse(instance.isTurn());        
    }

    /**
     * Test of useToken, getFreeTokens, incrementTokens method, 
     * of class Player.
     */
    @Test
    public void testUseToken() {
        System.out.println("useToken");
        String name = "Bob";
        Player instance = new Player(name, true);
        
        // Should start with 0 tokens
        assertEquals(0,instance.getFreeTokens());
        assertFalse(instance.useToken());
        assertEquals(0,instance.getFreeTokens());
        
        // Add tokens
        instance.incrementTokens();
        assertEquals(1,instance.getFreeTokens());
        
        // Use tokens
        assertTrue(instance.useToken());
        assertEquals(0,instance.getFreeTokens());
    }

    /**
     * Test of spinWheel method, of class Player.
     */
    @Test
    public void testSpinWheel() {
        System.out.println("spinWheel");
        String name = "Bob";
        Player instance = new Player(name, true);
        instance.spinWheel();
    }

    /**
     * Test of answerQuestion method, of class Player.
     */
    @Test
    public void testAnswerQuestion() {
        System.out.println("answerQuestion");
        String name = "Bob";
        Player instance = new Player(name, true);
        instance.answerQuestion();
    }

    /**
     * Test of chooseCategory method, of class Player.
     */
    @Test
    public void testChooseCategory() {
        System.out.println("chooseCategory");
        String name = "Bob";
        Player instance = new Player(name, true);
        instance.chooseCategory();
    }
}
