/**
 * 
 */
package pages;

import java.io.File;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import bases.BaseWeb;

/**
 * @author fendyridwan
 *
 */
public class AddServicePage extends BasePage{
	
	WebDriver driver;
	
	public AddServicePage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(id="service_step_one")
	@CacheLookup
	WebElement createServiceButtonFirstStep;
	
	@FindBy(xpath="//*[@for=\"service_type_websdk\"]")
	@CacheLookup
	WebElement webSDK;
	
	@FindBy(xpath="//*[@for=\"service_type_hosteddcb\"]")
	@CacheLookup
	WebElement hostedDCB;
	
	@FindBy(xpath="//*[@for=\"payment_type_subscription\"]")
	@CacheLookup
	WebElement subcription;
	
	@FindBy(xpath="//*[@for=\"payment_type_onetimepurchase\"]")
	@CacheLookup
	WebElement otp;
	
	@FindBy(xpath="//*[contains(@for,\"indonesia\")]")
	@CacheLookup
	WebElement countryIndonesia;
	
	@FindBy(xpath="//*[contains(@for,\"laos\")]")
	@CacheLookup
	WebElement countryLaos;
	
	@FindBy(id="service_step_two")
	@CacheLookup
	WebElement nextButtonSecondStep;
	
	@FindBy(id="service_step_three")
	@CacheLookup
	WebElement nextButtonThirdStep;
	
	@FindBy(xpath="//img[contains(@src,\"elkomsel\")]/..")
	@CacheLookup
	WebElement selectOperator;
	
	@FindBy(xpath="//img[contains(@src,\"nitel\")]/..")
	@CacheLookup
	WebElement selectOperatorUnitel;
	
	@FindBy(id="service_step_four")
	@CacheLookup
	WebElement nextButtonFourStep;

	@FindBy(id="service_name")
	@CacheLookup
	WebElement serviceName;
	
	@FindBy(id="call_back_url")
	@CacheLookup
	WebElement callBackURL;
	
	@FindBy(id="service_url")
	@CacheLookup
	WebElement serviceURL;
	
	@FindBy(id="provider_name")
	@CacheLookup
	WebElement providerName;
	
	@FindBy(id="description")
	@CacheLookup
	WebElement description;
	
	@FindBy(id="category")
	@CacheLookup
	WebElement category;
	
	@FindBy(id="fmessage")
	@CacheLookup
	WebElement firstMessage;
	
	@FindBy(id="rmessage")
	@CacheLookup
	WebElement renewalMessage;
	
	@FindBy(id="umessage")
	@CacheLookup
	WebElement unSubMessage;
	
	@FindBy(id="keyword")
	@CacheLookup
	WebElement keyword;
	
	@FindBy(id="sub_keyword")
	@CacheLookup
	WebElement sub_keyword;
	
	@FindBy(xpath="//input[@id=\"channel_type_sms\"]")
	@CacheLookup
	WebElement channelTypeSMS;
	
	@FindBy(xpath="//label[@for=\"subscribe_duration_daily\" and contains(text(),\"Daily\")]")
	@CacheLookup
	WebElement subDuration;
	
	@FindBy(id="freemium_duration")
	@CacheLookup
	WebElement freemium_duration;
	
	@FindBy(xpath="//input[@type='file' and @id=\"service_logo\"]")
	//@FindBy(id="service_logo")
	@CacheLookup
	WebElement service_logo;
	
	/*
	 * fifth step
	 */
	@FindBy(name="price_point")
	@CacheLookup
	WebElement price_point;
	
	@FindBy(id="service_step_five")
	@CacheLookup
	WebElement nextButtonFifthStep;
	
	/*
	 * Sixth Step
	 */
	@FindBy(id="subscription_flow")
	@CacheLookup
	WebElement subscription_flow;
	
	@FindBy(id="unsubscription_flow")
	@CacheLookup
	WebElement unsubscription_flow;
	
	@FindBy(id="service_step_six")
	@CacheLookup
	WebElement submitButton;
	
	@FindBy(xpath="//*[contains(text(),\"Price Point\")]")
	@CacheLookup
	List<WebElement> pricePointIsExist;
	
	@FindBy(xpath="//div[@id=\"renewal_block\" and @style=\"display: none;\"]")
	@CacheLookup
	List<WebElement> renewalMessageList;
	
	@FindBy(xpath="//div[@id=\"unsubscribe_block\" and @style=\"display: none;\"]")
	@CacheLookup
	List<WebElement> unSubMessageList;
	
	@FindBy(xpath="//div[@id=\"channel_type_block\" and @style=\"display: none;\"]")
	@CacheLookup
	List<WebElement> channelTypeIsExist;
	
