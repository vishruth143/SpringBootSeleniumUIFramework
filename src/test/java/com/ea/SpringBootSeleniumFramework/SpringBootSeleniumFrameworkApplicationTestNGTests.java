package com.ea.SpringBootSeleniumFramework;

import com.ea.SpringBootSeleniumFramework.pages.CreateEmployeePage;
import com.ea.SpringBootSeleniumFramework.pages.EmployeeListPage;
import com.ea.SpringBootSeleniumFramework.pages.HomePage;
import com.ea.SpringBootSeleniumFramework.pages.LoginPage;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("prod")
public class SpringBootSeleniumFrameworkApplicationTestNGTests extends AbstractTestNGSpringContextTests {

	@Autowired
	private WebDriver driver;

	@Autowired
	private HomePage homePage;

	@Autowired
	private LoginPage loginPage;

	@Autowired
	private CreateEmployeePage createEmployeePage;

	@Autowired
	private EmployeeListPage employeeListPage;

	@Test
	void contextLoads() {
		homePage.clickLogin();
		loginPage.Login("admin", "password");
		loginPage.ClickLogin();
		homePage.clickEmployeeList();
		employeeListPage.clickCreateNew();
		createEmployeePage.createNewEmployee("AutoUser2", "22222", "autotestuser2@gmail.com", "20000", "Middle");

	}

}
