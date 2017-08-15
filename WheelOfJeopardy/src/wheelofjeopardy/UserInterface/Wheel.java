/*
 *
 */
package wheelofjeopardy.UserInterface;

import java.util.*;
/**
 *
 * @author adam
 */
public class Wheel 
{
    
    private int currentSector;
    List<Sector> gameSectors = new ArrayList<>();
    
    public Wheel()
    {
        // Create Six non-category sectors
        gameSectors.add(new Sector(Sector.SectorType.SPIN_AGAIN));
        gameSectors.add(new Sector(Sector.SectorType.OPP_CHOICE));
        gameSectors.add(new Sector(Sector.SectorType.PLAYER_CHOICE));
        gameSectors.add(new Sector(Sector.SectorType.BANKRUPT));
        gameSectors.add(new Sector(Sector.SectorType.FREE_TURN));
        gameSectors.add(new Sector(Sector.SectorType.LOSE_TURN));
        
        // Create Six Category sectors
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY));
        
        // randomize order of Sectors
        Collections.shuffle(gameSectors);
    }
    
    public Sector getCurrentSector()
    {
        return gameSectors.get(currentSector);
    }
    
    public void spin()
    {
        // todo and animate the spinning
        
    }
}