	@FindBy(xpath="//fieldset[@class=\"card\" and @id=\"select_service_type\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatoryServiceType;
	
	@FindBy(xpath="//fieldset[@class=\"card\" and @id=\"select_payment_type\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatoryPaymentType;
	
	@FindBy(id="select_service_country")
	@CacheLookup
	List<WebElement> select_service_country;
	
	@FindBy(xpath="//*[@class=\"card\" and @id=\"select_service_country\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatorySelectServiceCountry;
	
	@FindBy(id="select_service_operators")
	@CacheLookup
	List<WebElement> select_service_operators;
	
	@FindBy(xpath="//*[@class=\"card\" and @id=\"select_service_operators\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatorySelectServiceOperator;
	
	@FindBy(xpath="//*[contains(text(),\"Service Description\")]")
	@CacheLookup
	List<WebElement> verifyFourthStepDisplayed;
	
	/*
	 * Four Step of create service 
	 */
	@FindBy(xpath="//input[@id=\"service_name\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatoryServiceName;
	
	@FindBy(xpath="//input[@id=\"call_back_url\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatoryCallBackURL;
	
	@FindBy(xpath="//input[@id=\"service_url\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatoryServiceURL;
	
	@FindBy(xpath="//input[@id=\"provider_name\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatoryProviderName;
	
	@FindBy(xpath="//*[@id=\"description\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatoryDescription;
	
	@FindBy(xpath="//*[@id=\"category\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatoryCategory;
	
	@FindBy(xpath="//input[@id=\"fmessage\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatoryFirstMessage;
	
	@FindBy(xpath="//input[@id=\"keyword\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatoryKeyword;
	
	@FindBy(xpath="//input[@id=\"sub_keyword\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatorySubKeyword;
	
	@FindBy(xpath="//div[@class=\"border service_logo_div\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatoryServiceLogo;
	
	@FindBy(xpath="//*[contains(text(),\"Service Flow\")]")
	@CacheLookup
	List<WebElement> ServiceFlowIsExist;
	
	public void clickOnWebSDK() {
		webSDK.click();
	}
	
	public void clickOnHostedDCB() {
		hostedDCB.click();
	}
	
	public void clickOnSubcription() {
		subcription.click();
	}
	
	public void clickOnOTP() {
		waitVisibility(otp).click();
	}
	
	public void clickOnCreateServiceButtonFirstStep() {
		//waitVisibility(createServiceButtonFirstStep).click();
		clickELement(createServiceButtonFirstStep);
	}
	
	public void clickOnIndonesiaCountry() {
		waitVisibility(countryIndonesia).click();
	}
	
	public void clickOnLaosCountry() {
		waitVisibility(countryLaos).click();
	}
	
	public void clickNextButtonSecondStep() {
		waitVisibility(nextButtonSecondStep).click();
	}
	
	public void clickOnNextButtonThirdStep() {
		waitVisibility(nextButtonThirdStep).click();
	}
	
	public void selectOperator() {
		waitVisibility(selectOperator).click();
	}
	
	public void selectOperatorUnitel() {
		waitVisibility(selectOperatorUnitel).click();
	}
	
	public void clickOnNextButtonFourStep() throws InterruptedException {
		scrollIntoView("//button[@id=\"service_step_four\" and contains(text(),\"Next\")]");
		//nextButtonFourStep.click();
		//waitVisibility(nextButtonFourStep).click();
		//driver.findElement(By.xpath("//button[@id=\"service_step_four\" and contains(text(),\"Next\")]").click();
		clickELement(nextButtonFourStep);
		
	}
	
	public void typeServiceName(String name)
	{
		waitVisibility(serviceName).clear();
		waitVisibility(serviceName).sendKeys(name);
	}
	
	public void typeCallBackURL(String name)
	{
		waitVisibility(callBackURL).clear();
		waitVisibility(callBackURL).sendKeys(name);
	}
	
	public void typeServiceURL(String name)
	{
		waitVisibility(serviceURL).clear();
		waitVisibility(serviceURL).sendKeys(name);
	}
	
	public void typeProviderName(String name)
	{
		waitVisibility(providerName).clear();
		waitVisibility(providerName).sendKeys(name);
	}
	
	public void typeDescription(String name)
	{
		waitVisibility(description).clear();
		waitVisibility(description).sendKeys(name);
	}
	
	public void selectCategory()
	{
		Select dd = new Select(category);
		dd.selectByVisibleText("Gaming");
	}
	
	public void typeFirstMessage(String name)
	{
		waitVisibility(firstMessage).clear();
		waitVisibility(firstMessage).sendKeys(name);
	}
	
	public void typeRenewalMessage(String name)
	{
		if(renewalMessageList()==false) {
			waitVisibility(renewalMessage).clear();
			waitVisibility(renewalMessage).sendKeys(name);
		}
	}
	
	public void typeUnSubMessage(String name)
	{
		if(unSubMessageList()==false) {
			waitVisibility(unSubMessage).clear();
			waitVisibility(unSubMessage).sendKeys(name);
		}
	}
	
	public void typeKeyWord(String name)
	{
		waitVisibility(keyword).clear();
		waitVisibility(keyword).sendKeys(name);
	}
	
	public void clickOnSubDuration()
	{
		waitVisibility(subDuration).click();
	}
	
	public void typeSubKeyword(String name)
	{
		waitVisibility(sub_keyword).clear();
		waitVisibility(sub_keyword).sendKeys(name);
	}
	
	public void selectChannelType() {
		if(channelTypeIsExist()==false) {
			try {
				channelTypeSMS.click();
			}catch(Exception e) {
				clickELement(channelTypeSMS);
			}
			
		}
	}

	public void uploadLogoService()
	{
		scrollIntoView("//button[@id=\"service_step_four\" and contains(text(),\"Next\")]");
		
		String filename = "attachment/logo.png";
	    File file = new File(filename);
	    String path = file.getAbsolutePath();
	    System.out.println(path);
	    (service_logo).sendKeys(path);

	}
	
	/*
	 * Fifth Step price point
	 */
	public void selectPricePoint()
	{
		Select dd = new Select(price_point);
		dd.selectByIndex(1);
	}
	
	public void clickOnNextButtonFifthStep() {
		try {
			waitVisibility(nextButtonFifthStep).click();
		}catch(Exception e) {
			clickELement(nextButtonFifthStep);
		}
	}
	
	/*
	 * Sixth Step Service Flow
	 */
	public void SubcriptionFlow()
	{
		scrollIntoView("//button[@id=\"service_step_four\" and contains(text(),\"Next\")]");
		
		String filename = "attachment/contractFile.pdf";
	    File file = new File(filename);
	    String path = file.getAbsolutePath();
	    System.out.println(path);
	    (subscription_flow).sendKeys(path);

	}
	
	public void UnSubcriptionFlow()
	{
		scrollIntoView("//button[@id=\"service_step_four\" and contains(text(),\"Next\")]");
		
		String filename = "attachment/contractFile.pdf";
	    File file = new File(filename);
	    String path = file.getAbsolutePath();
	    System.out.println(path);
	    (unsubscription_flow).sendKeys(path);

	}
	
	public void clickOnSubmitButton() {
		try{
			waitVisibility(submitButton).click();
		}catch(Exception e) {
			clickELement(submitButton);
		}
		
	}
	
	
	public void selectRandomlyServiceType() {
		int x = new Random().nextInt(2);
		if(x==1) {
			clickOnWebSDK();
		}else {
			clickOnHostedDCB();
		}
	}
	
	public void selectRandomlyPaymentType() {
		int x = new Random().nextInt(1);
		if(x==1) {
			clickOnSubcription();
		}else {
			clickOnOTP();
		}
	}
	
	public boolean alertMandatoryServiceType() {
		if(!alertMandatoryServiceType.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryPaymentType() {
		if(!alertMandatoryPaymentType.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean select_service_country() {
		if(!select_service_country.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatorySelectServiceCountry() {
		if(!alertMandatorySelectServiceCountry.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean select_service_operators() {
		if(!select_service_operators.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public void selectRandomlyCountry() {
		int x = new Random().nextInt(2);
		if(x==1) {
			clickOnIndonesiaCountry();
		}else {
			clickOnLaosCountry();
		}
	}
	
	public boolean alertMandatorySelectServiceOperator() {
		if(!alertMandatorySelectServiceOperator.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean verifyFourthStepDisplayed() {
		if(!verifyFourthStepDisplayed.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	/*
	 * 
	 */
	
	public boolean alertMandatoryServiceName() {
		if(!alertMandatoryServiceName.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryCallBackURL() {
		if(!alertMandatoryCallBackURL.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryServiceURL() {
		if(!alertMandatoryServiceURL.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryProviderName() {
		if(!alertMandatoryProviderName.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryDescription() {
		if(!alertMandatoryDescription.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryCategory() {
		if(!alertMandatoryCategory.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryFirstMessage() {
		if(!alertMandatoryFirstMessage.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryKeyword() {
		if(!alertMandatoryKeyword.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatorySubKeyword() {
		if(!alertMandatorySubKeyword.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryServiceLogo() {
		if(!alertMandatoryServiceLogo.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean renewalMessageList() {
		if(!renewalMessageList.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean channelTypeIsExist() {
		if(!channelTypeIsExist.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean unSubMessageList() {
		if(!unSubMessageList.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean pricePointIsExist() {
		if(!pricePointIsExist.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean ServiceFlowIsExist() {
		if(!ServiceFlowIsExist.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	

}
