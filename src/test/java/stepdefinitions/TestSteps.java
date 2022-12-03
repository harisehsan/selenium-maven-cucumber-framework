package stepdefinitions;

import Pages.TestPage;
import base.BaseUtil;
import io.cucumber.java.en.Given;

public class TestSteps {

    private BaseUtil base;
    TestPage testPage;

    public TestSteps(BaseUtil base)  {
        this.base = base;
        testPage = new TestPage(base.driver);
    }


    @Given("I navigate to the test site")
    public void iNavigateToTheTestSite() throws InterruptedException {
        testPage.navigateToSite();
    }

}
