package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	
	
	static {
		Configurator.initialize(null, "F:\\SeleniumLearning\\FrameworkProject\\src\\main\\java\\resources\\log4j.xml");
	}
	
	public WebDriver driver;
	 Logger log;
	
	@BeforeMethod
	public void openApplication() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
		
		driver = initializeDriver();
		log.debug("Browser got Launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to Application URL");
	}
	
	@Test(dataProvider="getLoginData")
	public void login(String email,String password,String expectedResult) throws IOException, InterruptedException {
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on My Account Dropdown");
		landingPage.loginOption().click();
		log.debug("Clicked on Login Option");
		Thread.sleep(3000);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.email().sendKeys(email);
		log.debug("Email Adress got entered");
		loginPage.password().sendKeys(password);
		log.debug("Password got entered");
		loginPage.loginbtn().click();
		log.debug("Click to the login button");
		
		AccountPage accountPage = new AccountPage(driver);
		
		String acutualResult = null;
		
		try { 
			
			if(accountPage.accountBreadcum().isDisplayed()) {
				log.info("User got logged in");
			   acutualResult = "Success";
			}
			
		}catch(Exception e) {
			
			log.error("User didn't logged in");
			acutualResult = "Failure";
			
		}
		
		Assert.assertEquals(expectedResult,acutualResult);
		log.info("Login Test got Passed");
	}
	
	
	@AfterMethod
	public void closure() {
		
		driver.close();
		log.debug("Browser got terminated");
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		
		Object[][] data = {{"satyaprakashbiswal2000@gmail.com","Satya@2000","Success"},{"dummy@test.com","1234","Failure"}};
		
		return data;
		
	}
}
