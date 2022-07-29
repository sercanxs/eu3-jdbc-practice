package apitests;




import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.List;

import static io.restassured.RestAssured.*;

public class HtApiWithJsonPath {

    @BeforeClass
    public void beforeclass(){

        baseURI= ConfigurationReader.get("hr.apiUrl");

    }

    @Test
    public void test1(){

        Response response = get("/countries");

        JsonPath jsonPath = response.jsonPath();

        String secondCountryName = jsonPath.getString("items.country_name[1]");

        System.out.println(secondCountryName);

        List<String> countryIDs = jsonPath.getList("items.country_id");
        System.out.println(countryIDs);

        List<String> cNames = jsonPath.getList("items.findAll{it.region_id>2}.country_name");
        System.out.println(cNames);

        String maxSalary = jsonPath.getString("items.max{it.salary}.first_name");

        System.out.println(maxSalary);

    }

@Test
    public void test3(){

    Response response = get("/employees");

    JsonPath jsonPath = response.jsonPath();

    String maxSalary = jsonPath.getString("items.max{it.salary}.first_name");

    System.out.println(maxSalary);



}





}
