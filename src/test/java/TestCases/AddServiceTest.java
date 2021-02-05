/**
 * 
 */
package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import bases.BaseWeb;
import pages.AddServicePage;
import pages.SideMenuPage;

/**
 * @author fendyridwan
 *
 */
public class AddServiceTest extends BaseWeb{
	
	/*
	 * User sign in
	 */
	@Test(priority = 1)
	public void signIn() throws InterruptedException {
		userSignIn();
	}
	
	/*
	 * J01
	 * Add Service - first step of add service
	 * 
	 */
	@Test(priority = 2)
	public void J01_FirstStepAddService() throws InterruptedException 
	{
		SideMenuPage smp = new SideMenuPage(driver);
		AddServicePage sp = new AddServicePage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Access add service page");
		smp.clickOnServiceDropDown();		
		smp.clickOnAddService();
		
		Thread.sleep(1000);
		System.out.println("-> Click on create service button ");
		sp.clickOnCreateServiceButtonFirstStep();
		
		System.out.println("-> Verify");
		sa.assertTrue(sp.alertMandatoryServiceType(), "Service type alert is not displayed");
		sa.assertTrue(sp.alertMandatoryPaymentType(), "payment type alert is not displayed");
		
		System.out.println("-> Select service type");
		sp.selectRandomlyServiceType();
		
		System.out.println("-> Select payment type");
		sp.selectRandomlyPaymentType();
		
		System.out.println("-> Click on create service button");
		sp.clickOnCreateServiceButtonFirstStep();
		
		System.out.println("Verify");
		sa.assertTrue(sp.select_service_country(), "second step is not displayed");
		sa.assertAll();
	}
	
	/*
	 * J02
	 * Add Service - second step of add service
	 * 
	 */
	@Test(priority = 3)
	public void J02_SecondStepService() throws InterruptedException 
	{
		//SideMenuPage smp = new SideMenuPage(driver);
		AddServicePage sp = new AddServicePage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Click on next button ");
		sp.clickNextButtonSecondStep();
		
		System.out.println("-> Verify");
		sa.assertTrue(sp.alertMandatorySelectServiceCountry(), "country mandatory alert is not displayed");
		
		System.out.println("-> Select country ");
		if(environment.equals("airpay")) {
			sp.clickOnIndonesiaCountry();
		}else {
			sp.clickOnLaosCountry();
		}
		System.out.println("-> Click on next button");
		sp.clickNextButtonSecondStep();
		
		System.out.println("Verify");
		sa.assertTrue(sp.select_service_operators(), "third step is not displayed");
		sa.assertAll();
	}
	
	/*
	 * J03
	 * Add Service - Third step of add service
	 * 
	 */
	@Test(priority = 4)
	public void J03_ThirdStepService() throws InterruptedException 
	{
		//SideMenuPage smp = new SideMenuPage(driver);
		AddServicePage sp = new AddServicePage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Click on next button ");
		sp.clickOnNextButtonThirdStep();
		
		System.out.println("-> Verify");
		sa.assertTrue(sp.alertMandatorySelectServiceOperator(), "operator mandatory alert is not displayed");
		
		System.out.println("-> Select operator");
		if(environment.equals("airpay")) {
			sp.selectOperator();
		}else {
			sp.selectOperatorUnitel();
		}
		
		System.out.println("-> Click on next button");
		sp.clickOnNextButtonThirdStep();
		
		System.out.println("Verify");
		sa.assertTrue(sp.verifyFourthStepDisplayed(), "Fourth step is not displayed");
		sa.assertAll();
	}
	
