package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    public GoogleSearchPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(xpath = "//input[@name='q']")
    public WebElement googleSearchBox;

    //    public WebElement capitalElement(String capital){
//        return Driver.getDriver().findElement(By.linkText(capital));
//    }

    public String getCapital(){
        return Driver.getDriver().findElement(By.xpath("//a[@class='FLP8od']")).getText();
    }





}
