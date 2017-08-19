/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelofjeopardy.UserInterface;

import org.junit.Test;
import static org.junit.Assert.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 *
 * @author Zac
 */
public class SquaresTest {

    /**
     * Test of hide method, of class Squares.
     */
    @Test
    public void testHide() {
        System.out.println("hide");
        Display display = new Display();
        Shell shell = new Shell(display);
        Composite composite = new Composite(shell, SWT.BORDER);
        Squares instance = new Squares(composite, "Blah");
        instance.hide();
    }
    
}
