package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base{
	public WebDriver driver;
	
	@Test
	public void testTwo() throws IOException, InterruptedException {
		System.out.println("Krish has updated this code");
		
		System.out.println("TestTwo");
		driver = initializeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		Thread.sleep(2000);
		Assert.assertTrue(false);
		driver.close();
	}

}
