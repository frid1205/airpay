/**
 * 
 */
package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import bases.BaseWeb;
import pages.DocumentationPage;
import pages.EditProfilePage;
import pages.SideMenuPage;

/**
 * @author fendyridwan
 *
 */
public class DocumentationTest extends BaseWeb{
	
	/*
	 * User sign in
	 */
	@Test
	public void signIn() throws InterruptedException {
		userSignIn();
	}
	
	/*
	 * H01
	 * Getting Started
	 * 
	 */
	@Test
	public void H01_GettingStarted() throws InterruptedException 
	{
		//SideMenuPage smp = PageFactory.initElements(driver, SideMenuPage.class);
		//DocumentationPage ep = PageFactory.initElements(driver, DocumentationPage.class);
		
		SideMenuPage smp = new SideMenuPage(driver);
		DocumentationPage ep = new DocumentationPage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Access Getting Started page");
		smp.clickOnDocumentationDropDown();
		smp.clickOnGettingStarted();
		
		System.out.println("-> Verify ");
		sa.assertTrue(ep.verifyGettingStarted(), "getting started is not displayed");
		sa.assertAll();
	}
	
	/*
	 * H02
	 * Merchant On Boarding
	 * 
	 */
	@Test
	public void H02_MerchantOnBoarding() throws InterruptedException 
	{
		//SideMenuPage smp = PageFactory.initElements(driver, SideMenuPage.class);
		//DocumentationPage ep = PageFactory.initElements(driver, DocumentationPage.class);
		SideMenuPage smp = new SideMenuPage(driver);
		DocumentationPage ep = new DocumentationPage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Access Merchant on boarding page");
		//smp.clickOnDocumentationDropDown();
		smp.clickOnMerchantOnBoarding();
		
		System.out.println("-> Verify ");
		sa.assertTrue(ep.verifyMerchantOnboarding(), "Merchant Onboarding is not displayed");
		sa.assertAll();
	}
	
	/*
	 * H03
	 * Service On Boarding
	 * 
	 */
	@Test
	public void H03_ServiceOnBoarding() throws InterruptedException 
	{
		//SideMenuPage smp = PageFactory.initElements(driver, SideMenuPage.class);
		//DocumentationPage ep = PageFactory.initElements(driver, DocumentationPage.class);
		SideMenuPage smp = new SideMenuPage(driver);
		DocumentationPage ep = new DocumentationPage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Access Service on boarding page");
		//smp.clickOnDocumentationDropDown();
		smp.clickOnServiceOnBoarding();
		
		System.out.println("-> Verify ");
		sa.assertTrue(ep.verifyServiceOnBoarding(), "Service Onboarding is not displayed");
		sa.assertAll();
	}
	
	/*
	 * H04
	 * Integration
	 * 
	 */
	@Test
	public void H04_Integration() throws InterruptedException 
	{
		//SideMenuPage smp = PageFactory.initElements(driver, SideMenuPage.class);
		//DocumentationPage ep = PageFactory.initElements(driver, DocumentationPage.class);
		SideMenuPage smp = new SideMenuPage(driver);
		DocumentationPage ep = new DocumentationPage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Access Integration page");
		//smp.clickOnDocumentationDropDown();
		smp.clickOnIntegration();
		
		System.out.println("-> Verify ");
		sa.assertTrue(ep.verifyIntegration(), "Integration page is not displayed");
		sa.assertAll();
	}
	
	/*
	 * H05
	 * Reporting
	 * 
	 */
	@Test
	public void H05_Reporting() throws InterruptedException 
	{
		//SideMenuPage smp = PageFactory.initElements(driver, SideMenuPage.class);
		//DocumentationPage ep = PageFactory.initElements(driver, DocumentationPage.class);
		SideMenuPage smp = new SideMenuPage(driver);
		DocumentationPage ep = new DocumentationPage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Access Reporting page");
		//smp.clickOnDocumentationDropDown();
		smp.clickOnReporting();
		
		System.out.println("-> Verify ");
		sa.assertTrue(ep.verifyReporting(), "Reporting page is not displayed");
		sa.assertAll();
	}

	/*
	 * H06
	 * FAQ
	 * 
	 */
	@Test
	public void H06_FAQ() throws InterruptedException 
	{
		//SideMenuPage smp = PageFactory.initElements(driver, SideMenuPage.class);
		//DocumentationPage ep = PageFactory.initElements(driver, DocumentationPage.class);
		SideMenuPage smp = new SideMenuPage(driver);
		DocumentationPage ep = new DocumentationPage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Access FAQ page");
		//smp.clickOnDocumentationDropDown();
		smp.clickOnFAQ();
		
		System.out.println("-> Verify ");
		sa.assertTrue(ep.verifyFAQ(), "FAQ page is not displayed");
		sa.assertAll();
	}
}
