/**
 * 
 */
package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * @author fendyridwan
 *
 */
public class UpdatePasswordPage extends BasePage{
	
	WebDriver driver;
	
	public UpdatePasswordPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(id="o_password")
	@CacheLookup
	WebElement currentPassword;
	
	@FindBy(id="n_password")
	@CacheLookup
	WebElement newPassword;
	
	@FindBy(id="c_password")
	@CacheLookup
	WebElement coPassword;
	
	@FindBy(xpath="//button[contains(text(),\"Update Password\")]")
	@CacheLookup
	WebElement updatePasswordButton;
	
	@FindBy(xpath="//p[@class=\"alert alert-danger\" and contains(text(),\"Your current password did not matched with our database\")]")
	@CacheLookup
	List<WebElement> invalidCurrentPasswordMessage;
	
	@FindBy(xpath="//*[@class=\"text-danger\" and contains(text(),\"Password Did not matched\")]")
	@CacheLookup
	List<WebElement> passwordNotMatchMessage;
	
	@FindBy(xpath="//*[@class=\"alert alert-success\" and contains(text(),\"Your Password Changed successfully\")]")
	@CacheLookup
	List<WebElement> passwordSuccessfullyUpdatedmessage;
	
	
	public void typeCurrentPassword(String name) {
		waitVisibility(currentPassword).clear();
		waitVisibility(currentPassword).sendKeys(name);
	}
	
	public void typeNewPassword(String name) {
		waitVisibility(newPassword).clear();
		waitVisibility(newPassword).sendKeys(name);
	}
	
	public void typeCoPassword(String name) {
		waitVisibility(coPassword).clear();
		waitVisibility(coPassword).sendKeys(name);
	}
	
	public void clickOnUpdatePasswordButton() {
		waitVisibility(updatePasswordButton).click();
	}
	
	public boolean invalidCurrentPasswordMessage() {
		if(!invalidCurrentPasswordMessage.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean passwordNotMatchMessage() {
		if(!passwordNotMatchMessage.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean passwordSuccessfullyUpdatedmessage() {
		if(!passwordSuccessfullyUpdatedmessage.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	

}
