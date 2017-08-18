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
public class SectorTest {
    
    public SectorTest() {
    }

    /**
     * Test of getType method, of class Sector.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Sector instance = null;
        Sector.SectorType expResult = null;
        Sector.SectorType result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Sector.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Sector instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
