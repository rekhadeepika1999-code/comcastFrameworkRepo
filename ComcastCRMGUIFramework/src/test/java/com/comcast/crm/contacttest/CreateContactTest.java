package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.OrganizationPage;
import com.comcast.crm.ObjectRepository.createNewOrganizationPage;
import com.comcast.crm.basetest.BaseClass;

import CreateNewContactPage.CreateNewContactPage;
import contactPage.ContactPage;
import junit.framework.Assert;

/*
 * 
 * @author Deepika
 * 
 */
//Test case : 4
//Navigate to application
//Login to application
//Place the mouse cursor and click on "contact" link
//Navigate to "Create new contact" page by click on "+" image
//Create a contact without mandatory fields and save 
//logout
public class CreateContactTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createContactTest() throws Throwable {

//	    	//Generate the Random Number
//	    	Random random = new Random();
//	    	int randomInt = random.nextInt(1000);
//	    	//Read testscript data from Excel file
//	    	FileInputStream fis1 = new FileInputStream("./testdata/testscriptdata.xlsx");
//	    	Workbook wb = WorkbookFactory.create(fis1);
//	    	Sheet sh = wb.getSheet("contact");
//	    	Row row = sh.getRow(1);

		/* Read testscript data from Excel file */
		String lastName = eLib.getDataFromExcel("Contact", 0, 0) + jLib.getRandomNumber();
		System.out.println(lastName);
		// wb.close();

		// step 2: navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();

		// driver.findElement(By.linkText("Contacts")).click();

		// step 3: Click on "create organization" button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactBtn().click();

		// driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		// Step 4:Enter all the details & create new Contact
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.getLastname().sendKeys(lastName);
		ccp.getSave().click();
//	    	driver.findElement(By.name("lastname")).sendKeys(lastName);
//	    	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verify Header
//			String actHeader = driver.findElement(By.className("dvHeaderText")).getText();
//			if(actHeader.equals(lastName)) {
//				System.out.println(lastName + "Header is verified==PASS");
//			}else {
//				System.out.println(lastName + "Header is not verified==FAIL");
//			}
		// Verify Header phone Number info Expected Result
		String actHeader = cp.getHeaderMsg().getText();
		boolean status = actHeader.contains(lastName);
		Assert.assertEquals(status, true);

		// Verify lastname info Expected Result
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
//			if (actLastName.equals(lastName)) {
//				System.out.println(lastName + " information is verified==PASS");
//			} else {
//				System.out.println(lastName + " information is not verified==FAIL");
//			}
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName, lastName);
		soft.assertAll();

	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDateTest() throws Throwable {
		// read testscript data from Excel file
		String lastName = eLib.getDataFromExcel("Contact", 0, 0) + jLib.getRandomNumber();

		// Step 2: navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getContactlnk().click();

		// Step 3: Click on "create contact" button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactBtn().click();

		// Step 4 : Enter all the details & create new contact
		
		String reqDate = jLib.getRequiredDateYYYYDDMM(30);
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		
		ccp.getLastname().sendKeys(lastName);
		ccp.getEnddate().sendKeys(reqDate);
ccp.getSave().click();
		// Verify Header phone Number info Expected Result
//		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
//		if (actStartDate.equals(startDate)) {
//			System.out.println(startDate + " information is verified==PASS");
//		} else {
//			System.out.println(startDate + " information is not verified==FAIL");
//		}
//					ContactsInfoPage cip = new ContactsInfoPage(driver);
//					String actStartDate = cip.getSupportStartDateInfo().getText();
//					Assert.assertEquals(actStartDate.trim(),startDate);

		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actEndDate.equals(reqDate)) {
			System.out.println(reqDate + " information is verified==PASS");
		} else {
			System.out.println(reqDate + " information is not verified==FAIL");
		}
//					String actendDate = cip.getSupportEndDateInfo().getText();
//					Assert.assertEquals(actendDate.trim(), endDate);
//			    	//Step 5:logout
//			    	driver.quit();
	}

	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws Throwable {
		WebDriver driver = null;

		// Read testScript data from Excel file
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String contactLastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();

		// Step 2: navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3 : click on "create organization" button
		OrganizationPage cnp = new OrganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// Step 4: Enter all the details & create new organization
		createNewOrganizationPage cnop = new createNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		// Step 5: navigate to Contact module
		hp.getContactlnk().click();

		// Step 6: Click on "create contact" button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContactBtn().click();

		// Step 7 :Enter all the details & create new Contact
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContactwithOrg(contactLastName, orgName);

		// Verify Header orgName info Expected Result
		String actOrgName = driver.findElement(By.id("mouseArea-organizationName")).getText();
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " information is created==PASS");
		} else {
			System.out.println(orgName + " information is not created==FAIL");
		}
//			String actOrgName = driver.findElement(By.id("mouseArea-organizationName")).getText();
//			actOrgName = oip.getOrgNameInfo().getText();
//			Assert.assertEquals(actOrgName.trim(),orgName);
	}
}
