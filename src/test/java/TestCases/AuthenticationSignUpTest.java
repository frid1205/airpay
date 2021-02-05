/**
 * @author fendyridwan
 * Verify Authentication User Sign In
 */
package TestCases;

import bases.BaseWeb;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.signInPage;
import pages.signUpPage;


public class AuthenticationSignUpTest extends BaseWeb {
	
	/*
	 * A01
	 * Sign Up with invalid credential
	 * 
	 */
	
	@Test(priority=1)
	public void A01_SignUpWithInvalidCredential() throws InterruptedException 
	{
		String getUsername = dayDate();
		signInPage si = PageFactory.initElements(driver, signInPage.class);
		signUpPage su = PageFactory.initElements(driver, signUpPage.class);
		signUpPage su1 = PageFactory.initElements(driver, signUpPage.class);
		signUpPage su2 = PageFactory.initElements(driver, signUpPage.class);
		signUpPage su3 = PageFactory.initElements(driver, signUpPage.class);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Click on sign up url link");
		si.clickSignUpUrlLink();
		
		System.out.println("1. Verify signup with username is taken");
		if(environment.equals("airpay")) {
			su.typeUserName("airpay12");
		}else {
			su.typeUserName("vittel2");
		}
		su.typeEmail(getUsername+"@yopmail.com");
		su.typePassword("Abcde12345!");
		su.typeCoPassword("Abcde12345!");
		su.clickSignUpButton();
		Thread.sleep(1000);
		System.out.println("-> 1.Verify");
		sa.assertTrue(su.verifyUserNameIsTaken(), "there is no message validation displayed in username");
		
		System.out.println("2. Verify sign up with invalid email address");
		su1.clearUsernameField();
		su1.typeUserName(getUsername);
		su1.clearEmailField();
		su1.typeEmail(getUsername);
		su1.clickSignUpButton();
		Thread.sleep(1000);
		System.out.println("-> 2.Verify");
		sa.assertTrue(su.verifyEmailAddressNotValid(), "there is no message validation displayed in email address");
		
		System.out.println("3. Verify sign up with invalid password");
		su2.clearEmailField();
		su2.typeEmail(getUsername+"@yopmail.com");
		su2.clearPasswordField();
		su2.typePassword("Abcde");
		scrollDown();
		su2.clickSignUpButton();
		Thread.sleep(1000);
		System.out.println("-> 3.Verify");
		sa.assertTrue(su.verifyPasswordNotValid(), "there is no message validation displayed in password");
		
		System.out.println("4. Verify sign up with copassword not match with password");
		su3.clearPasswordField();
		su3.typePassword("Abcde12345!");
		su3.clearCoPassField();
		su3.typeCoPassword("Abcde123456789!");
		scrollDown();
		su3.clickSignUpButton();
		Thread.sleep(1000);
		System.out.println("-> 4.Verify");
		sa.assertTrue(su.verifycoPasswordNotValid(), "there is no message validation displayed in co password");
		sa.assertAll();
		
	}
	

}
