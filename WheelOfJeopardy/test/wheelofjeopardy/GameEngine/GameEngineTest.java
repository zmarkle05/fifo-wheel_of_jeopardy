/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelofjeopardy.GameEngine;

import org.junit.Test;
import static org.junit.Assert.*;
import wheelofjeopardy.UserInterface.Sector;
import wheelofjeopardy.UserInterface.UserInterface;
import wheelofjeopardy.Database.Database;


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
        Database database = new Database("database.csv");
        UserInterface ui  = new UserInterface(database);
        GameEngine instance = new GameEngine(database, ui);
        instance.compareAnswer(category);
    }

    /**
     * Test of endGame method, of class GameEngine.
     */
    @Test
    public void testEndGame() {
        System.out.println("endGame");
        Database database = new Database("database.csv");
        UserInterface ui  = new UserInterface(database);
        GameEngine instance = new GameEngine(database, ui);
        instance.endGame();
    }

    /**
     * Test of endTurn method, of class GameEngine.
     */
    @Test
    public void testEndTurn() {
        System.out.println("endTurn");
        Database database = new Database("database.csv");
        UserInterface ui  = new UserInterface(database);
        GameEngine instance = new GameEngine(database, ui);
        instance.endTurn();
    }

    /**
     * Test of declareWinner method, of class GameEngine.
     */
    @Test
    public void testDeclareWinner() {
        System.out.println("declareWinner");
        Database database = new Database("database.csv");
        UserInterface ui  = new UserInterface(database);
        GameEngine instance = new GameEngine(database, ui);
       // instance.declareWinner();
    }

    /**
     * Test of playGame method, of class GameEngine.
     */
    @Test
    public void testPlayGame() {
        System.out.println("playGame");
        Sector sector = new Sector(Sector.SectorType.BANKRUPT, "Bankrupt");
        Database database = new Database("database.csv");
        UserInterface ui  = new UserInterface(database);
        GameEngine instance = new GameEngine(database, ui);
        instance.playGame(sector);
    }

    /**
     * Test of performSectorOperation method, of class GameEngine.
     */
    @Test
    public void testPerformSectorOperation() {
        System.out.println("performSectorOperation");
        Sector sector = new Sector(Sector.SectorType.BANKRUPT, "Bankrupt");
        Database database = new Database("database.csv");
        UserInterface ui  = new UserInterface(database);
        GameEngine instance = new GameEngine(database, ui);
        instance.performSectorOperation(sector);
    }

    /**
     * Test of loseTurn method, of class GameEngine.
     */
    @Test
    public void testLoseTurn() {
        System.out.println("loseTurn");
        Database database = new Database("database.csv");
        UserInterface ui  = new UserInterface(database);
        GameEngine instance = new GameEngine(database, ui);
        instance.loseTurn();
    }

    /**
     * Test of bankrupt method, of class GameEngine.
     */
    @Test
    public void testBankrupt() {
        System.out.println("bankrupt");
        Database database = new Database("database.csv");
        UserInterface ui  = new UserInterface(database);
        GameEngine instance = new GameEngine(database, ui);
        instance.bankrupt();
    }
    
}
