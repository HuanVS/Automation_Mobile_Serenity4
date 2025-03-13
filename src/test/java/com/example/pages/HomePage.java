package com.example.pages;

import com.example.common.BasePage;
import dev.failsafe.internal.util.Assert;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.http.util.Asserts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Active Assignment']")
    private WebElementFacade txtActiveAssignment;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'Profile')]")
    private WebElementFacade lblProfile;

    public void userShouldSeeHomePageAfterLoginSuccessfully(){
        waitUntilElementVisible(txtActiveAssignment);
        Assert.isTrue(txtActiveAssignment.isPresent(),
                "txtActiveAssignment isn't present!");

    }

    public void userClickToProfileTab(){
        try {
            lblProfile.waitUntilClickable();
            lblProfile.click();
        } catch (Exception ex) {
            logger.error("Error clicking on element: {}", lblProfile, ex);
        }
    }
}
