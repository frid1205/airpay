/**
 * @author fendyridwan
 * 
 * This page used for configuration settingfgg
 * dfdfdfdfdfdfd
 */
package bases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import pages.SideMenuPage;
import pages.signInPage;

@Listeners(bases.Listener.class)
public class BaseWeb{
	public static WebDriver driver;
	public static String validAdmin;
	public static String validPassword;
	public static String url;
	public static String urlApp;
	public static String environment;
	WebDriverWait wait;
	
	public WebDriver getDriver() {
        return driver;
    }
	
	@BeforeSuite
	public void settupTestingData() {
		validAdmin 		= "admin";
		validPassword 	= "L1nk1t360";
	}
	

	@BeforeSuite
	public void deleteScreenShot() throws IOException 
	{
		File dir = new File("ScreenShot");
		File[] listFiles = dir.listFiles();

		if (dir.length() > 0) {
			for (File file : listFiles) {
				file.getName();
				file.delete();
			}
			dir.delete();
		}
		
		File dir2 = new File("allure-results");
		File[] listFiles2 = dir2.listFiles();

		if (dir2.length() > 0) {
			for (File file2 : listFiles2) {
				file2.getName();
				file2.delete();
			}
			dir2.delete();
		}
	}

	@BeforeClass
	@Parameters({ "browser" , "headless","env"})
	public void setBaseConfig(String browser, String headless, String Env) 
	{
		
		if(Env.equals("airpay")) {
			url = "http://staging.cms.merchant.airpay.mobi/";
		}else {
			url = "http://vittel-staging.infralinkit360.com:8000/";
		}
		environment = Env;	
		
		WebDriver driver = BrowserFactory.startBrowser(browser, url, headless);
		BaseWeb.driver = driver;

	}
	
	
	// user sign in with valid credential
	public void userSignIn() throws InterruptedException 
	{
		//signInPage si = PageFactory.initElements(driver, signInPage.class);
		signInPage si = new signInPage(driver);
		System.out.println("User Login");
		if(environment.equals("airpay")) {
			
			si.typeUserName("airpay10");
			
			//System.out.println("-> Input valid password");
			si.typePassword("Abcde12345!");
		}else {
			si.typeUserName("vittel2");
			
			//System.out.println("-> Input valid password");
			si.typePassword("Abcde12345!");
		}
		//System.out.println("-> Click on sign in button");
		si.clickSignInButton();
		
		Thread.sleep(2000);
	}
	
	// admin sign in with valid credential
	public void adminSignIn() throws InterruptedException 
	{
		//signInPage si = PageFactory.initElements(driver, signInPage.class);
		signInPage si = new signInPage(driver);
		
		System.out.println("Admin Login");
		si.typeUserName("admin");
		
		//System.out.println("-> Input valid password");
		si.typePassword("L1nk1t360");
		
		//System.out.println("-> Click on sign in button");
		si.clickSignInButton();
		
		Thread.sleep(2000);
	}
	
	public void logOut() throws InterruptedException {
		SideMenuPage smp = new SideMenuPage(driver);
		smp.clickOnLogoutButton();
		Thread.sleep(2000);
	}

	// get driver of this class for screenshot
	public File getscreenshot() throws IOException 
	{
		File des = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return des;
	}
	
	public void scrollDown()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,2000)");
	}
	
	public void scrollUp()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-2000)");
	}
	
	public void scrollIntoView(String element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Find element by link text and store in variable "Element"        		
        WebElement Element = driver.findElement(By.xpath(element));

        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
       
	}
	
	
	
	public String dayDate() {
		Date now = new Date();
		
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmm");  
        String strDate= formatter.format(now);  
 
		return strDate;
	}
	
	public String getURL() {
		return driver.getCurrentUrl();
	}

	@AfterClass
	public void quitDriver() {
		driver.quit();
	}
	
	
}
