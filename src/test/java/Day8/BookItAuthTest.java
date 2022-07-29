package Day8;


import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;
public class BookItAuthTest {


    @BeforeClass
    public void beforeclass(){

        baseURI="https://cybertek-reservation-api-qa2.herokuapp.com";

    }





    @Test
    public void test1(){

        String token = "eyJhbGciOiJIUzI1NiJ9.eyJq" +
                "dGkiOiIxMzAiLCJhdWQiOiJzdHVkZW50LXRlYW0tbGVhZGVyIn0.3YSCwcTXRcEygBm7LvBLb6_D8jU5WXjAD6E3VA9oh0o";
        Response response = given().header("Authorization", "Bearer "+token)
                .when().get("/api/campuses");


    }

}
