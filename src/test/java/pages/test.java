package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class test {

	@FindBy(xpath="//div//span[@class=\"text-danger\" and @id=\"error_msg_username\"and contains(text(),\"This Field is required\")]")
	@CacheLookup
	List<WebElement> userNameMandatory;
	
	@FindBy(xpath="//div//span[@class=\"text-danger\" and @id=\"error_msg_email\"and contains(text(),\"This Field is required\")]")
	@CacheLookup
	List<WebElement> emailMandatory;
	
	@FindBy(xpath="//div//span[@class=\"text-danger\" and @id=\"error_msg_company\"and contains(text(),\"This Field is required\")]")
	@CacheLookup
	List<WebElement> companyMandatory;
	
	@FindBy(xpath="//div//span[@class=\"text-danger\" and @id=\"error_msg_phone\"and contains(text(),\"This Field is required\")]")
	@CacheLookup
	List<WebElement> phonelMandatory;
	
	@FindBy(xpath="//div//span[@class=\"text-danger\" and @id=\"error_msg_password\"and contains(text(),\"This Field is required\")]")
	@CacheLookup
	List<WebElement> passwordMandatory;
}
