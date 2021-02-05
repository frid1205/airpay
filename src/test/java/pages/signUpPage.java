package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.BaseWeb;

/**
 * @author fendyridwan
 *
 */

public class signUpPage extends BasePage {
	WebDriver driver;
	
	public signUpPage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	@FindBy(id="moderation-username")
	@CacheLookup
	WebElement userName;
	
	@FindBy(id="moderation-email")
	@CacheLookup
	WebElement email;
	
	@FindBy(id="moderation-password")
	@CacheLookup
	WebElement password;
	
	@FindBy(id="moderation-passwordconfirm")
	@CacheLookup
	WebElement coPassword;
	
	@FindBy(id="signupBtn")
	@CacheLookup
	WebElement signUpButton;
	
	@FindBy(id="moderation-company")
	@CacheLookup
	WebElement companyNameSecondStep;
	
	@FindBy(id="moderation-company_phone")
	@CacheLookup
	WebElement phoneSecondStep;
	
	@FindBy(id="moderation-country")
	@CacheLookup
	WebElement countrySecondStep;
	
	@FindBy(id="moderation-city")
	@CacheLookup
	WebElement citySecondStep;
	
	@FindBy(id="moderation-website")
	@CacheLookup
	WebElement companyURLsecondStep;
	
	@FindBy(id="moderation-company_address")
	@CacheLookup
	WebElement addressSecondStep;
	
	@FindBy(xpath="//*[@class=\"btn btn-primary next ml-2\"]")
	@CacheLookup
	WebElement continueButtonSecondStep;
	
	@FindBy(id="userpayoutdetail-bank_holder_name")
	@CacheLookup
	WebElement bankHolderNameThirdStep;
	
	@FindBy(id="userpayoutdetail-bank_account_number")
	@CacheLookup
	WebElement accountNumber;
	
	@FindBy(id="userpayoutdetail-bank_name")
	@CacheLookup
	WebElement bankName;
	
	@FindBy(id="userpayoutdetail-bank_swift_code")
	@CacheLookup
	WebElement swiftCode;
	
	@FindBy(id="userpayoutdetail-bank_location")
	@CacheLookup
	WebElement bankLocation;
	
	@FindBy(xpath="//*[@class=\"btn btn-primary ml-2\"]")
	@CacheLookup
	WebElement continueButtonThirdStep;
	
	@FindBy(xpath="//input[@id=\"moderation-contract_file\" and @name=\"Moderation[contract_file]\"]")
	@CacheLookup
	WebElement browseContractFile;
	
	@FindBy(xpath="//*[contains(text(),'Skip')]")
	@CacheLookup
	WebElement skipButton;
	
	@FindBy(id="verifyModEmail")
	@CacheLookup
	WebElement verifyEmailButton;
	
	@FindBy(xpath="//*[contains(text(),'Finish')]")
	@CacheLookup
	WebElement finishButton;
	
	@FindBy(xpath="//*[contains(text(), 'username has already been taken')]")
	@CacheLookup
	List<WebElement> messageUserNameTaken;
	
	@FindBy(xpath="//*[contains(text(), 'Email is not a valid email address')]")
	@CacheLookup
	List<WebElement> messageInvalidEmailAddress;
	
	@FindBy(xpath="//*[contains(text(), 'Password must contain atleast 6 or more letters with combination of one capital letter,small letter,numeric,special charecter')]")
	@CacheLookup
	List<WebElement> messageInvalidPassword;
	
	@FindBy(xpath="//*[contains(text(), 't match')]")
	@CacheLookup
	List<WebElement> messageInvalidcoPassword;
	
	
	public void typeUserName(String name)
	{
		waitVisibility(this.userName).sendKeys(name);
	}
	
	public void typeEmail(String email)
	{
		waitVisibility(this.email).sendKeys(email);
	}
	
	public void typePassword(String pass)
	{
		waitVisibility(this.password).sendKeys(pass);
	}
	
