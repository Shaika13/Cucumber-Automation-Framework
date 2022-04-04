package pageObjects;

import org.openqa.selenium.By;

public class LoginPage {

	
	 public By name=By.name("username");
	 public By Password=By.name("password");
	 public By loginBtn=By.xpath("//input[@value=\"login\"]");
}
