package com.ea.SpringBootSeleniumUIFramework.pages;

import com.ea.SpringBootSeleniumUIFramework.extensions.UIElementExtensions;
import org.openqa.selenium.By;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmployeeListPage extends BasePage {

//*******************************************************(Web Elements)*************************************************
//-------------------------------------------------------Link-----------------------------------------------------------
    private final By btnCreateNew = By.linkText("Create New");

//*******************************************************(Actions)******************************************************
//-------------------------------------------------------Click----------------------------------------------------------
    public void clickCreateNew() {
        UIElementExtensions.performClick(driver, btnCreateNew);
    }

}
