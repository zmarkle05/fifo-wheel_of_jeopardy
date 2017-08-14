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
    
    public UserInterface()
    {
        // TODO pass categories to the wheel
        wheel = new Wheel();
        board = new GameBoard();
        infoDisplay = new InformationDisplay();
    }
    
    public Sector.SectorType spinWheel()
    {
        wheel.spin();
        
        return wheel.getCurrentSector().getType();
    }
    
}
