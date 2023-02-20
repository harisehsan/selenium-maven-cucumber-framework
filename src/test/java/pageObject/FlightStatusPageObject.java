package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlightStatusPageObject {
    @FindBy(xpath = "//dh-io-vmos[@class='webcomponent aem-GridColumn aem-GridColumn--default--12']") public WebElement our_models_shadow_root;
    @FindBy (xpath = "//button[@class='cookie-consent--cta-accept a-cta a-cta-prio1']") public WebElement cookie_accept_btn;
    @FindBy (xpath = "(//button[@aria-haspopup='true'])[2]") public WebElement airport_txt_1;
    @FindBy (xpath = "(//button[@aria-haspopup='true'])[3]") public WebElement airport_txt_2;
    @FindBy (xpath = "//input[@placeholder='Departure airport']") public WebElement departure_Airport;
    @FindBy (xpath = "(//input[@placeholder='Destination airport'])[1]") public WebElement destination_Airport;
    @FindBy (name = "datepicker_input_27") public WebElement date_picker;
    @FindBy (css = "form[method='post'] div button[type='submit'] span span") public WebElement show_Flight_Status_btn;
    @FindBy (xpath = "//h2[normalize-space()='Check your flight status']") public WebElement check_Flight_Status;
    @FindBy (name = "ew-calendar-id-31") public List <WebElement> dates_lbl;
    @FindBy (xpath = "(//div[@class='o-search-flight-status__card'])") public List <WebElement> flight_Routes_card;
    @FindBy (xpath = "(//*[name()='svg'][@data-component-name='icon'])[21]") public WebElement next_Month_btn;
    @FindBy (xpath = "//span[@class='o-station-select__new-station-list__label-text']") public WebElement airport_drpDown;
    @FindBy (xpath = "//span[@class='o-station-select__new-station-list__label-text']") public List <WebElement> airport_drpDown_lst;
    @FindBy (xpath = "(//span[@class='o-compact-search__cta-button-value'])[1]") public WebElement first_Airport_lbl;
    @FindBy (xpath = "(//span[@class='o-compact-search__cta-button-value'])[2]") public WebElement second_Airport_lbl;
    @FindBy (name = "flightNumber") public WebElement flight_Number_txtField;
    @FindBy (xpath = "(//span[@class='a-label a-label--block'])[2]") public WebElement flightNumber_rdoBtn;
    @FindBy (name = "datepicker_input_235") public WebElement getDate_picker_2;
    @FindBy (name = "ew-calendar-id-239") public List <WebElement> dates_picker2;

    public By class_A_lbl_by = By.className("dh-io-vmos_1PW4e");
}
