/*
 * 
 */
package wheelofjeopardy.UserInterface;

/**
 *
 * @author adam
 */
public class Sector 
{   
    public enum SectorType
    {
        SPIN_AGAIN, OPP_CHOICE, PLAYER_CHOICE, BANKRUPT,
        CATEGORY, FREE_TURN, LOSE_TURN  
    }
    
    private String name;
    private SectorType type;
    
    public Sector(SectorType type)
    {
        this.type = type;
    }
    
    public SectorType getType()
    {
        return type;
    }
    
    public String getName()
    {
        return name;
    }
    
}
