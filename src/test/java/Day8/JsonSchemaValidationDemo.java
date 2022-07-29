package Day8;






import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;
public class JsonSchemaValidationDemo {
    @BeforeClass
    public void beforeclass(){

        baseURI= ConfigurationReader.get("spartan.apiUrl");

    }


    @Test
    public void test1(){


given().accept(ContentType.JSON).and().pathParam("id",10)
        .when().get("/api/spartans/{id}")
        .then().statusCode(200)
        .and().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SingleSpartanSchema.json"));







    }











}
