/**
 * 
 */
package TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import bases.BaseWeb;
import pages.SideMenuPage;
import pages.signInPage;

/**
 * @author fendyridwan
 *
 */
public class LogoutTest extends BaseWeb{
	
	/*
	 * Sign in first
	 */
	@Test(priority=1)
	public void signIn() throws InterruptedException {
		userSignIn();
	}

	/*
	 * logout
	 */
	@Test(priority = 2)
	public void logOut() throws InterruptedException {
		SideMenuPage smp = new SideMenuPage(driver);
		signInPage sp = new signInPage(driver);
		smp.clickOnLogoutButton();
		Thread.sleep(2000);
		assertTrue(sp.signInPageVerify(), "logout failed");
	}
}
