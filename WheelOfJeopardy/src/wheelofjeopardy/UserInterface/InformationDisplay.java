/*
 * 
 */
package wheelofjeopardy.UserInterface;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 *
 * @author adam
 */
public class InformationDisplay {
    private Label curPlayer;
    private Label score;
    private Label tokens; 
    private Label time;
    
    public InformationDisplay(UserInterface ui, Composite composite, int style)
    {
        GridData gd = new GridData(SWT.FILL, SWT.FILL, true,true);

        //current player
        curPlayer = new Label(composite, SWT.NONE);
        curPlayer.setLayoutData(gd);
        curPlayer.setAlignment(SWT.CENTER);
        
        //score
        score = new Label(composite, SWT.NONE);
        score.setLayoutData(gd);
        score.setAlignment(SWT.CENTER);
       
        //tokens
        tokens = new Label(composite, SWT.NONE);
        tokens.setLayoutData(gd);
        tokens.setAlignment(SWT.CENTER);
        
        //time
        time = new Label(composite, SWT.NONE);
        
        time.setLayoutData(gd);
        time.setAlignment(SWT.CENTER);
    }
    
    public void updateInfoWithTurn(String playerName, int player1score,
            int player2score, int player1tokens, int player2tokens) {
        curPlayer.setText("CURRENT PLAYER " + playerName);
        score.setText("SCORE Player 1: " + player1score 
                + " | Player 2: " + player2score);
        tokens.setText("TOKENS Player 1: " + player1tokens 
                + " | Player 2: " + player2tokens);
    }
    
    public void updateTimer(int t) {
        time.setText("TIME " + t);
    }
    
}
