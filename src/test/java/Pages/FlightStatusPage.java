package Pages;

import base.Base;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import pageObject.FlightStatusPageObject;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;


public class FlightStatusPage extends Base {
    WebDriver driver;
    FlightStatusPageObject flightStatusPageObject = new FlightStatusPageObject();

    public FlightStatusPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, flightStatusPageObject);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void navigateToSite() throws InterruptedException {

        goToPage("https://www.eurowings.com/en/information/at-the-airport/flight-status.html");
        waitUntilPageReady(Duration.ofMinutes(1));
        waitUntilVisible(flightStatusPageObject.cookie_accept_btn, Duration.ofSeconds(10));
        flightStatusPageObject.cookie_accept_btn.click();

    }

    public void enterTheDestinationAndDepartureAirport(String departureAirport, String destinationAirport) throws InterruptedException {
        int i=0; int j=0;
        scrollToView(flightStatusPageObject.check_Flight_Status);
        do {
            try {
                i++;
                waitUntilVisible(flightStatusPageObject.airport_txt_1, Duration.ofSeconds(10));
                flightStatusPageObject.airport_txt_1.click();
                waitUntilVisible(flightStatusPageObject.departure_Airport, Duration.ofSeconds(10));
                flightStatusPageObject.departure_Airport.sendKeys(departureAirport);
                waitUntilVisible(flightStatusPageObject.airport_drpDown, Duration.ofSeconds(10));
                flightStatusPageObject.departure_Airport.sendKeys(Keys.ENTER);
            } catch (Exception ignored) {
            }
        } while (!flightStatusPageObject.first_Airport_lbl.getText().contains("Cologn") && i<10);
        do {
            try {
                j++;
                waitUntilVisible(flightStatusPageObject.airport_txt_2, Duration.ofSeconds(10));
                flightStatusPageObject.airport_txt_2.click();
                waitUntilVisible(flightStatusPageObject.destination_Airport, Duration.ofSeconds(10));
                flightStatusPageObject.destination_Airport.sendKeys(destinationAirport);
                waitUntilVisible(flightStatusPageObject.airport_drpDown, Duration.ofSeconds(10));
                flightStatusPageObject.destination_Airport.sendKeys(Keys.ENTER);
            } catch (Exception ignored) {}
        } while (!flightStatusPageObject.second_Airport_lbl.getText().contains("Berlin") && j<10);

    }
        public void selectTodaysDate()
    {
        flightStatusPageObject.date_picker.click();
        flightStatusPageObject.dates_lbl.get(getTodaysDateDay()-1).click();
    }

    public void clickOnShowFlightStatusButton() throws InterruptedException {
        flightStatusPageObject.show_Flight_Status_btn.click();
    }



    public boolean verifyThatFlightsRoutesAreDisplayed() throws InterruptedException {
        try {
            waitUntilVisible(flightStatusPageObject.flight_Routes_card.get(flightStatusPageObject.flight_Routes_card.size()-1),Duration.ofSeconds(5));
            scrollToView(flightStatusPageObject.flight_Routes_card.get(0));
            Thread.sleep(2000); // This optional to use that to check that either the results are correctly verifying by slowing it down
        } catch (Exception ignored) {
        }
        return elementExist(flightStatusPageObject.flight_Routes_card);
    }

    public void selectTheTomorrowDate() throws InterruptedException {
      scrollToView(flightStatusPageObject.check_Flight_Status);
        flightStatusPageObject.date_picker.click();
         if (getTomorrowDate() < getTodaysDateDay())
               flightStatusPageObject.next_Month_btn.click();
        flightStatusPageObject.dates_lbl.get(getTomorrowDate()-1).click();
    }

    public void enterTheFlightStatus(String flightNumber)
    {
        waitUntilVisible(flightStatusPageObject.flight_Number_txtField,Duration.ofSeconds(10));
        flightStatusPageObject.flight_Number_txtField.sendKeys(flightNumber);
    }

    public void selectFlightNumberOption() throws InterruptedException {
      scrollToView( flightStatusPageObject.flightNumber_rdoBtn);
      flightStatusPageObject.flightNumber_rdoBtn.click();
    }

    public void getDatePicker2()
    {
        flightStatusPageObject.getDate_picker_2.click();
        flightStatusPageObject.dates_picker2.get(getTodaysDateDay()-1).click();
    }

    public boolean verifyThatFlightsRoutesAreDisplayedforflightByNumber() throws InterruptedException {
        try {
            waitUntilVisible(flightStatusPageObject.flight_Routes_card.get(flightStatusPageObject.flight_Routes_card.size()-1),Duration.ofSeconds(3));
            scrollToView(flightStatusPageObject.flight_Routes_card.get(0));
        } catch (Exception ignored) {
        }
        return elementExist(flightStatusPageObject.flight_Routes_card);
    }

    private int getTodaysDateDay()
    {
        String date =  java.time.LocalDate.now().toString().substring(8);
        if (date.startsWith(String.valueOf(0)))
            date.replace("0","");
        return Integer.parseInt(date);
    }

    private int getTomorrowDate()
    {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 1);
        dt = c.getTime();
        String date = dt.toString().substring(8,10);
        if (date.startsWith(String.valueOf(0)))
            date.replace("0","");

        return Integer.parseInt(date);
    }

   }