package apitests;



import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class HamcrestMatchersApiTest {


@Test
    public void test1(){
given().accept(ContentType.JSON).pathParam("id",15)
        .when().get("http://54.161.114.237:8000/api/spartans/{id}")
        .then().statusCode(200)
        .and().assertThat().contentType("application")
        .and().assertThat().body("id",Matchers.equalTo(15),
                               "name",equalTo("Meta"),
                                  "gender",equalTo("Female"),
                                 "phone",equalTo(1938695106));





}

@Test

    public void test2(){

    given().accept(ContentType.JSON).pathParam("id",21887)
            .when().get("http://api.cybertektraining.com/teacher/{id}")
            .then().assertThat().statusCode(200)
            .and().contentType("application/json;charset=UTF-8")
            .and().header("Content-Length",equalTo("275"))
            .and().header("Date",notNullValue())
            .and().assertThat().body("teachers.firstName[0]",equalTo("Leonel")
                                         ,"teachers.teacherId[0]",equalTo(21887));


}

@Test
    public void test3(){
    given().accept(ContentType.JSON).pathParam("name","Computer")
            .when().get("http://api.cybertektraining.com/teacher/department/{name}")
            .then().statusCode(200)
            .and().contentType("application/json;charset=UTF-8")
            .and().body("teachers.firstName",Matchers.hasItems("Camry","Jack"));





}








}
