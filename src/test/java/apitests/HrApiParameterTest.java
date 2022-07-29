package apitests;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.*;

public class HrApiParameterTest {

    @BeforeClass
    public void beforeclass(){

        baseURI= ConfigurationReader.get("hr.apiUrl");

    }
    @Test
    public void test1(){

        get("/regions");




    }





}
