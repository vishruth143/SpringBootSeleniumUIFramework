package com.ea.SpringBootSeleniumUIFramework.steps;

import com.ea.SpringBootSeleniumUIFramework.libraries.DriverManager;
import com.ea.SpringBootSeleniumUIFramework.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Hooks {

    @Value("${selenium.browser:chrome}")
    private String browser;

    @Value("${selenium.headless:false}")
    private boolean headless;

    @Value("${app.url}")
    private String url;

    @Before
    public void InitializeTest(Scenario scenario) {
        System.out.println("-".repeat(200));
        System.out.println("Hooks->InitializeTest");
        DriverManager.initDriver(browser, headless);
        WebDriver driver = DriverManager.getDriver();

        System.out.println("Maximize the browser window");
        driver.manage().window().maximize();

        driver.get(url);
    }

    @After
    public void TearDownTest(Scenario scenario) {
        WebDriver driver = DriverManager.getDriver();

        System.out.println("Hooks->TearDownTest");
        if (scenario.isFailed()) {
            ScreenshotUtil.takeScreenshot(driver, scenario.getName());
            System.out.println(scenario.getName()+" - Failed!");
        }
        System.out.println("-".repeat(200));
        DriverManager.quitDriver();
    }
}
