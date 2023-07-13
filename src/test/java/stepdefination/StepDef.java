package stepdefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {

	public WebDriver driver;
	public LoginPage loginPg;
	public SearchCustomerPage SearchCustPg;
	public AddNewCustomerPage addNewCustPg;
			
	
	@Given("User Launch firefox browser")
	public void user_launch_firefox_browser() {
	    // Write code here that turns the phrase above into concrete actions
      WebDriverManager.firefoxdriver().setup();
      	driver=new FirefoxDriver();

		loginPg= new LoginPage(driver);
		addNewCustPg = new AddNewCustomerPage(driver);
	//	SearchCustPg = new SearchCustomerPage(driver);


	}
	
	@When("User opens URL {string}")
	public void user_opens_url(String URL) {
	    // Write code here that turns the phrase above into concrete actions
        driver.get(URL);
	}
	
	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		loginPg.enterEmail(string);
		loginPg.enterPassword(string2);
	}
	
		
	@When("Click on Login")
	public void click_on_login() {
	    // Write code here that turns the phrase above into concrete actions
		loginPg.clickOnLoginButton();
	}
	
	
                	//////////Login feature///////////////////////////

	
	
	
	
	
	
	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
	    // Write code here that turns the phrase above into concrete actions
		String actualTitle=driver.getTitle();

		if(actualTitle.equals(expectedTitle))
		{
			
			Assert.assertTrue(true);//pass
		}
		else
		{
			Assert.assertTrue(false);//fail
			

		}
	}
	
	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
	    // Write code here that turns the phrase above into concrete actions
		loginPg.clickOnLogOutButton();
	}
	
	
	
    	///////////////////////////Add new customer/////////////////////

	
	
	
	
	
	
	
	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {
	    // Write code here that turns the phrase above into concrete actions
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";

		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);

		}
		else
		{
			Assert.assertTrue(false);

		}

	}
	
	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
	    // Write code here that turns the phrase above into concrete actions
		addNewCustPg.clickOnCustomersMenu();
	}
	
	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
	    // Write code here that turns the phrase above into concrete actions
		addNewCustPg.clickOnCustomersMenuItem();
	}
	
	@When("click on Add new button")
	public void click_on_add_new_button() {
	    // Write code here that turns the phrase above into concrete actions
		addNewCustPg.clickOnAddnew();
	}
	
	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	    // Write code here that turns the phrase above into concrete actions
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if(actualTitle.equals(expectedTitle))
		{

			Assert.assertTrue(true);//pass
		}
		else
		{

			Assert.assertTrue(false);//fail
		}
	}
	
	@When("User enter customer info")
	public void user_enter_customer_info() {
	    // Write code here that turns the phrase above into concrete actions
		addNewCustPg.enterEmail("bharat112gmail.com");
		//addNewCustPg.enterEmail(generateEmailId() + "@gmail.com");
		addNewCustPg.enterPassword("test1");
		addNewCustPg.enterFirstName("bharat");
		addNewCustPg.enterLastName("veer");
		addNewCustPg.enterGender("Male");
		addNewCustPg.enterDob("8/15/1999");
		addNewCustPg.enterCompanyName("CodeStudio");
		addNewCustPg.enterAdminContent("Admin content");
		addNewCustPg.enterManagerOfVendor("Vendor 1");

	}
	
	@When("click on Save button")
	public void click_on_save_button() {
	    // Write code here that turns the phrase above into concrete actions
		addNewCustPg.clickOnSave();
	}
	
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String exptectedConfirmationMsg) {
	    // Write code here that turns the phrase above into concrete actions
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if(bodyTagText.contains(exptectedConfirmationMsg))
		{
			Assert.assertTrue(true);//pass

		}
		else
		{

			Assert.assertTrue(false);//fail

		}

	}

             
	              ////////////Search Customer//////////////////////////

	
	
	
	
	
	
	
	
	
	@When("Enter customer EMail")
	public void enter_customer_e_mail() {
	    // Write code here that turns the phrase above into concrete actions
		SearchCustPg.enterEmailAdd("victoria_victoria@nopCommerce.com");
		}
	
	@When("Click on search button")
	public void click_on_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		SearchCustPg.clickOnSearchButton();
	}
	
	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
	    // Write code here that turns the phrase above into concrete actions
		String expectedEmail = "victoria_victoria@nopCommerce.com";

		//   Assert.assertTrue(SearchCustPg.searchCustomerByEmail(expectedEmail));

		if( SearchCustPg.searchCustomerByEmail(expectedEmail) ==true)
		{
			Assert.assertTrue(true);

		}
		else {
			Assert.assertTrue(false);

		}
	}
	
	
	
	         ///////////////search customer by name////////////////////

	
	
	
	
	
	
	
	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
	    // Write code here that turns the phrase above into concrete actions
		SearchCustPg.enterFirstName("Victoria");
	}
	
	@When("Enter customer LastName")
	public void enter_customer_last_name() {
	    // Write code here that turns the phrase above into concrete actions
		SearchCustPg.enterLastName("Terces");
	}
	
	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
	    // Write code here that turns the phrase above into concrete actions
		String expectedName = "Victoria Terces";


		if( SearchCustPg.searchCustomerByName(expectedName) ==true)
		{
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);

	}
	

	@Then("close browser")
	public void close_browser() {
	    // Write code here that turns the phrase above into concrete actions
        driver.close();
        driver.quit();
	}
	
	
	}
