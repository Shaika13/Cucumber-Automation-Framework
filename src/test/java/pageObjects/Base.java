package pageObjects;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {

	public static WebDriver driver;
	public static Logger logger;
	public Properties configProp;
	
	 public static void clickElement (By element) throws  Exception{

		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 WebDriverWait webDriverWait = new WebDriverWait(driver,60);
		 webDriverWait.until(ExpectedConditions.elementToBeClickable (element));


		 driver.findElement(element).click();
		 Thread.sleep(1000);

	 }

 public static void verifyElementAndDataEntry(WebDriver driver2, By element,String value) throws Exception {
	 
	 boolean elementResult=driver2.findElement(element).isDisplayed();
	 clickElement(element);
	 driver2.findElement(element).clear();
     if(elementResult==true)
     {
         System.out.println("The ID: " +element+ "element is visible");
     }
     else
     {
         System.out.println("The ID: " +element+ "element is not visible");
     }
     driver2.findElement(element).sendKeys(new String[] { value });

	 
 }

 
  	public static void checkPageSource(String expectedVal ) {
  		
  		if(driver.getPageSource().contains(expectedVal)) {
  			
  			System.out.println("Login Successful");
  		}
  		
  		else 
  			driver.close();
  		
  		
  	}
}
