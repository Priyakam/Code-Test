package resources;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base<WebElements> {
	
	public WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException
	{
	
	System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
	return driver =new ChromeDriver();
	}
	
	

}
