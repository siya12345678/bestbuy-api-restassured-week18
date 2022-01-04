package com.bestbuy.api.extrctingresponce;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Extracting {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }


    //1. Extract the limit
    @Test
    public void test001() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //2. Extract the total
    @Test
    public void test002() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //3. Extract the name of 5th store
    @Test
    public void test003() {
        String name = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of store is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //4. Extract the names of all the store
    @Test
    public void test004() {
        List<String> name = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of store name is : " + name);
        System.out.println("------------------End of Test---------------------------");

    }

    //5. Extract the storeId of all the store
    @Test
    public void test005() {
        List<Integer> storeId = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of store Id are: " + storeId);
        System.out.println("------------------End of Test---------------------------");

    }

    //6. Print the size of the data list
    @Test
    public void test006() {
        List<Integer> dataSize = response.extract().path("data");
        int size = dataSize.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Size of data list: " + size);
        System.out.println("------------------End of Test---------------------------");

    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test007() {
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Value of the store name: " + values);
        System.out.println("------------------End of Test---------------------------");
    }


    //8. Get the address of the store where store name = Rochester
    @Test
    public void test008() {
        List<HashMap<String, ?>> address = response.extract().path("data.findAll{it.name=='Rochester'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Address of the store name: " + address);
        System.out.println("------------------End of Test---------------------------");
    }

    //9. Get all the services of 8th
    @Test
    public void test009() {
        List<HashMap<String, ?>> services = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Services of 8 store: " + services);
        System.out.println("------------------End of Test---------------------------");
    }

    //10. Get storeServices of the store where service name = Windows Store
    @Test
    public void test010() {
        List<HashMap<String, ?>> storeService = response.extract().path("data.findAll{it.name='Windows Store'}.services.storeservices");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" StoreId of all the store:" + storeService);
        System.out.println("------------------End of Test---------------------------");

    }

    //11. Get all the storeId of all the store
    @Test
    public void test011() {
        List<Integer> storeId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("  StoreId of all the store:" + storeId);
        System.out.println("------------------End of Test---------------------------");
    }

    //12. Get id of all the store
    @Test
    public void test012() {
        List<Integer> id = response.extract().path("data.services.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("  ID of all the store:" + id);
        System.out.println("------------------End of Test---------------------------");

    }

    //13. Find the store names Where state = ND
    @Test
    public void test013() {
        List<String> storeName = response.extract().path("data.findAll{it.state == 'ND'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Store names where state = ND :" + storeName);
        System.out.println("------------------End of Test---------------------------");
    }

    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test014() {
        int services = response.extract().path("data.findAll{it.name == 'Rochester'}.services.size");
        //int count = services.size();
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total number of services are:" + services);
        System.out.println("------------------End of Test---------------------------");

    }

    //15. Find the createdAt for all services whose name = “Windows Store”
    @Test
    public void test015(){
        List<String> created =response.extract().path("data.findAll{it.services.name=='Windows Store'}.services.created");
        System.out.println("-----------------------StartingTest-----------------------------");
        System.out.println("Total store services are: " + created);
        System.out.println("------------------------End of Test-----------------------------");

    }
    //16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test016(){
        List<String> services = response.extract().path("data.findAll{it.name=='Fargo'}.services.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Name of all services are:" + services);
        System.out.println("------------------End of Test---------------------------");

    }
    //17. Find the zip of all the store
    @Test
    public void test017() {
        List<Integer> zip = response.extract().path("data.zip");
        System.out.println("-----------------------StartingTest-----------------------------");
        System.out.println("Total store services are: " + zip);
        System.out.println("------------------------End of Test-----------------------------");
    }
    //18. Find the zip of store name = Roseville
    @Test
    public void test018(){
        List<Integer> zip = response.extract().path("data.findAll{it.name=='Rochester'}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the zip are: " + zip);
        System.out.println("------------------End of Test---------------------------");
    }
    //19. Find the storeservices details of the service name = Magnolia Home Theater
    @Test
    public void test019(){
        List<HashMap<String, ?>> services = response.extract().path("data.findAll{it.name=='Samsung Experience'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of the services are: " + services);
        System.out.println("------------------End of Test---------------------------");
    }
    //20. Find the lat of all the stores
    @Test
    public void test020() {
        List<Integer> lat = response.extract().path("data.lat");
        System.out.println("-----------------------StartingTest-----------------------------");
        System.out.println("Total store services are: " + lat);
        System.out.println("------------------------End of Test-----------------------------");
    }
}
