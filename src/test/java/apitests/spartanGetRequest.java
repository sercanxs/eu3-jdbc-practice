package apitests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class spartanGetRequest {

    String spartanUrl = "http://54.161.114.237:8000";

    @Test
    public void test1(){

        Response response = when().get(spartanUrl+"/api/spartans");

        System.out.println(response.statusCode());

        response.prettyPrint();


    }
@Test
    public void test2(){
    Response response = when().get(spartanUrl + "/api/hello");

    Assert.assertEquals(response.statusCode(),200);

    Assert.assertEquals(response.contentType(),"text/plain;charset=UTF-8");

    System.out.println(response.header("Content-Length"));
    System.out.println(response.headers().hasHeaderWithName("date"));

    System.out.println(response.body().asString());
    System.out.println(response.toString());


}






}
