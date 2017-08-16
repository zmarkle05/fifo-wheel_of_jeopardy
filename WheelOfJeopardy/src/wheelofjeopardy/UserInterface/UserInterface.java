/*
 * 
 */
package wheelofjeopardy.UserInterface;

import java.util.ArrayList;
import wheelofjeopardy.Database.Database;

/**
 *
 * @author adam
 */
public class UserInterface {
    
    private static Wheel wheel;
    private static GameBoard board;
    private static InformationDisplay infoDisplay;
    
    public UserInterface(Database db)
    {
        // TODO pass categories to the wheel
        wheel = new Wheel(db.getCategories());
        board = new GameBoard(db);
        infoDisplay = new InformationDisplay();
    }
    
    public Sector.SectorType spinWheel()
    {
        wheel.spin();
        
        return wheel.getCurrentSector().getType();
    }
    
    public String retrieveSectorName()
    {
        return wheel.getCurrSectorName();
    }
    
}
