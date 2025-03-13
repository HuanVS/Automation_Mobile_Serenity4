package com.example.defs;

// src/test/java/com/yourcompany/stepdefinitions/LoginSteps.java

import com.example.steps.LoginSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class LoginDefs {

    @Steps
    LoginSteps loginSteps;

    @Given("User opens the application")
    public void openApplication() {
        loginSteps.openApplication();
    }

    @When("User logins the application with user: {string} and pass: {string}")
    public void userLoginApp(String username, String password) {
        loginSteps.userLoginApp(username, password);
        loginSteps.userShouldSeeHomePageAfterLogin();
    }

}