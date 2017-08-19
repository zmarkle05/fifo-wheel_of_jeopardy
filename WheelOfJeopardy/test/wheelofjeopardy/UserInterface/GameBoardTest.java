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
import wheelofjeopardy.Database.Database;

/**
 *
 * @author Zac
 */
public class GameBoardTest {

    /**
     * Test of enableDisableCategories method, of class GameBoard.
     */
    @Test
    public void testEnableDisableCategories() {
        System.out.println("enableDisableCategories");
        boolean flag = false;
        Display display = new Display();
        Shell shell = new Shell(display);
        Composite composite = new Composite(shell, SWT.BORDER);
        Database db = new Database("database.csv");
        GameBoard instance = new GameBoard(db, composite, 1);
        instance.enableDisableCategories(flag);
    }

    /**
     * Test of hideSquare method, of class GameBoard.
     */
    @Test
    public void testHideSquare() {
        System.out.println("hideSquare");
        String question = "";
        Display display = new Display();
        Shell shell = new Shell(display);
        Composite composite = new Composite(shell, SWT.BORDER);
        Database db = new Database("database.csv");
        GameBoard instance = new GameBoard(db, composite, 1);
        instance.hideSquare(question);
    }
    
}
