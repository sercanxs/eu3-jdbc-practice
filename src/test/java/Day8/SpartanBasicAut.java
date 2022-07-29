package Day8;


import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;
public class SpartanBasicAut {

    @BeforeClass
    public void beforeclass(){

        baseURI= ConfigurationReader.get("spartan.apiUrl");

    }


@Test
    public void test1(){

given().accept(ContentType.JSON)
        .and().auth().basic("admin","admin")
        .when().get("/api/spartans")
        .then()
        .statusCode(200).and()
        .log().all();




}


}
