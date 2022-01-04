package com.bestbuy.api.bestbuytest;

import com.bestbuy.api.ProductPojo;
import com.bestbuy.api.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductTest extends TestBase {
    @Test
    public void test001() {   //getAllProductsInfo
        Response response =
                given()
                        .when()
                        .get("/products");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void test002() {    //createNewProduct

        ProductPojo productPojo = new ProductPojo();


        productPojo.setName("oppo");
        productPojo.setType("mobile");
        productPojo.setPrice(40.50);
        productPojo.setUpc("2182021");
        productPojo.setShipping(15.25);
        productPojo.setDescription("opp mobile");
        productPojo.setManufacturer("opp Store");
        productPojo.setModel("String");
        productPojo.setUrl("String");
        productPojo.setImage("String");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .post("/products");
        response.then().statusCode(201);
        response.prettyPrint();


    }
    @Test
    public void  test003(){      //getProductById
        Response response =
                given()
                        .basePath("/products")
                        .pathParam("id", 127687)
                        .when()
                        .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void test004(){     //updateProduct
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Sony Laptop");
        Response response = given()
                .basePath("/products")
                .header("Content-Type","application/json")
                .body(productPojo)
                .when()
                .patch("/347146");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void test005() {     //deleteProduct
        Response response =
                given()
                        .when()
                        .delete("/48530");
        response.then().statusCode(404);
        response.prettyPrint();

    }

}
