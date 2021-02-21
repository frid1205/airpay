/**
 * 
 */
package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

/**
 * @author fendyridwan
 *
 */
public class CSToolsCreatePage extends BasePage{
	WebDriver driver;
	
	public CSToolsCreatePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id=\"name\"]")
	@CacheLookup
	WebElement name;
	
	@FindBy(xpath="//input[@id=\"email\"]")
	@CacheLookup
	WebElement email;
	
	@FindBy(xpath="//div[@class=\"header\"]//span[@class=\"font-weight-bold\"]")
	@CacheLookup
	WebElement headerName;
	
	@FindBy(id="provider")
	@CacheLookup
	WebElement provider;
	
	@FindBy(id="description")
	@CacheLookup
	WebElement description;
	
	@FindBy(id="complainsubmit")
	@CacheLookup
	WebElement complainsubmit;
	
	@FindBy(xpath="//*[@id=\"name\" and @disabled]")
	@CacheLookup
	List<WebElement> nameIsDisable;
	
	@FindBy(xpath="//*[@id=\"email\" and @disabled]")
	@CacheLookup
	List<WebElement> emailIsDisable;
	
	
	public String getAttributeValueName() {
		
		return name.getAttribute("value"); 
	}
	
	public String getAttributeValueEmail() {
		
		return email.getAttribute("value"); 
	}
	
	public String getAttributeValueHeaderName() {
		
		return headerName.getText(); 
	}
	
	public boolean nameIsDisable() {
		if(!nameIsDisable.isEmpty()==true) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean emailIsDisable() {
		if(!emailIsDisable.isEmpty()==true) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean validateName() {
		if(getAttributeValueName().contains(getAttributeValueHeaderName())) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean validateEmail() {
		if(getAttributeValueEmail().contains(getAttributeValueHeaderName())) {
			return true;
		}else {
			return false;
		}
	}
	
	@Step("type provider")
	public void typeProvider(String name) throws InterruptedException {
		provider.sendKeys(name);
	}
	
	@Step("type description")
	public void typeDescription(String name) {
		description.sendKeys(name);
	}
	
	public void clickOnSubmitButton() throws InterruptedException {
		try {
			waitVisibility(complainsubmit).click();
			
		}catch(Exception e) {
			clickELement(complainsubmit);
		}
		Thread.sleep(2000);
	}

}
