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
    public  static StatisticTracker statTracker;
    public  UserInterface userInterface;  
    
    public GameEngine()
    {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        
        statTracker = new StatisticTracker();
        
        userInterface = new UserInterface();
    }

    public static boolean compareAnswer()
    {
       return false;
    }
    
    public static void endRound()
    {
        statTracker.incrementRound(); 
    }
    
    public static void endGame()
    {
        
    }
    
    public static void endTurn()
    {
        
    }
    
    public static void declareWinner()
    {
        
    }
    
    public void startGame()
    {
        //player2s turn is initialized to false when player2 is initialized
        player1.setTurn(true);
        
        // player 1 spins the wheel
        Sector.SectorType sector = userInterface.spinWheel();
        
        performSectorOperation(sector);
        
    }
    
    public void performSectorOperation(Sector.SectorType sector)
    {
        // TODO REPLACE IFs with switch
        if (sector == Sector.SectorType.LOSE_TURN)
        {
          // Set opposite player's turn to true but give player option to use
          // free token if they have any first
        }
        else if (sector == Sector.SectorType.BANKRUPT)
        {
            // remove all of the player's points and they lose their turn
        }
        else if (sector == Sector.SectorType.OPP_CHOICE)
        {
            // allow other play to choose a category
        }
        else if (sector == Sector.SectorType.FREE_TURN)
        {
            // increment current player's free tokens by one
        }
        else if (sector == Sector.SectorType.SPIN_AGAIN)
        {
            // player should be promted to spin again
        }
        else if (sector == Sector.SectorType.PLAYER_CHOICE)
        {
            // player can choose any category
        }
        else
        {
            //should be certain category, grab category name and display question
            // to the player
        }
            
        
    }
}
