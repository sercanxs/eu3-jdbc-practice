package Day6_POJO;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PostRequestDemo {




    @Test
    public void test1(){
        String jsonBody ="{\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"name\": \"JohnAB\",\n" +
                "  \"phone\": 2132131122\n" +
                "}";


        Response response = given()
                .accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(jsonBody).when().post("http://54.161.114.237:8000/api/spartans");

        System.out.println(response.statusCode());

        String actualMessage = response.path("success");
        System.out.println(actualMessage);


    }

    @Test
    public void test2(){

        Spartan spartan = new Spartan();

        spartan.setName("John");
        spartan.setGender("Male");
        spartan.setPhone(1231231234l);





        given().accept(ContentType.JSON)
                         .and().log().all().and().contentType(ContentType.JSON)
                         .and().body(spartan)
                         .when().post("http://54.161.114.237:8000/api/spartans")
                         .then().log().all().and().statusCode(201)
                         .and().contentType("application/json")
                         .and().body("success",equalTo("A Spartan is Born!")
                         ,"data.name",equalTo("John")
                         ,"data.phone",equalTo(1231231234));




    }
@Test
    public void test3(){
        Spartan spartan = new Spartan();

        spartan.setName("John");
        spartan.setGender("Male");
        spartan.setPhone(1231231234l);



}


}
