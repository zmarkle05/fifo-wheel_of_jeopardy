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
public class InformationDisplayTest {

    /**
     * Test of updateInfoWithTurn method, of class InformationDisplay.
     */
    @Test
    public void testUpdateInfoWithTurn() {
        System.out.println("updateInfoWithTurn");
        String playerName = "";
        int player1score = 0;
        int player2score = 0;
        int player1tokens = 0;
        int player2tokens = 0;
        Display display = new Display();
        Shell shell = new Shell(display);
        Composite composite = new Composite(shell, SWT.BORDER);
        Database db = new Database("database.csv");
        UserInterface ui = new UserInterface(db);
        InformationDisplay instance = new InformationDisplay(ui, composite, 0);
        instance.updateInfoWithTurn(playerName, player1score, player2score, player1tokens, player2tokens);
    }

    /**
     * Test of updateTimer method, of class InformationDisplay.
     */
    @Test
    public void testUpdateTimer() {
        System.out.println("updateTimer");
        int t = 0;
        Display display = new Display();
        Shell shell = new Shell(display);
        Composite composite = new Composite(shell, SWT.BORDER);
        Database db = new Database("database.csv");
        UserInterface ui = new UserInterface(db);
        InformationDisplay instance = new InformationDisplay(ui, composite, 0);
        instance.updateTimer(t);
        t = -1;
        instance.updateTimer(t);
        t = 12345678;
        instance.updateTimer(t);        
    }
    
}
