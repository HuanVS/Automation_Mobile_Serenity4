package com.example.defs;

import com.example.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class HomeDefs {
    @Steps
    HomePage homePage;

    @And("User taps to Profile tab")
    public void userClicksToProfileTab() {
        homePage.userClickToProfileTab();
    }

}
