package com.example.steps;

import com.example.pages.TutorialsPage;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;

public class TutorialsSteps {
    TutorialsPage tutorialsPage;

    @Step
    public void verifyItemSectionDisplayInTutorialsScreen(String section){
        Assert.assertTrue(section + "not displayed!",
                tutorialsPage.verifyTutorialsScreen(section));
    }

    @Step
    public void userTapsOnAssignedRoute(){
        tutorialsPage.userTapsOnAssignedRoute();
    }
}
