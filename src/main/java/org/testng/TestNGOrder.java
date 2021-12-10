package org.testng;

import java.util.Date;

import org.pojoclass.fbLoginPojo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.web.BaseClass;

public class TestNGOrder extends BaseClass {
	
	@BeforeClass
	private void LaunchingChrome() {
		launchChrome();
		loadUrl("https://www.facebook.com");
		winMax();
		printTitle();
		printCurrentUrl();
	}
	@AfterClass
	private void ClosigChrome() {
		closeChrome();
	}
	@BeforeMethod
	private void StartTime() {
		System.out.println(new Date());
	}
	@AfterMethod
	private void endtime() {
		System.out.println(new Date());
	}
	@Test
	private void tc3() {
		fbLoginPojo f = new fbLoginPojo();
		btnClick(f.getBtnLogin());
	}
	@Test
	private void tc1() {
		fbLoginPojo f = new fbLoginPojo();
		fill(f.getTxtUser(), "mani");
	}
	@Test
	private void tc2() {
		fbLoginPojo f = new fbLoginPojo();
		fill(f.getTxtpass(), "mani123@");
	}
		

}
