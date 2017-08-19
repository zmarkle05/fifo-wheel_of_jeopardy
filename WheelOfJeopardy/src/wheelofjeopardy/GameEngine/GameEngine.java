package wheelofjeopardy.GameEngine;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import wheelofjeopardy.UserInterface.*;
import wheelofjeopardy.Database.Database;
import wheelofjeopardy.Database.Question;

/**
 *
 * @author adam
 */
public class GameEngine 
{
        
    public static int questionsLeft;
    public Player player1;
    public Player player2;
    private Question curQuestion;
    public  StatisticTracker statTracker;
    private final Database database;
    private UserInterface ui;
    
    public GameEngine(Database database, UserInterface ui)
    {
        player1 = new Player("Player 1", true);
        player1.incrementTokens();

        player2 = new Player("Player 2", false);
        player2.incrementTokens();

        statTracker = new StatisticTracker();
        this.database = database;
        this.ui = ui;
    }

    public void compareAnswer(String answer)
    {   
        if (curQuestion != null)
        {
            //TODO pass question to GUI for user to answer
            String userAnswer = answer;
                
            String correctAnswer = curQuestion.getAnswer();
            int pointValue = curQuestion.getPointValue();
                
            boolean isCorrect = userAnswer.toLowerCase().equals(correctAnswer.toLowerCase());
       
            if (isCorrect)
            {
                if (player1.isTurn())
                {
                    statTracker.incrementScore(1, pointValue);
                }
                else
                {
                    statTracker.incrementScore(2, pointValue);            
                }
           
               endTurn();
            }
              
            else {
                boolean choice = ui.useFreeTokens();  
                if (!choice) {
                    endTurn();
                }
            }
        }
        else
        {
            endTurn();// how should we handle categories that run out of questions?
        }
    }

    public void endGame()
    {
        int player1Score = statTracker.getPlayerScore(1);
        int player2Score = statTracker.getPlayerScore(2);
        if (player1Score > player2Score)
        {
            ui.declareWinner(1);
        }
        else if (player2Score > player1Score)
        {
            ui.declareWinner(2);
        }
        else
        {
            ui.declareWinner(-1);
        }
    }
    
    public void endTurn()
    {
        //TODO notify GUI of change of turns
        if (player1.isTurn())
        {
            player1.setTurn(false);
            player2.setTurn(true);
        }
        else if (player2.isTurn())
        {
            player2.setTurn(false);
            player1.setTurn(true);
            
        }
        if (!database.hasQuestions()) {
            endGame();
        }
        
    }
    
    public void playGame(Sector sector)
    {           
        if(statTracker.getNumberOfSpins() < 50)
        {
            statTracker.incrementSpins();
            performSectorOperation(sector);
        }     
        
    }
    
    public void performSectorOperation(Sector sector)
    {
        switch(sector.getType())
        {
            case LOSE_TURN:
            {
                break;
            }
            case BANKRUPT:
            {  
                break;
            }
            case OPP_CHOICE:
            {
                break;
            }
            case FREE_TURN:
            {
                if (player1.isTurn()) {
                    player1.incrementTokens();
                } else {
                    player2.incrementTokens();
                }
                break;
            }
            case SPIN_AGAIN:
            {
                break;
            }
            case PLAYER_CHOICE:
            {
                break;
            }
            case CATEGORY:
            {     
                break;
            }
            default:
            {
                //INVALID
            }
        }
        ui.updateInfo();
    }
    

    public void loseTurn()
    {
        boolean choice = ui.useFreeTokens();  
        if (!choice) {
            endTurn();
        }
    }
    
    public void bankrupt()
    {
        if (getCurPlayer().getName().equals("Player 1"))
        {
            statTracker.player1Score = 0;
        }
        else if (getCurPlayer().getName().equals("Player 2"))
        {
            statTracker.player2Score = 0; 
        }
        
        endTurn();
    }

    public void setCurrentQuestion(Question q) {
        curQuestion = q;
    }
    
    public Player getCurPlayer() {
       
        if (player1.isTurn()) {
            return player1;
        } else if (player2.isTurn()) {
            return player2;
        }
        return null;
    }
    
    public Player getOppositePlayer() {
       
        if (player1.isTurn()) {
            return player2;
        } else if (player2.isTurn()) {
            return player1;
        }
        return null;
    }
    
    public Player getPlayer1() {
        return player1;
    }
    
    public Player getPlayer2() {
        return player2;
    }
    
    public StatisticTracker getStats() {
        return statTracker;
    }
    
    public int getNumberOfSpins()
    {
        return statTracker.getNumberOfSpins();
    }
       
    public void playerUseToken(boolean useToken)
    {
        if (useToken)
        {
            getCurPlayer().useToken();
            
        }
        else
        {
            endTurn();
        }
        
    }
    
    public Question getCurQuestion() {
        return curQuestion;
    }
}

