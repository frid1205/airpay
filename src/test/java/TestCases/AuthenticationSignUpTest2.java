/**
 * 
 */
package TestCases;

import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import bases.BaseWeb;
import pages.signInPage;
import pages.signUpPage;
import pages.yopmailPage;

/**
 * @author fendyridwan
 *
 */
public class AuthenticationSignUpTest2 extends BaseWeb{
	String getUsername = dayDate();
	/*
	 *Sign up with valid credential
	 *
	 */
	
	@Test(priority=1)
	public void A02_SignUpWithValidCredential() throws InterruptedException 
	{
		
		Thread.sleep(20000);
		signInPage si = new signInPage(driver);
		signUpPage su = new signUpPage(driver);
		
		System.out.println("-> Click on sign up url link");
		si.clickSignUpUrlLink();
		
		System.out.println("-> Type valid username");
		su.typeUserName(getUsername);
		
		System.out.println("-> Type valid email address");
		su.typeEmail(getUsername+"@yopmail.com");
		
		System.out.println("-> Type valid password");
		su.typePassword("Abcde12345!");
		
		System.out.println("-> Type valid co password");
		su.typeCoPassword("Abcde12345!");
		
		System.out.println("-> Click on sign up button");
		su.clickSignUpButton();
		
		Thread.sleep(7000);
		System.out.println("-> Verify");
		assertTrue(su.verifySecondStepSignUp(), "sign up is failed");
		
		
	}
	
	/*
	 *Second Step Sign Up
	 *
	 */
	
	@Test(priority=2)
	public void A03_SecondStepSignUp() throws InterruptedException 
	{
		signUpPage su = new signUpPage(driver);
		
		System.out.println("-> Type company name");
		su.typeCompanyNameSecondStep("TestCompanyName");
		
		System.out.println("-> Type phone");
		su.typePhoneSecondStep("9280009");
		
		System.out.println("-> Select Country");
		su.selectCountrySecondStep();
		
		System.out.println("-> type City");
		su.typeCitySecondSteps("Vientine");
		
		System.out.println("-> Company URL");
		su.typeCompanyURLSecondStep("linkit.com");
		
		System.out.println("-> address");
		su.typeAddressSecondStep("Vientine street");
		
		System.out.println("-> Click Continue button");
		su.clickContinueButtonSecondStep();
		
		Thread.sleep(1000);
		System.out.println("-> Verify");
		assertTrue(su.verifyThirdStepSignUp(), "not continue to third step");
	}
	
	/*
	 *Third Step Sign Up
	 *
	 */
	
	@Test(priority=3)
	public void A04_ThirdStepSignUp() throws InterruptedException 
	{
		signUpPage su = new signUpPage(driver);
		
		System.out.println("-> Type Bank Holder Name");
		su.typeBankHolderName("MR Kim");
		
		System.out.println("-> type Account number");
		su.typeAccountNumber("12345");
		
		System.out.println("-> Type Bank Name");
		su.typeBankName("Bank Central Asia");
		
		System.out.println("-> Type swift code");
		su.typeSwiftCode("153");
		
		System.out.println("-> Select bank location");
		su.selectBankLocation();
		
		System.out.println("-> Click continue button");
		su.clickContinueButtonThirdStep();
	}
	
	/*
	 *Fouth step of sign up 
	 *
	 */
	
	@Test(priority=4)
	public void A05_FouthStepofSignUp () throws InterruptedException 
	{
		signUpPage su = new signUpPage(driver);
		
		/*System.out.println("-> Browse File");
		su.browseContractFile();
		
		System.out.println("-> Click Submit button");
		su.clickContinueButtonThirdStep();*/
		
		//System.out.println("-> Click on Skip URL Link");
		Thread.sleep(1000);
		su.clickSkipButton();
		
		Thread.sleep(5000);
		System.out.println("-> Verify Page");
		assertTrue(su.verifyEmailVerificationPage(), "Verify email page not displayed");
	}
	
	/*
	 * Verify Email Address Request 
	 *
	 */
	
	@Test(priority=5)
	public void A06_VerifyEmailPage () throws InterruptedException 
	{
		signUpPage su = new signUpPage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Click On Verify Emaill Button");
		su.clickOnVerifyEmailButton();
		
		Thread.sleep(7000);
		System.out.println("-> Verify sign up is success");
		sa.assertTrue(su.verifySignUpIsSuccess(), "sign up failed");
		
		
	}
	
	/*
	 * Email Verification success 
	 *
	 */
	
	@Test(enabled = false)
	public void A07_EmailVerificationSuccess () throws InterruptedException 
	{
		yopmailPage yp = new yopmailPage(driver);
		driver.get("http://www.google.com/");
		
		System.out.println("verify email");
		yp.typeUserName(getUsername);
		yp.clickCheckButton();
		Thread.sleep(3000);
		yp.clickfirstLineEmail();
		yp.verifyCaptcha();
		yp.confirmAccount();
		
		Thread.sleep(10000);
		
		
	}
}
