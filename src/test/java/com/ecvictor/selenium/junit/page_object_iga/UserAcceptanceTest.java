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

public class UserAcceptanceTest extends BaseTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        super.setUp();
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
        assertEquals(driver.findElement(By.xpath("//H1[@class='push-medium--bottom']")).getText(), "LOGIN");
        driver.findElement(By.id("body_0_main_1_LoginBox_TxtEmail")).sendKeys("info@ecvictor.com");
        driver.findElement(By.id("body_0_main_1_LoginBox_TxtPassword")).sendKeys("ecvictor123");
        driver.findElement(By.id("body_0_main_1_LoginBox_BtnConnection")).click();
        assertEquals(driver.findElement(
                By.cssSelector("#body_0_main_1_LoginBox_ErrorSummaryControl > ul > li")).getText(),
                "Login unsuccessful : try another email address or another password.");
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }


}
