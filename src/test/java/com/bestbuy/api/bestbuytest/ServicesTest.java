package com.bestbuy.api.bestbuytest;

import com.bestbuy.api.ServicesPojo;
import com.bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesTest extends TestBase {
    @Test
    public void test001() {    //getAllServicesInfo
        Response response =
                given()
                        .when()
                        .get("/services");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void test002() {     //createNewServices
        ServicesPojo servicesPojo = new ServicesPojo();

        servicesPojo.setName("Samsung Services");


        Response response = given()
                .header("Content-Type", "application/json")
                .body(servicesPojo)
                .when()
                .post("/services");
        response.then().statusCode(201);
        response.prettyPrint();


    }


    @Test
    public void test003 (){     //getServicesById
        Response response =
                given()
                        .basePath("/services")
                        .pathParam("id", 20)
                        .when()
                        .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void test004 (){    //updateServices
        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Mobile Specialty Store");
        Response response = given()
                .basePath("/services")
                .header("Content-Type","application/json")
                .body(servicesPojo)
                .when()
                .patch("/20");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    @Test
    public void test005() {    //deleteServices
        Response response =
                given()
                        .when()
                        .delete("/21");
        response.then().statusCode(404);
        response.prettyPrint();

    }
}
