package com.ecvictor.api.rest.assured.o2o;

import org.junit.Test;

import static io.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by caoc on 2/22/16.
 * Copyright (c) 2015 Service ECVictor Inc. All rights reserved.
 */
public class coinmarketcapTest {
    /**
     * Should not be able to access.
     */
    @Test
    public void coinmarket_top_10_coin_returns_200_with_expected_limit_and_unit() {
        expect().statusCode(200)
                .given().log().uri()
                .when().get("https://api.coinmarketcap.com/v1/ticker/?limit=10")
                .then().log().ifValidationFails()
                .body("size()", lessThan(10)).body("name", hasItem("Bitcoin"))
                .contentType("application/json");
    }


}