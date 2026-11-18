package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactpage {
	WebDriver driver;
	public Contactpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Contact")
	private WebElement ContactLink;

	@FindBy(linkText = "ele3")
	private WebElement ele3;

	@FindBy(linkText = "ele2")
	private WebElement ele2;

	
	public WebElement getContactLink() {
		return ContactLink;
	}

	public WebElement ele3() {
		return ele3;
	}

	
	public WebElement ele2() {
		return ele2;
	}
	
	


}
