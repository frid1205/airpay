/**
 * 
 */
package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * @author fendyridwan
 *
 */
public class CSToolsListPage extends BasePage{

	WebDriver driver;
	
	public CSToolsListPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//button[contains(@class,\"create_complaints\")]")
	@CacheLookup
	WebElement createComplaintsButton;
	
	@FindBy(xpath="//td[3]")
	@CacheLookup
	WebElement checkProviderList;
	
	@FindBy(xpath="//th[3]")
	@CacheLookup
	WebElement providerOrder;
	
	@FindBy(xpath="//td[3]")
	@CacheLookup
	List<WebElement> checkProviderListIsExist;
	
	@FindBy(xpath="//button[contains(@class,\"create_complaints\")]")
	@CacheLookup
	List<WebElement> createComplaintsButtonIsExist;
	
	public void clickCreateComplaintsButton() throws InterruptedException {
		waitVisibility(createComplaintsButton).click();
		Thread.sleep(2000);
	}
	
	public boolean checkProviderListIsExist() {
		if(!checkProviderListIsExist.isEmpty()==true) {
			return true;
		}else {
			return false;
		}
	}
	
	public void clickOnProviderOrder() {
		waitVisibility(providerOrder).click();
	}
	
	public boolean checkComplaintsIsAdded(String name) {
		
		try {
			if(checkProviderList.getText().contains(name)) {
				return true;
			}else {
				return false;
			}
			
		}catch(Exception e) {
			clickOnProviderOrder();
			if(checkProviderList.getText().contains(name)) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public boolean createComplaintsButtonIsNotExist() {
		if(createComplaintsButtonIsExist.isEmpty()==true) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
