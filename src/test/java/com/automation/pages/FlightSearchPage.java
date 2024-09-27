package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightSearchPage extends BasePage {

    @FindBy(xpath = "//android.view.View[@content-desc='Leaving from Button']")
    WebElement flyingFromField;

    @FindBy(xpath = "//android.view.View[@content-desc='Going to Button']")
    WebElement flyingToField;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='TeamTypeaheadInput']")
    WebElement flyingFromAndToInput;

    @FindBy(xpath = "//android.widget.TextView[@text='Search']")
    WebElement searchBtn;

    @FindBy(xpath = "//android.view.View[contains(@content-desc,'Dates Button')]")
    WebElement dateField;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='buttonLabel']")
    WebElement doneBtn;

    String flyingFromAndToLocator = "//android.widget.TextView[contains(@text,'%s')]";
    String dateSelection = "//android.view.View[contains(@content-desc,'%s')]";


    public boolean isFlightSearchPageDisplayed() {
        return isPresent(flyingFromField) && isPresent(flyingToField);
    }

    public void selectFlyingFrom(String fromCity) {
        flyingFromField.click();
        flyingFromAndToInput.sendKeys(fromCity);
        String loc = String.format(flyingFromAndToLocator, fromCity);
        driver.findElement(By.xpath(loc)).click();
    }

    public void selectFlyingFTo(String toCity) {
        flyingToField.click();
        waitForElementToBeClickable(flyingFromAndToInput);
        flyingFromAndToInput.sendKeys(toCity);
        String loc = String.format(flyingFromAndToLocator, toCity);
        driver.findElement(By.xpath(loc)).click();
    }

    public void clickOnSearchBtn() {
        searchBtn.click();
    }

    public void clickOnDateField() {
        dateField.click();
    }

    public void clickOnDoneBtn() {
        doneBtn.click();
    }

    public void selectDate(String fromDate) {
        String loc = String.format(dateSelection, fromDate);
        driver.findElement(By.xpath(loc)).click();
    }
}
