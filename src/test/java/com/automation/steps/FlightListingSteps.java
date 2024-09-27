package com.automation.steps;

import com.automation.pages.FlightListingPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class FlightListingSteps {

    FlightListingPage flightListingPage = new FlightListingPage();

    @Then("verify flight listing page is displayed")
    public void verify_flight_listing_page_is_displayed() {
        Assert.assertTrue(flightListingPage.isFlightListingPageDisplayed());
    }
}
