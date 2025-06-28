package com.ea.SpringBootSeleniumUIFramework;

import com.ea.SpringBootSeleniumUIFramework.pages.CreateEmployeePage;
import com.ea.SpringBootSeleniumUIFramework.pages.EmployeeListPage;
import com.ea.SpringBootSeleniumUIFramework.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ea.SpringBootSeleniumUIFramework.pages.HomePage;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("prod")
class SpringBootSeleniumUIFrameworkApplicationTests {

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
