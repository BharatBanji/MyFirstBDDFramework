package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage<WebElements> {

	WebDriver ldriver;

	public SearchCustomerPage(WebDriver rDriver)
	{
		this.ldriver=rDriver;

		PageFactory.initElements(rDriver, this);
	}





	@FindBy(id="SearchEmail")
	WebElement emailAdd;
	
	//action method to enter email address
	public void enterEmailAdd(String email)
	{
		emailAdd.sendKeys(email);
	}

	
	
	

	@FindBy(id="search-customers")
	WebElement searchBtn;

	//action method to perform click action on search button
	public void clickOnSearchButton()
	{
		searchBtn.click();
		
	}

	
	
	
	

	@FindBy(xpath="//table[@role='grid']")
	WebElement searchResult;
	

	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	//total no. of rows in a grid
	int ttlRows = tableRows.size();


	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr[1]/td")
	List<WebElement> tableColumns;

	//total no. of columns
    int ttlColumns = tableColumns.size();


	public boolean searchCustomerByEmail(String email)
	{
		boolean found = false;


		for(int i=1;i<=ttlRows;i++)//to iterate all the rows of the grid
		{
			System.out.println("Searching row:" +i );

			WebElement webElementEmail = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i  + "]/td[2]"));
			String actualEmailAdd = webElementEmail.getText();
			System.out.println(actualEmailAdd);

			if(actualEmailAdd.equals(email))
			{
				found=true;
			}


		}

		return found;

	}

	
	
	
	
	///////////////////////search customer by name///////////////////////////////
	//action method to enter first name
	
	@FindBy(id="SearchFirstName")
	WebElement firstName;

	public void enterFirstName(String firstNameText)
	{
		firstName.sendKeys(firstNameText);
	}
	
	
	
	
	@FindBy(id="SearchLastName")
	WebElement lastName;

	//action method to enter last name
	public void enterLastName(String LastNameText)
	{
		lastName.sendKeys(LastNameText);
	}

	public boolean searchCustomerByName(String name)
	{
		boolean found = false;

		//total no. of rows in a grid
		int ttlRows = tableRows.size();


		for(int i=1;i<=ttlRows;i++)//to iterate all the rows of the grid
		{
			WebElement webElementName = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i  + "]/td[3]"));
			String actualName = webElementName.getText();

			if(actualName.equals(name))
			{
				found=true;
				break;
			}


		}

		return found;

	}
}