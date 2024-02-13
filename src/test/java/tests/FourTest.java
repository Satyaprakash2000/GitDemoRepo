package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base {
	public WebDriver driver;
	@Test
	public void testFour() throws IOException, InterruptedException {
		System.out.println("Satya Has Updated this code");
		System.out.println("Some Changes Done by Satya");
		System.out.println("TestFour");
		driver = initializeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		Thread.sleep(2000);
		driver.close();
	}
}
