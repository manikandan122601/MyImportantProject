package org.web;

import org.excel.BaseMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import sun.launcher.resources.launcher;
import sun.launcher.resources.launcher_zh_CN;

public class WebBrowserLaunch extends BaseClass {
	
	
	public static void main(String[] args) {
		
		// Browser configuration
		
		launchChrome();;
		
		loadUrl("https://wwww.facebook.com/");
		
		winMax();
		
		printTitle();
		
		printCurrentUrl();
		
		WebElement txtuser = driver.findElement(By.id("email"));
		fill(txtuser, "mani");
		
		WebElement txtpass = driver.findElement(By.id("pass"));
		fill(txtpass, "mani123@");
		
		btnClick(txtpass);
		
		WebElement btnlogin = driver.findElement(By.xpath("//button[@name='login']"));
		
		btnClick(btnlogin);
	
		
		
		
		
		
	}

}
