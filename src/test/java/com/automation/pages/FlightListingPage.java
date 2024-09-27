package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightListingPage extends BasePage {

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Price Tracking']")
    WebElement priceTrackingHeader;

    @FindBy(id = "com.expedia.bookings:id/flight_time")
    WebElement flightTime;

    @FindBy(id = "com.expedia.bookings:id/location")
    WebElement flightLocation;

    @FindBy(id = "com.expedia.bookings:id/flights_price")
    WebElement flightPrice;

    public boolean isFlightListingPageDisplayed() {
        return priceTrackingHeader.isDisplayed() && flightTime.isDisplayed() && flightLocation.isDisplayed() && flightPrice.isDisplayed();
    }
}
