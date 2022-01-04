package com.bestbuy.api.bestbuytest;

import com.bestbuy.api.StoresPojo;
import com.bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresTest extends TestBase {
    @Test
    public void test001() {      //getAllStoresInfo
        Response response =
                given()
                        .when()
                        .get("/stores");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void test002(){ //create new product

        StoresPojo storesPojo= new StoresPojo();
        storesPojo.setName("Decorama");
        storesPojo.setType("Dollar Savings");
        storesPojo.setAddress("12341 Semley Road");
        storesPojo.setAddress2("");
        storesPojo.setCity("Pune");
        storesPojo.setState("DB");
        storesPojo.setZip("23871");
        storesPojo.setLat(45.087f);
        storesPojo.setLng(23.123f);
        storesPojo.setHours("string");

        Response response =
                given()
                        .basePath("/stores")
                        .header("Content-Type", "application/json")
                        .body(storesPojo)
                        .when()
                        .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }


    @Test
    public void  test003(){     // getStoresById
        Response response =
                given()
                        .basePath("/stores")
                        .pathParam("id", 18)
                        .when()
                        .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void test004(){       //updateStores
        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("La Crosse");
        Response response = given()
                .basePath("/stores")
                .header("Content-Type","application/json")
                .body(storesPojo)
                .when()
                .patch("/16");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void test005() {     // deleteStores
        Response response =
                given()
                        .when()
                        .delete("/19");
        response.then().statusCode(404);
        response.prettyPrint();

    }

}

