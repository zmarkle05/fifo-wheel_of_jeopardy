/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelofjeopardy.UserInterface;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zac
 */
public class UserInterfaceTest {
    
    public UserInterfaceTest() {
    }

    /**
     * Test of spinWheel method, of class UserInterface.
     */
    @Test
    public void testSpinWheel() {
        System.out.println("spinWheel");
        UserInterface instance = null;
        Sector.SectorType expResult = null;
        Sector.SectorType result = instance.spinWheel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveSectorName method, of class UserInterface.
     */
    @Test
    public void testRetrieveSectorName() {
        System.out.println("retrieveSectorName");
        UserInterface instance = null;
        String expResult = "";
        String result = instance.retrieveSectorName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
