/**
 * 
 */
package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;

/**
 * @author fendyridwan
 *
 */
public class ListServicePage extends BasePage{
	
WebDriver driver;
	
	public ListServicePage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@class=\"serviceRow odd\"]")
	@CacheLookup
	List<WebElement> listService;
	
	@FindBy(xpath="//tr//td[contains(text(),\"Approved\")]")
	@CacheLookup
	List<WebElement> serviceStatus;
	
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
	
	//@FindBy(xpath="//td[contains(text(), 'Approved')]/../td/a[@class=\"btn color-e active_service\"]/../../td[@class=\"text-center sorting_1\"]")
	@FindBy(xpath="//tr/td[8]/../td[@class=\"text-center sorting_1\"]")
	@CacheLookup
	WebElement getServiceId;
	
	//@FindBy(xpath="//tr//a[@class=\"btn btn-success active_service\" and @data-service=\"336\"]")
	@FindBy(xpath="//td[contains(text(), 'Approved')]/../td/a[contains(@class,\"active_service\")]")
	@CacheLookup
	WebElement activateServiceButton;
	
	//@FindBy(xpath="//tr//a[@class=\"btn btn-danger disable_service\" and @data-service=\"336\"]")
	@FindBy(xpath="//td[contains(text(), 'Approved')]/../td/a[contains(@class,\"disable_service\")]")
	@CacheLookup
	WebElement disableServiceButton;
	
	@FindBy(id="servicesearchbtn")
	@CacheLookup
	WebElement servicesearchbtn;
	
	@FindBy(xpath="//a[@href=\"/list-service\" and contains(text(),\"Reset\")]")
	@CacheLookup
	WebElement resetButton;
	
	@FindBy(xpath="//td//a[@class=\"btn btn-primary mr-2\"]")
	@CacheLookup
	WebElement editButton;
	
	//@FindBy(xpath="//tr//a[@class=\"btn btn-success active_service\" and @data-service=\"336\"]")
	@FindBy(xpath="//td[contains(text(), 'Approved')]/../td/a[@class=\"btn color-e active_service\"]")
	@CacheLookup
	List<WebElement> activateServiceButtonExist;
	
	//@FindBy(xpath="//tr//a[@class=\"btn btn-danger disable_service\" and @data-service=\"336\"]")
	@FindBy(xpath="//td[contains(text(), 'Approved')]/../td/a[@class=\"btn color-a disable_service\"]")
	@CacheLookup
	List<WebElement> disableServiceButtonExist;
	
	@FindBy(xpath="//*[contains(text(),\"Service is activated\")]")
	@CacheLookup
	List<WebElement> statusServiceIsActivated;
	
	@FindBy(xpath="//*[contains(text(),\"Service is disabled\")]")
	@CacheLookup
	List<WebElement> statusServiceIsDisabled;
	
	@FindBy(xpath="//*[contains(text(),\"Your Service not approved yet\")]")
	@CacheLookup
	List<WebElement> statusNotApproved;
	
	@FindBy(xpath="//tr//td[contains(text(),\"Laos\") or contains(text(),\"Ltc\") or contains(text(),\"Subcription\") or contains(text(),\"Gaming\") or contains(text(),\"Submitted\")]")
	@CacheLookup
	List<WebElement> listSearchResultStg;
	
	@FindBy(xpath="//tr//td[contains(text(),\"Indonesia\") or contains(text(),\"telkomsel\") or contains(text(),\"Subcription\") or contains(text(),\"Gaming\") or contains(text(),\"Submitted\")]")
	@CacheLookup
	List<WebElement> listSearchResultProd;
	
	@FindBy(xpath="//td[contains(text(), 'Approved')]/../td/a[@class=\"btn color-e active_service\"]/../../td[@class=\"text-center sorting_1\"]")
	@CacheLookup
	List<WebElement> getServiceIdList;
	
	@FindBy(xpath="//tr/td[8 and contains(text(),\"Approved\")]")
	@CacheLookup
	List<WebElement> approvedStatusAreExist;
	
	
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
	
	public void selectCategoryFilter(String name)
	{
		Select dd = new Select(waitVisibility(categoryFilter));
		dd.selectByVisibleText(name);
	}
	
	public void clickOnSearchButton()
	{
		waitVisibility(searchButton).click();
	}
	
	@Step("Click On edit button")
	public void clickOnEditButton() {
		waitVisibility(editButton).click();
		//waitVisibility(driver.findElement(By.xpath("//td[contains(text(), '"+getServiceId()+"')]/../td/a[@class=\"btn color-e active_service\"]"))).click();
	}
	
	public String getServiceId() throws InterruptedException {
		
		return getServiceId.getText();
	}
	
	public void clickOnActivateServicebutton() throws InterruptedException {
		
		if(!activateServiceButtonExist.isEmpty()) {
			waitVisibility(activateServiceButton).click();
		}else if(!disableServiceButtonExist.isEmpty()) {
			waitVisibility(disableServiceButton).click();
			Thread.sleep(3000);
			waitVisibility(activateServiceButton).click();
		}	
	}
	
	public void clickOnDeactivateServiceButton() throws InterruptedException {
		
		if(!disableServiceButtonExist.isEmpty()) {
			waitVisibility(disableServiceButton).click();
		}else if(!activateServiceButtonExist.isEmpty()) {
			waitVisibility(activateServiceButton).click();
			Thread.sleep(3000);
			waitVisibility(disableServiceButton).click();
		}
		
	}
	
	
	
	@Step("Click On Reset Button")
	public void clickOnResetButton()
	{
		waitVisibility(resetButton).click();
	}
	
	@Step("Search Service")
	public void searchService() throws InterruptedException {
		System.out.println("-> search");
		if(getEnvironment().contains("airpay")) {
			selectCountryFilter("Indonesia");
			selectOperatorFilter("telkomsel");
			selectPaymentTypeFilter("Subscription");
			//selectStatusFilter();
			//selectCategoryFilter();
		}else if(getEnvironment().contains("stg")) {
			selectCountryFilter("Laos");
			selectOperatorFilter("Unitel");
			selectPaymentTypeFilter("Submitted");
			//selectStatusFilter();
			//selectCategoryFilter();
		}
		
		clickOnSearchButton();
	}
	
	public boolean listServiceIsExist() {
		if(!listService.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean serviceStatus() {
		if(!serviceStatus.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean listSearchResult() {
		if(getEnvironment().equals("stg")) {
			if(!listSearchResultStg.isEmpty()) {
				return true;
			}else {
				return false;
			}
		}else if(getEnvironment().equals("prod")) {
			if(!listSearchResultProd.isEmpty()) {
				return true;
			}else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public boolean statusServiceIsActivated() throws InterruptedException {
		Thread.sleep(1000);
		if(!statusServiceIsActivated.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean statusServiceIsDisabled() throws InterruptedException {
		Thread.sleep(1000);
		if(!statusServiceIsDisabled.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean approvedStatusAreExist() throws InterruptedException {
		if(!approvedStatusAreExist.isEmpty()) {
			return true;
		}else {
			return false;
		}
	}
}
