package com.ea.SpringBootSeleniumUIFramework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/java/com/ea/SpringBootSeleniumUIFramework/features"},
        glue = "com.ea.SpringBootSeleniumUIFramework.steps",
        plugin = {
            "pretty",                                          // ✅ Console readable format
            "json:target/cucumber-reports/cucumber.json",      // ✅ JSON for advanced reporting if needed
            "html:target/cucumber-reports/cucumber.html",      // ✅  HTML report
            "junit:target/cucumber-reports/cucumber.xml"       // ✅ Optional: JUnit format
        },
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {
//        // ✅ Enable parallel execution of scenarios
//        @Override
//        @DataProvider(parallel = true)
//        public Object[][] scenarios() {
//                return super.scenarios();
//        }
}
