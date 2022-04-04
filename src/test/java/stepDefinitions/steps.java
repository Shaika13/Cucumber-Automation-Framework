package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.Base;
import pageObjects.LoginPage;



public class steps extends Base{
public LoginPage lp =new LoginPage();

@Before
public void setup() throws IOException {
	
	configProp=new Properties();
	FileInputStream configPropFile=new FileInputStream("config.properties");
	configProp.load(configPropFile);
	
	final String ProjectPath= System.getProperty("user.dir");
	String os= System.getProperty("os.name").toLowerCase();
	
	logger =Logger.getLogger("CucumberAutomation");
	PropertyConfigurator.configure("log4j.properties");
	
	String browsername= configProp.getProperty("browserName");
	
	if(browsername.equals("chrome") & os.contains("windows")) {
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+configProp.getProperty("chromepathWindows"));
	driver= new ChromeDriver();
	logger.info("Launching chrome browser on windows");}
	
	else if(browsername.equals("chrome") & os.contains("mac")) {
		System.setProperty("webdriver.chrome.driver",ProjectPath+configProp.getProperty("chromepathMac"));
		driver= new ChromeDriver();
		}
	else if(browsername.equals("firefox") & os.contains("windows")) {
		System.setProperty("webdriver.gecko.driver",ProjectPath+configProp.getProperty("geckopathWindows"));
		driver= new FirefoxDriver();
		}
	else if(browsername.equals("firefox") & os.contains("mac")) {
		System.setProperty("webdriver.gecko.driver",ProjectPath+configProp.getProperty("geckopathMac"));
		driver= new FirefoxDriver();
		}
	String Adress=configProp.getProperty("url");
	   driver.get(Adress);
	   driver.manage().window().maximize();
	
}


     
	@When("user enters name as {string}")
	public void user_enters_name_as(String name) throws Exception {
	    verifyElementAndDataEntry(driver, lp.name, name);
	    logger.info("User entered name");
	}

	

	@Then("user enters Password as {string}")
	public void user_enters_password_as(String password) throws Exception {
		verifyElementAndDataEntry(driver, lp.Password, password);
		logger.info("User entered password");
	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() throws Exception{
		
		clickElement(lp.loginBtn);
	}
	
 @After
 public void tearDown()
 {
	 driver.quit();
	    logger.info("Browser closed");
	 
 }
	
}
