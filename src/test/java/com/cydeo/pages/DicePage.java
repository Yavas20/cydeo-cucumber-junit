package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DicePage {

    public DicePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "typeaheadInput")
    public WebElement keywordBox;

    @FindBy(id = "google-location-search")
    public WebElement zipCodeBox;

    @FindBy(id = "totalJobCount")
    public WebElement totalJobs;

}
