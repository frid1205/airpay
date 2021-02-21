/**
 * 
 */
package TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import bases.BaseWeb;
import pages.CreateOperatorPage;
import pages.ListOperatorPage;
import pages.SideMenuPage;

/**
 * @author fendyridwan
 *
 */
public class SettingOperatorTest extends BaseWeb{

	/*
	 * Admin sign in
	 */
	@Test(priority=1)
	public void signIn() throws InterruptedException {
		adminSignIn();
	}
	
	/*
	 * Y01
	 * Create operator with let one or all mandatory fields are empty
	 * 
	 */
	@Test(priority = 2)
	public void Y01_CreateOperatorwithLetOneOrAllMandatoryFieldsAreEmpty() throws InterruptedException {
		SideMenuPage sm = new SideMenuPage(driver);
		ListOperatorPage lo = new ListOperatorPage(driver);
		CreateOperatorPage co = new CreateOperatorPage(driver);
		
		System.out.println("-> Access create operator page");
		sm.clickOnSettingDropDown();
		sm.clickOnOperator();
		Thread.sleep(2000);
		
		lo.clickOnCreateOperatorButton();
		co.clickOnCreateButton();
		
		assertTrue(co.mandatoryMessageDisplayed(), "mandatory message is not displayed");
		
	}
	
	/*
	 * Y02
	 * Create operator with all mandatory fields are filled
	 * 
	 */
	@Test(priority = 3)
	public void Y02_CreateOperatorwithAllMandatoryFieldsAreFilled() throws InterruptedException {
		SideMenuPage sm = new SideMenuPage(driver);
		ListOperatorPage lo = new ListOperatorPage(driver);
		CreateOperatorPage co = new CreateOperatorPage(driver);
		
		co.typeOperatorName("testOperator");
		
		co.selectCountry(name);
		
		co.clickOnCreateButton();
		
		assertTrue(co.mandatoryMessageDisplayed(), "mandatory message is not displayed");
		
	}
}
