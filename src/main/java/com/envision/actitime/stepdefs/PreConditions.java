package com.envision.actitime.stepdefs;

import com.envision.actitime.utility.BrowserFactory;
import io.cucumber.java.en.Given;

public class PreConditions {
    @Given("user launches the url {string}")
    public void user_launches_the_url(String url) {
        BrowserFactory.openUrl(url);
    }
}
