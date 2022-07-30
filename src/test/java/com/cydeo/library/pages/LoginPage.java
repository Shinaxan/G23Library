package com.cydeo.library.pages;

import com.cydeo.library.Utilities.ConfigurationReader;
import com.cydeo.library.Utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "inputEmail")
    private WebElement emailInput;

    @FindBy(id = "inputPassword")
    private WebElement passwordInput;

    @FindBy(xpath = "//button")
    private WebElement signinBtn;

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("library.url"));
    }

    public void verify_that_the_title_is(String expectedTitle) {
        Assert.assertEquals("Title isn't matching", expectedTitle, Driver.getDriver().getTitle());
    }
    public void librarian_enters_valid_and(String email, String password) {

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
    }

    public void user_click_sign_in_button() {
        signinBtn.click();
    }




}


