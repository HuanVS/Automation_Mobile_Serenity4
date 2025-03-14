package com.example;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        plugin = {
                "pretty",
                "html:target/site/serenity/",
                "json:target/serenity-reports/cucumber_report.json"
        },
        glue = {"com.example.defs"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CucumberTestSuite {
}
