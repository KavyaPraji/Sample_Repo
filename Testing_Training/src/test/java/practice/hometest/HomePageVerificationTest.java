package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerificationTest {
	@Test
	public void homePageTest(Method mtd) {

		System.out.println(mtd.getName() + "Test start");

		String expectedPage = "Home page";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

		String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
				
//		if (actTitle.equals(expectedPage)) {
//			System.out.println(expectedPage + "is verified===PASS");
//		} else {
//			System.out.println(expectedPage + "is  not verified===FAIL");
//		}
		
		//hard assert
		Assert.assertEquals(actTitle, expectedPage);
		
		driver.close();

		System.out.println(mtd.getName() + "Test end");

	}

	@Test
	public void verifyLogohomePageTest(Method mt) {
		System.out.println(mt.getName() + "Test start");

		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		boolean flag=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		
//		if (flag==true) {
//			System.out.println( "Logo is verified===PASS");
//		} else {
//			System.out.println( "Logo is  not verified===FAIL");
//		}
		
		//hard assert
		
		//Assert.assertEquals(true, flag);
		
		Assert.assertTrue(flag);
		
		driver.close();

		System.out.println(mt.getName() + "Test end");


		
		

		
	}

}
