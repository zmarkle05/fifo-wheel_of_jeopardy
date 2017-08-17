/*
 *
 */
package wheelofjeopardy.UserInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 *
 * @author adam
 */
public class Wheel 
{
    
    private int currentSector;
    List<Sector> gameSectors = new ArrayList<>();
    
    public Wheel(String [] catNames)
    {
        // Create Six non-category sectors
        gameSectors.add(new Sector(Sector.SectorType.SPIN_AGAIN,    "SPIN AGAIN"));
        gameSectors.add(new Sector(Sector.SectorType.OPP_CHOICE,    "OPPONENT'S CHOICE"));
        gameSectors.add(new Sector(Sector.SectorType.PLAYER_CHOICE, "PLAYER'S CHOICE" ));
        gameSectors.add(new Sector(Sector.SectorType.BANKRUPT,      "BANKRUPT"));
        gameSectors.add(new Sector(Sector.SectorType.FREE_TURN,     "FREE TURN"));
        gameSectors.add(new Sector(Sector.SectorType.LOSE_TURN,     "LOSE TURN"));
        
        // Create Six Category sectors
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[0]));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[1]));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[2]));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[3]));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[4]));
        gameSectors.add(new Sector(Sector.SectorType.CATEGORY, catNames[5]));
        
        // randomize order of Sectors
        Collections.shuffle(gameSectors);
    }
    
    public Sector getCurrentSector()
    {
        return gameSectors.get(currentSector);
    }
    
    public String getCurrSectorName()
    {
        return gameSectors.get(currentSector).getName();
    }
    
    public void spin()
    {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(gameSectors.size());
        currentSector = index;
        // todo and animate the spinning
        
    }
}
