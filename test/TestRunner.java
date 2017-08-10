import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import ui.*;
import engine.*;
import database.*;

public class TestRunner {
   	public static void main(String[] args) {
      		Result uiResults = JUnitCore.runClasses(TestWheel.class, 
							TestSector.class, 
							TestAnswerBox.class, 
							TestGameBoard.class, 
							TestSquares.class, 
      							TestInformationDisplay.class);

      		Result engineResults = JUnitCore.runClasses(TestGameEngine.class, 
							TestPlayer.class, 
							TestStatisticTracker.class);

      		Result dbResults = JUnitCore.runClasses(TestDatabase.class, 
							TestQuestion.class);

		// Print UI test failures
      		for (Failure failure : uiResults.getFailures()) {
        		System.out.println(failure.toString());
    		}
		
		// Print Game Engine test failures
      		for (Failure failure : engineResults.getFailures()) {
        		System.out.println(failure.toString());
    		}
		
		// Print Database test failures
      		for (Failure failure : dbResults.getFailures()) {
        		System.out.println(failure.toString());
    		}
		
		//System.out.println(result.wasSuccessful());
   	}
}  
