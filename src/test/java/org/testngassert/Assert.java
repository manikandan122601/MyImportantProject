package org.testngassert;

import java.io.IOException;
import java.util.Date;

import org.dataprovider.DataForLogin;
import org.jsoup.select.Evaluator.ContainsData;
import org.junit.AfterClass;
import org.pojoclass.fbLoginPojo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.web.BaseClass;

public class Assert extends BaseClass {
	
	@BeforeClass
	private void launchingChrome() {
		launchChrome();
		
		winMax();

	}

	@AfterClass
	private void closingChrome() {
		closeChrome();

	} 
	@BeforeMethod
	private void starTime() {
		System.out.println(new Date());
		loadUrl("https:www.facebook.com");

	}
	@AfterMethod
	private void endTime() {
		System.out.println(new Date());
	}
//	@Test(priority=3,enabled=true)
//	private void tc1() throws IOException, InterruptedException {
//		fbLoginPojo f = new fbLoginPojo();
//		fill(f.getTxtUser(), getData(5, 8));
//		fill(f.getTxtpass(), getData(8, 4));
//		btnClick(f.getBtnLogin());
//		Thread.sleep(2000);
//		
//		
//	}
//	@Test(priority=-10,enabled=true)
//	private void tc3() throws IOException, InterruptedException {
//		fbLoginPojo f = new fbLoginPojo();
//		fill(f.getTxtUser(),getData(6, 2));
//		fill(f.getTxtpass(), getData(7, 3));
//		btnClick(f.getBtnLogin());
//		Thread.sleep(2000);
//
//	}
	@Test(dataProvider="fblogin", dataProviderClass=DataForLogin.class)
	private void tc2(String s1,String s2) throws IOException, InterruptedException {
		fbLoginPojo f = new fbLoginPojo();
		// Soft Assert
		String title = driver.getTitle();
		SoftAssert s = new SoftAssert();
		s.assertTrue(title.contains("facebook"), "please check the title");
		fill(f.getTxtUser(), s1);
		fill(f.getTxtpass(), s2);
		btnClick(f.getBtnLogin());
		Thread.sleep(2000);
		System.out.println("checking");
		s.assertAll();
		
		}

}






