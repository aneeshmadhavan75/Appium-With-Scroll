package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user opens application")
    public void user_opens_application() {
        homePage.openApplication();
    }

    @Then("verify user is on home screen")
    public void verify_user_is_on_home_screen() {
        Assert.assertTrue(homePage.isHomeScreenDisplayed());
    }

    @When("user click on flight tab")
    public void user_click_on_flight_tab() {
        homePage.clickOnFlightTab();
    }


    @And("verify scroll and swipe is working")
    public void verifyScrollAndSwipeIsWorking() {
        homePage.performScrollAndSwipe();

    }
}
