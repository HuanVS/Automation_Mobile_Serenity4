package com.example.pages;

import com.example.common.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ProfilePage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(ProfilePage.class);

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Tutorials']")
    private WebElementFacade itemTutorial;

    @AndroidFindBy(xpath = "//div[@class='section-title']")
    private List<WebElementFacade> sectionTitles;

    public void userClickToTutorial(){
        try {
            scrollDownByAction();
            itemTutorial.waitUntilClickable().click();
            waitABit(3000);
        } catch (Exception ex) {
            logger.error("Error clicking on element: {}", itemTutorial, ex);
        }
    }

    public boolean areSectionsDisplayed(List<String> expectedSections) {
        try {
            List<String> actualSections = sectionTitles.stream()
                    .map(WebElementFacade::getText)
                    .toList();

            logger.info("Expected Sections: {}", expectedSections);
            logger.info("Actual Sections: {}", actualSections);

            return actualSections.containsAll(expectedSections);
        } catch (Exception e) {
            logger.error("Error verifying sections on Profile screen", e);
            return false;
        }
    }

}
