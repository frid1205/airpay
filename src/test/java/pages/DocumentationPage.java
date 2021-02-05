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

import bases.BaseWeb;

/**
 * @author fendyridwan
 *
 */
public class DocumentationPage extends BasePage{
	WebDriver driver;
	
	public DocumentationPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//p[contains(text(),\"Getting Started\")]")
	@CacheLookup
	List<WebElement> gettingStarted;
	
	@FindBy(xpath="//p[contains(text(),\"Merchant On Boarding\")]")
	@CacheLookup
	List<WebElement> merchantOnBoarding;
	
	@FindBy(xpath="//p[contains(text(),\"Service Onboarding\")]")
	@CacheLookup
	List<WebElement> serviceOnBoarding;
	
	@FindBy(xpath="//p[contains(text(),\"Integration\")]")
	@CacheLookup
	List<WebElement> integration;
	
	@FindBy(xpath="//p[contains(text(),\"Reporting\")]")
	@CacheLookup
	List<WebElement> reporting;
	
	@FindBy(xpath="//p[contains(text(),\"Frequently Asked Questions\")]")
	@CacheLookup
	List<WebElement> faq;
	
	public boolean verifyGettingStarted() {
		if(!gettingStarted.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean verifyMerchantOnboarding() {
		if(!merchantOnBoarding.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean verifyServiceOnBoarding() {
		if(!serviceOnBoarding.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean verifyIntegration() {
		if(!integration.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean verifyReporting() {
		if(!reporting.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyFAQ() {
		if(!faq.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	

}
