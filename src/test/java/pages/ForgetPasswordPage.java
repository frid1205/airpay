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
public class ForgetPasswordPage extends BasePage{
	
	WebDriver driver;
	
	public ForgetPasswordPage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(name="email")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath="//*[@class=\"btn btn-danger login-btn btn-block\"]")
	@CacheLookup
	WebElement resetPasswordButton;
	
	@FindBy(xpath="//p[@class=\"error\" and contains(text(),\"able to identify you given the information provided.\")]")
	@CacheLookup
	List<WebElement> resetPasswordFailMessage;
	
	@FindBy(xpath="//*[contains(text(),\"Please Check your email, your reset password link send to your email\")]")
	@CacheLookup
	List<WebElement> forgetPasswordIsSent;
	
	@Step("Input email")
	public void typeEmail(String name) {
		waitVisibility(this.email).clear();
		waitVisibility(this.email).sendKeys(name);
	}
	
	@Step("Input password")
	public void clickOnResetPasswordButton() {
		waitVisibility(this.resetPasswordButton).click();
	}
	
	@Step("Verify reset password fail message")
	public boolean resetPasswordFailMessage() {
		if(!resetPasswordFailMessage.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	@Step("verify forget password is sent")
	public boolean forgetPasswordIsSent() {
		if(!forgetPasswordIsSent.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

}
