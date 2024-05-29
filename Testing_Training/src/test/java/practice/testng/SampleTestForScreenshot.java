package practice.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class SampleTestForScreenshot 
{
	@Test
	public void amazonTest() throws IOException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://amazon.com");
		
		//step1: crate an object to EventFiring WebDriver
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		
		//step2: capture screen shot in runtime using getscreenshotAs method to get file type
		File src_file=edriver.getScreenshotAs(OutputType.FILE);
		
		File dest_fie=new File("./Screenshot_TestNG/test.png");
		
		//step 3:store screenshot in local drive
		FileUtils.copyFile(src_file, dest_fie);
		
		
		
		
	}

}
