/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelofjeopardy.UserInterface;

import org.junit.Test;
import static org.junit.Assert.*;
import wheelofjeopardy.Database.Database;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 *
 * @author Zac
 */
public class WheelTest {
    
    /**
     * Test of getCurrentSector method, of class Wheel.
     */
    @Test
    public void testGetCurrentSector() {
        System.out.println("getCurrentSector");
        Display display = new Display();
        Shell shell = new Shell(display);
        Composite composite = new Composite(shell, SWT.BORDER);
        Database db = new Database("database.csv");
        UserInterface ui = new UserInterface(db);
        Wheel instance = new Wheel(ui, db.getCategories(), composite, 0);
        assertNotNull(instance.getCurrentSector());
    }

    /**
     * Test of getCurrSectorName method, of class Wheel.
     */
    @Test
    public void testGetCurrSectorName() {
        System.out.println("getCurrSectorName");
        Display display = new Display();
        Shell shell = new Shell(display);
        Composite composite = new Composite(shell, SWT.BORDER);
        Database db = new Database("database.csv");
        UserInterface ui = new UserInterface(db);
        Wheel instance = new Wheel(ui, db.getCategories(), composite, 0);
        assertNotNull(instance.getCurrSectorName());
    }

    /**
     * Test of spin method, of class Wheel.
     */
    @Test
    public void testSpin() {
        System.out.println("spin");
        Display display = new Display();
        Shell shell = new Shell(display);
        Composite composite = new Composite(shell, SWT.BORDER);
        Database db = new Database("database.csv");
        UserInterface ui = new UserInterface(db);
        Wheel instance = new Wheel(ui, db.getCategories(), composite, 0);
        instance.spin();
    }

    /**
     * Test of setSpinning, isSpinning methods, of class Wheel.
     */
    @Test
    public void testSpinning() {
        System.out.println("spinning");
        Display display = new Display();
        Shell shell = new Shell(display);
        Composite composite = new Composite(shell, SWT.BORDER);
        Database db = new Database("database.csv");
        UserInterface ui = new UserInterface(db);
        Wheel instance = new Wheel(ui, db.getCategories(), composite, 0);
        instance.setSpinning(false);
        assertFalse(instance.isSpinning());
        instance.setSpinning(true);
        assertTrue(instance.isSpinning());
    }    
}
