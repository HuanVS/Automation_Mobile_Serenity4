package com.example.pages;

import com.example.common.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialsPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(ProfilePage.class);

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Assigned Route']")
    private WebElementFacade lblAssignedRoute;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Quit tutorial']")
    private WebElementFacade btnQuitTutorial;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Yes, quit tutorial']")
    private WebElementFacade btnConfirmQuitTutorial;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Start Tutorial']")
    private WebElementFacade btnStartTutorial;

    public boolean verifyTutorialsScreen(String section) {
        String locatorSection = "//*[@content-desc='%s']";
        waitABit(1000);
        logger.info("locatorSection: "+ String.format(locatorSection, section));
        return find(By.xpath(String.format(locatorSection, section))).isDisplayed();
    }

    public void userTapsOnAssignedRoute(){
        try {
            lblAssignedRoute.waitUntilClickable();
            lblAssignedRoute.click();
        } catch (Exception ex) {
            logger.error("Error clicking on element: {}", lblAssignedRoute, ex);
        }
    }

    public void userTapsOnStartTutorial(){
        try {
            btnStartTutorial.waitUntilClickable();
            btnStartTutorial.click();
        } catch (Exception ex) {
            logger.error("Error clicking on element: {}", btnStartTutorial, ex);
        }
    }

    public void userTapsOnBtnQuitTutorial(){
        try {
            btnQuitTutorial.waitUntilClickable().click();
            btnConfirmQuitTutorial.waitUntilClickable().click();
        } catch (Exception ex) {
            logger.error("Error clicking on element: {}", btnQuitTutorial, ex);
        }
    }
}
