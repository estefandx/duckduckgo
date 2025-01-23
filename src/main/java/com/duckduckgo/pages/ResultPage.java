package com.duckduckgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class ResultPage extends  BasePage{

    @FindBy(xpath = "//article[@data-testid='result']//a[@data-testid='result-title-a']")
    List<WebElement> titleListElements;

    @FindBy(xpath = "//a[@data-testid='region-filter-label']")
    WebElement filterRegionDropDown;

    @FindBy(xpath = "//div[@class='z0NZlhz4vu_SBzEGoeJS']/a")
    WebElement clearFilterRegion;

    @FindBy(xpath = "//div[@data-testid='dropdown-options']//span[@class='fdosLIuRgrWo7SyeqSUb']")
    List<WebElement> countryList;


    public ResultPage(WebDriver driver) {
        super(driver);
    }

    public void openFilterRegion(){
        filterRegionDropDown.click();
    }

    public void openClearFilterRegion(){
        openFilterRegion();
        clearFilterRegion.click();
        openFilterRegion();

    }

    public List<String> getListTitle(){
        wait.until(ExpectedConditions.visibilityOfAllElements(titleListElements));
        List<String> titleList = new ArrayList<>();

        for(WebElement element:titleListElements){
            System.out.println(element.getText());
            titleList.add(element.getText());
        }
        return  titleList;
    }

    public int getNumberCountries(){
        return countryList.size();

    }


}
