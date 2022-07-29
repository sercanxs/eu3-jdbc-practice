package apitests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class simpleGetRequest {

    String hrurl = "http://54.161.114.237:1000/ords/hr/regions";

    @Test
    public void test1(){
        Response response = RestAssured.get(hrurl);

        System.out.println(response.statusCode());

        response.prettyPrint();

    }

@Test
    public void test2(){

    Response response = RestAssured.given().accept(ContentType.JSON).when().get(hrurl);
    System.out.println(response.statusCode());
    System.out.println(response.getContentType());
    System.out.println(response.contentType());


}
@Test
    public void test3(){
        RestAssured.given().accept(ContentType.JSON)
                .when().get(hrurl)
                .then().assertThat().statusCode(200)
                .and().contentType("application/json");



}
@Test
    public void test4(){
    Response response = given().accept(ContentType.JSON).when().get(hrurl + "/2");

    System.out.println(response.body().asString());

    Assert.assertTrue(response.body().asString().contains("Americas"));


}


}

