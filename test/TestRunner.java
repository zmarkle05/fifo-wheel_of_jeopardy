package test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import test.ui.*;
import test.engine.*;
import test.database.*;

/**
 * This class manages the execution of the tests and compiles the results.
 *
 * @author zac
 */
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

		if (uiResults.wasSuccessful()) {
			System.out.println("- All UI tests passed!");
		}
		
		// Print Game Engine test failures
      		for (Failure failure : engineResults.getFailures()) {
        		System.out.println(failure.toString());
    		}

		if (engineResults.wasSuccessful()) {
			System.out.println("- All Game Engine tests passed!");
		}
		
		// Print Database test failures
      		for (Failure failure : dbResults.getFailures()) {
        		System.out.println(failure.toString());
    		}

		if (dbResults.wasSuccessful()) {
			System.out.println("- All Database tests passed!");
		}
		
   	}
}  
