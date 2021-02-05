/**
 * 
 */
package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * @author fendyridwan
 *
 */
public class EditServicePage extends BasePage{
	
	WebDriver driver;
	
	public EditServicePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="list-home-list")
	@CacheLookup
	WebElement infoTab;
	
	@FindBy(id="list-profile-list")
	@CacheLookup
	WebElement editTab;
	
	@FindBy(id="list-messages-list")
	@CacheLookup
	WebElement integrationTab;
	
	//Edit Tab
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
	
	@FindBy(id="first_message")
	@CacheLookup
	WebElement firstMessage;
	
	@FindBy(id="renewal_message")
	@CacheLookup
	WebElement renewalMessage;
	
	@FindBy(id="unsubscribe_message")
	@CacheLookup
	WebElement unSubMessage;
	
	@FindBy(id="keyword")
	@CacheLookup
	WebElement keyword;
	
	@FindBy(id="sub_keyword")
	@CacheLookup
	WebElement sub_keyword;
	
	@FindBy(xpath="//label[@for=\"subscribe_duration_daily\" and contains(text(),\"Daily\")]")
	@CacheLookup
	WebElement subDuration;
	
	@FindBy(id="freemium_duration")
	@CacheLookup
	WebElement freemium_duration;
	
	@FindBy(id="service_logo")
	@CacheLookup
	WebElement service_logo;
	
	@FindBy(name="price_point")
	@CacheLookup
	WebElement pricePoint;
	
	@FindBy(xpath="//select[@name=\"price_point\"]//option[2]")
	@CacheLookup
	WebElement pricePointSelectValue;
	
	@FindBy(xpath="//button[@id=\"edit_service_step_three\"]")
	@CacheLookup
	WebElement nextButton1;
	
	@FindBy(xpath="//button[@id=\"edit_service_step_four\"]")
	@CacheLookup
	WebElement nextButton2;
	
	@FindBy(xpath="//button[@id=\"edit_service_step_five\"]")
	@CacheLookup
	WebElement nextButton3;
	
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
	
	@FindBy(xpath="//input[@id=\"renewal_message\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatoryRenewalMessage;
	
	@FindBy(xpath="//input[@id=\"unsubscribe_message\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatoryUnSubcribeMessage;
	
	@FindBy(xpath="//input[@id=\"keyword\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatoryKeyword;
	
	@FindBy(xpath="//input[@id=\"sub_keyword\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatorySubKeyword;
	
	@FindBy(xpath="//div[@class=\"border service_logo_div\" and contains(@style,\"red\")]")
	@CacheLookup
	List<WebElement> alertMandatoryServiceLogo;
	
	@FindBy(xpath="//div[@class=\"content-title\"]//span[contains(text(),\"Edit Service\")]")
	@CacheLookup
	List<WebElement> editServicePageisDisplayed;
	
	@FindBy(xpath="//li[@class=\"list-inline-item active\" and contains(text(),\"2\")]")
	@CacheLookup
	List<WebElement> pricePointIsDisplayed;
	
	public void clickOnInfoTab() {
		waitVisibility(infoTab).click();
	}
	
	public void clickOnEditProfileTab() {
		waitVisibility(editTab).click();
	}
	
	public void clickOnIntegrationTab() {
		waitVisibility(integrationTab).click();
	}
	
	public void typeServiceName(String name)
	{
		scrollIntoView(serviceName);
		waitVisibility(serviceName).clear();
		waitVisibility(serviceName).sendKeys(name);
	}
	
	public void typeCallBackURL(String name)
	{
		scrollIntoView(callBackURL);
		waitVisibility(callBackURL).clear();
		waitVisibility(callBackURL).sendKeys(name);
	}
	
	public void typeServiceURL(String name)
	{
		scrollIntoView(serviceURL);
		waitVisibility(serviceURL).clear();
		waitVisibility(serviceURL).sendKeys(name);
	}
	
	public void typeProviderName(String name)
	{
		scrollIntoView(providerName);
		waitVisibility(providerName).clear();
		waitVisibility(providerName).sendKeys(name);
	}
	
	public void typeDescription(String name)
	{
		scrollIntoView(description);
		waitVisibility(description).clear();
		waitVisibility(description).sendKeys(name);
	}
	
	public void selectCategory()
	{
		scrollIntoView(category);
		Select dd = new Select(category);
		dd.selectByVisibleText("Gaming");
	}
	
	public void typeFirstMessage(String name)
	{
		scrollIntoView(firstMessage);
		waitVisibility(firstMessage).clear();
		waitVisibility(firstMessage).sendKeys(name);
	}
	
	public void typeRenewalMessage(String name)
	{
		scrollIntoView(renewalMessage);
		waitVisibility(renewalMessage).clear();
		waitVisibility(renewalMessage).sendKeys(name);
	}
	
	public void typeUnSubMessage(String name)
	{
		scrollIntoView(unSubMessage);
		waitVisibility(unSubMessage).clear();
		waitVisibility(unSubMessage).sendKeys(name);
	}
	
	public void typeKeyWord(String name)
	{
		scrollIntoView(keyword);
		waitVisibility(keyword).clear();
		waitVisibility(keyword).sendKeys(name);
	}
	
	public void typeSubKeyWord(String name)
	{
		scrollIntoView(sub_keyword);
		waitVisibility(sub_keyword).clear();
		waitVisibility(sub_keyword).sendKeys(name);
	}
	
	public void clickOnSubDuration()
	{
		scrollIntoView(subDuration);
		waitVisibility(subDuration).click();
	}
	
	public void typeSubKeyword(String name)
	{
		scrollIntoView(sub_keyword);
		waitVisibility(sub_keyword).clear();
		waitVisibility(sub_keyword).sendKeys(name);
	}
	
	public void typeFreemiumDuration(String name)
	{
		scrollIntoView(freemium_duration);
		waitVisibility(freemium_duration).clear();
		waitVisibility(freemium_duration).sendKeys(name);
	}
	
	public void clickOnNextButton1() {
		scrollIntoViewByXpath("//button[@id=\"edit_service_step_three\"]");
		//driver.getPageSource();
		clickELement(nextButton1);
		
	}
	
	public void selectPricePoint()
	{
		//Select dd = new Select(pricePoint);
		//dd.deselectByValue("2000");
		waitVisibility(pricePoint).click();
		waitVisibility(pricePointSelectValue).click();
	}
	
	public void clickOnNextButton2() {
		clickELement(nextButton2);
	}
	
	public void clickOnNextButton3() {
		clickELement(nextButton3);
	}
	
	public void emptyAllFields() {
		scrollIntoView(serviceName);
		waitVisibility(serviceName).clear();
		scrollIntoView(callBackURL);
		waitVisibility(callBackURL).clear();
		scrollIntoView(serviceURL);
		waitVisibility(serviceURL).clear();
		scrollIntoView(providerName);
		waitVisibility(providerName).clear();
		scrollIntoView(description);
		waitVisibility(description).clear();
		scrollIntoView(keyword);
		waitVisibility(keyword).clear();
		scrollIntoView(sub_keyword);
		waitVisibility(sub_keyword).clear();
		scrollIntoView(firstMessage);
		waitVisibility(firstMessage).clear();
		scrollIntoView(renewalMessage);
		waitVisibility(renewalMessage).clear();
		scrollIntoView(unSubMessage);
		waitVisibility(unSubMessage).clear();
		scrollIntoView(freemium_duration);
		waitVisibility(freemium_duration).clear();
		
	}
	
	public boolean validateServiceNameIsEdited(String name) {
		scrollIntoView(serviceName);
		if(waitVisibility(serviceName).getAttribute("value").contains(name)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean validateCallBackURLIsEdited(String name) {
		scrollIntoView(callBackURL);
		if(waitVisibility(callBackURL).getAttribute("value").contains(name)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean validateServiceURLIsEdited(String name) {
		scrollIntoView(serviceURL);
		if(waitVisibility(serviceURL).getAttribute("value").contains(name)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean validateKeywordEdited(String name) {
		scrollIntoView(keyword);
		if(waitVisibility(keyword).getAttribute("value").contains(name)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean validateSubKeywordEdited(String name) {
		scrollIntoView(sub_keyword);
		if(waitVisibility(sub_keyword).getAttribute("value").contains(name)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean validateDescriptionEdited(String name) {
		scrollIntoView(description);
		if(waitVisibility(description).getAttribute("value").contains(name)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean validateFirstMessageEdited(String name) {
		scrollIntoView(firstMessage);
		if(waitVisibility(firstMessage).getAttribute("value").contains(name)) {
			return true;
		}else {
			return false;
		}
		
	} 
	
	public boolean validateRenewalMessageEdited(String name) {
		scrollIntoView(renewalMessage);
		if(waitVisibility(renewalMessage).getAttribute("value").contains(name)) {
			return true;
		}else {
			return false;
		}
		
	} 
	
	public boolean validateProviderNameIsEdited(String name) {
		scrollIntoView(providerName);
		if(waitVisibility(providerName).getAttribute("value").contains(name)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean validateUnsubcribeMessageIsEdited(String name) {
		scrollIntoView(unSubMessage);
		if(waitVisibility(unSubMessage).getAttribute("value").contains(name)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean validateFreemiumDurationIsEdited(String name) {
		scrollIntoView(freemium_duration);
		if(waitVisibility(freemium_duration).getAttribute("value").contains(name)) {
			return true;
		}else {
			return false;
		}
		
	}
	

	public boolean alertMandatoryServiceName() {
		scrollIntoView(serviceName);
		if(!alertMandatoryServiceName.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryCallBackURL() {
		scrollIntoView(callBackURL);
		if(!alertMandatoryCallBackURL.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryServiceURL() {
		scrollIntoView(serviceURL);
		if(!alertMandatoryServiceURL.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryProviderName() {
		scrollIntoView(providerName);
		if(!alertMandatoryProviderName.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryDescription() {
		scrollIntoView(description);
		if(!alertMandatoryDescription.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryCategory() {
		scrollIntoView(category);
		if(!alertMandatoryCategory.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryFirstMessage() {
		scrollIntoView(firstMessage);
		if(!alertMandatoryFirstMessage.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryRenewalMessage() {
		scrollIntoView(renewalMessage);
		if(!alertMandatoryRenewalMessage.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryUnsubcribeMessage() {
		scrollIntoView(unSubMessage);
		if(!alertMandatoryUnSubcribeMessage.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatoryKeyword() {
		scrollIntoView(keyword);
		if(!alertMandatoryKeyword.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean alertMandatorySubKeyword() {
		scrollIntoView(sub_keyword);
		if(!alertMandatorySubKeyword.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean EditHasPassed() {
		if(!pricePointIsDisplayed.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}
