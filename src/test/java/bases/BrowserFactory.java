/**
 * dfdfddf
 */
package bases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author fendyridwan
 *
 */
public class BrowserFactory 
{
	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url, String headless) 
	{
		//System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		System.setProperty("webdriver.gecko.driver", "driver/geckodriver");
		if(browserName.equals("firefox"))
		{
			driver = new FirefoxDriver();
			
		}
		else if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver88");
			if(headless.equals("true"))
			{
				ChromeOptions option = new ChromeOptions();
				option.addArguments("--headless");
				//option.addArguments("--start-maximized");
				option.addArguments("window-size=1920,1080");
				driver = new ChromeDriver(option);
			}
			else
			{
				driver = new ChromeDriver();
			}
			
			
		}
		else if(browserName.equals("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();

		driver.get(url);
		
		return driver;
	}

}
