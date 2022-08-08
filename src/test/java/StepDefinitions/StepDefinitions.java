package StepDefinitions;
import POM.MainPagePageObjects;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class StepDefinitions {
    MainPagePageObjects mainPage = new MainPagePageObjects();
    @Given("user launches Google Chrome browser and go to url")
    public void user_launches_google_chrome_browser_and_go_to_url() {
          mainPage.verifyPage();
    }
    @When("user click on the finding a distance button")
    public void user_click_on_the_finding_a_distance_button() {
        mainPage.clickOnTheSearchDistanceButton();
    }
    @When("enter From point")
    public void enter_from_point() {
        mainPage.enterDataToFromField();
    }
    @When("enter To point")
    public void enter_to_point() {
        mainPage.enterDataToToField();
    }
    @When("in the transport option dropdown list select bicycle OSRM")
    public void in_the_transport_option_dropdown_list_select_bicycle_osrm() {
        mainPage.selectTypeOfTransport();
    }
    @When("click to Go button")
    public void click_to_go_button() {
        mainPage.goButtonClick();
    }
    @Then("verify the distance and close a browser")
    public void verify_the_distance_and_close_a_browser() {
        Assert.assertEquals("Расстояние: 2423km. Время: 154:29.", mainPage.getTextActualDistance());
    }
}
