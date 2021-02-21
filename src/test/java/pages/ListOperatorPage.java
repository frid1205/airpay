/**
 * 
 */
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

/**
 * @author fendyridwan
 *
 */
public class ListOperatorPage extends BasePage{
	WebDriver driver;

	public ListOperatorPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[contains(@href,\"/setting/addoperator\")]")
	@CacheLookup
	WebElement createOperatorButton;
	
	@Step("Click on create operator button")
	public void clickOnCreateOperatorButton() {
		waitVisibility(createOperatorButton).click();
	}

}