	public void typeCoPassword(String coPass)
	{
		waitVisibility(this.coPassword).sendKeys(coPass);
	}
	
	public void clickSignUpButton()
	{
		waitVisibility(signUpButton).click();
	}
	
	public void clearUsernameField() {
		waitVisibility(userName).clear();
	}
	
	public void clearEmailField() {
		waitVisibility(email).clear();
	}
	
	public void clearPasswordField() {
		waitVisibility(password).clear();
	}
	
	public void clearCoPassField() {
		waitVisibility(coPassword).clear();
	}
	
	public void clickContinueButtonSecondStep()
	{
		waitVisibility(continueButtonSecondStep).click();
	}
	
	public void typeCompanyNameSecondStep(String name)
	{
		waitVisibility(companyNameSecondStep).clear();
		waitVisibility(companyNameSecondStep).sendKeys(name);
	}
	
	public void typePhoneSecondStep(String name)
	{
		waitVisibility(phoneSecondStep).clear();
		waitVisibility(phoneSecondStep).sendKeys(name);
	}
	
	public void selectCountrySecondStep()
	{
		Select dd = new Select(countrySecondStep);
		dd.selectByVisibleText("Laos");
	}
	
	public void typeCitySecondSteps(String name)
	{
		waitVisibility(citySecondStep).clear();
		waitVisibility(citySecondStep).sendKeys(name);
	}
	
	public void typeCompanyURLSecondStep(String name)
	{
		waitVisibility(companyURLsecondStep).clear();
		waitVisibility(companyURLsecondStep).sendKeys(name);
	}
	
	public void typeAddressSecondStep(String name)
	{
		waitVisibility(addressSecondStep).clear();
		waitVisibility(addressSecondStep).sendKeys(name);
	}
	
	public void typeBankHolderName(String name)
	{
		waitVisibility(bankHolderNameThirdStep).clear();
		waitVisibility(bankHolderNameThirdStep).sendKeys(name);
	}
	
	public void typeAccountNumber(String name)
	{
		waitVisibility(accountNumber).clear();
		waitVisibility(accountNumber).sendKeys(name);
	}
	
	public void typeBankName(String name)
	{
		waitVisibility(bankName).clear();
		waitVisibility(bankName).sendKeys(name);
	}
	
	public void typeSwiftCode(String name)
	{
		waitVisibility(swiftCode).clear();
		waitVisibility(swiftCode).sendKeys(name);
	}
	
	public void selectBankLocation() {
		Select dd = new Select(bankLocation);
		dd.selectByVisibleText("Laos");
	}
	
	public void clickContinueButtonThirdStep() {
		waitVisibility(continueButtonThirdStep).click();
	}
	
	public void browseContractFile() {
		waitVisibility(browseContractFile).sendKeys("/Users/fendyridwan/Documents/Project/Airpay/contractFile.pdf");
	}
	
	public void clickSkipButton() {
		waitVisibility(skipButton).click();
	}
	
	public void clickOnVerifyEmailButton() {
		waitVisibility(verifyEmailButton).click();
	}
	
	public void clickOnFinishButton() {
		waitVisibility(finishButton).click();
	}
	
	public boolean verifyUserNameIsTaken() {
		
		if(!messageUserNameTaken.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean verifyEmailAddressNotValid() {
		
		if(!messageInvalidEmailAddress.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean verifyPasswordNotValid() {
		
		if(!messageInvalidPassword.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean verifycoPasswordNotValid() {
		
		if(!messageInvalidcoPassword.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean verifySecondStepSignUp() {
		if(getURL().contains("second-step-sign-up")) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean verifyThirdStepSignUp() {
		if(getURL().contains("third-step-sign-up")) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean verifyEmailVerificationPage() {
		if(getURL().contains("email-verification")) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean verifySignUpIsSuccess() {
		if(getURL().contains("success-signup")) {
			return true;
		}else {
			return false;
		}
	}
	
	

}
