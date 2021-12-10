package org.dataprovider;

import org.testng.annotations.DataProvider;

public class DataForLogin {
	
	@DataProvider(name="fblogin")
	public Object[][] gettingData() {
		
		return new Object[][] {
			
			{"sql","sql@123"},
			{"java","java@123"},
			{"selenium","selenium@123"},
			{"phython","phython@123"},
						
		};
				
	}
	
}
