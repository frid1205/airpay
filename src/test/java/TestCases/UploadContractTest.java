/**
 * 
 */
package TestCases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import bases.BaseWeb;
import pages.SideMenuPage;
import pages.UploadContractPage;

/**
 * @author fendyridwan
 *
 */
public class UploadContractTest extends BaseWeb{
	
	/*
	 * User sign in
	 */
	@Test
	public void signIn() throws InterruptedException {
		userSignIn();
	}
	
	/*
	 * G01
	 * Upload file
	 */
	@Test
	public void G01_UploadFile() throws InterruptedException {
		SideMenuPage smp = new SideMenuPage(driver);
		UploadContractPage ucp = new UploadContractPage(driver);
		
		System.out.println("-> Access upload contract page");
		smp.clickOnProfileDropDown();
		smp.clickUploadContractMenu();
		Thread.sleep(2000);
		
		System.out.println("-> Upload file");
		ucp.browseFile();
		ucp.clickOnUploadButton();
		
		assertFalse(ucp.somethingWentWrongMessage(), "fail to upload");
	}
	
	/*
	 * G02
	 * Download file
	 */
	@Test
	public void G02_DownloadFile() throws InterruptedException {
		UploadContractPage ucp = new UploadContractPage(driver);
		
		System.out.println("-> download file");
		try {
			ucp.clickOnDownload1();
			ucp.clickOnDownload2();
			ucp.clickOnDownload3();
		}catch(Exception e) {
			assertTrue(false, "something wrong with download button");
		}
		
	}

}
