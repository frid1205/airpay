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
public class InviteUserPage extends BasePage{
	
	WebDriver driver;
	
	public InviteUserPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id="username")
	@CacheLookup
	WebElement username;
	
	@FindBy(id="email")
	@CacheLookup
	WebElement email;
	
	@FindBy(id="company")
	@CacheLookup
	WebElement company;
	
	@FindBy(id="phone")
	@CacheLookup
	WebElement phone;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//button[@class=\"btn color-a\" and contains(text(),\"Invite User\")]")
	@CacheLookup
	WebElement inviteUserButton;
	
	@FindBy(xpath="//div//span[@class=\"text-danger\" and @id=\"error_msg_username\"and contains(text(),\"This Field is required\")]")
	@CacheLookup
	List<WebElement> userNameMandatory;
	
	@FindBy(xpath="//div//span[@class=\"text-danger\" and @id=\"error_msg_email\"and contains(text(),\"This Field is required\")]")
	@CacheLookup
	List<WebElement> emailMandatory;
	
	@FindBy(xpath="//div//span[@class=\"text-danger\" and @id=\"error_msg_company\"and contains(text(),\"This Field is required\")]")
	@CacheLookup
	List<WebElement> companyMandatory;
	
	@FindBy(xpath="//div//span[@class=\"text-danger\" and @id=\"error_msg_phone\"and contains(text(),\"This Field is required\")]")
	@CacheLookup
	List<WebElement> phonelMandatory;
	
	@FindBy(xpath="//div//span[@class=\"text-danger\" and @id=\"error_msg_password\"and contains(text(),\"This Field is required\")]")
	@CacheLookup
	List<WebElement> passwordMandatory;
	
	@FindBy(xpath="//div//span[@class=\"text-danger\" and @id=\"error_msg_username\" and contains(text(),\"This username has already been taken\")]")
	@CacheLookup
	List<WebElement> usernameAlreadyTaken;
	
	@FindBy(xpath="//div//span[@class=\"text-danger\" and @id=\"error_msg_email\"and contains(text(),\"This email has already been registered\")]")
	@CacheLookup
	List<WebElement> emailAlreadyTaken;
	
	@FindBy(xpath="//p[@class=\"alert alert-success\" and contains(text(),\"User Invited Successfully\")]")
	@CacheLookup
	List<WebElement> userInvitedSuccesfully;
	
	
	
	public void typeUserName(String name) {
		waitVisibility(username).clear();
		waitVisibility(username).sendKeys(name);
	}
	
	public void typeEmail(String email) {
		waitVisibility(this.email).clear();
		waitVisibility(this.email).sendKeys(email);
	}
	
	public void typeCompany(String name) {
		waitVisibility(company).clear();
		waitVisibility(company).sendKeys(name);
	}
	
	public void typePhone(String name) {
		waitVisibility(phone).clear();
		waitVisibility(phone).sendKeys(name);
	}
	
	public void typePassword(String name) {
		waitVisibility(password).clear();
		waitVisibility(password).sendKeys(name);
	}
	
	public void clearUsername() {
		waitVisibility(username).clear();
	}
	
	public void clearEmail() {
		waitVisibility(email).clear();
	}
	
	public void clearCompany() {
		waitVisibility(company).clear();
	}
	
	public void clearPhone() {
		waitVisibility(phone).clear();
	}
	
	public void clearPassword() {
		waitVisibility(password).clear();
	}
	
	public void clickOnInviteUserButton() {
		try {
			waitVisibility(inviteUserButton).click();
		}catch(Exception e) {
			clickELement(inviteUserButton);
		}
	}
	
	public boolean emailMandatory() {
		if(!emailMandatory.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean userNameMandatory() {
		if(!userNameMandatory.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean companyMandatory() {
		if(!companyMandatory.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean phoneMandatory() {
		if(!userNameMandatory.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean passwordMandatory() {
		if(!passwordMandatory.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean usernameAlreadyTaken() {
		if(!usernameAlreadyTaken.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean emailAlreadyTaken() {
		if(!emailAlreadyTaken.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean userInvitedSuccesfully() {
		if(!userInvitedSuccesfully.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
