/*
 *
 */
package wheelofjeopardy.GameEngine;

import wheelofjeopardy.UserInterface.*;

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
    public  UserInterface userInterface;  
    
    public GameEngine()
    {
        player1 = new Player("Player 1", true);
        player2 = new Player("Player 2", false);
        
        currPlayer = player1;
        
        statTracker = new StatisticTracker();
        
        userInterface = new UserInterface();
    }

    public static boolean compareAnswer()
    {
       return false;
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
    
    public static void endGame()
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
            Sector.SectorType sector = userInterface.spinWheel();
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
        switch(sector)
        {
            case LOSE_TURN:
            {
                // Set opposite player's turn to true but give player option to use
                // free token if they have any first
                loseTurn();
            }
            case BANKRUPT:
            {
                 bankrupt();
            }
            case OPP_CHOICE:
            {
                // allow other play to choose a category
            }
            case FREE_TURN:
            {
                currPlayer.incrementTokens();
            }
            case SPIN_AGAIN:
            {
                 // player should be promted to spin again from GUI
                playGame();
            }
            case PLAYER_CHOICE:
            {
                  // player can choose any category
            }
            case CATEGORY:
            {
                //should be certain category, grab category name and display question
                // to the player
            }
            default:
            {
                //INVALID
            }
        }      
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
                playGame();
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
