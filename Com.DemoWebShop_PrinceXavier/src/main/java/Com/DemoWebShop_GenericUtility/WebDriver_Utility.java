package Com.DemoWebShop_GenericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utility{
	
	public void webPageScreenShot(WebDriver driver) throws IOException {
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	File des = new File(FrameWorkContants.screenShotPath);
	FileHandler.copy(temp, des);
	}
	
	public void selectByVisibleText(WebElement dropdownElement, String text) {
		
		Select sel = new Select(dropdownElement);
		sel.selectByVisibleText(text);
	}
	
	public void javaScripScrollTillElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void JavaScriptClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void JavaScriptPopupAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	

}