	/*
	 * J04
	 * Add Service - Fourth step of sign up
	 * 
	 */
	@Test(enabled=true, priority = 5)
	public void J04_FourthStepService() throws InterruptedException 
	{
		//SideMenuPage smp = new SideMenuPage(driver);
		AddServicePage sp = new AddServicePage(driver);
		SoftAssert sa = new SoftAssert();
		
		Thread.sleep(1000);
		System.out.println("-> Click on next button ");
		sp.clickOnNextButtonFourStep();
		
		System.out.println("-> Verify");
		sa.assertTrue(sp.alertMandatoryServiceName(), "service name mandatory alert is not displayed");
		sa.assertTrue(sp.alertMandatoryCallBackURL(), "call back url mandatory alert is not displayed");
		sa.assertTrue(sp.alertMandatoryServiceURL(), "service url mandatory alert is not displayed");
		sa.assertTrue(sp.alertMandatoryProviderName(), "provider name mandatory alert is not displayed");
		sa.assertTrue(sp.alertMandatoryDescription(), "description mandatory alert is not displayed");
		scrollDown();
		sa.assertTrue(sp.alertMandatoryCategory(), "category mandatory alert is not displayed");
		sa.assertTrue(sp.alertMandatoryFirstMessage(), "first Message mandatory alert is not displayed");
		sa.assertTrue(sp.alertMandatoryKeyword(), "keyword mandatory alert is not displayed");
		sa.assertTrue(sp.alertMandatorySubKeyword(), "subkeyword mandatory alert is not displayed");
		sa.assertTrue(sp.alertMandatoryServiceLogo(), "Service Logo mandatory alert is not displayed");
		
		//Scroll Up
		scrollUp();
		System.out.println("-> type service name");
		sp.typeServiceName("TestService");
		
		System.out.println("-> type call URL");
		sp.typeCallBackURL("call back URL");
		
		System.out.println("-> type service URL");
		sp.typeServiceURL("service URL");
		
		System.out.println("-> type provider name");
		sp.typeProviderName("Provider name");
		
		System.out.println("-> type description");
		sp.typeDescription("description");
		
		System.out.println("-> Select category");
		sp.selectCategory();
		
		System.out.println("-> type first Message");
		sp.typeFirstMessage("first message");
		
		System.out.println("-> type Renewal Message");
		sp.typeRenewalMessage("Renewal message");
		
		System.out.println("-> type Unsub Message");
		sp.typeUnSubMessage("unsubcribe message");
		
		System.out.println("-> type keyword");
		sp.typeKeyWord("keyword");
		
		System.out.println("-> type subkeyword");
		sp.typeSubKeyword("subkeyword");
		
		System.out.println("-> Select channel type");
		sp.selectChannelType();
		
		System.out.println("-> browse file");
		sp.uploadLogoService();
		
		System.out.println("-> Click on next button");
		sp.clickOnNextButtonFourStep();
		Thread.sleep(1000);
		
		System.out.println("-> Verify price point page is displayed");
		sa.assertTrue(sp.pricePointIsExist(), "price point page is not displayed");
		sa.assertAll();
	}
	
	/*
	 * J05
	 * Fifth step of add service (Price Point)
	 * 
	 */
	@Test(dependsOnMethods = "J04_FourthStepService", priority = 6)
	public void J05_FifthStepService() throws InterruptedException 
	{
		AddServicePage sp = new AddServicePage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Select price point");
		sp.selectPricePoint();
		
		System.out.println("-> Click on next button");
		sp.clickOnNextButtonFifthStep();
		Thread.sleep(1000);
		
		System.out.println("Verify");
		sa.assertTrue(sp.ServiceFlowIsExist(), "Fifth step is not displayed");
		sa.assertAll();
	}
	
	/*
	 * J06
	 * Sixth step of add service (Service Flow)
	 * 
	 */
	@Test(dependsOnMethods = "J05_FifthStepService", priority = 7)
	public void J06_SixthStepService() throws InterruptedException 
	{
		AddServicePage sp = new AddServicePage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> upload subcription flow");
		sp.SubcriptionFlow();
		
		System.out.println("-> upload unsubcription flow");
		sp.UnSubcriptionFlow();
		
		System.out.println("-> click on submit button");
		sp.clickOnSubmitButton();
		
		System.out.println("Verify");
		//sa.assertTrue(sp.ServiceFlowIsExist(), "Fifth step is not displayed");
		sa.assertAll();
		Thread.sleep(2000);
	}

}
