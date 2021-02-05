/**
 * 
 */
package TestCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import bases.BaseWeb;
import pages.ForgetPasswordPage;
import pages.signInPage;

/**
 * @author fendyridwan
 *
 */
public class ForgetPasswordTest extends BaseWeb{
	
	/*
	 * C01
	 * Unverified user try to forget password
	 * 
	 */
	
	@Test(priority=1)
	public void C01_UnverifiedUserTryToForgetPassword() throws InterruptedException 
	{
		signInPage si = new signInPage(driver);
		ForgetPasswordPage fp = new ForgetPasswordPage(driver);
		
		System.out.println("-> Go to forget password page");
		si.clickForgetPasswordLink();
		
		System.out.println("-> Input unverified email address");
		fp.typeEmail("unveriUser@yopmail.com");
		
		System.out.println("-> Click on reset password button");
		fp.clickOnResetPasswordButton();
		
		System.out.println("-> Verify");
		assertTrue(fp.resetPasswordFailMessage(), "message fail is not displayed");
		
	}
	
	/*
	 * C02
	 * Forget password with invalid email credential
	 * 
	 */
	
	@Test(priority=2)
	public void C02_ForgetPasswordWithInvalidEmailCredential() throws InterruptedException 
	{
		//signInPage si = PageFactory.initElements(driver, signInPage.class);
		//ForgetPasswordPage fp = PageFactory.initElements(driver, ForgetPasswordPage.class);
		ForgetPasswordPage fp = new ForgetPasswordPage(driver);
		
		System.out.println("-> Input unverified email address");
		fp.typeEmail("sfdfsdf@abcd.com");
		
		System.out.println("-> Click on reset password button");
		fp.clickOnResetPasswordButton();
		
		System.out.println("-> Verify");
		assertTrue(fp.resetPasswordFailMessage(), "message fail is not displayed");
		
	}
	
	/*
	 * C03
	 * Forget password with valid email credential
	 * 
	 */
	
	@Test(priority=3)
	public void C03_ForgetPasswordWithValidEmailCredential() throws InterruptedException 
	{
		//signInPage si = PageFactory.initElements(driver, signInPage.class);
		//ForgetPasswordPage fp = PageFactory.initElements(driver, ForgetPasswordPage.class);
		signInPage si = new signInPage(driver);
		ForgetPasswordPage fp = new ForgetPasswordPage(driver);
		
		//System.out.println("-> Go to forget password page");
		//si.clickForgetPasswordLink();
		
		System.out.println("-> Input unverified email address");
		if(environment.equals("airpay")) {
			fp.typeEmail("airpay12@yopmail.com");
		}else {
			fp.typeEmail("vittel2@yopmail.com");
		}
		
		System.out.println("-> Click on reset password button");
		fp.clickOnResetPasswordButton();
		
		System.out.println("-> Verify");
		assertTrue(fp.forgetPasswordIsSent(), "message forget password sent is not displayed");
		
	}

}
