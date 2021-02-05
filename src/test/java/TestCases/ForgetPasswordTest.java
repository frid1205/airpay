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
	
	@Test
	public void C01_UnverifiedUserTryToForgetPassword() throws InterruptedException 
	{
		signInPage si = new signInPage(driver);
		ForgetPasswordPage fp = new ForgetPasswordPage(driver);
		
		System.out.println("-> Go to forget password page");
		si.clickForgetPasswordLink();
		
		System.out.println("-> Input unverified email address");
		fp.typeEmail("901211227@yopmail.com");
		
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
	
	@Test
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
	
	@Test
	public void C03_ForgetPasswordWithValidEmailCredential() throws InterruptedException 
	{
		//signInPage si = PageFactory.initElements(driver, signInPage.class);
		//ForgetPasswordPage fp = PageFactory.initElements(driver, ForgetPasswordPage.class);
		signInPage si = new signInPage(driver);
		ForgetPasswordPage fp = new ForgetPasswordPage(driver);
		
		System.out.println("-> Go to forget password page");
		si.clickForgetPasswordLink();
		
		System.out.println("-> Input unverified email address");
		fp.typeEmail("airpay1@yopmail.com");
		
		System.out.println("-> Click on reset password button");
		fp.clickOnResetPasswordButton();
		
		System.out.println("-> Verify");
		assertTrue(fp.forgetPasswordIsSent(), "message forget password sent is not displayed");
		
	}

}
