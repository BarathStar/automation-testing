package com.ecvictor.selenium.junit.classic.iga;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import static org.junit.Assert.assertEquals;
/* Created by caoc on 2/10/17.
 * Copyright (c) 2015 Service ECVictor Inc. All rights reserved.
 */

public class SmokeTest extends BaseTest {
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }


    @Test
    public void testOpenHomePage() throws Exception {
        driver.get(baseUrl);
        assertEquals(driver.getTitle(), "IGA | Supermarket in Quebec: Recipes, Online Grocery, Flyer");

    }

    @Test
    public void testMyAccount() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//A[@id='header_0_MobileAccountLink']")).click();
        assertEquals(driver.findElement(By.xpath("//H1[@class='push-medium--bottom']")).getText(), "LOGIN");
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

}
