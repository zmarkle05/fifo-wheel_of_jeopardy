/*
 * 
 */
package wheelofjeopardy.UserInterface;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import wheelofjeopardy.Database.Database;
import wheelofjeopardy.Database.Question;

import java.util.*;

/**
 *
 * @author adam
 */
public class GameBoard {

    private Button[] catButtons;
    private HashMap<String,Squares> gameSquares;
    
    public GameBoard(Database db,
                     Composite composite,
                     int roundNum)
    {
        String[] categories = db.getCategories();
        catButtons  = new Button[6];
        gameSquares = new HashMap<String,Squares>(); 
        for (int iter = 0; iter < categories.length; iter++)
        {
            Composite categoryButtons = new Composite (composite, SWT.BORDER);
            categoryButtons.setLayout(new FillLayout(SWT.VERTICAL));
            catButtons[iter] = new Button(categoryButtons, SWT.None);
            catButtons[iter].setText(categories[iter]);
            catButtons[iter].setEnabled(false);
            
            Queue<Question> questions = db.getCategory(iter + 1).retrieveQuestions();
            for (Question quest: questions)
            {
                String label = Integer.toString((quest.getPointValue()) * roundNum);
                
                String questText = quest.getQuestion();
                
                gameSquares.put(questText, new Squares(categoryButtons, label));
            }             
        }
        
        setListeners();
    }
    
    public void enableDisableCategories(boolean flag)
    {
        catButtons[0].setEnabled(flag);
        catButtons[1].setEnabled(flag);
        catButtons[2].setEnabled(flag);
        catButtons[3].setEnabled(flag);
        catButtons[4].setEnabled(flag);
        catButtons[5].setEnabled(flag);
    }
    
    public void hideSquare(String question)
    {
        if (!question.equals(""))
        {
            gameSquares.get(question).hide();
        }
    }
    
    private void setListeners() {
        Listener listener = new Listener() {
            @Override
            public void handleEvent(Event event) {
                if (event.widget == catButtons[0]){
                    enableDisableCategories(false);
                } else if (event.widget == catButtons[1]) {
                    enableDisableCategories(false);
                } else if (event.widget == catButtons[2]) {
                    enableDisableCategories(false);
                } else if (event.widget == catButtons[3]) {
                    enableDisableCategories(false);
                } else if (event.widget == catButtons[4]) {
                    enableDisableCategories(false);
                } else if (event.widget == catButtons[5]) {
                    enableDisableCategories(false);
                }
            }
        };
        
        for (Button cat: catButtons)
        {
            cat.addListener(SWT.Selection, listener);
        }
    }
}
