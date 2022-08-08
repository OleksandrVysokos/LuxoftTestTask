package POM;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static POM.DriverHolder.driver;

public class MainPagePageObjects {
    By searchDistanceBtn = By.xpath("//*[@id='sidebar']/div[1]/form[1]/div/div[2]/a");
    By fieldFrom = By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[2]/div[2]/input");
    By fieldTo = By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[3]/div[2]/input");
    By transportList = By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[4]/div[1]/select");
    By selectBicycle = By.xpath("/html/body/div/div[1]/div[1]/form[2]/div[4]/div[1]/select/option[1]");
    By goBtn = By.xpath("//*[@id='sidebar']/div[1]/form[2]/div[2]/div[2]");
    By distance = By.xpath("/html/body/div/div[1]/div[5]/p[1]");
    public void verifyPage() {
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("OpenStreetMap"));
    }
    public void clickOnTheSearchDistanceButton() {
        WebElement searchDistanceButton = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(searchDistanceBtn)));
        searchDistanceButton.findElement(searchDistanceBtn).click();
    }
    public void enterDataToFromField() {
        String from = "Радищева, Київ";
        WebElement fromInputField = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(fieldFrom)));
        fromInputField.findElement(fieldFrom).click();
        fromInputField.sendKeys(from);
    }
    public void enterDataToToField() {
        String to = "Кембридж";
        WebElement toInputField = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(fieldTo)));
        toInputField.findElement(fieldTo).click();
        toInputField.sendKeys(to);
    }
    public void selectTypeOfTransport() {
        WebElement selectTransport = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(transportList));
        selectTransport.findElement(transportList).click();
        WebElement optionsTransport = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(selectBicycle)));
        optionsTransport.click();
    }
    public void goButtonClick() {
        WebElement clickToGoButton = (new WebDriverWait(driver, Duration.ofSeconds(10)))
                .until(ExpectedConditions.presenceOfElementLocated(goBtn));
        clickToGoButton.click();
    }
    public String getTextActualDistance() {
        WebElement getDistance = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(distance)));
        return getDistance.findElement(distance).getText();
    }
}
