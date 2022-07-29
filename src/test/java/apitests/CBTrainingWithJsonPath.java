package apitests;




import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;
public class CBTrainingWithJsonPath {

    @BeforeClass
    public void beforeclass(){

        baseURI= ConfigurationReader.get("cbt.api.url");

    }
@Test
    public void test1(){

    Response response = given().accept(ContentType.JSON).pathParam("id", 32881)
            .when().get("/student/{id}");


    System.out.println(response.statusCode());

    JsonPath jsonPath = response.jsonPath();

    String firstName = response.path("students.firstName[0]");

    System.out.println(firstName);

    String frstName = jsonPath.getString("students.company[0].address.zipCode");
    System.out.println(frstName);


}














}
