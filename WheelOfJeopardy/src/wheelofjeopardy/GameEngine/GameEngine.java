package wheelofjeopardy.GameEngine;

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
        

        player2 = new Player("Player 2", false);
        
        
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
            System.out.println("CORRECT ANSWER: " + correctAnswer);
            int pointValue = curQuestion.getPointValue();
                
            boolean isCorrect = userAnswer.toLowerCase().equals(correctAnswer.toLowerCase());
       
            if (isCorrect)
            {
                if (player1.isTurn())
                {
                    statTracker.incrementScore(1, curQuestion.getPointValue());
                    System.out.println("PLAYER 1: " + statTracker.player1Score);
                }
                else
                {
                    statTracker.incrementScore(2, curQuestion.getPointValue());            
                    System.out.println("PLAYER 2: " + statTracker.player2Score);
                }
           
                endTurn();
            }
            else if (player1.isTurn() && player1.getFreeTokens() > 0 && 
                     statTracker.getNumberOfSpins() != 50)
            {
                // TODO prompt user if they would like to use a token
                if (true) //player selected to use token
                {
                    endTurn();
                }
                else
                {
                    endTurn();
                }
            }
            else if (player2.isTurn() && player2.getFreeTokens() > 0 && 
                     statTracker.getNumberOfSpins() != 50)
            {
                // TODO prompt user if they would like to use a token
                if (true) //player selected to use token
                {
                     endTurn();
                }
                else
                {
                    endTurn();
                }
            } 
            else {
                endTurn();
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
            // TODO inform GUI to display winner
            System.out.println("Player1 won the game");
        }
        else if (player2Score > player1Score)
        {
            // TODO inform GUI to display winner
            System.out.println("Player2 won the game");
        }
        else
        {
            // TODO inform GUI to display Tie
            System.out.println("Tie Game");
        }
    }
    
    public void endTurn()
    {
        //TODO notify GUI of change of turns
        if (player1.isTurn())
        {
           System.out.println("player1 end turn");

            player1.setTurn(false);
            player2.setTurn(true);
        }
        else if (player2.isTurn())
        {
            System.out.println("player2 end turn");
            player2.setTurn(false);
            player1.setTurn(true);
            
        }
        else
        {
            System.out.println("maybe?");
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
                loseTurn();
                break;
            }
            case BANKRUPT:
            {  
                bankrupt();
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
        ui.updateInfo();
    }
    

    public void loseTurn()
    {
        if (getCurPlayer().getFreeTokens() > 0 && 
            statTracker.getNumberOfSpins() != 50)
        {
            // TODO prompt user if they would like to use a token
            if (true) //player selected to use token
            {
                getCurPlayer().useToken();
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
        if (getCurPlayer().getName().equals("Player 1"))
        {
            statTracker.player1Score = 0;
            // TODO DISPLAY TO GUI
        }
        else if (getCurPlayer().getName().equals("Player 2"))
        {
            statTracker.player2Score = 0; 
            // TODO DISPLAY TO GUI
        }
        
        endTurn();
    }

    public void setCurrentQuestion(Question q) {
        curQuestion = q;
    }
    
    public Player getCurPlayer() {
       
        if (player1.isTurn()) {
             System.out.println("cur - " + player1.getName());
            return player1;
        } else if (player2.isTurn()) {
            System.out.println("cur - " + player2.getName());

            return player2;
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
}

