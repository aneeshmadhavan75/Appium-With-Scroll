package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(id = "com.expedia.bookings:id/uds_button_label")
    WebElement acceptBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Get started']")
    WebElement getStartedBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='Close']")
    WebElement closeBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Let’s go']")
    WebElement letsGoBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Flights']")
    WebElement flightsTab;

    @FindBy(id = "com.expedia.bookings:id/btn_accept_cookies")
    WebElement acceptCookiesBtn;

    @FindBy(xpath = "//android.view.View[@resource-id='PreSignInDismissIcon']")
    WebElement advCloseBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Not now']")
    WebElement notNowBtn;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Explore stays in popular destinations\"]/following-sibling::android.view.View//android.widget.TextView[1]")
    WebElement exploreStayFirstCard;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Go beyond your typical stay']/following-sibling::android.view.View//android.view.View[contains(@content-desc,'Page')]")
    WebElement currentCard;

    public void openApplication() {
        clickOnElementIfPresent(acceptCookiesBtn);
        clickOnElementIfPresent(advCloseBtn);
        clickOnElementIfPresent(notNowBtn);
    }


    public boolean isHomeScreenDisplayed() {
        return isPresent(flightsTab);
    }

    public void clickOnFlightTab() {
        flightsTab.click();
    }

    public void performScrollAndSwipe() {

        // Scroll Logic
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while (!isPresent(exploreStayFirstCard)) {
            scrollOrSwipe(width / 2, height / 2, width / 2, 0);
        }

        // Swipe Logic
        WebElement currentCard = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Explore stays in popular destinations\"]/following-sibling::android.view.View/android.view.View"));
        String currentTitle = exploreStayFirstCard.getText();
        String previousTitle = "";

        while (!currentTitle.equals(previousTitle)) {
            int x = currentCard.getLocation().getX();
            int y = currentCard.getLocation().getY();
            int cardWidth = currentCard.getSize().getWidth();
            int cardHeight = currentCard.getSize().getHeight();

            scrollOrSwipe(x + cardWidth, y + cardHeight / 2, 0, y + cardHeight / 2);

            previousTitle = currentTitle;

            exploreStayFirstCard = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Explore stays in popular destinations\"]/following-sibling::android.view.View//android.widget.TextView[1]"));
            currentTitle = exploreStayFirstCard.getText();

            System.out.println("Previous Title  " + previousTitle);
            System.out.println("Current Title  " + currentTitle);

            currentCard=driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Explore stays in popular destinations\"]/following-sibling::android.view.View/android.view.View"));
        }
    }

}
