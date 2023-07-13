package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rDriver)
	{
		this.ldriver=rDriver;

		PageFactory.initElements(rDriver, this);
	}
	
	
	@FindBy(id = "Email")
	WebElement email;
	
	public void enterEmail(String emailAdd)
	{
		email.clear();
		email.sendKeys(emailAdd);
	}
	
	
	@FindBy(id="Password")
	WebElement password;

	public void enterPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement LoginBtn;

	
	public void clickOnLoginButton()
	{
		LoginBtn.click();
	}

	
	
	@FindBy(linkText = "Logout")
	WebElement logout;
	
	
	public void clickOnLogOutButton()
	{
		logout.click();
	}
}
