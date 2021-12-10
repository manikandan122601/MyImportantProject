package org.junit;



import java.io.IOException;
import java.util.Date;

import org.pojoclass.fbLoginPojo;
import org.web.BaseClass;

public class JUnitOrder extends BaseClass{
	
	@BeforeClass
	public static void launchingBrowser() {
		launchChrome();
		loadUrl("https://www.facebook.com");
		winMax();
		
	}
//	@AfterClass
//	public static void closingBrowser() {
//		closeChrome();
//	}
	@Before
	public void startTime() {
		Date d = new Date();
		System.out.println(d);
}
	@After
	public void endTime() {
		System.out.println(new Date());
	}
	@Test
	public void tc2() throws IOException {
		fbLoginPojo f = new fbLoginPojo();
		fill(f.getTxtUser(),getData(5, 2));

	}
//	@Ignore
	@Test
	public void tc1() {
		fbLoginPojo f = new fbLoginPojo();
		btnClick(f.getBtnLogin());

	}
	@Test
	public void tc3() throws IOException {
		fbLoginPojo f = new fbLoginPojo();
		fill(f.getTxtpass(),getData(8, 2));

	}
	
	
}