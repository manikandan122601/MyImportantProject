package org.pojoclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.web.BaseClass;

public class fbLoginPojo extends BaseClass {
	
	public fbLoginPojo() {
		PageFactory.initElements(driver, this);
		
	}
	//2 Annotation and private webelement
	 
	@FindBys({
		
	@FindBy(id="email"),
	@FindBy(xpath="//input[@type='text']")
	})
	private WebElement txtUser;
	
	@FindBy(id="pass")
	private WebElement txtpass;
	
	@FindBy(xpath="//button[@name='login']")
	private WebElement btnLogin;

	public WebElement getTxtUser() {
		return txtUser;
	}

	public WebElement getTxtpass() {
		return txtpass;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}
	
}
