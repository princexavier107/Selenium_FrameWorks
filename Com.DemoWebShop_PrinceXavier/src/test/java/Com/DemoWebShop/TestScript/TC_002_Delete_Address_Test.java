package Com.DemoWebShop.TestScript;

import java.io.IOException;

import org.testng.annotations.Test;

import Com.DemoWebShop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.Addresses_Page;

public class TC_002_Delete_Address_Test extends BaseTest{
	@Test
	public void deleteAddress() throws IOException, InterruptedException {
		System.out.println("Delete Address Script");
		
		webDriverUtility.javaScripScrollTillElement(driver, homePage.getAddressesBtn());
		homePage.getAddressesBtn().click();
		
		Addresses_Page addressesPage = new Addresses_Page(driver);
		addressesPage.getDeleteAddressBtn().get(0).click();
		
		webDriverUtility.JavaScriptPopupAccept(driver);
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		webDriverUtility.webPageScreenShot(driver);
		
	}

}
