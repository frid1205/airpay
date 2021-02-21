/**
 * 
 */
package pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Step;

/**
 * @author fendyridwan
 *
 */
public class CreateOperatorPage extends BasePage{
	WebDriver driver;

	public CreateOperatorPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//button[@class=\"btn color-a\"]")
	@CacheLookup
	WebElement createButton;
	
	@FindBy(name="Operator[name]")
	@CacheLookup
	WebElement operatorName;
	
	@FindBy(name="Operator[country]")
	@CacheLookup
	WebElement operatorCountry;
	
	@FindBy(name="Operator[photo]")
	@CacheLookup
	WebElement operatorPhoto;
	
	@FindBy(name="Operator[mo_limit]")
	@CacheLookup
	WebElement MOLimit;
	
	@FindBy(name="Operator[service_limit]")
	@CacheLookup
	WebElement serviceLimit;
	
	@FindBy(name="Operator[revenue_limit]")
	@CacheLookup
	WebElement revenueLimit;
	
	@Step("type operator name")
	public void typeOperatorName(String name) {
		operatorName.sendKeys(name);
	}
	
	@Step("select country")
	public void selectCountry(String name) {
		Select dd = new Select(operatorCountry);
		dd.selectByIndex(4);
	}
	
	@Step("choose a photo")
	public void chooseAPhoto() {
		String filename = "attachment/axis.png";
	    File file = new File(filename);
	    String path = file.getAbsolutePath();

	    (operatorPhoto).sendKeys(path);
	}
	
	@Step("type Mo Limit")
	public void typeMoLimit(String name) {
		MOLimit.sendKeys(name);
	}
	
	@Step("type service limit")
	public void typeServiceLimit(String name) {
		serviceLimit.sendKeys(name);
	}
	
	@Step("type revenue Limit")
	public void typeRevenueLimit(String name) {
		revenueLimit.sendKeys(name);
	}
	
	
	@FindBy(xpath="//*[contains(text(),\"Name cannot be blank\")]")
	@CacheLookup
	List<WebElement> nameMandatoryValidation;
	
	@FindBy(xpath="//*[contains(text(),\"Country cannot be blank\")]")
	@CacheLookup
	List<WebElement> countryMandatoryValidation;
	
	@FindBy(xpath="//*[contains(text(),\"Logo cannot be blank\")]")
	@CacheLookup
	List<WebElement> logoMandatoryValidation;
	
	@FindBy(xpath="//*[contains(text(),\"Mo Limit cannot be blank\")]")
	@CacheLookup
	List<WebElement> moLimitMandatoryValidation;
	
	@FindBy(xpath="//*[contains(text(),\"Service Limit cannot be blank\")]")
	@CacheLookup
	List<WebElement> serviceLimitMandatoryValidation;
	
	@FindBy(xpath="//*[contains(text(),\"Revenue Limit cannot be blank\")]")
	@CacheLookup
	List<WebElement> revenueLimitMandatoryValidation;
	
	@Step("Click on create button")
	public void clickOnCreateButton() {
		waitVisibility(createButton).click();
	}
	
	@Step("validate mandatory fields")
	public boolean mandatoryMessageDisplayed() {
		if(!nameMandatoryValidation.isEmpty()==true&&!countryMandatoryValidation.isEmpty()==true&&!logoMandatoryValidation.isEmpty()==true
				&&!moLimitMandatoryValidation.isEmpty()==true&&!serviceLimitMandatoryValidation.isEmpty()==true
				&&!revenueLimitMandatoryValidation.isEmpty()==true) {
			return true;
		}else {
			return false;
		}
	}
}
