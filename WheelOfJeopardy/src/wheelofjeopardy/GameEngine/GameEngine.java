/*
 *
 */
package wheelofjeopardy.GameEngine;

import wheelofjeopardy.GameEngine.Player;
import wheelofjeopardy.GameEngine.StatisticTracker;

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
    
    public GameEngine()
    {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        
        statTracker = new StatisticTracker();
    }

    public static boolean compareAnswer()
    {
       return false;
    }
    
    public static void endRound()
    {
        
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
    
    public static void performSectorOperation()
    {
        
    }
}
