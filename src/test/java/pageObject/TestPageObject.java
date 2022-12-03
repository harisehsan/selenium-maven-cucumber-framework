package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestPageObject {
    @FindBy(xpath = "//dh-io-vmos[@class='webcomponent aem-GridColumn aem-GridColumn--default--12']") public WebElement our_models_shadow_root;

    public By class_A_lbl_by = By.className("dh-io-vmos_1PW4e");


}
