package org.rerunconcept;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Failed implements IRetryAnalyzer {
	 
	int min=0; int max=3;
	
	public boolean retry(ITestResult result) {
		 // 3<3 f
		if (min<max) {
		
		min++;
		return true;
	}
		
		return false;

}

	
}	