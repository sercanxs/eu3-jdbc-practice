package Day8;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.baseURI;


import static io.restassured.RestAssured.*;
public class DeleteRequestDemo {


    @BeforeClass
    public void beforeclass(){

        baseURI= ConfigurationReader.get("spartan.apiUrl");

    }





    @Test(priority = 1)
    public void test1(){

given().pathParam("id",116).delete("/api/spartans/{id}")
        .then().statusCode(204).log().all();







    }





}
