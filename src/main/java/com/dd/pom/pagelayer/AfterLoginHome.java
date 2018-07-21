package com.dd.pom.pagelayer;

//import javax.swing.Action;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.dd.crm.pom.baselayer.BaseTest;

public class AfterLoginHome extends BaseTest {

	@FindBy(xpath="//*[contains(text(),'User: Naveen K')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement taskLink;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactlink;
	
	
	public AfterLoginHome() {
		PageFactory.initElements(driver, this);
	}
	
	public String testHomePageTitle() {
		String homePageTitle = driver.getTitle();
		return homePageTitle;
	}
	
	public boolean testHomePageUser() {
		driver.switchTo().frame("mainpanel");
		boolean user = usernameLabel.isDisplayed();
		return user;
	}
	
	public ContactsPage clickonContacts() {
		driver.switchTo().frame("mainpanel");
		contactsLink.click();
		return new ContactsPage();
		
	}
	
	public TaskPage clickonTasks() {
		taskLink.click();
		return new TaskPage();
		
	}
	
	public void clickOnNewContactsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactlink.click();
		
	}
	
	
	
}


