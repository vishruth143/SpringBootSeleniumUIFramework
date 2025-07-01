package com.ea.SpringBootSeleniumUIFramework.pages;

import com.ea.SpringBootSeleniumUIFramework.extensions.UIElementExtensions;
import com.ea.SpringBootSeleniumUIFramework.extensions.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class HomePage extends BasePage {

//*******************************************************(Web Elements)*************************************************
//-------------------------------------------------------Link-----------------------------------------------------------
    private final By lnkLogin = By.linkText("Login");
    private final By lnkEmployeeList = By.linkText("Employee List");
    private final By lnkEmployeeDetails = By.linkText("Employee Details");

//-------------------------------------------------------Text-----------------------------------------------------------
private final By textInvalidLoginAttempt = By.xpath("//li[normalize-space()='Invalid login attempt.']");

//*******************************************************(Actions)******************************************************
//-------------------------------------------------------Click----------------------------------------------------------
    public void clickLogin() {
        UIElementExtensions.performClick(driver, lnkLogin);
    }

    public void clickEmployeeList(){
        UIElementExtensions.performClick(driver, lnkEmployeeList);
    }
//-------------------------------------------------------Exists---------------------------------------------------------
    public boolean isEmployeeDetailsExists() {
        WebElement element = WaitHelper.waitForPresence(driver, lnkEmployeeDetails, 10);
        return element.isDisplayed();
    }

    public boolean isInvalidLoginAttemptExists() {
        WebElement element = WaitHelper.waitForPresence(driver, textInvalidLoginAttempt, 10);
        return element.isDisplayed();
    }

}
