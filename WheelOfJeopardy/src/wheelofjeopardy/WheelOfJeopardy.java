/*
 * 
 */
package wheelofjeopardy;

import wheelofjeopardy.Database.Database;
import wheelofjeopardy.GameEngine.GameEngine;
import wheelofjeopardy.UserInterface.UserInterface;

/**
 *
 * @author adam
 */
public class WheelOfJeopardy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database database = new Database("./database.csv");
        
        UserInterface userInterface = new UserInterface(database);
    }
    
}
