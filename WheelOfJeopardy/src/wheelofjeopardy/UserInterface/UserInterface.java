/*
 * 
 */
package wheelofjeopardy.UserInterface;

/**
 *
 * @author adam
 */
public class UserInterface {
    
    private static Wheel wheel;
    private static GameBoard board;
    private static InformationDisplay infoDisplay;
    
    public UserInterface(String[] catNames)
    {
        // TODO pass categories to the wheel
        wheel = new Wheel(catNames);
        board = new GameBoard();
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
