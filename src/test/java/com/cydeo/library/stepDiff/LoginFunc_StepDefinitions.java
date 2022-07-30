package com.cydeo.library.stepDiff;

import com.cydeo.library.Utilities.ConfigurationReader;
import com.cydeo.library.Utilities.Driver;
import com.cydeo.library.pages.BasePage;
import com.cydeo.library.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class LoginFunc_StepDefinitions {
    LoginPage loginPage = new LoginPage();
    BasePage basePage= new BasePage();


    @Given("user is on the loginPage")
    public void user_is_on_the_login_page() {
        loginPage.user_is_on_the_login_page();
    }
    @Then("verify that the title is {string}")
    public void verify_that_the_title_is(String expectedTitle) {
        loginPage.verify_that_the_title_is(expectedTitle);

    }
    @When("librarian enters valid email and password")
    public void librarian_enters_valid_and(Map <String, String> credentials ) {
        loginPage.librarian_enters_valid_and(credentials.get("username"),credentials.get("pass") );
    }
    @When("user click sign in button")
    public void user_click_sign_in_button() {
        loginPage.user_click_sign_in_button();
    }

    @Then("verify that there are {int} models on the page")
    public void verify_that_there_are_models_on_the_page(int numberOfModels) {
        basePage.verify_that_there_are_models_on_the_page(numberOfModels);
    }

}
