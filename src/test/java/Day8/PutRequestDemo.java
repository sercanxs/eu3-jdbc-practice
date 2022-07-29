package Day8;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;


import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
public class PutRequestDemo {

    @BeforeClass
    public void beforeclass(){

        baseURI= ConfigurationReader.get("spartan.apiUrl");

    }



    @Test
    public void test1(){

        Map<String,Object> putRequestMap = new HashMap<>();

        putRequestMap.put("name","john");
        putRequestMap.put("gender","Male");
        putRequestMap.put("phone",1231231239);

        given().log().all()
                .and().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().pathParam("id",89)
                .and().body(putRequestMap)
                .when().put("/api/spartans/{id}")
                .then()
                .log().all()
                .and().assertThat().statusCode(204);


    }
    @Test
    public void test2(){
        Map<String,Object> putRequestMap = new HashMap<>();

        putRequestMap.put("name","john");
        putRequestMap.put("gender","Male");
        putRequestMap.put("phone",1231231239);

        given().log().all()
                .and().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().pathParam("id",89)
                .and().body(putRequestMap)
                .when().patch("/api/spartans/{id}")
                .then()
                .log().all()
                .and().assertThat().statusCode(204);
















    }


}
