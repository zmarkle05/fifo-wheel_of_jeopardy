/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelofjeopardy.UserInterface;

import org.junit.Test;
import static org.junit.Assert.*;
import wheelofjeopardy.Database.Database;
import wheelofjeopardy.Database.Question;

/**
 *
 * @author Zac
 */
public class UserInterfaceTest {
    
    /**
     * Test of spinWheel method, of class UserInterface.
     */
    @Test
    public void testSpinWheel() {
        System.out.println("spinWheel");
        Database db = new Database("database.csv");
        UserInterface instance = new UserInterface(db);
        Sector.SectorType result = instance.spinWheel();
    }

    /**
     * Test of retrieveSectorName method, of class UserInterface.
     */
    @Test
    public void testRetrieveSectorName() {
        System.out.println("retrieveSectorName");
        Database db = new Database("database.csv");
        UserInterface instance = new UserInterface(db);
        String result = instance.retrieveSectorName();
    }

    /**
     * Test of updateInfo method, of class UserInterface.
     */
    @Test
    public void testUpdateInfo() {
        System.out.println("updateInfo");
        Database db = new Database("database.csv");
        UserInterface instance = new UserInterface(db);
        instance.updateInfo();
    }

    /**
     * Test of updateQuestion method, of class UserInterface.
     */
    @Test
    public void testUpdateQuestion() {
        System.out.println("updateQuestion");
        Question question = new Question("What color is the sky?", "Blue", 100);
        Database db = new Database("database.csv");
        UserInterface instance = new UserInterface(db);
        instance.updateQuestion(question);
    }

    /**
     * Test of startTimer method, of class UserInterface.
     */
    @Test
    public void testStartTimer() {
        System.out.println("startTimer");
        Database db = new Database("database.csv");
        UserInterface instance = new UserInterface(db);
        instance.startTimer();
    }

    /**
     * Test of getDb method, of class UserInterface.
     */
    @Test
    public void testGetDb() {
        System.out.println("getDb");
        Database db = new Database("database.csv");
        UserInterface instance = new UserInterface(db);
        assertEquals(db, instance.getDb());
    }

    /**
     * Test of enableSpin method, of class UserInterface.
     */
    @Test
    public void testEnableSpin() {
        System.out.println("enableSpin");
        Database db = new Database("database.csv");
        UserInterface instance = new UserInterface(db);
        instance.enableSpin(false);
        instance.enableSpin(true);
    }

    /**
     * Test of enableSubmit method, of class UserInterface.
     */
    @Test
    public void testEnableSubmit() {
        System.out.println("enableSubmit");
        Database db = new Database("database.csv");
        UserInterface instance = new UserInterface(db);
        instance.enableSubmit(false);
        instance.enableSubmit(true);
    }

    /**
     * Test of useFreeTokens method, of class UserInterface.
     */
    @Test
    public void testUseFreeTokens() {
        System.out.println("useFreeTokens");
        Database db = new Database("database.csv");
        UserInterface instance = new UserInterface(db);
        instance.useFreeTokens();
    }
    
}
