/**
 * 
 */
package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

/**
 * @author fendyridwan
 *
 */
public class signInPage extends BasePage{
	WebDriver driver;
	
	public signInPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="User[email]")
	@CacheLookup
	WebElement userName;
	
	@FindBy(name="User[password]")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//*[@class=\"btn login-btn btn-block\"]")
	@CacheLookup
	WebElement signInButton;
	
	@FindBy(xpath="//*[@class=\"sign_up_here\"]")
	@CacheLookup
	WebElement signUpLink;
	
	@FindBy(xpath="//*[@class=\"pull-right forget_password\"]")
	@CacheLookup
	WebElement forgetPasswordLink;
	
	@FindBy(xpath="//p[@class=\"error\" and contains(text(),\"you are not an authorized user\")]")
	@CacheLookup
	List<WebElement> errorSignInMessage;
	
	@FindBy(xpath="//p[@class=\"error\" and contains(text(),\"Please Verify Your Email to access your account\")]")
	@CacheLookup
	List<WebElement> signInUnverifiedMessage;
	
	
	@Step("Input Username")
	public void typeUserName(String userName)
	{
		waitVisibility(this.userName).clear();
		waitVisibility(this.userName).sendKeys(userName);
	}
	
	@Step("Input password")
	public void typePassword(String password)
	{
		waitVisibility(this.password).clear();
		waitVisibility(this.password).sendKeys(password);
	}
	
	@Step("Click on signin button")
	public void clickSignInButton() {
		waitVisibility(signInButton).click();
	}
	
	@Step("Click on sign up URL Link")
	public void clickSignUpUrlLink() {
		waitVisibility(signUpLink).click();
	}
	
	@Step("Click on forget password url link")
	public void clickForgetPasswordLink() {
		waitVisibility(forgetPasswordLink).click();
	}
	
	@Step("Verify error sign in is displayed")
	public boolean errorSignInMessage() {
		if(!errorSignInMessage.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	@Step("Verify sign in unverified message is displayed")
	public boolean signInUnverifiedMessage() {
		if(!signInUnverifiedMessage.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

}
