/**
 * 
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.BaseWeb;



/**
 * @author fendyridwan
 *
 */
public class BasePage extends BaseWeb {
	public WebDriver driver;
	public WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }
	
	public WebElement waitVisibility(WebElement elementBy) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(elementBy));
		
		return elementBy;
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
	
	public void scrollIntoView(WebElement elementBy) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Find element by link text and store in variable "Element"        		
       // WebElement Element = driver.findElement(By.xpath(element));

        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", elementBy);
       
	}
	
	public void scrollIntoViewByXpath(String elementBy) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Find element by link text and store in variable "Element"        		
		WebElement Element = driver.findElement(By.xpath(elementBy));

        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);
       
	}
	
	public void clickELement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", element);
	}
	
	public void clickOnEditButtonSpesificId(String id) {
		String xpath = "//*[contains(text(),\""+id+"\")]/../td/a[@class=\"btn btn-primary mr-2\"]";
		waitVisibility(driver.findElement(By.xpath(xpath))).click();
	}
	
	public void backPreviousPage() {
		driver.navigate().back();
	}
	
	public String getEnvironment() {
		
		return environment;
	}
	


}
