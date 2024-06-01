package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AdminPage;
import pages.BasePage;
import pages.LoginPage;
import setup.BrowserFactory;
import utils.Wrapper;

public class loginSteps {

    WebDriver driver;
    BasePage basePage;
    AdminPage adminPage;
    LoginPage loginPage;

    @Before
    public void tearUp(){
        driver = BrowserFactory.launchBrowser("chrome");
        basePage = new BasePage(driver);
        adminPage = new AdminPage(driver);
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown(){
        Wrapper.waitForLoading(3);
        basePage.closeBrowser();
    }


    @Given("Launching Website for testing")
    public void launchApplication(){
        Wrapper.waitForLoading(3);
        basePage.launchURL("https://opensource-demo.orangehrmlive.com/");
    }

    @Given("I am on login page of application")
    public void verifyIfUserIsOnLoginPage(){
        Assert.assertTrue(loginPage.checkIfLoginTestDisplay());
    }

    @Given("I enter valid user name and password")
    public void provideUserNameAndPassword(){
        loginPage.enterUserName(Wrapper.get("username"));
        loginPage.enterPassword(Wrapper.get("password"));
    }

    @Given("I enter invalid user name and password")
    public void provideInvalidUserNameAndPassword(){
        loginPage.enterUserName(Wrapper.get("username"));
        loginPage.enterPassword(Wrapper.get("invalidPassword"));
    }

    @Given("I click on login button")
    public void clickOnLoginButton(){
        loginPage.clickOnLoginButton();
    }

    @Given("I am landing on home page successfully")
    public void verifyLoginSuccessful(){
        Assert.assertTrue(loginPage.checkIfUserIconDisplay());
    }

    @Given("I am getting error for invalid credential")
    public void verifyLoginFailed(){
        Assert.assertTrue(loginPage.checkIfInvalidCredentialErrorDisplay());
    }


    @When("I enter username {string}")
    public void enterUserNameInTextBox(String userName){
        loginPage.enterUserName(userName);
        Wrapper.waitForLoading(3);

    }

    @When("I enter password {string}")
    public void enterPasswordInTextBox(String password){
        loginPage.enterPassword(password);

    }





}
