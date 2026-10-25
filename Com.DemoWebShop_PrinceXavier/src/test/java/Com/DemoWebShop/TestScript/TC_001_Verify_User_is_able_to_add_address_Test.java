package Com.DemoWebShop.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.DemoWebShop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.AddNewAddress_Page;
import Com.DemoWebShop_POM.Addresses_Page;

public class TC_001_Verify_User_is_able_to_add_address_Test extends BaseTest{
	
	@Test
	
	public void addAddress() throws EncryptedDocumentException, IOException, InterruptedException {
		System.out.println("Add Address Test Script");
		
		webDriverUtility.javaScripScrollTillElement(driver, homePage.getAddressesBtn());
		homePage.getAddressesBtn().click();
		
		//Need to create Object for new Page
		Addresses_Page addressesPage = new Addresses_Page(driver);
		addressesPage.getAddNewAddressBtn().click();
		
		
		//Created Object for new Page
		AddNewAddress_Page newAddressPage = new AddNewAddress_Page(driver);
		newAddressPage.getFirstNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 0));
		newAddressPage.getLastNameTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 1));
		newAddressPage.getEmailTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 2));
		
		//Dropdown
		webDriverUtility.selectByVisibleText(newAddressPage.getCountryDropDown(), 
				fileUtility.readDataFromExcelFile("Sheet1", 1, 3));
		
		newAddressPage.getCityTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 4));
		newAddressPage.getAddress1TextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 5));
		newAddressPage.getZipCodeTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 6));
		newAddressPage.getPhoneNumberTextField().sendKeys(fileUtility.readDataFromExcelFile("Sheet1", 1, 7));
		newAddressPage.getSaveBtn().click();
		
		//Screenshot
		webDriverUtility.webPageScreenShot(driver);
		
		Thread.sleep(3000);
		
		
	}

}
