package apitests;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
public class SpartanTestWithParameters {

@BeforeClass
    public void beforeclass(){

    baseURI= "http://54.161.114.237:8000";

}
@Test
    public void test1(){

    Response response = given().accept(ContentType.JSON).and().pathParam("id",5).when().get("/api/spartans/{id}");

}

@Test
    public void test2(){
    given().accept(ContentType.JSON).and().queryParam("gender","Female")
            .and().queryParam("nameContains","e")
            .when().get("/api/spartans/search");



}


@Test
    public void test3(){

    Map<String,Object> queryMap = new HashMap<>();
    queryMap.put("gender","Female");
    queryMap.put("nameContains","e");

    Response response = given().accept(ContentType.JSON).and().queryParams(queryMap).when().get("/api/spartans/search");


}


@Test
    public void test4(){







}








}
