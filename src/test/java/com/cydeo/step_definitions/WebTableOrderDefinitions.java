package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class WebTableOrderDefinitions {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();
    BasePage basePage = new BasePage();
    OrderPage orderPage = new OrderPage();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.table.url"));
        webTableLoginPage.login();
        basePage.order.click();
    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {

        Select select = new Select(orderPage.productDropdown);
        select.selectByVisibleText(string);


    }

    @When("user enters quantity {int}")
    public void user_enters_quantity(Integer int1) {

        orderPage.inputQuantity.clear();

       // orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE, "" + int1);
        orderPage.inputQuantity.sendKeys(""+int1);

    }

    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {

        orderPage.inputName.sendKeys(string);

    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {

        orderPage.inputStreet.sendKeys(string);

    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {

        orderPage.inputCity.sendKeys(string);

    }

    @When("user enters state {string}")
    public void user_enters_state(String string) {

        orderPage.inputState.sendKeys(string);

    }

    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {

        orderPage.inputZip.sendKeys(string);

    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String string) {

        for (WebElement each : orderPage.cardType) {

           if(each.getText().equalsIgnoreCase(string)){
               each.click();
           }

        }


        }



    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {

        orderPage.cardNoInput.sendKeys(string);

    }

    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {

        orderPage.cardExpInput.sendKeys(string);

    }

    @When("user enters process order button")
    public void user_enters_process_order_button() {

        orderPage.processOrderBtn.click();

    }

    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String string) {

        WebElement firstRowOfTable = Driver.getDriver().findElement(By.xpath("(//tbody//tr)[1]"));

        Assert.assertTrue(firstRowOfTable.getText().contains(string));


        //Driver.getDriver().findElement(By.xpath("//button[.='Logout']")).click();

    }



}
