package stepdefinitions;

import Pages.FlightStatusPage;
import base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FlightStatusSteps {

    private BaseUtil base;
    FlightStatusPage flightStatusPage;

    public FlightStatusSteps(BaseUtil base)  {
        this.base = base;
        flightStatusPage = new FlightStatusPage(base.driver);
    }


    @Given("I navigate to the test site")
    public void iNavigateToTheTestSite() throws InterruptedException {
        flightStatusPage.navigateToSite();
    }

    @And("I select the today's Date")
    public void iSelectTheTodaySDate() {
        flightStatusPage.selectTodaysDate();
    }

    @And("I select show flight status button")
    public void iSelectShowFlightStatusButton() throws InterruptedException {
        flightStatusPage.clickOnShowFlightStatusButton();
    }

    @Then("I verify that flight routes are displayed")
    public void iVerifyThatFlightRoutesForTodaySDateIsDisplayed() throws InterruptedException {
        Assert.assertTrue(flightStatusPage.verifyThatFlightsRoutesAreDisplayed(), "The Flight route(s) for today are not displayed!");

    }

    @When("I enter {string} as a departure airport and {string} as a destination airport")
    public void iEnterAsADepartureAirportAndDestinationAirport(String departure, String destination) throws InterruptedException {
        flightStatusPage.enterTheDestinationAndDepartureAirport(departure,destination);
    }

    @When("I select the tomorrow's date")
    public void iSelectTheTomorrowSDate() throws InterruptedException {
        flightStatusPage.selectTheTomorrowDate();

    }

    @When("I enter the flight number {string}")
    public void iEnterTheFlightNumber(String flightNumber) {
        flightStatusPage.enterTheFlightStatus(flightNumber);

    }

    @And("I select flight number")
    public void iSelectFlightNumber() throws InterruptedException {
      flightStatusPage.selectFlightNumberOption();
    }

    @And("I select the today's Date for flight by number")
    public void iSelectTheTodaySDateForFlightByNumber() {
      flightStatusPage.getDatePicker2();
    }

    @Then("I verify that flight routes are displayed for flight by number")
    public void iVerifyThatFlightRoutesAreDisplayedForFlightByNumber() throws InterruptedException {
      Assert.assertTrue(flightStatusPage.verifyThatFlightsRoutesAreDisplayedforflightByNumber(),"The Flight route(s) for the given flight number and date are not displayed!");
    }
}
