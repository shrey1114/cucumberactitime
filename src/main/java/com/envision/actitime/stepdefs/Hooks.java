package com.envision.actitime.stepdefs;

import com.envision.actitime.utility.BrowserFactory;
import com.envision.actitime.utility.PropertyFileReader;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver;

    @Before
    public void openBrowser() {
        String brname = PropertyFileReader.getPropertyValue("actitime.browsername");
        String rmode = PropertyFileReader.getPropertyValue("actitime.runmode");
        this.driver = BrowserFactory.getBrowser(brname, rmode);

        // If you dont want to write precondition then write this:
//        String url = PropertyFileReader.getPropertyValue("actitime.url");
//        BrowserFactory.openUrl(url);
    }

    @After
    public void closeBrowser() {
        BrowserFactory.closeCurrentBrowserWindow();
    }

    @AfterAll
    public static void before_or_after_all() {
        BrowserFactory. exitBrowser();
    }
}
