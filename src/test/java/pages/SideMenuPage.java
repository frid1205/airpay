/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

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
	
	@FindBy(xpath="//a[@href=\"/login/logout\"]")
	@CacheLookup
	WebElement logoutButton;
	
	public void clickOnProfileDropDown()
	{
		waitVisibility(profileDropDown).click();
	}
	
	public void clickOnEditProfileButton() {
		waitVisibility(editProfileButton).click();
	}
	
	public void clickOnUpdatePasswordButton() {
		waitVisibility(updatePasswordButton).click();
	}
	
	public void clickUploadContractMenu() {
		waitVisibility(uploadContract).click();
	}
	
	public void clickOnServiceDropDown()
	{
		waitVisibility(serviceDropDown).click();
	}
	
	public void clickOnAddService()
	{
		waitVisibility(addServiceButton).click();
	}
	
	public void clickOnListService()
	{
		waitVisibility(listServiceButton).click();
	}
	
	public void clickOnAdminstrationDropDown() {
		waitVisibility(administrationDropdown).click();
	}
	
	public void clickOnServiceManagement() {
		waitVisibility(serviceManagement).click();
	}
	
	public void clickOnDocumentationDropDown()
	{
		waitVisibility(documentationDropDown).click();
	}
	
	public void clickOnGettingStarted()
	{
		waitVisibility(gettingStarted).click();
	}
	
	public void clickOnMerchantOnBoarding()
	{
		waitVisibility(merchantOnBoarding).click();
	}
	
	public void clickOnServiceOnBoarding()
	{
		waitVisibility(serviceOnBoarding).click();
	}
	
	public void clickOnIntegration()
	{
		waitVisibility(integration).click();
	}
	
	
	public void clickOnReporting()
	{
		waitVisibility(reporting).click();
	}
	
	public void clickOnFAQ()
	{
		waitVisibility(faq).click();
	}
	
	public void accessEditProfilePage() {
		clickOnProfileDropDown();
		clickOnEditProfileButton();
	}
	
	public void accessUpdatePasswordPage() {
		clickOnProfileDropDown();
		clickOnUpdatePasswordButton();
	}
	
	public void clickOnLogoutButton() {
		//scrollIntoView("//a[@href=\"/login/logout\"]");
		waitVisibility(logoutButton).click();
	}
	
	public void clickOnInviteUserDropDown() {
		waitVisibility(userInvitationDropDown).click();
	}
	
	public void clickOnInviteUserMenu() {
		waitVisibility(inviteUser).click();
	}
	
	public void clickOnUserApproval() {
		waitVisibility(userApproval).click();
	}

}
