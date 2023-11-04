package com.actitime.qa.stepdefinitions;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import com.actitime.qa.util.TestUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ActitimeStepDefinitions extends TestBase {
	
	
	LoginPage loginPage;
	HomePage homePage;

	UsersPage usersPage;
	String sheetName = "Users";
	TestUtil testUtil;

	
	@Given("^User in the Actitime Loging Page$")
	public void user_in_the_Actitime_Loging_Page() throws Throwable {
	    
		initialization();
		loginPage = new LoginPage();
	}

	@When("^User Enter the User Name as  \"([^\"]*)\"$")
	public void user_Enter_the_User_Name_as(String userName) throws Throwable {
		loginPage.enterUserName(userName);
	}

	@Then("^User Enter the Password as  \"([^\"]*)\"$")
	public void user_Enter_the_Password_as(String password) throws Throwable {
		loginPage.enterPassword(password);
	}

	@Then("^User click in Loging button$")
	public void user_click_in_Loging_button() throws Throwable {
		homePage =loginPage.clickSubmitButton();
	}

	@Then("^User should be able to successfuly loging to Actitime$")
	public void user_should_be_able_to_successfuly_loging_to_Actitime() throws Throwable {
	    
		homePage.validateActiTimeLogo();
		driver.quit();
		
	}

	@Given("^User is logged in as an admin$")
	public void user_is_logged_in_as_an_admin() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		loginPage.loging("tv.peduruhewa@gmail.com", "Thilina123");
		homePage = loginPage.clickSubmitButton();
	}

	@Given("^User in the Actitime Users Page$")
	public void user_in_the_Actitime_Users_Page() throws Throwable {
		usersPage = homePage.clickOnUsersLink();
	}

	@When("^User clicks on the new user button$")
	public void user_clicks_the_new_user_button() throws Throwable {
		usersPage.clickNewUserButton();
	}

	@Then("^User Enters the First Name as  \"([^\"]*)\"$")
	public void user_Enter_First_Name_as(String firstName) throws Throwable {
		usersPage.enterFirstName(firstName);
	}

	@Then("^User Enters the Last Name as  \"([^\"]*)\"$")
	public void user_Enter_Last_Name_as(String lastName) throws Throwable {
		usersPage.enterLastName(lastName);
	}

	@Then("^User Enters the Email as  \"([^\"]*)\"$")
	public void user_Enter_Email_as(String email) throws Throwable {
		usersPage.enterEmail(email);
	}

	@Then("^User clicks the Save and Send Invitation button$")
	public void user_Clicks_the_Save_and_Send_Invitation_Button() throws Throwable {
		usersPage.clickCreateUserLink();
	}

	@Then("^User clicks close button$")
	public void user_Clicks_close_button() throws Throwable {
		usersPage.clickCloseButton();
	}

	@Then("User should be able to find the new users {string} {string} in the users list")
	public void userShouldFindNewUserInTheList(String firstname, String lastname) {
		// Add code to check if the new user is in the user list
		String newUser = driver.findElement(By.xpath("//*[@id=\"userListTableContainer\"]/div/table/tbody/tr[1]/td[1]/div/table/tbody/tr/td/div[1]/span[2]")).getText();;
		assertEquals("Text doesn't match", lastname+ ", " +firstname, newUser);
	}
}
