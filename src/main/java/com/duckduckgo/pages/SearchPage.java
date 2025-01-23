package com.duckduckgo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends  BasePage {

    @FindBy(id = "searchbox_input")
    WebElement searchInput;

    @FindBy(xpath = "//button[@aria-label='Search']")
    WebElement searchButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void searchWord(String word){
        searchInput.sendKeys(word);
        searchButton.click();
    }
}
