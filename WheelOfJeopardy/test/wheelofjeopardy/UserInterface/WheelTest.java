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
public class WheelTest {
    
    public WheelTest() {
    }

    /**
     * Test of getCurrentSector method, of class Wheel.
     */
    @Test
    public void testGetCurrentSector() {
        System.out.println("getCurrentSector");
        Wheel instance = null;
        Sector expResult = null;
        Sector result = instance.getCurrentSector();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrSectorName method, of class Wheel.
     */
    @Test
    public void testGetCurrSectorName() {
        System.out.println("getCurrSectorName");
        Wheel instance = null;
        String expResult = "";
        String result = instance.getCurrSectorName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of spin method, of class Wheel.
     */
    @Test
    public void testSpin() {
        System.out.println("spin");
        Wheel instance = null;
        instance.spin();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
