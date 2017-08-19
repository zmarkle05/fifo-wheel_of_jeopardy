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
    public int player1Score;
    public int player2Score;
    public int player1TotScore;
    public int player2TotScore;
    private double answerTimer;
    private int numberOfSpins;
    private int currentRound;
    
    public StatisticTracker()
    {
        player1Score  = 0;
        player2Score  = 0;
        answerTimer   = 0.0;
        numberOfSpins = 0;
        currentRound  = 1;
                
    }
    
   public void incrementScore(int playerNum)
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
   
   public void decrementScore(int playerNum)
   {
       if (playerNum == 1)
       {
           player1Score--;
       }
       else
       {
           player2Score--;
       }
       
   }
   
   public void incrementTimer()
   {
       answerTimer++;
       
   }
   
   public void incrementSpins()
   {
       numberOfSpins++;
       
   }
   
   public int getPlayerScore(int playerNum)
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
   
   public int getNumberOfSpins()
   {
       return numberOfSpins;
   }
   
   public void incrementRound()
   {
       currentRound++;
   }
   
   public int getRound()
   {
       return currentRound;
   }
   
   public void reset()
   {
       
   }
}

