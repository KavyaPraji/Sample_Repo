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

public class Read_Data_From_JsonFile {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	
		 
		
		//parse JSon Physical file in to Java Object using JsonParse class
		JSONParser pars=new JSONParser();
		Object obj=pars.parse(new FileReader("./src/test/resources/AppCommondata.json"));
		
		
		//convert java object to JSon object using down casting
		JSONObject map=(JSONObject)obj;
		
		
		//get the value using get method
		String URL=(String) map.get("url");
		String BROWSER=(String)map.get("browser");
		String USERNAME=(String)map.get("username");
		String PASSWORD=(String)map.get("password");
		//String T=(String)map.get("timeOut");
		
		
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
		driver.findElement(By.linkText("Organizations")).click();
		
		
		
	}

}
