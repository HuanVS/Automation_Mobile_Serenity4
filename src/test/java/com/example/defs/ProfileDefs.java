package com.example.defs;


import com.example.steps.ProfileSteps;
import dev.failsafe.internal.util.Assert;
import groovyjarjarantlr4.runtime.debug.Profiler;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

import java.util.List;
import java.util.Map;


public class ProfileDefs {
    @Steps
    ProfileSteps profileSteps;

    @And("User clicks to item Tutorials")
    public void userClicksToItemTutorials() {
        profileSteps.userClickToTutorial();
    }

}
