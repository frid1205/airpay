/**
 * 
 */
package TestCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import bases.BaseWeb;
import io.qameta.allure.Description;
import pages.HomePage;
import pages.signInPage;

/**
 * @author fendyridwan
 *
 */
public class AuthenticationSignInTest extends BaseWeb{
	/*
	 * B01
	 * Login with invalid credential
	 * 
	 */
	
	@Test(priority=1, enabled=true)
	@Description("Login with invalid credential")
	public void B01_LoginWithInvalidCredential() throws InterruptedException 
	{
		//signInPage si = PageFactory.initElements(driver, signInPage.class);
		signInPage si = new signInPage(driver);
		
		System.out.println("-> Input invalid username");
		si.typeUserName("invalidUser");
		
		System.out.println("-> Input invalid password");
		si.typePassword("aaaaaaaa");
		
		System.out.println("-> Click on sign in button");
		si.clickSignInButton();
		
		System.out.println("-> Verify");
		assertTrue(si.errorSignInMessage(), "There is no message validation for invalid user");
		
	}
	
	/*
	 * B02
	 * Login with unverified user account
	 * 
	 */
	
	@Test(priority=2, enabled=true)
	public void B02_LoginWithUnverifiedUserAccount() throws InterruptedException 
	{
		//signInPage si = PageFactory.initElements(driver, signInPage.class);
		signInPage si = new signInPage(driver);
		
		System.out.println("-> Input unverified username");
		si.typeUserName("unveriUser");
		
		System.out.println("-> Input valid password");
		si.typePassword("Abcde12345!");
		
		System.out.println("-> Click on sign in button");
		si.clickSignInButton();
		
		Thread.sleep(1000);
		System.out.println("-> Verify");
		assertTrue(si.signInUnverifiedMessage(), "There is no message validation for unverified user login");
	}
	
	
	/*
	 * B03
	 * Login with verified user account
	 * 
	 */
	
	@Test(priority=3, enabled=true)
	public void B03_LoginWithVerifiedUserAccount() throws InterruptedException 
	{
		//signInPage si = PageFactory.initElements(driver, signInPage.class);
		//HomePage hp = PageFactory.initElements(driver, HomePage.class);
		signInPage si = new signInPage(driver);
		HomePage hp = new HomePage(driver);
		
		System.out.println("-> Input valid username");
		if(environment.equals("airpay")) {
			si.typeUserName("airpay12");
		}else {
			si.typeUserName("vittel2");
		}
		
		System.out.println("-> Input valid password");
		si.typePassword("Abcde12345!");
		
		System.out.println("-> Click on sign in button");
		si.clickSignInButton();
		
		Thread.sleep(2000);
		System.out.println("-> Verify");
		assertTrue(hp.verifyHomePage(), "home page is not displayed");
		
		
	}
}
