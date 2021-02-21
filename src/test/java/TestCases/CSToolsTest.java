/**
 * 
 */
package TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import bases.BaseWeb;
import pages.CSToolsCreatePage;
import pages.CSToolsListPage;
import pages.SideMenuPage;

/**
 * @author fendyridwan
 *
 */
public class CSToolsTest extends BaseWeb{
	String getDate = dayDate();
	
	/*
	 * User sign in
	 */
	@Test(priority=1)
	public void signIn() throws InterruptedException {
		userSignIn();
	}
	
	/*
	 * Create complaint by user
	 */
	@Test(priority=2)
	public void V01_CreateComplaintsByUser() throws InterruptedException {
		SideMenuPage sm = new SideMenuPage(driver);
		SideMenuPage sm2 = new SideMenuPage(driver);
		CSToolsListPage ctl = new CSToolsListPage(driver);
		CSToolsCreatePage ccp = new CSToolsCreatePage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Access complaints page");
		sm.clickComplaintsPage();
		
		System.out.println("-> access create complaints page");
		ctl.clickCreateComplaintsButton();
		
		sa.assertTrue(ccp.validateName(), "right value name is not displayed");
		sa.assertTrue(ccp.validateEmail(), "right value email is not displayed");
		sa.assertTrue(ccp.nameIsDisable(),"name field is not disabled");
		sa.assertTrue(ccp.emailIsDisable(),"email field is not disabled");
		
		System.out.println("-> type Provider");
		ccp.typeProvider("provider"+getDate);
		
		System.out.println("-> type description");
		ccp.typeDescription("Description "+getDate);
		
		System.out.println("-> Click on submit button");
		ccp.clickOnSubmitButton();
		
		System.out.println("-> access list page");
		sm2.clickComplaintsListPage();
		
	
		sa.assertTrue(ctl.checkComplaintsIsAdded("provider"+getDate), "cannot found provider");
		sa.assertAll();
		
	}
	
	/*
	 * logout
	 */
	@Test(priority=3)
	public void logout() throws InterruptedException {
		logOut();
	}
	
	/*
	 * Admin sign in
	 */
	@Test(priority=4)
	public void signInAdmin() throws InterruptedException {
		adminSignIn();
	}
	
	/*
	 * Create complaint by admin
	 */
	@Test(priority=5)
	public void V02_CreateComplaintsByUser() throws InterruptedException {
		SideMenuPage sm = new SideMenuPage(driver);
		CSToolsListPage ctl = new CSToolsListPage(driver);
		
		System.out.println("-> Access complaints page");
		sm.clickComplaintsPage();
		
		System.out.println("-> Verify create button is not exist");
		assertTrue(ctl.createComplaintsButtonIsNotExist(), "create button should not exist");
		
	}
	

}
