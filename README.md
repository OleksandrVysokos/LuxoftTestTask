# LuxoftTestTask
This project was created by Oleksandr Vysokos for Luxoft as a test task. 
Goal: Create a Gherkin scenario and automate it with Cucumber, Java. 
Also I use Selenium WebDriver and JUnit. 
Package FeatureFiles contains luxoft.feature file with Gherkin scenario. 
Package POM contains DriverHolder java class (this class create driver for all project). 
MainPagePageObject java class (this class contains all objects than used in project). 
Package StepDefinitions contains Hooks java class (contains @Before and @After testing scenario methods). 
StepDefinitions java class (contains all steps definitions for Gherkin scenario and created using Page Object Model pattern).  
RunCucumberTest is runner for test project.
