/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelofjeopardy.GameEngine;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zac
 */
public class StatisticTrackerTest {
    
    public StatisticTrackerTest() {
    }

    /**
     * Test of incrementScore, decrementScore, getPlayerScore methods, 
     * of class StatisticTracker.
     */
    @Test
    public void testScorekeeping() {
        System.out.println("Scorekeeping");
        int playerNum = 1;
        StatisticTracker instance = new StatisticTracker();
        
        // Player number 1
        instance.incrementScore(playerNum);
        assertEquals(1, instance.getPlayerScore(playerNum));
        instance.decrementScore(playerNum);
        assertEquals(0, instance.getPlayerScore(playerNum));
        // Decrement should not work if score is currently 0
        instance.decrementScore(playerNum);
        assertEquals(0, instance.getPlayerScore(playerNum));
        
        // Player number 2
        playerNum = 2;
        instance.incrementScore(playerNum);
        assertEquals(1, instance.getPlayerScore(playerNum));
        instance.decrementScore(playerNum);
        assertEquals(0, instance.getPlayerScore(playerNum));
        // Decrement should not work if score is currently 0
        instance.decrementScore(playerNum);
        assertEquals(0, instance.getPlayerScore(playerNum));
        
        // Bad player number
        playerNum = -1;
        instance.incrementScore(playerNum);
        assertEquals(1, instance.getPlayerScore(playerNum));
        instance.decrementScore(playerNum);
        assertEquals(0, instance.getPlayerScore(playerNum));
        // Decrement should not work if score is currently 0
        instance.decrementScore(playerNum);
        assertEquals(0, instance.getPlayerScore(playerNum));
    }

    /**
     * Test of incrementTimer method, of class StatisticTracker.
     */
    @Test
    public void testIncrementTimer() {
        System.out.println("incrementTimer");
        StatisticTracker instance = new StatisticTracker();
        instance.incrementTimer();
    }

    /**
     * Test of incrementSpins, getNumberOfSpins methods, 
     * of class StatisticTracker.
     */
    @Test
    public void testSpinkeeping() {
        System.out.println("Spinkeeping");
        StatisticTracker instance = new StatisticTracker();
        
        assertEquals(0, instance.getNumberOfSpins());
        instance.incrementSpins();
        assertEquals(1, instance.getNumberOfSpins());
    }

    /**
     * Test of incrementRound, getRound methods, 
     * of class StatisticTracker.
     */
    @Test
    public void testIncrementRound() {
        System.out.println("Roundkeeping");
        StatisticTracker instance = new StatisticTracker();
        
        assertEquals(1, instance.getRound());
        instance.incrementRound();
        assertEquals(2, instance.getRound());
    }

    /**
     * Test of reset method, of class StatisticTracker.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        StatisticTracker instance = new StatisticTracker();
        instance.reset();
    }
    
}
