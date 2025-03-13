package com.example.steps;

import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;

public class LoginSteps extends UIInteractions {
    LoginPage loginPage;
    HomePage homePage;

    @Step
    public void openApplication() {
        loginPage.openApplication();
    }

    @Step
    public void userLoginApp(String username, String password) {
        loginPage.userLoginApp(username, password);
    }

    @Step
    public void userShouldSeeHomePageAfterLogin(){
        homePage.userShouldSeeHomePageAfterLoginSuccessfully();
    }

}