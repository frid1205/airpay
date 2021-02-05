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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author fendyridwan
 *
 */
public class EditProfilePage extends BasePage{
	WebDriver driver;
	
	public EditProfilePage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[contains(@href,\"basic-info\")]")
	@CacheLookup
	WebElement basicInfoTab;
	
	@FindBy(xpath="//a[contains(@href,\"suppoting-docs\")]")
	@CacheLookup
	WebElement supportingDocTab;
	
	/*
	 *Basic info Tab 
	 */
	
	@FindBy(name="username")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="company")
	@CacheLookup
	WebElement companyName;
	
	@FindBy(name="email")
	@CacheLookup
	WebElement email;
	
	@FindBy(name="country")
	@CacheLookup
	WebElement country;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement city;
	
	@FindBy(name="company_address")
	@CacheLookup
	WebElement companyAddress;
	
	@FindBy(name="company_phone")
	@CacheLookup
	WebElement phone;
	
	@FindBy(name="website")
	@CacheLookup
	WebElement website;
	
	@FindBy(name="update_personal_info_btn")
	@CacheLookup
	WebElement submitBasicInfoButton;
	
	@FindBy(name="country")
	@CacheLookup
	List<WebElement> country1;
	
	@FindBy(name="city")
	@CacheLookup
	List<WebElement> city1;
	
	@FindBy(name="company_address")
	@CacheLookup
	List<WebElement> companyAddress1;
	
	@FindBy(name="company_phone")
	@CacheLookup
	List<WebElement> phone1;
	
	@FindBy(name="website")
	@CacheLookup
	List<WebElement> website1;
	
	@FindBy(xpath="//*[@class=\"text-danger\" and contains(text(),\"Company Phone cannot be blank\")]")
	@CacheLookup
	List<WebElement> phoneValidation;
	
	
	
	/*
	 *Supporting Document Tab 
	 */
	
	@FindBy(id="bank_holder_name")
	@CacheLookup
	WebElement bankHolderName;
	
	@FindBy(id="bank_account_number")
	@CacheLookup
	WebElement bankAccountNumber;
	
	@FindBy(id="bank_name")
	@CacheLookup
	WebElement bankName;
	
	@FindBy(id="bank_location")
	@CacheLookup
	WebElement bankLocation;
	
	@FindBy(id="bank_swift_code")
	@CacheLookup
	WebElement bankSwiftCode;
	
	@FindBy(id="supportDocBtn")
	@CacheLookup
	WebElement supportingSubmitButton;
	
	@FindBy(id="bank_holder_name")
	@CacheLookup
	List<WebElement> bankHolderName1;
	
	@FindBy(id="bank_account_number")
	@CacheLookup
	List<WebElement> bankAccountNumber1;
	
	@FindBy(id="bank_name")
	@CacheLookup
	List<WebElement> bankName1;
	
	@FindBy(id="bank_location")
	@CacheLookup
	List<WebElement> bankLocation1;
	
	@FindBy(id="bank_swift_code")
	@CacheLookup
	List<WebElement> bankSwiftCode1;
	
	@FindBy(id="supportDocBtn")
	@CacheLookup
	List<WebElement> supportingSubmitButton1;
	
	@FindBy(xpath="//*[@class=\"text-danger\" and contains(text(),\"Please enter Bank holder name\")]")
	@CacheLookup
	List<WebElement> bankHolderNameValidationMessage;
	
	@FindBy(xpath="//*[@class=\"text-danger\" and contains(text(),\"Bank account number is required\")]")
	@CacheLookup
	List<WebElement> bankAccountNumberValidationMessage;
	
	@FindBy(xpath="//*[@class=\"text-danger\" and contains(text(),\"Please enter Bank swift code\")]")
	@CacheLookup
	List<WebElement> bankSwiftCodeValidationMessage;
	
	
	public void clickBasicInfoTab() {
		waitVisibility(basicInfoTab).click();
	}
	
	public void clickSupportingDocTab() {
		waitVisibility(supportingDocTab).click();
	}
	
	/*
	 *Basic info Tab 
	 */
	public void clearAllFieldsInBasicInfo() {
		waitVisibility(city).clear();
		waitVisibility(companyAddress).clear();
		waitVisibility(phone).clear();
		waitVisibility(website).clear();
		
	}
	
	public void selectCountry()
	{
		Select dd = new Select(country);
		dd.selectByVisibleText("Laos");
	}
	
	public void clickOnSubmitButtonInBasicInfo() {
		waitVisibility(submitBasicInfoButton).click();
	}
	
	public boolean fieldsInBasicInfoAreDisable() {
		int i =0;
		if(username.getAttribute("readonly").equals(true)) {
			i=i+1;
		}
		
		if(companyName.getAttribute("readonly").equals(true)) {
			i=i+1;
		}
		
		if(email.getAttribute("readonly").equals(true)) {
			i=i+1;
		}
		
		if(i==3) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean fieldsInBasicInfoAreExists() {
		int i=0;
		if(!country1.isEmpty()) {
			i=i+1;
		}
		
		if(!city1.isEmpty()) {
			i=i+1;
		}
		
		if(!companyAddress1.isEmpty()) {
			i=i+1;
		}
		
		if(!phone1.isEmpty()) {
			i=i+1;
		}
		
		if(!website1.isEmpty()) {
			i=i+1;
		}
		
		if(i==5) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean phoneValidationMessage() {
		if(!phoneValidation.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * Supporting Document Tab 
	 */
	
	public void typeBankHolderName(String name)
	{
		waitVisibility(bankHolderName).clear();
		waitVisibility(bankHolderName).sendKeys(name);
	}
	
	public void typeBankAccountNumber(String name)
	{
		waitVisibility(bankAccountNumber).clear();
		waitVisibility(bankAccountNumber).sendKeys(name);
	}
	
	public void typeBankName(String name)
	{
		waitVisibility(bankName).clear();
		waitVisibility(bankName).sendKeys(name);
	}
	
	public void typeBankLocation(String name)
	{
		waitVisibility(bankLocation).clear();
		waitVisibility(bankLocation).sendKeys(name);
	}
	
	public void typeBankSwiftCode(String name)
	{
		waitVisibility(bankSwiftCode).clear();
		waitVisibility(bankSwiftCode).sendKeys(name);
	}
	
	public void clearAllFieldsInSupportingDocumentTab()
	{
		waitVisibility(bankHolderName).clear();
		waitVisibility(bankAccountNumber).clear();
		waitVisibility(bankName).clear();
		waitVisibility(bankLocation).clear();
		waitVisibility(bankSwiftCode).clear();
	}
	
	public void clickOnSupportingSubmitButton() {
		waitVisibility(supportingSubmitButton).click();
	}
	
	public boolean fieldsInSupportingDocAreExists() {
		int i=0;
		if(!bankHolderName1.isEmpty()) {
			i=i+1;
		}
		
		if(!bankAccountNumber1.isEmpty()) {
			i=i+1;
		}
		
		if(!bankName1.isEmpty()) {
			i=i+1;
		}
		
		if(!bankLocation1.isEmpty()) {
			i=i+1;
		}
		
		if(!bankSwiftCode1.isEmpty()) {
			i=i+1;
		}
		
		if(i==5) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean bankHolderNameValidationMessage() {
		if(!bankHolderNameValidationMessage.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean bankAccountNumberValidationMessage() {
		if(!bankAccountNumberValidationMessage.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean bankSwiftCodeValidationMessage() {
		if(!bankSwiftCodeValidationMessage.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

}
