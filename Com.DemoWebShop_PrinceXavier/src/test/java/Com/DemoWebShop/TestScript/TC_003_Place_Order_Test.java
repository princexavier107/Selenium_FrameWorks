package Com.DemoWebShop.TestScript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Com.DemoWebShop_GenericUtility.BaseTest;
import Com.DemoWebShop_POM.Books_Page;
import Com.DemoWebShop_POM.CheckOut_Page;
import Com.DemoWebShop_POM.ShoppingCart_Page;

public class TC_003_Place_Order_Test extends BaseTest {

	@Test
	public void placeOrder() throws IOException, InterruptedException {
		System.out.println("Placing order");

		homePage.getSearchTextField().sendKeys(fileUtility.readDataFromPropertyFile("product"));
		homePage.getSearchBtn().click();

		Books_Page bookPage = new Books_Page(driver);
		webDriverUtility.JavaScriptClick(driver, bookPage.getAddTocart());

		Thread.sleep(2000);
		homePage.getShoppingCartLink().click();

		ShoppingCart_Page cartPage = new ShoppingCart_Page(driver);
		cartPage.getTermsOfServiceBtn().click();
		cartPage.getCheckoutBtn().click();

		CheckOut_Page checkOutPage = new CheckOut_Page(driver);
//		checkOutPage.getContinueBtn().get(0).click();
//		checkOutPage.getContinueBtn().get(1).click();
//		checkOutPage.getContinueBtn().get(2).click();

//		for (int i = 0; i < checkOutPage.getContinueBtn().size(); i++) {
//			checkOutPage.getContinueBtn().get(i).click();
//		}

		for (WebElement iterable_element : checkOutPage.getContinueBtn()) {
			iterable_element.click();
		}
		
		checkOutPage.getConfirmBtn().click();
		
		Thread.sleep(2000);
		webDriverUtility.webPageScreenShot(driver);

	}

}
