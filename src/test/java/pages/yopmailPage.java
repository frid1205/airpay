/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author fendyridwan
 *
 */
public class yopmailPage {
	
	WebDriver driver;
	
	public yopmailPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	
	@FindBy(id="login")
	@CacheLookup
	WebElement userName;
	
	@FindBy(xpath="//input[@type=\"submit\" and @class=\"sbut\"]")
	@CacheLookup
	WebElement checkButton;
	
	@FindBy(xpath="//*[@id=\"m1\"]/div/a")
	@CacheLookup
	WebElement firstLineEmail;
	
	@FindBy(xpath="//div[@class=\"recaptcha-checkbox-border\"]")
	@CacheLookup
	WebElement verifyCaptcha;
	
	@FindBy(xpath="//*[contains(text(),\"Confirm Account\")]")
	@CacheLookup
	WebElement confirmAccountButton;
	
	
	
	
	public void typeUserName(String name)
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(this.userName)).sendKeys(name);
	}
	
	public void clickCheckButton()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(this.checkButton)).click();
	}
	
	public void clickfirstLineEmail()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(this.firstLineEmail)).click();
	}
	
	public void verifyCaptcha()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(this.verifyCaptcha)).click();
	}
	
	public void confirmAccount()
	{
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(this.confirmAccountButton)).click();
	}

}
