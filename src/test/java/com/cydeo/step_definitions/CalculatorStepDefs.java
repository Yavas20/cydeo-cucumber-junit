package com.cydeo.step_definitions;

import com.cydeo.pages.CalculatorPage;
import com.cydeo.pages.PercentageCalculatorPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.Map;

public class CalculatorStepDefs {

    @Given("User is on calculator page")
    public void user_is_on_calculator_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("calculator.url"));

    }


    @When("User clicks {string} on calculator")
    public void user_clicks_on_calculator(String button) {

        new CalculatorPage().button(button).click();

    }


    @Then("result {string} should be displayed")
    public void resultShouldBeDisplayed(String expectedResult) {

        String actualResult = new CalculatorPage().outPut.getText().trim();
        Assert.assertEquals("Wrong calculation", expectedResult, actualResult);

    }


    @Given("User is on percentage calculator page")
    public void userIsOnPercentageCalculatorPage() {
        System.out.println("User is on the percentage page");
        Driver.getDriver().get(ConfigurationReader.getProperty("percentage.url"));
    }

    @Then("User should see fallowing calculation results")
    public void userShouldSeeFallowingCalculationResults(Map<Integer,Integer> valuesMap) {
        System.out.println("valuesMap = " + valuesMap);
        PercentageCalculatorPage page = new PercentageCalculatorPage();
        page.percent.sendKeys("5");
        // 500 is key --- value is 25=result

        for(Integer inputKey : valuesMap.keySet()){
            page.input.clear();
            page.input.sendKeys(""+inputKey+ Keys.ENTER);

            System.out.println("input value = " + inputKey);
            System.out.println("Expected value of %5 is = "+valuesMap.get(inputKey));

            System.out.println("Actual value from webpage = "+page.result.getAttribute("value"));

            Assert.assertEquals(valuesMap.get(inputKey), Integer.valueOf(page.result.getAttribute("value")));

        }
    }


}
