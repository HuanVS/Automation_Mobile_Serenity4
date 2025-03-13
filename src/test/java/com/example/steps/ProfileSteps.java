package com.example.steps;

import com.example.pages.HomePage;
import com.example.pages.ProfilePage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;

public class ProfileSteps {
    ProfilePage profilePage;

    @Step
    public void userClickToTutorial(){
        profilePage.userClickToTutorial();
    }
}
