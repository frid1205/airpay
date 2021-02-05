/**
 * 
 */
package TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import bases.BaseWeb;
import pages.AddServicePage;
import pages.InviteUserPage;
import pages.SideMenuPage;

/**
 * @author fendyridwan
 *
 */
public class InviteUserTest extends BaseWeb{
	String getUsername = dayDate();
	/*
	 * User sign in
	 */
	@Test(priority=1)
	public void signIn() throws InterruptedException {
		userSignIn();
	}
	
	/*
	 * N01
	 * Invite User with let one or all mandatory fields are empty
	 * 
	 */
	@Test(priority=2)
	public void N01_InviteUserWithAllMandatoryAreEmpty() throws InterruptedException 
	{
		InviteUserPage iup = new InviteUserPage(driver);
		SideMenuPage smp = new SideMenuPage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Access invite user page");
		smp.clickOnInviteUserDropDown();		
		smp.clickOnInviteUserMenu();
		
		Thread.sleep(1000);
		System.out.println("-> Clear all field");
		iup.clearUsername();
		iup.clearEmail();
		iup.clearCompany();
		iup.clearPhone();
		iup.clearPassword();
		
		System.out.println("-> Click on invite user button ");
		iup.clickOnInviteUserButton();
		
		System.out.println("-> Verify");
		sa.assertTrue(iup.userNameMandatory(), "mandatory message for username is not displayed");
		sa.assertTrue(iup.emailMandatory(), "mandatory message for email is not displayed");
		sa.assertTrue(iup.companyMandatory(), "mandatory message for company is not displayed");
		sa.assertTrue(iup.phoneMandatory(), "mandatory message for phone is not displayed");
		sa.assertTrue(iup.passwordMandatory(), "mandatory message for password is not displayed");
		sa.assertAll();
	}
	
	/*
	 * N02
	 * Invite taken username or taken email address
	 */
	@Test(priority=3)
	public void N02_InviteTakenUsernameOrTakenEmailAddress() throws InterruptedException {
		InviteUserPage iup = new InviteUserPage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> input taken username and email");
		iup.typeUserName("airpay12");
		iup.typeEmail("airpay12@yopmail.com");
		iup.typeCompany("linkit");
		iup.typePhone("12345678");
		iup.typePassword("Abcde12345!");
		iup.clickOnInviteUserButton();
		Thread.sleep(1000);
		
		sa.assertTrue(iup.usernameAlreadyTaken(), "cannot find message validation for username is taken");
		sa.assertTrue(iup.emailAlreadyTaken(), "cannot find message validation for email is taken");
		sa.assertAll();
		
	}
	
	/*
	 * N03
	 * Invite user with valid credential
	 */
	@Test(priority=4)
	public void N03_InviteUserWithValidCredential() throws InterruptedException {
		InviteUserPage iup = new InviteUserPage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> input valid credential");
		iup.typeUserName(getUsername);
		iup.typeEmail(getUsername+"@yopmail.com");
		iup.typeCompany("linkit");
		iup.typePhone("12345678");
		iup.typePassword("Abcde12345!");
		iup.clickOnInviteUserButton();
		Thread.sleep(1000);
		
		sa.assertTrue(iup.userInvitedSuccesfully(), "user is not invited");
		sa.assertAll();
		
	}

}
