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
public class AboutPage extends BasePage {

//*******************************************************(Web Elements)*************************************************
//-------------------------------------------------------Text-------------------------------------------------------
    private final By applicationVersionText = By.xpath("//p[contains(text(),'ExecuteAutomation Employee Application v1.0')]");

//*******************************************************(Actions)******************************************************

//-------------------------------------------------------Exists----------------------------------------------------------
    public boolean isApplicationVersionTextExists() {
        WebElement element = WaitHelper.waitForPresence(driver, applicationVersionText, 10);
        return element.isDisplayed();
    }

}
