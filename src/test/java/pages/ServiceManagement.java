/**
 * 
 */
package pages;

import static org.testng.Assert.assertTrue;

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
public class ServiceManagement extends BasePage{
	
	WebDriver driver;
	
	public ServiceManagement(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * filter section
	 */
	@FindBy(id="filter_country")
	@CacheLookup
	WebElement filterCountry;
	
	@FindBy(id="filter_operator")
	@CacheLookup
	WebElement filterOperator;
	
	@FindBy(id="payment_type")
	@CacheLookup
	WebElement paymentType;
	
	@FindBy(id="status")
	@CacheLookup
	WebElement statusFilter;
	
	@FindBy(id="category")
	@CacheLookup
	WebElement categoryFilter;
	
	@FindBy(id="servicesearchbtn")
	@CacheLookup
	WebElement searchButton;
	
	@FindBy(xpath="//tr//td[8 and (contains(text(),\"Reject\") or contains(text(),\"Submitted\"))]/../td/a[@class=\"btn color-e approve_service\"]")
	@CacheLookup
	WebElement approveButton;
	
	@FindBy(xpath="//tr//td[8 and (contains(text(),\"Approved\") or contains(text(),\"Submitted\"))]/../td/a[@class=\"btn color-a reject_service\"]")
	@CacheLookup
	WebElement rejectButton;
	
	@FindBy(xpath="//a[contains(text(),\"Reset\")]")
	@CacheLookup
	WebElement resetButton;
	
	
	@FindBy(xpath="//tr[@class=\"serviceRow odd\"]//td[contains(text(),\"Indonesia\")]")
	@CacheLookup
	List<WebElement> searchResultCountry;
	
	@FindBy(xpath="//tr[@class=\"serviceRow odd\"]//td[contains(text(),\"subscription\")]")
	@CacheLookup
	List<WebElement> searchResultSubscription;
	
	@FindBy(xpath="//tr[@class=\"serviceRow odd\"]//td[contains(text(),\"Telkomsel\")]")
	@CacheLookup
	List<WebElement> searchResultOperator;
	
	@FindBy(xpath="//tr[@class=\"serviceRow odd\"]//td[contains(text(),\"Approved\")]")
	@CacheLookup
	List<WebElement> searchResultStatus;
	
	@FindBy(xpath="//tr//td[8 and (contains(text(),\"Reject\") or contains(text(),\"Submitted\"))]/../td/a[contains(@class,\"approve_service\")]")
	@CacheLookup
	List<WebElement> approveButtonExist;
	
	@FindBy(xpath="//tr//td[8 and (contains(text(),\"Approved\") or contains(text(),\"Submitted\"))]/../td/a[contains(@class,\"reject_service\")]")
	@CacheLookup
	List<WebElement> rejectButtonExist;
	
	@FindBy(xpath="//*[contains(text(),\"Service is Deactivated\")]")
	@CacheLookup
	List<WebElement> serviceDeactivated;
	
	@FindBy(xpath="//*[contains(text(),\"Service is successfully approved\")]")
	@CacheLookup
	List<WebElement> serviceApproved;
	
	@FindBy(xpath="//*[contains(text(),\"List of Services\")]")
	@CacheLookup
	List<WebElement> ListOfServiceDisplayed;
	
	@FindBy(xpath="//tr//td[1]")
	@CacheLookup
	List<WebElement> serviceIdIsExist;
	
	@FindBy(xpath="//tr//td[2]")
	@CacheLookup
	List<WebElement> merchantNameIsExist;
	
	@FindBy(xpath="//tr//td[3]")
	@CacheLookup
	List<WebElement> serviceNameIsExist;
	
	@FindBy(xpath="//tr//td[4]")
	@CacheLookup
	List<WebElement> countryIsExist;
	
	@FindBy(xpath="//tr//td[5]")
	@CacheLookup
	List<WebElement> operatorIsExist;
	
	@FindBy(xpath="//tr//td[6]")
	@CacheLookup
	List<WebElement> paymentTypeIsExist;
	
	@FindBy(xpath="//tr//td[7]")
	@CacheLookup
	List<WebElement> priceIsExist;
	
	@FindBy(xpath="//tr//td[8]")
	@CacheLookup
	List<WebElement> categoryIsExist;
	
	@FindBy(xpath="//tr//td[9]")
	@CacheLookup
	List<WebElement> statusIsExist;
	
	@FindBy(xpath="//tr//td[10]")
	@CacheLookup
	List<WebElement> actionButtonIsExist;
	
	public void selectCountryFilter(String name)
	{
		Select dd = new Select(waitVisibility(filterCountry));
		dd.selectByVisibleText(name);
	}
	
	public void selectOperatorFilter(String name) throws InterruptedException
	{
		Select dd = new Select(waitVisibility(filterOperator));
		Thread.sleep(2000);
		dd.selectByVisibleText(name);
	}
	
	public void selectPaymentTypeFilter(String name)
	{ 
		Select dd = new Select(waitVisibility(paymentType));
		dd.selectByVisibleText(name);
	}
	
	public void selectStatusFilter(String name)
	{
		Select dd = new Select(waitVisibility(statusFilter));
		dd.selectByVisibleText(name);
	}
	
	@Step("Search Service")
	public void searchService() throws InterruptedException {
		System.out.println("-> search");
		if(getEnvironment().contains("prod")) {
			selectCountryFilter("Indonesia");
			selectOperatorFilter("telkomsel");
			selectPaymentTypeFilter("Subscription");
			selectStatusFilter("Submitted");
			
		}else if(getEnvironment().contains("stg")) {
			selectCountryFilter("Laos");
			selectOperatorFilter("ltc");
			selectPaymentTypeFilter("Submitted");
			selectStatusFilter("Submitted");
		}
		
		clickOnSearchButton();
	}
	
	public void clickOnSearchButton()
	{
		waitVisibility(searchButton).click();
	}
	
	public void clickOnResetButton()
	{
		waitVisibility(resetButton).click();
	}
	
	public void clickOnApproveButton() throws InterruptedException {
		if(approveButtonisExist()==true) {
			waitVisibility(approveButton).click();
		}else if(rejectButtonExist()==true) {
			waitVisibility(rejectButton).click();
			Thread.sleep(2000);
			clickOnResetButton();
			Thread.sleep(2000);
			searchService();
			waitVisibility(approveButton).click();
		}else {
			assertTrue(false, "cannot find approve button");
		}
		
	}
	
	public void clickOnRejectButton() throws InterruptedException {
		if(rejectButtonExist()==true) {
			waitVisibility(rejectButton).click();
		}else if(approveButtonisExist()==true) {
			waitVisibility(approveButton).click();
			Thread.sleep(2000);
			clickOnResetButton();
			Thread.sleep(2000);
			searchService();
			waitVisibility(rejectButton).click();
		}else {
			assertTrue(false, "cannot find approve button");
		}
		
	}
	
	public boolean countryIsFiltered() {
		if(!searchResultCountry.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean operatorIsFiltered() {
		if(!searchResultOperator.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean subcriptionTypeIsFiltered() {
		if(!searchResultSubscription.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean statusTypeIsFiltered() {
		if(!searchResultStatus.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean approveButtonisExist() {
		if(!approveButtonExist.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean rejectButtonExist() {
		if(!rejectButtonExist.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean serviceApproved() {
		if(!serviceApproved.isEmpty()) {
			
			System.out.println("masuk sini harusnya");
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean serviceDeactivated() {
		if(!serviceDeactivated.isEmpty()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean ListOfServiceDisplayed() {
		if(!serviceIdIsExist.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}

	public boolean ListOfMerchantNameDisplayed() {
		if(!merchantNameIsExist.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean ListOfServiceNameDisplayed() {
		if(!serviceNameIsExist.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean ListOfOperatorDisplayed() {
		if(!operatorIsExist.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean ListOfCountryDisplayed() {
		if(!countryIsExist.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean ListOfPaymentDisplayed() {
		if(!paymentTypeIsExist.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean ListOfPriceDisplayed() {
		if(!priceIsExist.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean ListOfCategoryDisplayed() {
		if(!categoryIsExist.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean ListOfStatusDisplayed() {
		if(!statusIsExist.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean ListOfActionDisplayed() {
		if(!actionButtonIsExist.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
}
