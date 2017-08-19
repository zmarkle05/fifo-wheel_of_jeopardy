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
    private String  name;
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
    
    public void useToken()
    {
        System.out.println(numFreeTokens);
        numFreeTokens = numFreeTokens -1;
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

