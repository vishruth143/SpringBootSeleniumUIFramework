package com.ea.SpringBootSeleniumUIFramework.steps;

import com.ea.SpringBootSeleniumUIFramework.pages.AboutPage;
import com.ea.SpringBootSeleniumUIFramework.pages.HomePage;
import com.ea.SpringBootSeleniumUIFramework.pages.LoginPage;
import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.ea.SpringBootSeleniumUIFramework.utils.ConfigParser;

public class EA_App_Steps {

    //Logger
    private static final Logger logger = LoggerFactory.getLogger(EA_App_Steps.class);

    //Test data
    JsonNode testData = ConfigParser.loadYaml("ui_test_data_config");

    // Pages
    private final HomePage homePage;
    private final AboutPage aboutPage;
    private final LoginPage loginPage;

    // Constructor
    public EA_App_Steps() {
        // Pages initialized with WebDriver from ThreadLocal
        homePage = new HomePage();
        loginPage = new LoginPage();
        aboutPage = new AboutPage();
    }

    @Given("I click \"login\" link in \"Home\" page")
    public void iClickLoginInHomePage() {
        logger.info("I click login in Home page");
        homePage.clickLoginLink();
    }

    @When("I enter the following for Login")
    public void iEnterTheFollowingForLogin(DataTable table) {
        logger.info("I enter the following for Login");
        System.out.println("UserName: " + testData.get("Login with correct username and password").get("username").asText());
        System.out.println("Password: " + testData.get("Login with correct username and password").get("password").asText());
        // Convert the data table into a list of lists
        var data = table.asLists(String.class);

        // Assuming the data table has key-value pairs like username and password
        String username = data.get(1).get(0); // First row, first column
        String password = data.get(1).get(1); // First row, second column

        loginPage.Login(username, password);
    }

    @And("I click \"Log in\" button")
    public void iClickLoginButton() {
        logger.info("I click login button");
        loginPage.clickLoginButton();
    }

    @Then("I should see the \"Employee Details\" link")
    public void iShouldSeeTheEmployeeDetailsLink() {
        logger.info("I should see the \"Employee Details\" link");
        Assert.assertTrue(homePage.isEmployeeDetailsLinkExists());
    }

    @Then("I should see the \"Invalid login attempt.\" text displayed")
    public void iShouldSeeTheTextDisplayed() {
        logger.info("I should see the \"Invalid login attempt.\" text displayed");
        Assert.assertTrue(homePage.isInvalidLoginAttemptTextExists());
    }

    @Then("I should see the \"Log off\" link")
    public void iShouldSeeTheLogoffLink() {
        logger.info("I should see the \"Log off\" link");
        Assert.assertTrue(homePage.isLogoffLinkExists());
    }

    @And("I click \"Log off\" link")
    public void iClickLogoffLink() {
        logger.info("I click \"Log off\" link");
        homePage.clickLogoffLink();
    }

    @Then("I should see the \"Login\" link")
    public void iShouldSeeLoginLink() {
        logger.info("I should see the \"Login\" link");
        Assert.assertTrue(homePage.isLoginLinkExists());
    }

    @Given("I click \"About\" link on \"Home\" page")
    public void iClickAboutLink() {
        logger.info("I click \"About\" link on \"Home\" page");
        homePage.clickAboutLink();
    }

    @Then("I should see the application version")
    public void iShouldSeeTheApplicationVersion() {
        Assert.assertTrue(aboutPage.isApplicationVersionTextExists());
    }
}
