/**
 * 
 */
package TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import bases.BaseWeb;
import pages.EditProfilePage;
import pages.SideMenuPage;

/**
 * @author fendyridwan
 *
 */
public class EditProfileTest extends BaseWeb{
	
	/*
	 * User sign in
	 */
	@Test
	public void signIn() throws InterruptedException {
		userSignIn();
	}
	
	/*
	 * E01
	 * Access edit profile page - Basic Information tab
	 * 
	 */
	@Test
	public void E01_AccessEditProfileBasicInformationTab() throws InterruptedException 
	{
		//SideMenuPage smp = PageFactory.initElements(driver, SideMenuPage.class);
		//EditProfilePage ep = PageFactory.initElements(driver, EditProfilePage.class);
		SideMenuPage smp = new SideMenuPage(driver);
		EditProfilePage ep = new EditProfilePage(driver);
		SoftAssert sa = new SoftAssert();
		
		smp.accessEditProfilePage();
		ep.clickBasicInfoTab();
		//sa.assertTrue(ep.fieldsInBasicInfoAreDisable(), "username field or companyname field or email field are not disable");
		sa.assertTrue(ep.fieldsInBasicInfoAreExists(), "several fields are not exists");
		sa.assertAll();
		
	}
	
	/*
	 * E02
	 * Access edit profile page - Supporting Document tab
	 * 
	 */
	@Test
	public void E02_AccessEditProfileSupportingDocumentTab() throws InterruptedException 
	{
		//SideMenuPage smp = PageFactory.initElements(driver, SideMenuPage.class);
		//EditProfilePage ep = PageFactory.initElements(driver, EditProfilePage.class);
		EditProfilePage ep = new EditProfilePage(driver);
		SoftAssert sa = new SoftAssert();
		
		ep.clickSupportingDocTab();
		sa.assertTrue(ep.fieldsInSupportingDocAreExists(), "several fields are not exists");
		sa.assertAll();
		
	}
	
	/*
	 * E03
	 * Let mandatory field is empty in Edit prifle page - basic information tab
	 * 
	 */
	@Test
	public void E03_LetMandatoryFieldIsEmptyBasicInfoTab() throws InterruptedException 
	{
		//SideMenuPage smp = PageFactory.initElements(driver, SideMenuPage.class);
		//EditProfilePage ep = PageFactory.initElements(driver, EditProfilePage.class);
		EditProfilePage ep = new EditProfilePage(driver);
		
		System.out.println("-> Click on basic info tab");
		ep.clickBasicInfoTab();
		
		System.out.println("-> Clear all fields in basic info tab");
		ep.clearAllFieldsInBasicInfo();
		
		System.out.println("-> click on submit button");
		ep.clickOnSubmitButtonInBasicInfo();
		Thread.sleep(3000);
		
		System.out.println("-> Verify");
		assertTrue(ep.phoneValidationMessage(), "phone validation should be displayed");
		
	}
	
	/*
	 * E04
	 * Let mandatory field is empty in Edit prifle page - supporting document tab
	 * 
	 */
	@Test
	public void E04_LetMandatoryFieldIsEmptySupportingDocTab() throws InterruptedException 
	{
		//SideMenuPage smp = PageFactory.initElements(driver, SideMenuPage.class);
		//EditProfilePage ep = PageFactory.initElements(driver, EditProfilePage.class);
		//EditProfilePage ep2 = PageFactory.initElements(driver, EditProfilePage.class);
		EditProfilePage ep = new EditProfilePage(driver);
		EditProfilePage ep2 = new EditProfilePage(driver);
		
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Click on Supporting Document tab");
		ep.clickSupportingDocTab();
		
		System.out.println("-> Clear all fields in Supporting Document tab");
		ep.clearAllFieldsInSupportingDocumentTab();
		
		System.out.println("-> click on submit button");
		ep.clickOnSupportingSubmitButton();
		
		System.out.println("-> click on supporting document tab");
		Thread.sleep(3000);
		ep2.clickSupportingDocTab();
		
		System.out.println("-> Verify");
		sa.assertTrue(ep.bankHolderNameValidationMessage(), "bank holder name validation should be displayed");
		sa.assertTrue(ep.bankAccountNumberValidationMessage(), "bank account number validation should be displayed");
		sa.assertTrue(ep.bankSwiftCodeValidationMessage(), "bank swift code validation should be displayed");
		sa.assertAll();
		
	}

}
