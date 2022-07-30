package com.cydeo.library.pages;

import com.cydeo.library.Utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {

    public BasePage(){
    PageFactory.initElements(Driver.getDriver(), this);
}


    public void verify_that_there_are_models_on_the_page(int numberOfModels) {
        List<WebElement> modelsElements= Driver.getDriver().findElements(By.xpath("//ul[@id='menu_item']/li"));
        Assert.assertEquals(numberOfModels, modelsElements.size());
    }
}
