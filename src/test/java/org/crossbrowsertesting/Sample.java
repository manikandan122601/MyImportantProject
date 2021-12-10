package org.crossbrowsertesting;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.web.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {
	
	public WebDriver driver;
	
	@Parameters({"browser"})
	@Test
	private void tc1(String name) {

		if(name.equals("chrome")) {
			
			System.out.println("launch chrome");
			// steps to launch chrome
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if (name.equals("ff")) {
			
			System.out.println("launch firefox");
			// steps to launch ff
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else 
		{	
			System.out.println("launch Edge");
			// steps to launch edge
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
	} 
	
	// launch the url
	
	driver.get("https://www.facebook.com");
	driver.manage().window().maximize();
	driver.findElement(By.id("mail")).sendKeys("Greens");
	driver.findElement(By.id("pass")).sendKeys("Greens");
	
	}	
	 
	
}
	
	
	
	
	


