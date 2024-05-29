package Advanced_Selenium_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Json_File_Practice {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser=new JSONParser();
		Object obj=parser.parse(new FileReader("./src/test/resources/AppCommondata.json"));
		
		JSONObject jobj=(JSONObject)obj;
		String BROWSER=jobj.get("browser").toString();
		String URL  =jobj.get("url").toString();
		String USERNAME=jobj.get("username").toString();
		String PASSWORD=jobj.get("password").toString();
		WebDriver driver=null;
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equals("firefox"))
		{
			driver =new FirefoxDriver();
			
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
			
		}
		else
		{
			driver=new ChromeDriver();
			
		}	
		
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();
		driver.quit();
		
}

}
