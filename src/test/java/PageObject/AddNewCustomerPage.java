package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {

	public WebDriver ldriver;

	//constructor
	public AddNewCustomerPage(WebDriver rdriver)
	{
		this.ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}

	

	public String getPageTitle()
	{
		return ldriver.getTitle();
	}

	
	//Find web elements on the web page
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")	 
	WebElement lnkCustomers_menu;

	public void clickOnCustomersMenu() {
		lnkCustomers_menu.click();
	}


	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement lnkCustomers_menuitem;

	public void clickOnCustomersMenuItem() {
		lnkCustomers_menuitem.click();
	}

	
	@FindBy(xpath = "//a[@class='btn btn-primary']")	 
	WebElement btnAddnew;

	public void clickOnAddnew() {
		btnAddnew.click();
	}

	

	@FindBy(xpath = "//input[@id='Email']")
	WebElement txtEmail;

	public void enterEmail(String email)
	{
		txtEmail.sendKeys(email);
	}


	@FindBy(xpath = "//input[@id='Password']")
	WebElement txtPassword;
	
	public void enterPassword(String password)
	{
		txtPassword.sendKeys(password);
	}

	
	

	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement txtFirstName;

	public void enterFirstName(String firstName)
	{
		txtFirstName.sendKeys(firstName);
	}


	@FindBy(xpath = "//input[@id='LastName']")
	WebElement txtLastName;
 
	public void enterLastName(String lastName)
	{
		txtLastName.sendKeys(lastName);
	}

	@FindBy(xpath = "//input[@id='DateOfBirth']")
	WebElement txtDob;
	
    public void enterDob(String dob)
	{
		txtDob.sendKeys(dob);
	}

	@FindBy(xpath = "//input[@id='Company']")
	WebElement txtCompanyName;
	

	public void enterCompanyName(String coName)
	{
		txtCompanyName.sendKeys(coName);
	}

	@FindBy(xpath = "//textarea[@id='AdminComment']")
	WebElement txtAdminContent;


	public void enterAdminContent(String content)
	{
		txtAdminContent.sendKeys(content);
	}


	@FindBy(xpath = "//button[@name='save']")
	WebElement btnSave;

	public void clickOnSave()
	{
		btnSave.click();
	}

	

	@FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")
	WebElement txtCustomerRoles;
	
	

	@FindBy(xpath = "//li[contains(text(),'Administrators')]")
	WebElement listItemAdministrators;


	@FindBy(xpath = "//li[contains(text(),'Registered')]")
	WebElement listItemRegistered;

	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	WebElement listItemGuests;


	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	WebElement listItemVendors;
	//VendorId

	@FindBy(xpath = "//*[@id='VendorId']")
	WebElement dropdownVendorMgr;

	@FindBy(id = "Gender_Male")
	WebElement MaleGender;


	@FindBy(id = "Gender_Female")
	WebElement FeMaleGender;
	

	public void enterManagerOfVendor(String value)
	{
		Select drp=new Select(dropdownVendorMgr);
		drp.selectByVisibleText(value);
	}

	public void enterGender(String gender)
	{
		if(gender.equals("Male"))
		{
			MaleGender.click();
		}
		else if(gender.equals("Female"))
		{
			FeMaleGender.click();
		}
		else//default set Male gender
		{
			MaleGender.click();
		}

	}

	


}