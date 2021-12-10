package org.grouping;

import java.io.IOException;
import java.util.Date;

import org.junit.AfterClass;
import org.pojoclass.fbLoginPojo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.web.BaseClass;

public class Sample1 extends BaseClass {


	
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
	@Test(groups="Smoke")
	private void tc1() throws IOException, InterruptedException {
		fbLoginPojo f = new fbLoginPojo();
		fill(f.getTxtUser(), getData(5, 8));
		fill(f.getTxtpass(), getData(8, 4));
		btnClick(f.getBtnLogin());
		Thread.sleep(2000);
		
		
	}
	@Test(groups="Sanity")
	private void tc3() throws IOException, InterruptedException {
		fbLoginPojo f = new fbLoginPojo();
		fill(f.getTxtUser(),getData(6, 2));
		fill(f.getTxtpass(), getData(7, 3));
		btnClick(f.getBtnLogin());
		Thread.sleep(2000);

	}
	@Test(groups="Smoke")
	private void tc2() throws IOException, InterruptedException {
		fbLoginPojo f = new fbLoginPojo();
		fill(f.getTxtUser(), getData(4, 6));
		fill(f.getTxtpass(), getData(5, 6));
		btnClick(f.getBtnLogin());
		Thread.sleep(2000);
		}
	
	}
