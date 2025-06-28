package com.ea.SpringBootSeleniumUIFramework;

import com.ea.SpringBootSeleniumUIFramework.pages.CreateEmployeePage;
import com.ea.SpringBootSeleniumUIFramework.pages.EmployeeListPage;
import com.ea.SpringBootSeleniumUIFramework.pages.HomePage;
import com.ea.SpringBootSeleniumUIFramework.pages.LoginPage;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("prod")
public class SpringBootSeleniumUIFrameworkApplicationTestNGTests extends AbstractTestNGSpringContextTests {

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
