package com.envision.actitime.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.internal.annotations.TestAnnotation;

@CucumberOptions(features = {"src/main/java/com/envision/actitime/features"},
        glue = {"com.envision.actitime.stepdefs"},
        tags = "@medium",
        plugin = {"html:actitimereports/cucumber_reports/actitime_html_report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class LoginTestRunner extends AbstractTestNGCucumberTests {


}
