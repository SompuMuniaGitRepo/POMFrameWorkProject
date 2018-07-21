package com.dd.pom.pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.dd.crm.pom.baselayer.BaseTest;

public class ContactsPage  extends BaseTest{

	 @FindBy(xpath="//td[@class='datacardtitle']//*[contains(text(),'Contacts')]")
	 WebElement contactsLabel;
	 
	 @FindBy(xpath="//a[@title='Export']")
	 WebElement exportLinksideMenu;
	 
//	 @FindBy(xpath="//a[contains(text(),'chinna reddy')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@value='52233767']")
//	 WebElement checkContact;
	 
//	 @FindBy(xpath="//*[@id=\"vContactsForm\"]/table/tbody/tr[20]/td[2]/a")
	 
	 @FindBy(id="first_name")
	 WebElement first;
	 
	 @FindBy(id="surname")
	 WebElement last;
	 
	 @FindBy(name="client_lookup")
	 WebElement comp;
	 
	 @FindBy(xpath="//input[@value='Load From Company']//following-sibling::input[@value='Save']")
	 WebElement saveBtn;
	 
	 
	 public ContactsPage () {
		 PageFactory.initElements(driver, this);
	 }
	 
	 
	 public void checkContactsLabel() {
		 Assert.assertEquals(contactsLabel, "Contacts");
		 
	 }
	 
	 public void checkExportLink() {
		 Assert.assertEquals(exportLinksideMenu, "Export");
	 }
	 
	 public void selectContactfromTable(String name) {
		 WebElement checkContact = driver.findElement(By.xpath("//a[contains(text(),'" +name+"')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@value='52233767']"));
		 checkContact.click();
	 }
	 
	 public void createNewContact(String title,String fname, String lname, String company) {
		 Select select = new Select(driver.findElement(By.name("title")));
		 select.selectByVisibleText(title);
		 first.sendKeys(fname);
		 last.sendKeys(lname);
		 comp.sendKeys(company);
		 
		 saveBtn.click();
		 System.out.println("New contact has been saved");
	 }
}
