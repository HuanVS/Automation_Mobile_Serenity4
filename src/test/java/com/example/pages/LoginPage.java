package com.example.pages;


import com.example.common.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends BasePage {

//    @FindBy(id = "usernameField")
//    private WebElement usernameField;
//
    @AndroidFindBy(xpath = "//android.widget.EditText[1]")
    private WebElementFacade inputUser;

    @AndroidFindBy(xpath = "//android.widget.EditText[2]")
    private WebElementFacade inputPass;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Log In']")
    private WebElementFacade btnLogin;


    public void openApplication() {
    }

    public void userLoginApp(String username, String password) {
        waitUntilElementVisible(inputUser);
        enterText(inputUser, username);
        enterText(inputPass, password);
        btnLogin.waitUntilClickable().click();
    }

}
