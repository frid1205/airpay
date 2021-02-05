/**
 * 
 */
package TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import bases.BaseWeb;
import pages.ServiceManagement;
import pages.SideMenuPage;

/**
 * @author fendyridwan
 *
 */
public class ServiceManagementTest extends BaseWeb{

	/*
	 * Admin sign in
	 */
	@Test(priority = 1)
	public void signIn() throws InterruptedException {
		adminSignIn();
	}
	
	/*
	 * View service management list page
	 */
	@Test(priority = 2, dependsOnMethods = "signIn")
	public void R01_ViewServiceManagement() throws InterruptedException {
		
		SideMenuPage smp = new SideMenuPage(driver);
		ServiceManagement sm = new ServiceManagement(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Access service management page");
		smp.clickOnAdminstrationDropDown();		
		smp.clickOnServiceManagement();
		Thread.sleep(1000);
		
		sa.assertTrue(sm.ListOfServiceDisplayed(), "list of service id is not displayed");
		sa.assertTrue(sm.ListOfMerchantNameDisplayed(), "list of merchant name is not displayed");
		sa.assertTrue(sm.ListOfServiceNameDisplayed(), "list of service name is not displayed");
		sa.assertTrue(sm.ListOfCountryDisplayed(), "list of country is not displayed");
		sa.assertTrue(sm.ListOfOperatorDisplayed(), "list of operator is not displayed");
		sa.assertTrue(sm.ListOfPaymentDisplayed(), "list of payment is not displayed");
		sa.assertTrue(sm.ListOfPriceDisplayed(), "list of price is not displayed");
		sa.assertTrue(sm.ListOfCategoryDisplayed(), "list of category is not displayed");
		sa.assertTrue(sm.ListOfStatusDisplayed(), "list of status is not displayed");
		sa.assertAll();
		
	}
	/*
	 * Search service Management
	 */
	@Test(priority = 3)
	public void R02_SearchServiceManagement() throws InterruptedException {
		
		ServiceManagement sm = new ServiceManagement(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Search Service management");
		sm.searchService();
		
		Thread.sleep(2000);
		sa.assertTrue(sm.countryIsFiltered(), " country is no filtered");
		sa.assertTrue(sm.operatorIsFiltered(), " operator is no filtered");
		sa.assertTrue(sm.subcriptionTypeIsFiltered(), " payment type is no filtered");
		//sa.assertTrue(sm.statusTypeIsFiltered(), " status is no filtered");
		
		sa.assertAll();
		
	}
	
	/*
	 * Approve service
	 * 
	 */
	@Test(dependsOnMethods = "R02_SearchServiceManagement", priority = 4)
	public void R03_ApproveService() throws InterruptedException {
		
		ServiceManagement sm = new ServiceManagement(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Click on approve button");
		sm.clickOnApproveButton();
		Thread.sleep(500);
		
		sa.assertTrue(sm.serviceApproved(), "Service is not approved");
		sa.assertAll();
		
	}
	
	/*
	 * Reject service
	 * 
	 */
	@Test(priority = 5)
	public void R04_RejectService() throws InterruptedException {
		
		ServiceManagement sm = new ServiceManagement(driver);
		SoftAssert sa = new SoftAssert();
		
		Thread.sleep(1000);
		System.out.println("-> Click on reset button");
		sm.clickOnResetButton();
		Thread.sleep(2000);
		
		System.out.println("-> Search service");
		sm.searchService();
		Thread.sleep(2000);
		
		System.out.println("-> Click On reject button");
		sm.clickOnRejectButton();
		Thread.sleep(500);
		
		sa.assertTrue(sm.serviceDeactivated(), "Service is not deactivated");
		sa.assertAll();
		
	}
	
}
