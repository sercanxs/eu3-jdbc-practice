package apitests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.List;

import static io.restassured.RestAssured.*;


public class SpartanTestWithPath {

    @BeforeClass
    public void beforeclass(){

        baseURI= "http://54.161.114.237:8000";

    }

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON).pathParam("id", 10).when().get("/api/spartans/{id}");

        System.out.println(response.path("name").toString());
        System.out.println(response.path("id").toString());

        int a = response.path("id");
        String b = response.path("name");

        System.out.println(a);
        System.out.println(b);


    }
@Test
    public void test2(){

    Response response = given().accept(ContentType.JSON).when().get("/api/spartans");

    System.out.println(response.path("name[0]").toString());


    System.out.println(response.path("id[-1]").toString());

    List<String> name = response.path("name");

    System.out.println(name);

    List<Object> phone = response.path("phone");

    for (Object o : phone) {
        System.out.println(o);

    }

}








}
