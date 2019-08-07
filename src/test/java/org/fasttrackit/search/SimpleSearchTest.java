package org.fasttrackit.search;

import org.fasttrackit.AppConfig;
import org.fasttrackit.TesteBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleSearchTest extends TesteBase {

    @Test
    public void simpleSearchWithOneKeyord() {
        driver.get(AppConfig.getSiteUrl());

        String  searchKeyord = "vase";
        driver.findElement(By.id("search")).sendKeys(searchKeyord + Keys.ENTER);

        System.out.println("Pressed Enter in search field.");

        List<WebElement> productNames = Collections.singletonList(driver.findElement(By.cssSelector("h2.product-name a")));

        System.out.println("Stored" + productNames.size() + "product names");

        for (WebElement productName : productNames) {
            assertThat("Some of the products' names do not contain the searched keyword.",
                    productName.getText(), containsString(searchKeyord.toUpperCase()));
        }


    }

}