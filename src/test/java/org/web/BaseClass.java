package org.web;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.Action;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 
	public static Actions a;
	public static WebDriver driver;
	//1 launch chrome
	public static void launchChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	//2 getUrl
	public static void loadUrl(String url) {
		driver.get(url);
	}
	//3 maximise
	public static void winMax() {
		driver.manage().window().maximize();
	}
	
	//4 gettitle
	public static void printTitle() {
		System.out.println(driver.getTitle());
	}
	
	//5 getcurrenturl
	public static void printCurrentUrl() {
		System.out.println(driver.getCurrentUrl());
	}
	//6 sendkeys
	public static void fill(WebElement ele,String value) {
		ele.sendKeys(value);
	}
	//7 btnclick
	public static void btnClick(WebElement ele) {
		ele.click();
	}
	//8 quit
	public static void closeChrome() {
		driver.quit();
	}
	
	// actions class
	//9 movetoelement
    public static void moveElement(WebElement ele) {
    	a=new Actions(driver);
	    a.moveToElement(ele);
	}
    //10 draganddrop
	public static void drag(WebElement src,WebElement tar) {
		a=new Actions(driver);
	   a.dragAndDrop(src, tar);    	
	}
	//11 keyup
	public static void keykickup(WebElement ele, CharSequence key) {
		a=new Actions(driver);
		a.keyDown(ele, key).perform();
	   
	}  
	//12 keydown
	public static void keykickpress(WebElement ele,CharSequence key) {
		a=new Actions(driver);
		a.keyDown(ele, key).perform();
	}
	
	//13  doubleclick
	public static void twoClick(WebElement ele) {
		a=new Actions(driver);
		a.doubleClick(ele).perform();	
	}
	//14 rightclick      
    public static void rightclick(WebElement ele) {
    	a=new Actions(driver);
    	a.contextClick(ele).perform();
	}
    //15 sendkeys
    public static void fillData(WebElement ele,CharSequence value) {
    	a=new Actions(driver);
    	a.sendKeys(ele, value);
	}
    //16 click
    public static void click() {
    	a=new Actions(driver);
    	a.click().perform();
	}
    //Robot class
    //17 keypress enter
    public static void Enter() throws AWTException {
    	Robot r = new Robot();
    	r.keyPress(KeyEvent.VK_ENTER);
    	r.keyRelease(KeyEvent.VK_ENTER);
    }
    //18 keypress for cut
    public static void cut() throws AWTException {
    	Robot r = new Robot();
    	r.keyPress(KeyEvent.VK_CONTROL);
    	r.keyPress(KeyEvent.VK_X);
    	r.keyRelease(KeyEvent.VK_CONTROL);    	
    	r.keyRelease(KeyEvent.VK_X); 	
	}
    //19 keypress for copy
    public static void copy() throws AWTException {
    	Robot r = new Robot();
    	r.keyPress(KeyEvent.VK_CONTROL);    	
    	r.keyPress(KeyEvent.VK_C);
    	r.keyRelease(KeyEvent.VK_CONTROL);
    	r.keyRelease(KeyEvent.VK_C); 
	}
    //20 keypress for paste
    public static void paste() throws AWTException {
    	Robot r = new Robot();
    	r.keyPress(KeyEvent.VK_CONTROL);
    	r.keyPress(KeyEvent.VK_V);
    	r.keyRelease(KeyEvent.VK_CONTROL);
    	r.keyRelease(KeyEvent.VK_V);	
	}
    //21 keypress for paste
    public static void tab() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		
	}
   //22 Alert Simple Alert Accept
  	public static void alertOK() {
  		Alert a = driver.switchTo().alert();
  		a.accept();

  	}
  	
  	//23 Alert Confirm Alert Reject
  	public static void alertCancel() {
  		Alert a = driver.switchTo().alert();
  		a.dismiss();
  	}
  	
  	//24 Alert Prompt Alert SendKeys
  	public static void alertFill(String SendKeys) {
  		Alert a = driver.switchTo().alert();
  		System.out.println(a.getText());
  		a.sendKeys(SendKeys);
  		}
  	
  	// 25 ScreenShot
  	public static void screenshot(String name) throws IOException {
  		TakesScreenshot ts = (TakesScreenshot)driver;
  		File src = ts.getScreenshotAs(OutputType.FILE);
  		File dsc = new File("C:\\Users\\Asus\\eclipse-workspace\\Pract\\ScreenShot\\"+name+".png");
  		FileUtils.copyFile(src, dsc);
  	}
  			
  	
  	//26 java Script pass Value	
  	public static void jsFill(String SendKeys, WebElement ele) {
  		JavascriptExecutor js = (JavascriptExecutor)driver;
  		js.executeScript("arguments[0].setAttribute('value','"+SendKeys+"')", ele);
  		
  	}
  	
  	// 27 jsclick
  	public static void jsClick(WebElement ele) {
  		JavascriptExecutor js = (JavascriptExecutor)driver;
  		js.executeScript("arguments[0].click()", ele);
  	}
  	
  	// 28 jsScroll Top
  	public static void jsScrollTop(WebElement ele) {
  		JavascriptExecutor js = (JavascriptExecutor)driver;
  		js.executeScript("arguments[0].scrollIntoView(true)", ele);
  	}
  	
  	// 29 jsScroll Bottom
  	public static void jsScrollFoot(WebElement ele) {
  		JavascriptExecutor js = (JavascriptExecutor)driver;
  		js.executeScript("arguments[0].scrollIntoView(false)", ele);
  	}
    
  	public static Select s;
	//30 Single DropDown
	public static void ddSingValue(WebElement ele, String value) {
		s = new Select(ele);
		s.selectByValue(value);
	}
	//31 single DropDown Visible 
	public static void ddSingVisibleText(WebElement ele, String value) {
		s = new Select(ele);
		s.selectByValue(value);
	}
	//32 single dropdown Index
	public static void ddSingIndex(WebElement ele,int index) {
		s = new Select(ele);
		s.selectByIndex(index);
	}
	//33 isMultiple
	public static void multipleIs(WebElement element) {
		s = new Select(element);
		System.out.println(s.isMultiple());
	}
	//34 getOptions Select Class
	public static void allOption(WebElement element) {
		s = new Select(element);
		List<WebElement> list = s.getOptions();
		for (int i = 0; i < list.size(); i++) {
			WebElement eachOption = list.get(i);
			String string = eachOption.getText();
			System.out.println(string);
		}

	}
	
	
	//35 getAllSelectedOption
	public static void selectedOption(WebElement element) {
		s = new Select(element);
		List<WebElement> selectedOptions = s.getAllSelectedOptions();
		for (int i = 0; i < selectedOptions.size(); i++) {
			WebElement eachOp = selectedOptions.get(i);
			String text = eachOp.getText();
			System.out.println(text);
		}
	}
	
	//36 GetFirstSelectedOption
	public static void selectedFirstOption(WebElement element) {
		s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println("first Selected Option = "+ firstSelectedOption);
	}
	
	//37 Deselect By index posion
	public static void ddDeSelectIndex(WebElement ele, int index) {
		s = new Select(ele);
		s.deselectByIndex(index);
	}
	
	//38 Deselect By Value
	public static void ddDeSelectValue(WebElement ele, String value) {
		s = new Select(ele);
		s.deselectByValue(value);
	}
	
	//39 Deselect By Visible Text
	public static void ddDeSelectText(WebElement ele, String text) {
		s = new Select(ele);
		s.deselectByVisibleText(text);
	}
	
	//40 DeselectAll
	public static void ddDelectAll(WebElement element) {
		s = new Select(element);
		s.deselectAll();
	}
	
	//41 Switch to Frame Id
	public static void goFrameId(String Id) {
		driver.switchTo().frame(Id);
	}
	
	//42 Switch To Frame Name
	public static void goFrameName(String Name) {
		driver.switchTo().frame(Name);
	}
	
	//43 Switch To Frame WebElement
	public static void goFrameWebEle(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	//44 Switch To Frame Index Position
	public static void goFrameIndex(int Index) {
		driver.switchTo().frame(Index);
	}
	
	//45 Exit To  Previous Frame
	public static void preFrame() {
		driver.switchTo().parentFrame();
	}
	
	//46 Exit Frame To Html
	public static void exitFrame() {
		driver.switchTo().defaultContent();
	}
	
	//47 ForWord Page
	public static void forWard() {
		driver.navigate().forward();
	}
	
	//48 BackWard Page
	public static void backWard() {
		driver.navigate().back();
	}
	
	//49 Refresh your Page
		public static void reFresh() {
			driver.navigate().refresh();
		}
    
	//50 Read the Excell Sheet To Input Value and Data
		public static  String getData(int rowNumber, int cellNumber) throws IOException {
			File f = new File("C:\\Users\\Mani\\eclipse-workspace"
					+ "\\Sample\\ExcelBook\\SERVICE BLOCK -PSP HOSPITAL HEATLOAD ESTIMATION 107 Deg C.xlsx");
			
			FileInputStream fin = new FileInputStream(f);
			
			Workbook w = new XSSFWorkbook(fin);
			
			Sheet s = w.getSheet("SUMMARY");
			
			Row row = s.getRow(rowNumber);
			Cell cell = row.getCell(cellNumber);
			
			int cellType = cell.getCellType();
			
			String value = "";
			if (cellType == 1) {
				value = cell.getStringCellValue();			
			}else if (cellType == 0) {
				if (DateUtil.isCellInternalDateFormatted(cell)) {
					Date d = cell.getDateCellValue();
					
					SimpleDateFormat sim = new SimpleDateFormat("dd,MMMM,yyyy");
					value = sim.format(d);
					
				}else {
					double d = cell.getNumericCellValue();
					long l = (long) d;
					value = String.valueOf(l);
				}
			}
			return value;

		}
			
}
	

