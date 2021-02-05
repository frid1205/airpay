/**
 * 
 */
package pages;

import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * @author fendyridwan
 *
 */
public class UploadContractPage extends BasePage{
	
	WebDriver driver;
	
	public UploadContractPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="contract_file")
	@CacheLookup
	WebElement browseFile;
	
	@FindBy(id="upload_contract")
	@CacheLookup
	WebElement uploadContractButton;
	
	@FindBy(name="download_contract1")
	@CacheLookup
	WebElement downloadContractButton1;
	
	@FindBy(name="download_contract2")
	@CacheLookup
	WebElement downloadContractButton2;
	
	@FindBy(name="download_contract3")
	@CacheLookup
	WebElement downloadContractButton3;
	
	@FindBy(xpath="//*[contains(text(),\"Something Went wrong\")]")
	@CacheLookup
	List<WebElement> somethingWentWrongMessage;
	
	
	public void browseFile() {
		String filename = "attachment/contractFile.pdf";
	    File file = new File(filename);
	    String path = file.getAbsolutePath();
	    System.out.println(path);
	    (browseFile).sendKeys(path);

	}
	
	public void clickOnUploadButton() {
		try {
			waitVisibility(uploadContractButton).click();
		}catch(Exception e) {
			clickELement(uploadContractButton);
		}
	}
	
	public void clickOnDownload1() {
		waitVisibility(downloadContractButton1).click();
	}
	
	public void clickOnDownload2() {
		waitVisibility(downloadContractButton2).click();
	}
	
	public void clickOnDownload3() {
		waitVisibility(downloadContractButton3).click();
	}
	
	public boolean somethingWentWrongMessage() {
		if(!somethingWentWrongMessage.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}

}
