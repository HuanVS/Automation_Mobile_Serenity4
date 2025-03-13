package com.example.defs;

import com.example.steps.TutorialsSteps;
import dev.failsafe.internal.util.Assert;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import java.util.List;

public class TutorialsDefs {
    @Steps
    TutorialsSteps tutorialsSteps;

    @Then("User should sees the following sections:")
    public void userShouldSeesTheFollowingSections(DataTable data) {
        List<String> listSections = data.asList();
        for (String section : listSections) {
            tutorialsSteps.verifyItemSectionDisplayInTutorialsScreen(section.trim());
        }
    }

    @When("User taps on item Assigned Route")
    public void userTapsOnItemAssignedRoute() {
        tutorialsSteps.userTapsOnAssignedRoute();
    }
}
