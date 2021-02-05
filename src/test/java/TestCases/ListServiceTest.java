/**
 * 
 */
package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import bases.BaseWeb;
import pages.EditServicePage;
import pages.ListServicePage;
import pages.SideMenuPage;

/**
 * @author fendyridwan
 *
 */
public class ListServiceTest extends BaseWeb{
	private String getServiceId; 
	private String dayDate = dayDate();
	
	/*
	 * Admin sign in
	 */
	@Test(priority = 1)
	public void signIn() throws InterruptedException {
		adminSignIn();
	}
	
	/*
	 * K01
	 * Access list service page
	 * 
	 */
	@Test(priority = 2)
	public void K01_AccessListServicePage() throws InterruptedException 
	{
		//SideMenuPage smp = PageFactory.initElements(driver, SideMenuPage.class);
		SideMenuPage smp = new SideMenuPage(driver);
		ListServicePage lsp = new ListServicePage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Access List service page");
		smp.clickOnServiceDropDown();		
		smp.clickOnListService();
		Thread.sleep(1000);
		
		System.out.println("-> Verify list service is exist");
		sa.assertTrue(lsp.listServiceIsExist(), "List service is not exist");
		sa.assertTrue(lsp.serviceStatus(), "service status is not found");
		
		lsp.searchService();
		
		System.out.println("-> Verify search result");
		sa.assertTrue(lsp.listSearchResult(), "search result is not displayed");
		sa.assertAll();
	}
	
	/*
	 * K02
	 * activate service	 * 
	 */
	@Test(priority = 3)
	public void K02_ActivateService() throws InterruptedException 
	{
		//SideMenuPage smp = PageFactory.initElements(driver, SideMenuPage.class);
		ListServicePage lsp = new ListServicePage(driver);
		//ServiceManagementTest smt = new ServiceManagementTest();
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Click On Reset Button");
		lsp.clickOnResetButton();
		
		System.out.println("-> Search service");
		lsp.searchService();
		Thread.sleep(1000);
		
		System.out.println("-> Click on activate button");
		lsp.clickOnActivateServicebutton();
		
		System.out.println("-> Verify service is activated");
		sa.assertTrue(lsp.statusServiceIsActivated(), "Service is not activated");
		sa.assertAll();
	}
	
	/*
	 * K03
	 * deactivate service 
	 */
	@Test(priority = 4)
	public void K03_DeactiveService() throws InterruptedException 
	{
		//SideMenuPage smp = PageFactory.initElements(driver, SideMenuPage.class);
		//ListServicePage lsp = PageFactory.initElements(driver, ListServicePage.class);
		ListServicePage lsp = new ListServicePage(driver);
		SoftAssert sa = new SoftAssert();
		Thread.sleep(2000);
		System.out.println("-> Click On Reset Button");
		lsp.clickOnResetButton();
		
		Thread.sleep(1000);
		
		System.out.println("-> Click on activate button");
		lsp.clickOnDeactivateServiceButton();
		
		System.out.println("-> Verify service is disabled");
		sa.assertTrue(lsp.statusServiceIsDisabled(), "Service is not disabled");
		sa.assertAll();
	}
	
	/*
	 * K04
	 * Edit service with let one or all mandatory fields are empty 
	 */
	@Test(priority = 5)
	public void K04_EditServiceWithLetOneOrAllMandatoryFieldsAreEmpty() throws InterruptedException 
	{
		ListServicePage lsp = PageFactory.initElements(driver, ListServicePage.class);
		EditServicePage esp = new EditServicePage(driver);
		SoftAssert sa = new SoftAssert();
		
		Thread.sleep(2000);
		lsp.clickOnResetButton();
		
		System.out.println("-> search Service");
		lsp.searchService();
		Thread.sleep(1000);
		
		getServiceId = lsp.getServiceId();
		System.out.println(getServiceId);
		
		System.out.println("-> Click on edit button");
		lsp.clickOnEditButton();
		
		System.out.println("-> Click on edit tab");
		esp.clickOnEditProfileTab();
		
		System.out.println("-> clear all field");
		esp.emptyAllFields();
		
		System.out.println("-> Click on next button");
		esp.clickOnNextButton1();
		
		System.out.println("-> Verify mandatory validation is working");
		sa.assertTrue(esp.alertMandatoryServiceName(), "alert mandatory for service name is not displayed");
		sa.assertTrue(esp.alertMandatoryServiceURL(), "alert mandatory for service url is not displayed");
		//sa.assertTrue(esp.alertMandatoryCategory(), "alert mandatory for category is not displayed");
		sa.assertTrue(esp.alertMandatoryKeyword(), "alert mandatory for keyword is not displayed");
		sa.assertTrue(esp.alertMandatorySubKeyword(), "alert mandatory for sub keyword is not displayed");
		sa.assertTrue(esp.alertMandatoryRenewalMessage(), "alert mandatory for Renewal is not displayed");
		sa.assertTrue(esp.alertMandatoryUnsubcribeMessage(), "alert mandatory for unsubcribe message is not displayed");
		sa.assertAll();
		Thread.sleep(7000);
		
	}
	
