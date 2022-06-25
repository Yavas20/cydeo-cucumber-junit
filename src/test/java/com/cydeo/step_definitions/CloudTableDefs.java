package com.cydeo.step_definitions;

import com.cydeo.pages.CloudTablePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CloudTableDefs {

    CloudTablePage page = new CloudTablePage();
    String firstname;
    String lastname;

    @Given("User is on cloudTables homepage")
    public void user_is_on_cloud_tables_homepage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("cloudtables.url"));

    }

    @When("User clicks on New button")
    public void user_clicks_on_new_button() {

        page.newPerson.click();


    }

    @When("User enters {string} to firstname field")
    public void user_enters_to_firstname_field(String firstname) {


        page.firstName.sendKeys(firstname);
        this.firstname = firstname;


    }

    @When("User enters {string} to lastname field")
    public void user_enters_to_lastname_field(String lastname) {


        page.lastName.sendKeys(lastname);
        this.lastname = lastname;


    }

    @When("User enters {string} to position field")
    public void user_enters_to_position_field(String position) {

        page.positionBox.sendKeys(position);

    }

    @When("User enters {string} to salary field")
    public void user_enters_to_salary_field(String salary) {

        page.salary.sendKeys(salary);

    }

    @When("User clicks on create button")
    public void user_clicks_on_create_button() {

        page.createButton.click();

    }

    @Then("User should be able to find person at the search box {string}")
    public void user_should_be_able_to_find_person_at_the_search_box(String situation) {
       page.searchBox.clear();
        page.searchBox.sendKeys(this.firstname+" "+this.lastname);
        if(situation.equals("positive")){
            Assert.assertTrue(page.getNewPerson(firstname,lastname).isDisplayed());}
        else if(situation.equals("negative")){
            Assert.assertTrue(page.errorMessage.isDisplayed());}

    }


    @And("User deletes the person created")
    public void userDeletesThePersonCreated() {
        BrowserUtils.sleep(2);
        page.getNewPerson(firstname,lastname).click();
        page.deletePerson.click();
        page.confirmDelete.click();
        BrowserUtils.sleep(2);
    }



}
