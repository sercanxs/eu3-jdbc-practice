package apitests;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;
public class SpartanTestWithJsonPath {


    @BeforeClass
    public void beforeclass(){

        baseURI= ConfigurationReader.get("spartan.apiUrl");

    }


    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON).pathParam("id", 11).when().get("/api/spartans/{id}");

        System.out.println(response.getStatusCode());


        JsonPath jsonPath = response.jsonPath();

        int id = jsonPath.getInt("id");

        String nameJson = jsonPath.getString("name");

        System.out.println(id);
        System.out.println(nameJson);


    }


}
