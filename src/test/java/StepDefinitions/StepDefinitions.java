package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class StepDefinitions {
    WebDriver driver = new ChromeDriver();
    @Given("user launches Google Chrome browser and go to url")
    public void user_launches_google_chrome_browser_and_go_to_url() {
//        MainPagePageObjects startTesting = new MainPagePageObjects();
//        startTesting.start();
        driver.get("https://www.openstreetmap.org/");
        driver.manage().window().maximize();
    }
    @When("user click on the finding a distance button")
    public void user_click_on_the_finding_a_distance_button() {
//        MainPagePageObjects distance = new MainPagePageObjects();
//        distance.clickOnTheSearchDistanceButton();
        WebElement searchDistanceButton = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='sidebar']/div[1]/form[1]/div/div[2]/a"))));
        searchDistanceButton.findElement(By.xpath("//*[@id='sidebar']/div[1]/form[1]/div/div[2]/a")).click();

    }
    @When("enter From point")
    public void enter_from_point() {
//        MainPagePageObjects fromField = new MainPagePageObjects();
//        fromField.enterDataToFromField();
        String from = "Радищева, Київ";
        WebElement fromInputField = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[2]/div[2]/input"))));
        fromInputField.findElement(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[3]/div[2]/input")).click();
        fromInputField.sendKeys(from);
    }
    @When("enter To point")
    public void enter_to_point() {
//        MainPagePageObjects toField = new MainPagePageObjects();
//        toField.enterDataToToField();
        String to = "Кембридж";
        WebElement toInputField = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[3]/div[2]/input"))));
        toInputField.findElement(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[3]/div[2]/input")).click();
        toInputField.sendKeys(to);
    }
    @When("in the transport option dropdown list select bicycle OSRM")
    public void in_the_transport_option_dropdown_list_select_bicycle_osrm() {
//        MainPagePageObjects dropdownList = new MainPagePageObjects();
//        dropdownList.selectTypeOfTransport();
        WebElement selectTransport = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[4]/div[1]/select")));
        selectTransport.findElement(By.xpath("//*[@id='sidebar']/div[1]/form[2]/div[4]/div[1]/select")).click();
        WebElement optionsTransport = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[4]/div[1]/select/option[1]"))));
        optionsTransport.click();
    }
    @When("click to Go button")
    public void click_to_go_button() {
//        MainPagePageObjects go = new MainPagePageObjects();
//        go.goButtonClick();
        WebElement clickToGoButton = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='sidebar']/div[1]/form[2]/div[2]/div[2]")));
        clickToGoButton.click();
    }
    @Then("verify the distance and close a browser")
    public void verify_the_distance_and_close_a_browser() {
//        MainPagePageObjects endTest = new MainPagePageObjects();
//        endTest.tearDown();
        WebElement actualResult = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[5]/p[1]")));
        String actual = actualResult.getText();
        Assert.assertEquals("Расстояние: 2423km. Время: 154:29.", actual);
        driver.quit();
    }
}
