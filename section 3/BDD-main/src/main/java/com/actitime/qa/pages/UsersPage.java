package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage extends TestBase  {
    @FindBy(xpath = "//input[@type='text'and @id='createUserPanel_firstNameField']")
    WebElement firstName;

    @FindBy(xpath = "//input[@type='text'and @id='createUserPanel_lastNameField']")
    WebElement lastName;

    @FindBy(xpath = "//input[@type='text'and @id='createUserPanel_emailField']")
    WebElement email;

    @FindBy(xpath = "//div[@class='atLogoImg']")
    WebElement actiTimeLogo;

    @FindBy(xpath = "//div[text()='New User']")
    WebElement newUserButton;

    @FindBy(xpath = "//div[text()='Save & Send Invitation']")
    WebElement saveUserButton;

    Logger log = Logger.getLogger(UsersPage.class);

    public UsersPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickNewUserButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(newUserButton));
        this.newUserButton.click();
    }

    public void enterFirstName(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(this.firstName));
        this.firstName.sendKeys(firstName);
        log.info("First name entered as "+ firstName);
    }

    public void enterLastName(String lastName) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(this.lastName));
        this.lastName.sendKeys(lastName);
        log.info("First name entered as "+ lastName);
    }

    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(this.email));
        this.email.sendKeys(email);
        log.info("Email entered as "+ email);
    }

    public void clickCreateUserLink() {
        this.saveUserButton.click();
        log.info("New user create button click!");
    }

}
