package POM;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class DriverHolder {
    protected static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        }
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
    public static void closeDriver() {
        if (driver != null) {
            try {
                driver.close();
                driver.quit();
            } catch (NoSuchMethodError errorQuit) {
                System.out.println("NoSuchMethodError");
            } catch (NoSuchSessionException errorClose) {
                System.out.println("NoSuchSessionException");
            } catch (SessionNotCreatedException errorClose) {
                System.out.println("SessionNotCreatedException");}

            driver = null;
        }
    }
    }