	/*
	 * K05
	 * Edit service with all mandatory fields are filled 
	 */
	@Test(priority = 6, dependsOnMethods="K04_EditServiceWithLetOneOrAllMandatoryFieldsAreEmpty")
	public void K05_EditServiceWithAllMandatoryFieldsAreFilled() throws InterruptedException 
	{
		ListServicePage lsp = PageFactory.initElements(driver, ListServicePage.class);
		EditServicePage esp = new EditServicePage(driver);
		EditServicePage esp2 = new EditServicePage(driver);
		SoftAssert sa = new SoftAssert();
		System.out.println(getServiceId);
		
		System.out.println("-> Edit service");
		esp.typeServiceName("edit"+dayDate);
		esp.typeCallBackURL("edit"+dayDate);
		esp.typeServiceURL("edit"+dayDate);
		esp.typeKeyWord("Edit"+dayDate);
		esp.typeSubKeyword("Service Edit SubKeyword"+dayDate);
		esp.typeProviderName("edit Provider"+dayDate);
		esp.typeDescription("description edit"+dayDate);
		esp.typeFirstMessage("service edit first message"+dayDate);
		esp.typeRenewalMessage("edit Renewal"+dayDate);
		esp.typeUnSubMessage("Service Edit Unsubcribe Message"+dayDate);
		esp.typeFreemiumDuration("30");
		
		System.out.println("-> Click on next button 1");
		esp.clickOnNextButton1();
		
		Thread.sleep(2000);
		System.out.println("-> Verify edit has passed");
		sa.assertTrue(esp.EditHasPassed(), "edit is not passed");
		
		System.out.println("-> Select price point");
		esp.selectPricePoint();
		
		System.out.println("-> Click on next button (update document)");
		esp.clickOnNextButton2();
		
		System.out.println("-> Click on save button");
		esp.clickOnNextButton3();
		
		System.out.println("-> search Service");
		lsp.searchService();
		
		Thread.sleep(2000);
		System.out.println("->Access edited serviced");
		lsp.clickOnEditButtonSpesificId(getServiceId);
		
		System.out.println("-> Click on edit tab");
		esp.clickOnEditProfileTab();
		
		Thread.sleep(2000);
		
		sa.assertTrue(esp2.validateServiceNameIsEdited("edit"+dayDate), "service name value is not edited");
		sa.assertTrue(esp2.validateCallBackURLIsEdited("edit"+dayDate), "call back url value is not edited");
		sa.assertTrue(esp2.validateServiceURLIsEdited("edit"+dayDate), "service url value is not edited");
		sa.assertTrue(esp2.validateKeywordEdited("Edit"+dayDate), "keyword value is not edited");
		sa.assertTrue(esp2.validateSubKeywordEdited("Service Edit SubKeyword"+dayDate), "subkeyword value is not edited");
		sa.assertTrue(esp2.validateProviderNameIsEdited("edit Provider"+dayDate), "providername value is not edited");
		sa.assertTrue(esp2.validateDescriptionEdited("description edit"+dayDate), "description value is not edited");
		sa.assertTrue(esp2.validateFirstMessageEdited("service edit first message"+dayDate), "first message value is not edited");
		sa.assertTrue(esp2.validateRenewalMessageEdited("edit Renewal"+dayDate), "renewal message value is not edited");
		sa.assertTrue(esp2.validateUnsubcribeMessageIsEdited("Service Edit Unsubcribe Message"+dayDate), "Unsubcribe message value is not edited");
		sa.assertTrue(esp2.validateFreemiumDurationIsEdited("30"),"freemium duration value is not edited");
		
		sa.assertAll();
		Thread.sleep(7000);
		
	}

}
