package apitests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class JsonToJavaCollection {

    @BeforeClass
    public void beforeclass(){

        baseURI= ConfigurationReader.get("spartan.apiUrl");

    }


@Test
    public void test1(){

    Response response = given().accept(ContentType.JSON).pathParam("id", 15)
            .when().get("/api/spartans/{id}");

    System.out.println(response.statusCode());

    Map<String,Object> jsonDataMap = response.body().as(Map.class);

    System.out.println(jsonDataMap);

    String name = (String) jsonDataMap.get("name");
    System.out.println(name);

    BigDecimal phone = new BigDecimal(String.valueOf(jsonDataMap.get("phone")));
    System.out.println(phone);

}

@Test

    public void test2(){

    Response response = given().accept(ContentType.JSON).when().get("/api/spartans");

    System.out.println(response.statusCode());

    List<Map<String,Object>> allSpartanList = response.body().as(List.class);


    System.out.println(allSpartanList.get(1).get("name"));


}


@Test
    public void test3(){

    Response response = given().accept(ContentType.JSON).when().get("http://54.161.114.237:1000/ords/hr/regions");

    System.out.println(response.statusCode());

    Map<String,Object> regionMap = response.body().as(Map.class);

    List<Map<String,Object>> itemsList = (List<Map<String, Object>>) regionMap.get("items");


}


}
