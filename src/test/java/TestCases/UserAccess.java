/**
 * 
 */
package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertFalse;

import org.testng.asserts.SoftAssert;

import bases.BaseWeb;
import pages.HomePage;
import pages.SideMenuPage;
import pages.UploadContractPage;
import pages.signInPage;

/**
 * @author fendyridwan
 *
 */
public class UserAccess extends BaseWeb{
	
	/*
	 * D01
	 * unapproved user login
	 */
	@Test(priority=1)
	public void D01_unapprovedUserLogin() throws InterruptedException {
		signInPage si = new signInPage(driver);
		HomePage hp = new HomePage(driver);
		SideMenuPage smp = new SideMenuPage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("User Login");
		si.typeUserName("airpay9");
		
		//System.out.println("-> Input valid password");
		si.typePassword("Abcde12345!");
		
		//System.out.println("-> Click on sign in button");
		si.clickSignInButton();
		Thread.sleep(2000);
		
		sa.assertTrue(hp.verifyIsNotApprovedMessageDisplayed(), "no message is not approved is displayed");
		sa.assertTrue(smp.unapprovedUserlogin(), "Unapproved user should not have full access");
		sa.assertAll();
		
	}
	
	/*
	 * D02
	 * Approved User login
	 * 
	 */
	@Test(priority=2)
	public void D02_ApprovedUserLogin() throws InterruptedException {
		SideMenuPage smp = new SideMenuPage(driver);
		signInPage si = new signInPage(driver);
		SoftAssert sa = new SoftAssert();
	
		System.out.println("logout first");
		logOut();
		
		System.out.println("User Login");
		si.typeUserName("airpay10");
		
		//System.out.println("-> Input valid password");
		si.typePassword("Abcde12345!");
		
		//System.out.println("-> Click on sign in button");
		si.clickSignInButton();
		Thread.sleep(2000);
		
		sa.assertTrue(smp.approvedUserlogin(), "approved user should have all menu");
		sa.assertAll();
	}

}
