/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelofjeopardy.GameEngine;

import org.junit.Test;
import static org.junit.Assert.*;
import wheelofjeopardy.UserInterface.Sector;

/**
 *
 * @author Zac
 */
public class GameEngineTest {
    
    public GameEngineTest() {
    }

    /**
     * Test of compareAnswer method, of class GameEngine.
     */
    @Test
    public void testCompareAnswer() {
        System.out.println("compareAnswer");
        String category = "category";
        GameEngine instance = new GameEngine();
        instance.compareAnswer(category);
    }

    /**
     * Test of endRound method, of class GameEngine.
     */
    @Test
    public void testEndRound() {
        System.out.println("endRound");
        GameEngine instance = new GameEngine();
        instance.endRound();
    }

    /**
     * Test of endGame method, of class GameEngine.
     */
    @Test
    public void testEndGame() {
        System.out.println("endGame");
        GameEngine.endGame();
    }

    /**
     * Test of endTurn method, of class GameEngine.
     */
    @Test
    public void testEndTurn() {
        System.out.println("endTurn");
        GameEngine.endTurn();
    }

    /**
     * Test of declareWinner method, of class GameEngine.
     */
    @Test
    public void testDeclareWinner() {
        System.out.println("declareWinner");
        GameEngine.declareWinner();
    }

    /**
     * Test of playGame method, of class GameEngine.
     */
    @Test
    public void testPlayGame() {
        System.out.println("playGame");
        GameEngine instance = new GameEngine();
        instance.playGame();
    }

    /**
     * Test of performSectorOperation method, of class GameEngine.
     */
    @Test
    public void testPerformSectorOperation() {
        System.out.println("performSectorOperation");
        Sector.SectorType sector = Sector.SectorType.BANKRUPT;
        GameEngine instance = new GameEngine();
        instance.performSectorOperation(sector);
    }

    /**
     * Test of loseTurn method, of class GameEngine.
     */
    @Test
    public void testLoseTurn() {
        System.out.println("loseTurn");
        GameEngine instance = new GameEngine();
        instance.loseTurn();
    }

    /**
     * Test of bankrupt method, of class GameEngine.
     */
    @Test
    public void testBankrupt() {
        System.out.println("bankrupt");
        GameEngine instance = new GameEngine();
        instance.bankrupt();
    }
    
}
