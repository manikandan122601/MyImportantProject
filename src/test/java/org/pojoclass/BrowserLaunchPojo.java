package org.pojoclass;

import org.web.BaseClass;

public class BrowserLaunchPojo extends BaseClass {
	public static void main(String[] args) {
		launchChrome();
		winMax();
		loadUrl("https://www.facebook.com");
		printTitle();
		printCurrentUrl();
		fbLoginPojo p = new fbLoginPojo();
		String data = "mani";
		String data1 = "mani123";
		fill(p.getTxtUser(), data);
		fill(p.getTxtpass(), data1);             
		btnClick(p.getBtnLogin());
		
	}

}
