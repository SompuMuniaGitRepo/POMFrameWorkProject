package com.dd.pom.pagelayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.dd.crm.pom.baselayer.BaseTest;

public class LoginPage extends BaseTest {

	
	//Using Page Factory Concept - also known as creating Object Repository
	
		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//input[@type='submit' and @value='Login']")
		WebElement login_button;
		
		@FindBy(xpath="//button[contains(text(),'Sign Up')]")
		WebElement signupBtn;
		
		@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
		WebElement logo;
		
		
		// Initializing all the webelement of OR/ Page Factory
		public LoginPage() {
			PageFactory.initElements(driver, this);
			
		}
		
		//Actions
		public String validateLoginPageTitle() {
			return (driver.getTitle());
		}
		
		public boolean validateCRMlogo() {
			return logo.isDisplayed();
		}
		
		public AfterLoginHome validatelogin(String user, String pwd) {
			username.sendKeys(user);
			password.sendKeys(pwd);
			login_button.click();
			
			return new AfterLoginHome();
		}
}
