package com.duckduckgo.test;

import com.duckduckgo.hook.BaseTest;
import com.duckduckgo.pages.ResultPage;
import com.duckduckgo.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DuckTest extends BaseTest {

    @Test
    public void SearchWordDuckDuckTest(){

        SearchPage searchPage = new SearchPage(driver);
        ResultPage resultPage = new ResultPage(driver);
        searchPage.searchWord("Android");
        List<String> resultTitle = resultPage.getListTitle();

        Assert.assertTrue(resultTitle.stream()
                .allMatch(title -> title.toLowerCase().contains("android")));


    }

    @Test
    public void countRegionFilterElementTest(){

        SearchPage searchPage = new SearchPage(driver);
        ResultPage resultPage = new ResultPage(driver);
        searchPage.searchWord("Android");
        resultPage.openClearFilterRegion();
        int totalCountries = resultPage.getNumberCountries();
        Assert.assertTrue(totalCountries > 10);
    }
}
