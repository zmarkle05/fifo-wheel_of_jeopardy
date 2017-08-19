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
        Sector.SectorType secType = Sector.SectorType.FREE_TURN;
        String secName = "Testing";
        Sector instance = new Sector(secType, secName);
        Sector.SectorType result = instance.getType();
        assertEquals(secType, instance.getType());
    }

    /**
     * Test of getName method, of class Sector.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Sector.SectorType secType = Sector.SectorType.FREE_TURN;
        String secName = "Testing";
        Sector instance = new Sector(secType, secName);
        Sector.SectorType result = instance.getType();
        assertEquals(secName, instance.getName());
    }
    
}
