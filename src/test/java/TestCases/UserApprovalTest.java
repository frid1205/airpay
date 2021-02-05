/**
 * 
 */
package TestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import bases.BaseWeb;
import pages.SideMenuPage;
import pages.UserApprovalPage;

/**
 * @author fendyridwan
 *
 */
public class UserApprovalTest extends BaseWeb{
	
	/*
	 * Admin sign in
	 */
	@Test
	public void signIn() throws InterruptedException {
		adminSignIn();
	}
	
	/*
	 * Click on "Approve" button or "Reject" button without select the checkbox
	 */
	@Test
	public void O01_ClickOnApproveButtonRejectButtonWithoutSelectCheckbox() throws InterruptedException {
		SideMenuPage smp = new SideMenuPage(driver);
		UserApprovalPage uap = new UserApprovalPage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Access add service page");
		smp.clickOnServiceDropDown();		
		smp.clickOnUserApproval();
		
		System.out.println("-> click on approve button without select any user pending");
		uap.clickOnApproveButton();
		
		System.out.println("-> Verify");
		sa.assertTrue(uap.selectCheckboxValidationMessage(), "message is not displayed");
		Thread.sleep(1000);
		
		System.out.println("-> click on reject button");
		uap.clickOnRejectButton();
		
		System.out.println("-> verify");
		sa.assertTrue(uap.selectCheckboxValidationMessage(), "message is not displayed");
		
		sa.assertAll();
	}
	
	/*
	 * O02
	 * Reject User
	 */
	@Test
	public void O02_RejectUser() throws InterruptedException {
		UserApprovalPage uap = new UserApprovalPage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Select checkbox");
		uap.clickCheckBox();
		
		System.out.println("-> click on reject button");
		uap.clickOnRejectButton();
		
		System.out.println("-> verify");
		sa.assertTrue(uap.userRejectedMessage(), "message is not displayed");
		
		sa.assertAll();
	}
	
	/*
	 * O03
	 * Approve User
	 */
	@Test
	public void O02_ApproveUser() throws InterruptedException {
		UserApprovalPage uap = new UserApprovalPage(driver);
		SoftAssert sa = new SoftAssert();
		
		System.out.println("-> Select checkbox");
		uap.clickCheckBox();
		
		System.out.println("-> click on approve button");
		uap.clickOnApproveButton();
		
		System.out.println("-> verify");
		sa.assertTrue(uap.userApprovedMessage(), "message is not displayed");
		
		sa.assertAll();
	}
	
	
	

}
