package com.ea.SpringBootSeleniumUIFramework.steps;

import com.ea.SpringBootSeleniumUIFramework.models.TestUserDetails;
import com.ea.SpringBootSeleniumUIFramework.models.UserDetails;
import com.ea.SpringBootSeleniumUIFramework.pages.HomePage;
import com.ea.SpringBootSeleniumUIFramework.pages.LoginPage;
import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.ea.SpringBootSeleniumUIFramework.utils.ConfigParser;

public class LoginSteps {

    private static final Logger logger = LoggerFactory.getLogger(LoginSteps.class);
    JsonNode testData = ConfigParser.loadYaml("ui_test_data_config");

    @Autowired
    private HomePage homePage;

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private TestUserDetails testUserDetails;

    @Given("I click login in Home page")
    public void iClickLoginInHomePage() {
        logger.info("I click login in Home page");
        homePage.clickLogin();

        //Scenario Scope
        testUserDetails.setUserDetails(new UserDetails("admin", "password"));
    }

//    @And("I enter the following for Login")
//    public void iEnterTheFollowingForLogin(DataTable table) {
//        logger.info("I enter the following for Login");
//        System.out.println("UserName: " + testData.get("Login with correct username and password").get("username").asText());
//        System.out.println("Password: " + testData.get("Login with correct username and password").get("password").asText());
//        // Convert the data table into a list of lists
//        var data = table.asLists(String.class);
//
//        // Assuming the data table has key-value pairs like username and password
//        String username = data.get(1).get(0); // First row, first column
//        String password = data.get(1).get(1); // First row, second column
//
//        loginPage.Login(username, password);
//    }

    @And("I click login button")
    public void iClickLoginButton() {
        logger.info("I click login button");
        loginPage.ClickLogin();
    }

    @Then("I should see the userform page")
    public void iShouldSeeTheUserformPage() {
        logger.info("I should see the userform page");
        Assert.assertTrue(homePage.isEmployeeDetailsExists());
    }

}
