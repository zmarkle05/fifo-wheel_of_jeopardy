/*
 *
 */
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
    private static Player player1;
    private static Player player2;
    private static Player currPlayer;
    public  static StatisticTracker statTracker;
    
   // public  Controller controller;
    public  UserInterface userInterface;
    public  Database      database;
    
    public GameEngine()
    {
        player1 = new Player("Player 1", true);
        player2 = new Player("Player 2", false);
        
        currPlayer = player1;
        
        statTracker = new StatisticTracker();
        
        database = new Database("./database.csv");
        
        userInterface = new UserInterface(database);
    }

    public void compareAnswer(String category, String userAnswer)
    {
        Question question = database.getQuestion(category);
        
        if (question != null)
        {
                
            String correctAnswer = question.getAnswer();
        
            int pointValue = question.getPointValue();
                
            boolean isCorrect = userAnswer.toLowerCase().equals(correctAnswer.toLowerCase());
       
            if (isCorrect)
            {
                if (currPlayer.getName().equals("Player 1"))
                {
                    statTracker.player1Score = statTracker.player1Score  + pointValue;
                }
                else
                {
                    statTracker.player2Score = statTracker.player2Score  + pointValue;
                }
           
                endTurn();
            }
            else if (currPlayer.getFreeTokens() > 0 && 
                     statTracker.getNumberOfSpins() != 50)
            {
                // TODO prompt user if they would like to use a token
                if (true) //player selected to use token
                {
                    currPlayer.useToken();
                }
                else
                {
                    endTurn();
                }
            }
        }
        else
        {
            // how should we handle categories that run out of questions?
        }
    }
    
    public void endRound()
    {
        if (statTracker.getRound() == 1)
        {
            statTracker.incrementRound();
            playGame();
        }
        else
        {
            endGame();
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
    
    public static void endTurn()
    {
        
        //TODO notify GUI of change of turns
        if (currPlayer.getName().equals("Player 1"))
        {
            currPlayer = player2;
        }
        else if (currPlayer.getName().equals("Player 2"))
        {
             currPlayer = player1;       
        }
        else
        {
            //shouldn't happen
        }
    }
    
    public static void declareWinner()
    {
        
    }
    
    public void playGame()
    {           
        if(statTracker.getNumberOfSpins() < 50)
        {
            // player whose turn it is spins the wheel
            // This function should prompt the user to click Spin button
            Sector.SectorType sector = userInterface.retrieveCurrentSector();
            statTracker.incrementSpins();
            performSectorOperation(sector);
            
        }     
        else
        {
            endRound();
        }
    }
    
    public void performSectorOperation(Sector.SectorType sector)
    {
        System.out.println("Sector: " + sector.toString());
        switch(sector)
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
                System.out.println("Opponent Player Choose Category");
                String category   = ""; //userInterface.getCategory();
                String userAnswer = ""; //userInterface.getUserAnswer();
                compareAnswer(category, userAnswer );
                break;
            }
            case FREE_TURN:
            {
                currPlayer.incrementTokens();
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
                //should be certain category, grab category name and display question
                // to the player
                //grab category name
                String sectorName = userInterface.retrieveSectorName();
              // compareAnswer(sectorName);
                break;
            }
            default:
            {
                //INVALID
            }
        }
        
        playGame();
    }
    
    public void loseTurn()
    {
        if (currPlayer.getFreeTokens() > 0 && 
            statTracker.getNumberOfSpins() != 50)
        {
            // TODO prompt user if they would like to use a token
            if (true) //player selected to use token
            {
                currPlayer.useToken();
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
        if (currPlayer.getName().equals("Player 1"))
        {
            statTracker.player1Score = 0;
            // TODO DISPLAY TO GUI
        }
        else if (currPlayer.getName().equals("Player 2"))
        {
            statTracker.player2Score = 0; 
            // TODO DISPLAY TO GUI
        }
        
        endTurn();
    }

}
