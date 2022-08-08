package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static POM.DriverHolder.closeDriver;
import static POM.DriverHolder.getDriver;

public class Hooks {
    @Before
    public void initialization() {
        getDriver().get("https://www.openstreetmap.org/");
    }

    @After
    public void afterScenario() {
        closeDriver();
    }

}
