package practice.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class Working_With_Screenshot {

	@Test
	public void flipkartTest() throws IOException
	{
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		
		
		
		File src=edriver.getScreenshotAs(OutputType.FILE);
		
		File dest=new File("./Screenshot_TestNG/homepage.png");
		
		FileUtils.copyFile(src, dest);
		
	}

}
