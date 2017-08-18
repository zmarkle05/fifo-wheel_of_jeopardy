/*
 *
 */
package wheelofjeopardy.GameEngine;

import wheelofjeopardy.UserInterface.*;
import wheelofjeopardy.Database.Database;
import wheelofjeopardy.Database.Question;
import wheelofjeopardy.Database.Category;

/**
 *
 * @author adam
 */
public class GameEngine 
{
        
    public static int questionsLeft;
    private Player player1;
    private Player player2;
    private Question curQuestion;
    public  StatisticTracker statTracker;
    private final Database database;
    private UserInterface ui;
    
    public GameEngine(Database database, UserInterface ui)
    {
        player1 = new Player("Player 1", true);
        System.out.println(player1.getName());

        player2 = new Player("Player 2", false);
        System.out.println(player1.getName());
        
        statTracker = new StatisticTracker();
        this.database = database;
        this.ui = ui;
    }

    public boolean compareAnswer(String userAnswer)
    {   
        String correctAnswer = curQuestion.getAnswer();
       
        int pointValue = curQuestion.getPointValue();

        boolean isCorrect = userAnswer.toLowerCase().equals(correctAnswer.toLowerCase());

        if (isCorrect) {
            if (getCurrentPlayer().getName().equals("Player 1")) {
                statTracker.player1Score = statTracker.player1Score + pointValue;
            } else {
                statTracker.player2Score = statTracker.player2Score + pointValue;
            }
            endTurn();
            
            return true;
        } 
        
        return false;
    }
    
    public void playerUseToken(boolean useToken)
    {
        if (useToken)
        {
            getCurrentPlayer().useToken();
        }
        else
        {
            endTurn();
        }
        
    }

    public String endGame()
    {
        int player1Score = statTracker.getPlayerScore(1);
        int player2Score = statTracker.getPlayerScore(2);
        if (player1Score > player2Score)
        {
            return player1.getName();
        }
        else if (player2Score > player1Score)
        {
            return player2.getName();
        }
        else
        {
            return "TIE";
        }
    }
    
    public void endTurn()
    {
        if (player1.isTurn())
        {
            player1.setTurn(false);
            player2.setTurn(true);
        }
        else if (player2.isTurn())
        {
            player1.setTurn(true);
            player2.setTurn(false);
        }
        else
        {
            //shouldn't happen
        }
    }
    
    public void declareWinner()
    {
        
    }
    
    public void playGame(Sector sector)
    {           
        if(statTracker.getNumberOfSpins() < 50)
        {
            // player whose turn it is spins the wheel
            // This function should prompt the user to click Spin button
            statTracker.incrementSpins();
            performSectorOperation(sector);
            
        }     
        else
        {
            endGame();
        }
    }
    
    public void performSectorOperation(Sector sector)
    {
        switch(sector.getType())
        {
            case LOSE_TURN:
            {
                // Set opposite player's turn to true but give player option to use
                // free token if they have any first
               // loseTurn();
                break;
            }
            case BANKRUPT:
            {
               //  bankrupt();
                 break;
            }
            case OPP_CHOICE:
            {
                // allow other play to choose a category
                // TODO send message to GUI notifying opponent player to choose
               // System.out.println("Opponent Player Choose Category");
               // String category = "";
               // compareAnswer(category);
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
                 // player should be promted to spin again from GUI
                break;
            }
            case PLAYER_CHOICE:
            {
                  // player can choose any category
                // TODO send message to GUI notifying player to choose
                String category = "";
               // compareAnswer(category);
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
    }
    

    public void loseTurn()
    {
        if (getCurrentPlayer().getFreeTokens() > 0 && 
            statTracker.getNumberOfSpins() != 50)
        {
            // TODO prompt user if they would like to use a token
            if (true) //player selected to use token
            {
                getCurrentPlayer().useToken();
            }
            else
            {
                endTurn();
            }
        }
        else
        {
            endTurn();
        }
    }
    
    public void bankrupt()
    {
        if (getCurrentPlayer().getName().equals("Player 1"))
        {
            statTracker.player1Score = 0;
            // TODO DISPLAY TO GUI
        }
        else if (getCurrentPlayer().getName().equals("Player 2"))
        {
            statTracker.player2Score = 0; 
            // TODO DISPLAY TO GUI
        }
        
        endTurn();
    }

    public void setCurrentQuestion(Question q) {
        curQuestion = q;
    }
    
    public Player getCurrentPlayer()
    {
        if (player1.isTurn())
        {
            return player1;
        }
        else
        {
            return player2;
        }
    }
    
      public int getNumberOfSpins()
    {
        return statTracker.getNumberOfSpins();
    }
}
