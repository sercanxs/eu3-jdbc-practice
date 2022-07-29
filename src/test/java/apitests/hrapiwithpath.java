package apitests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.baseURI;

import static io.restassured.RestAssured.*;



public class hrapiwithpath {

    @BeforeClass
    public void beforeclass(){

        baseURI= ConfigurationReader.get("hr.apiUrl");

    }

@Test
    public void test1(){

    Response response = given().accept(ContentType.JSON).and().queryParam("q", "{\"region_id\":2}")
            .when().get("/countries");

    System.out.println(response.statusCode());

    String first = response.path("items.country_id[0]");
    System.out.println(first);


    String href = response.path("items.links[2].href[0]");

    System.out.println(href);


}








}
