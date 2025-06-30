package com.ea.SpringBootSeleniumUIFramework.pages;

import com.ea.SpringBootSeleniumUIFramework.libraries.DriverManager;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;

    // Constructor
    public BasePage() {
        this.driver = DriverManager.getDriver(); // dynamically get driver per scenario
    }
}

