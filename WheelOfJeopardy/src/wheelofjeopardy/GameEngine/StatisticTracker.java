/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wheelofjeopardy.GameEngine;

/**
 *
 * @author adam
 */
public class StatisticTracker 
{
    public static int player1Score;
    public static int player2Score;
    private static double answerTimer;
    private static int numberOfSpins;
    private static int currentRound;
    
    public StatisticTracker()
    {
        player1Score  = 0;
        player2Score  = 0;
        answerTimer   = 0.0;
        numberOfSpins = 0;
        currentRound  = 0;
                
    }
    
   public static void incrementScore(int playerNum)
   {
       if (playerNum == 1)
       {
           player1Score++;
       }
       else
       {
           player2Score++;
       }
       
   }
   
   public static void decrementScore(int playerNum)
   {
       if (playerNum == 1)
       {
           player1Score--;
       }
       else
       {
           player2Score++;
       }
       
   }
   
   public static void incrementTimer()
   {
       answerTimer++;
       
   }
   
   public static void incrementSpins()
   {
       numberOfSpins++;
       
   }
   
   public static int getPlayerScore(int playerNum)
   {
       if (playerNum == 1)
       {
           return player1Score;
       }
       else
       {
           return player2Score;
       }
   }
   
   public static int getNumberOfSpins()
   {
       return numberOfSpins;
   }
}


