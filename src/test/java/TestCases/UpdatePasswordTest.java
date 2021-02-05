/**
 * 
 */
package TestCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import bases.BaseWeb;
import pages.SideMenuPage;
import pages.UpdatePasswordPage;

/**
 * @author fendyridwan
 *
 */
public class UpdatePasswordTest extends BaseWeb {
	
	/*
	 * User sign in
	 */
	@Test(priority=1)
	public void signIn() throws InterruptedException {
		userSignIn();
	}
	
	/*
	 * F01
	 * Update password, with incorrect Current Password
	 * 
	 */
	@Test(priority=2)
	public void F01_UpdatePasswordWithIncorrectCurrentPassword() throws InterruptedException 
	{
		SideMenuPage smp = new SideMenuPage(driver);
		UpdatePasswordPage up = new UpdatePasswordPage(driver);
		
		System.out.println("-> Access update password page");
		smp.accessUpdatePasswordPage();
		
		System.out.println("-> Type invalid current password");
		up.typeCurrentPassword("Abcdefghij");
		
		System.out.println("-> Type valid new password");
		up.typeNewPassword("Abcde12345!");
		
		System.out.println("-> Type valid co password");
		up.typeCoPassword("Abcde12345!");
		
		System.out.println("-> Click on update password button");
		up.clickOnUpdatePasswordButton();
		
		System.out.println("-> Verify");
		assertTrue(up.invalidCurrentPasswordMessage(), "invalid current password message does not dipaye");
		
	}
	
	/*
	 * F02
	 * Update password, with new password and Co-password are different of each
	 * 
	 */
	@Test(priority=3)
	public void F02_UpdatePasswordWithNewPasswordAndCoPasswordAreDifferent() throws InterruptedException 
	{
		//UpdatePasswordPage up = PageFactory.initElements(driver, UpdatePasswordPage.class);
		UpdatePasswordPage up = new UpdatePasswordPage(driver);
	
		System.out.println("-> Type invalid current password");
		up.typeCurrentPassword("Abcde12345!");
		
		System.out.println("-> Type valid new password");
		up.typeNewPassword("Abcdeoooo12345!");
		
		System.out.println("-> Type different co password");
		up.typeCoPassword("Abcdefghij12345!");
		
		System.out.println("-> Click on update password button");
		up.clickOnUpdatePasswordButton();
		
		System.out.println("-> Verify");
		assertTrue(up.passwordNotMatchMessage(), "password not match message does not dipay");
	}

	/*
	 * F03
	 * Update password, with correct current password, new password and Co password
	 * 
	 */
	@Test(priority=4)
	public void F03_UpdatePasswordWithCorrectInput() throws InterruptedException 
	{
		//UpdatePasswordPage up = PageFactory.initElements(driver, UpdatePasswordPage.class);
		UpdatePasswordPage up = new UpdatePasswordPage(driver);
	
		System.out.println("-> Type invalid current password");
		up.typeCurrentPassword("Abcde12345!");
		
		System.out.println("-> Type valid new password");
		up.typeNewPassword("Abcde12345!");
		
		System.out.println("-> Type different co password");
		up.typeCoPassword("Abcde12345!");
		
		System.out.println("-> Click on update password button");
		up.clickOnUpdatePasswordButton();
		
		System.out.println("-> Verify");
		assertTrue(up.passwordSuccessfullyUpdatedmessage(), "password is not updated");
	}
}
