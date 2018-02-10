package com.ecvictor.selenium.junit.classic.iga;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/* Created by caoc on 2/10/17.
 * Copyright (c) 2015 Service ECVictor Inc. All rights reserved.
 */

public class UserAcceptanceTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //chose driver type
        String os = (System.getProperty("os.name"));

        if (os.equalsIgnoreCase("Mac OS X"))
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        else System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--kiosk");

        driver = new ChromeDriver(chromeOptions);

        baseUrl = "https://www.iga.net";

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testOpenHomePage() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[@title=\"Fresh Chicken Drumstick\"]")).click();
        assertEquals(driver.findElement(
                By.cssSelector("h1.h3-like.product-detail__name > span")).getText(),
                "Chicken Drumstick");
    }

    @Test
    public void testLoginFailed() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//A[@id='header_0_MobileAccountLink']")).click();
        assertEquals(driver.findElement(By.xpath("//H1[@class='push-medium--bottom']")).getText(),"LOGIN");
        driver.findElement(By.id("body_0_main_1_LoginBox_TxtEmail")).sendKeys("info@ecvictor.com");
        driver.findElement(By.id("body_0_main_1_LoginBox_TxtPassword")).sendKeys("ecvictor123");
        driver.findElement(By.id("body_0_main_1_LoginBox_BtnConnection")).click();
        assertEquals(driver.findElement(
                By.cssSelector("#body_0_main_1_LoginBox_ErrorSummaryControl > ul > li")).getText(),
                "Login unsuccessful : try another email address or another password.");
    }
    //*[@id="body_0_main_0_full61a767ecd2dc40dfae80a3ef0a403968_2_GroceryListControl_GroceryItems_GroceryTemplate_0_NavigateTo_0"]
    @After
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
