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
public class UserApprovalPage extends BasePage{
	WebDriver driver;
	
	public UserApprovalPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//td[2 and contains(text(),\"yopmail\")]/../td/div/input")
	@CacheLookup
	WebElement chkbox;
	
	@FindBy(xpath="//button[contains(text(),\"Approve\")]")
	@CacheLookup
	WebElement approveButton;
	
	@FindBy(xpath="//button[contains(text(),\"reject\")]")
	@CacheLookup
	WebElement rejectButton;
	
	@FindBy(xpath="//h2[contains(text(),\"Please select checkbox to change the status!\")]")
	@CacheLookup
	List<WebElement> selectCheckboxValidationMessage;
	
	@FindBy(xpath="//*[contains(text(),\"user rejected successfully\")]")
	@CacheLookup
	List<WebElement> userRejectedMessage;
	
	@FindBy(xpath="//*[contains(text(),\"Successfully Approved\")]")
	@CacheLookup
	List<WebElement> userApprovedMessage;
	
	
	public void clickCheckBox() {
		try {
			waitVisibility(chkbox).click();
		}
		catch(Exception e) {
			clickELement(chkbox);
		}
	}
	
	public void clickOnApproveButton() {
		waitVisibility(approveButton).click();
	}
	
	public void clickOnRejectButton() {
		waitVisibility(rejectButton).click();
	}
	
	public boolean selectCheckboxValidationMessage() {
		if(!selectCheckboxValidationMessage.isEmpty()==true) {
			return true;
			
		}else {
			return false;
		}
	}
	
	public boolean userRejectedMessage() {
		if(!userRejectedMessage.isEmpty()==true) {
			return true;
			
		}else {
			return false;
		}
	}
	
	public boolean userApprovedMessage() {
		if(!userApprovedMessage.isEmpty()==true) {
			return true;
			
		}else {
			return false;
		}
	}

}
