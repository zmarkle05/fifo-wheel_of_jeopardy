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
public class Player 
{
    private static String  name;
    private boolean isTurn;
    private int     numFreeTokens;
    
    public Player(String playerName, boolean isTurn)
    {
        this.name = playerName;
        this.isTurn = isTurn;
        this.numFreeTokens = 0;
    }
    
    public boolean isTurn()
    {
        return isTurn;
    }
    
    public boolean useToken()
    {
        if (numFreeTokens == 0)
        {
            return false;
        }
        else
        {
            numFreeTokens--;
            return true;
        }
    }
    
    public void spinWheel()
    {
        
    }
    
    public void answerQuestion()
    {
        
    }
    
    public void chooseCategory()
    {
        
    }
    
    public void setTurn(boolean changeTurn)
    {
        isTurn = changeTurn;
    }
    
    public boolean turnFlag()
    {
        return isTurn;
    }
    
    public int getFreeTokens()
    {
        return numFreeTokens;
    }
    
    public void incrementTokens()
    {
        numFreeTokens++;
    }
    
    public String getName()
    {
        return name;
    }
    
}
