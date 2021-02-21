/**
 * 
 */
package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

/**
 * @author fendyridwan
 *
 */
public class SideMenuPage extends BasePage{
	
	WebDriver driver;
	
	public SideMenuPage(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * Profile
	 */
	@FindBy(xpath="//img[contains(@src,\"Profile\")]")
	@CacheLookup
	WebElement profileDropDown;
	
	@FindBy(xpath="//a[contains(@href,\"edit-profile\")]")
	@CacheLookup
	WebElement editProfileButton;
	
	@FindBy(xpath="//a[contains(@href,\"update-password\")]")
	@CacheLookup
	WebElement updatePasswordButton;
	
	@FindBy(xpath="//a[contains(@href,\"upload-contract\")]")
	@CacheLookup
	WebElement uploadContract;
	
	/*
	 * Service
	 */
	@FindBy(xpath="//img[contains(@src,\"Service\")]")
	@CacheLookup
	WebElement serviceDropDown;
	
	@FindBy(xpath="//a[@href=\"/create-service\"]")
	@CacheLookup
	WebElement addServiceButton;
	
	@FindBy(xpath="//a[@href=\"/list-service\"]")
	@CacheLookup
	WebElement listServiceButton;
	
	
	/*
	 * Administration
	 */
	@FindBy(xpath="//img[contains(@src,\"Administration\")]")
	@CacheLookup
	WebElement administrationDropdown;
	
	@FindBy(xpath="//a[@href=\"/service-management\"]")
	@CacheLookup
	WebElement serviceManagement;
	
	@FindBy(xpath="//a[@href=\"/users/pending-request\"]")
	@CacheLookup
	WebElement userApproval;
	
	/*
	 * User Invitation
	 */
	
	@FindBy(xpath="//img[@class=\"menu-image\" and contains(@src,\"vitation\")]")
	@CacheLookup
	WebElement userInvitationDropDown;
	
	@FindBy(xpath="//a[@href=\"/invite-user\"]")
	@CacheLookup
	WebElement inviteUser;
	
	@FindBy(xpath="//a[@href=\"/invite-list\"]")
	@CacheLookup
	WebElement invitationList;
	
	/*
	 * CS tools
	 */
	
	@FindBy(xpath="//img[@class=\"menu-image\" and contains(@src,\"Tools\")]")
	@CacheLookup
	WebElement CsToolsDropDown;
	
	@FindBy(xpath="//a[contains(@href,\"complaints\")]")
	@CacheLookup
	WebElement complaints;
	
	
	/*
	 * Documentation
	 */
	@FindBy(xpath="//img[contains(@src,\"Documentation\")]")
	@CacheLookup
	WebElement documentationDropDown;
	
	@FindBy(xpath="//a[@href=\"/documentation\"]")
	@CacheLookup
	WebElement gettingStarted;
	
	@FindBy(xpath="//a[@href=\"/documentation/merchant-on-boarding\"]")
	@CacheLookup
	WebElement merchantOnBoarding;
	
	@FindBy(xpath="//a[@href=\"/documentation/service-on-boarding\"]")
	@CacheLookup
	WebElement serviceOnBoarding;
	
	@FindBy(xpath="//a[@href=\"/documentation/integration\"]")
	@CacheLookup
	WebElement integration;
	
	@FindBy(xpath="//a[@href=\"/documentation/reporting\"]")
	@CacheLookup
	WebElement reporting;
	
	@FindBy(xpath="//a[@href=\"/documentation/frequently-asked-questions\"]")
	@CacheLookup
	WebElement faq;
	
	@FindBy(xpath="//img[contains(@src,\"/Setting\")]")
	@CacheLookup
	WebElement setting;
	
	@FindBy(xpath="//a[contains(@href,\"/list-operator\")]")
	@CacheLookup
	WebElement operator;
	
	@FindBy(xpath="//a[@href=\"/login/logout\"]")
	@CacheLookup
	WebElement logoutButton;
	
	/*
	 * Unapproved user
	 */
	@FindBy(xpath="//div//a[contains(@href,\"service\") and @style=\"display: none;\"]")
	@CacheLookup
	List<WebElement> serviceMenuOff;
	
	@FindBy(xpath="//div//a[contains(@href,\"summary\") and @style=\"display: none;\"]")
	@CacheLookup
	List<WebElement> summaryMenuOff;
	
	@FindBy(xpath="//div//a[contains(@href,\"reporting-detail\") and @style=\"display: none;\"]")
	@CacheLookup
	List<WebElement> reportingDetailOff;
	
	@FindBy(xpath="//div//a[contains(@href,\"transaction\") and @style=\"display: none;\"]")
	@CacheLookup
	List<WebElement> transactionOff;
	
	@FindBy(xpath="//div//a[contains(@href,\"invoices\") and @style=\"display: none;\"]")
	@CacheLookup
	List<WebElement> invoicesOff;
	
	@FindBy(xpath="//div//a[contains(@href,\"refund\") and @style=\"display: none;\"]")
	@CacheLookup
	List<WebElement> refundOff;
	
	@FindBy(xpath="//div//a[contains(@href,\"payout\") and @style=\"display: none;\"]")
	@CacheLookup
	List<WebElement> payoutOff;
	
	@FindBy(xpath="//div//a[contains(@href,\"msisdn\") and @style=\"display: none;\"]")
	@CacheLookup
	List<WebElement> msisdnOff;
	
	@FindBy(xpath="//div//a[contains(@href,\"blacklist\") and @style=\"display: none;\"]")
	@CacheLookup
	List<WebElement> blacklistOff;
	
	@FindBy(xpath="//div//a[contains(@href,\"subscription\") and @style=\"display: none;\"]")
	@CacheLookup
	List<WebElement> subscriptionOff;
	
	@FindBy(xpath="//div//a[contains(@href,\"complaints\") and @style=\"display: none;\"]")
	@CacheLookup
	List<WebElement> complaintsOff;

	@FindBy(xpath="//div//a[contains(@href,\"invite\") and @style=\"display: none;\"]")
	@CacheLookup
	List<WebElement> inviteOff;
	
	@FindBy(xpath="//div//a[contains(@href,\"service\")]")
	@CacheLookup
	List<WebElement> serviceMenuOn;
	
	@FindBy(xpath="//div//a[contains(@href,\"summary\")]")
	@CacheLookup
	List<WebElement> summaryMenuOn;
	
	@FindBy(xpath="//div//a[contains(@href,\"reporting-detail\")]")
	@CacheLookup
	List<WebElement> reportingDetailOn;
	
	@FindBy(xpath="//div//a[contains(@href,\"transaction\")]")
	@CacheLookup
	List<WebElement> transactionOn;
	
	@FindBy(xpath="//div//a[contains(@href,\"invoices\")]")
	@CacheLookup
	List<WebElement> invoicesOn;
	
	@FindBy(xpath="//div//a[contains(@href,\"refund\")]")
	@CacheLookup
	List<WebElement> refundOn;
	
	@FindBy(xpath="//div//a[contains(@href,\"payout\")]")
	@CacheLookup
	List<WebElement> payoutOn;
	
	@FindBy(xpath="//div//a[contains(@href,\"msisdn\")]")
	@CacheLookup
	List<WebElement> msisdnOn;
	
	@FindBy(xpath="//div//a[contains(@href,\"blacklist\")]")
	@CacheLookup
	List<WebElement> blacklistOn;
	
	@FindBy(xpath="//div//a[contains(@href,\"subscription\")]")
	@CacheLookup
	List<WebElement> subscriptionOn;
	
	@FindBy(xpath="//div//a[contains(@href,\"complaints\")]")
	@CacheLookup
	List<WebElement> complaintsOn;

	@FindBy(xpath="//div//a[contains(@href,\"invite\")]")
	@CacheLookup
	List<WebElement> inviteOn;
	
	
	@Step("Click on profile drop down")
	public void clickOnProfileDropDown()
	{
		waitVisibility(profileDropDown).click();
	}
	
	@Step("Click edit profile button")
	public void clickOnEditProfileButton() {
		waitVisibility(editProfileButton).click();
	}
	
	@Step("Click on update password button")
	public void clickOnUpdatePasswordButton() {
		waitVisibility(updatePasswordButton).click();
	}
	
	@Step("click upload contract menu")
	public void clickUploadContractMenu() {
		waitVisibility(uploadContract).click();
	}
	
	@Step("Click on service drop down menu")
	public void clickOnServiceDropDown()
	{
		waitVisibility(serviceDropDown).click();
	}
	
	@Step("Click on add service menu")
	public void clickOnAddService()
	{
		waitVisibility(addServiceButton).click();
	}
	
	@Step("Click on list service menu")
	public void clickOnListService()
	{
		waitVisibility(listServiceButton).click();
	}
	
	@Step("Click on administration drop down")
	public void clickOnAdminstrationDropDown() {
		waitVisibility(administrationDropdown).click();
	}
	
	@Step("Click on service management menu")
	public void clickOnServiceManagement() {
		waitVisibility(serviceManagement).click();
	}
	
	public void clickOnDocumentationDropDown()
	{
		waitVisibility(documentationDropDown).click();
	}
	
	@Step("Access getting started page")
	public void clickOnGettingStarted()
	{
		waitVisibility(gettingStarted).click();
	}
	
	@Step("Access merchant onboarding page")
	public void clickOnMerchantOnBoarding()
	{
		waitVisibility(merchantOnBoarding).click();
	}
	
	@Step("Access service on boarding page")
	public void clickOnServiceOnBoarding()
	{
		waitVisibility(serviceOnBoarding).click();
	}
	
	@Step("Access integration page")
	public void clickOnIntegration()
	{
		waitVisibility(integration).click();
	}
	
	@Step("Access reporting page")
	public void clickOnReporting()
	{
		waitVisibility(reporting).click();
	}
	
	@Step("Access FAQ page")
	public void clickOnFAQ()
	{
		waitVisibility(faq).click();
	}
	
	@Step("Access edit profile page")
	public void accessEditProfilePage() {
		clickOnProfileDropDown();
		clickOnEditProfileButton();
	}
	
	@Step("Access update password page")
	public void accessUpdatePasswordPage() {
		clickOnProfileDropDown();
		clickOnUpdatePasswordButton();
	}
	
	@Step("Click logout button")
	public void clickOnLogoutButton() {
		scrollIntoView("//a[@href=\"/login/logout\"]");
		waitVisibility(logoutButton).click();
	}
	
	
	public void clickOnInviteUserDropDown() {
		waitVisibility(userInvitationDropDown).click();
	}
	
	@Step("Access invite user menu")
	public void clickOnInviteUserMenu() {
		waitVisibility(inviteUser).click();
	}
	
	@Step("Access user approval page")
	public void clickOnUserApproval() {
		waitVisibility(userApproval).click();
	}
	
	@Step("Access Complaints page")
	public void clickComplaintsPage() throws InterruptedException {
		waitVisibility(CsToolsDropDown).click();
		waitVisibility(complaints).click();
		Thread.sleep(2000);
	}
	
	@Step("Click on Setting drop down")
	public void clickOnSettingDropDown() {
		waitVisibility(setting).click();
	}
	
	@Step("Click on operator")
	public void clickOnOperator() {
		waitVisibility(operator).click();
	}
	
	@Step("Access Complaints list page")
	public void clickComplaintsListPage() throws InterruptedException {
		try {
			waitVisibility(complaints).click();
		}
		catch(Exception e) {
			waitVisibility(CsToolsDropDown).click();
			waitVisibility(complaints).click();
		}
		Thread.sleep(2000);
	}
	
	@Step("Verify login for unapproved user")
	public boolean unapprovedUserlogin() throws InterruptedException {
		Thread.sleep(2000);
		if((!serviceMenuOff.isEmpty()==true)&&(!summaryMenuOff.isEmpty()==true)&&(!reportingDetailOff.isEmpty()==true)
				&&(!transactionOff.isEmpty()==true)&&(!invoicesOff.isEmpty()==true)&&(!refundOff.isEmpty()==true)
				&&(!payoutOff.isEmpty()==true)&&(!msisdnOff.isEmpty()==true)&&(!blacklistOff.isEmpty()==true)
				&&(!subscriptionOff.isEmpty()==true)&&(!complaintsOff.isEmpty()==true)) {
			return true;
		}else {
			return false;
		}
		
	}
	
	@Step("Verify login for approved user")
	public boolean approvedUserlogin() {
		if((!serviceMenuOn.isEmpty()==true)&&(!summaryMenuOn.isEmpty()==true)&&(!reportingDetailOn.isEmpty()==true)
				&&(!transactionOn.isEmpty()==true)&&(!invoicesOn.isEmpty()==true)&&(!refundOn.isEmpty()==true)
				&&(!payoutOn.isEmpty()==true)&&(!msisdnOn.isEmpty()==true)&&(!blacklistOn.isEmpty()==true)
				&&(!subscriptionOn.isEmpty()==true)&&(!complaintsOn.isEmpty()==true)) {
			return true;
		}else {
			return false;
		}
		
	}

}
