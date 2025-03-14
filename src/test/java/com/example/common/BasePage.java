package com.example.common;

import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;

public class BasePage extends PageObject {
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    /**
     enter text
     */
    public void enterText(WebElementFacade element, String text) {
        try {
            element.waitUntilVisible().click();
            element.clear();
            element.sendKeys(text);
            logger.info("Entered text '{}' into element: {}", text, element);
        } catch (Exception e) {
            logger.error("Error entering text '{}' into element: {}", text, element, e);
        }
    }

    /**
     get text
     */
    public String getText(WebElementFacade element) {
        try {
            String text = element.waitUntilVisible().getText();
            logger.info("Retrieved text '{}' from element: {}", text, element);
            return text;
        } catch (Exception e) {
            logger.error("Error retrieving text from element: {}", element, e);
            return null;
        }
    }

    public void waitUntilElementVisible(WebElementFacade elementFacade) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(elementFacade));
    }

    // scroll W3C Actions
    public void scrollDownByAction() {
        var screenSize = getMobileDriver().manage().window().getSize();
        int deviceHeight = screenSize.getHeight();
        int deviceWidth = screenSize.getWidth();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), deviceWidth / 2, (int) (deviceHeight * 0.7)))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), deviceWidth / 2, (int) (deviceHeight * 0.3)))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        getMobileDriver().perform(Collections.singletonList(swipe));
    }

    public void scrollToElement(WebElementFacade element) {
        int maxScrollAttempts = 10; //Maximum number of scrolls to avoid scrolling forever
        int attempts = 0;

        while (!element.isVisible() && attempts < maxScrollAttempts) {
            var screenSize = getMobileDriver().manage().window().getSize();
            int startX = screenSize.getWidth() / 2;
            int startY = (int) (screenSize.getHeight() * 0.8);
            int endY = (int) (screenSize.getHeight() * 0.2);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 0)
                    .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX, endY))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            getMobileDriver().perform(Collections.singletonList(swipe));
            attempts++;
        }
    }

    public void swipe(Point start, Point end, Duration duration) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getMobileDriver().perform(ImmutableList.of(swipe));
    }


    // get current AppiumDriver
    public AppiumDriver getMobileDriver() {
        return (AppiumDriver) ((WebDriverFacade) getDriver()).getProxiedDriver();
    }

    public IOSDriver iosDriver() {
        return (IOSDriver) getMobileDriver();
    }

    public AndroidDriver androidDriver() {
        return (AndroidDriver) getMobileDriver();
    }

    // Click to element
    public void click(WebElementFacade element) {
        element.click();
    }

    // Check element display?
    public boolean isElementDisplayed(WebElementFacade element) {
        return element.isDisplayed();
    }

    // Find element by AppiumBy
    public WebElementFacade findElementByAccessibilityId(String id) {
        return $(AppiumBy.accessibilityId(id));
    }

    public WebElementFacade findElementByXPath(String xpath) {
        return $(AppiumBy.xpath(xpath));
    }

    // close app
    public void closeApp() {
        getMobileDriver().close();
    }

    // reopen app
    public void launchApp() {
        getMobileDriver().executeScript("mobile: activateApp", Map.of("appId", getAppPackage()));
    }


    // get package name
    private String getAppPackage() {
        return getMobileDriver().getCapabilities().getCapability("appPackage").toString();
    }

    // scroll to element
    public void scrollToElement(String visibleText) {
        String uiAutomatorString = "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"" + visibleText + "\")";
        getMobileDriver().executeScript("mobile: uiautomator", uiAutomatorString);
    }

    // capture
    public byte[] takeScreenshot() {
        return getMobileDriver().getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
    }

    // wait element display (maximum 30s)
    public void waitForElementToBeVisible(WebElementFacade element, int timeoutInSeconds) {
        withTimeoutOf(Duration.ofSeconds(timeoutInSeconds)).waitFor(element).isVisible();
    }
}