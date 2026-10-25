package Com.DemoWebShop_GenericUtility;

public interface FrameWorkContants {

	JavaUtility javaUtility = new JavaUtility();
	
	static String propertyFilePath = "./src/test/resources/TestData/commonData.properties";
	static String excelFilePath = "./src/test/resources/TestData/testScriptData.xlsx";
	static String screenShotPath = "./screenshots/" + javaUtility.localDateAndTime() + ".png";
	static String reportsPath = "./reports" + javaUtility.localDateAndTime() + ".html";
	
}
