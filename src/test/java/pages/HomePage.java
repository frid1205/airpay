/**
 * 
 */
package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

/**
 * @author fendyridwan
 *
 */
public class HomePage extends BasePage{
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//*[contains(text(),\"Dashboard\")]")
	@CacheLookup
	List<WebElement> verifyHomePage;
	
	
	@FindBy(xpath="//h2[contains(text(),\"Your Account is not approved\")]")
	@CacheLookup
	List<WebElement> verifyIsNotApprovedMessageDisplayed;
	
	
	//@Step("Verify home page is displayed")
	public boolean verifyHomePage() {
		if(!verifyHomePage.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	@Step("Verify is not approved message displayed")
	public boolean verifyIsNotApprovedMessageDisplayed() {
		if(!verifyIsNotApprovedMessageDisplayed.isEmpty()==true) {
			return true;
		}else {
			return false;
		}
	}

}
