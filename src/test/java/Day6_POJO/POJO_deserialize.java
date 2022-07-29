package Day6_POJO;



import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;


public class POJO_deserialize {

    @Test
    public void test1() {

        Response response = given().accept(ContentType.JSON).pathParam("id", 15).when().get("http://54.161.114.237:8000/api/spartans/{id}");

        System.out.println(response.statusCode());


        Spartan spartan15 = response.body().as(Spartan.class);

        System.out.println(spartan15);
        System.out.println(spartan15.toString());
        System.out.println(spartan15.getName());
        System.out.println(spartan15.getPhone());

    }

    @Test

    public void test4() {

        Response response = given().accept(ContentType.JSON).when().get("http://54.161.114.237:1000/ords/hr/regions");
        System.out.println(response.statusCode());

        Regions regions = response.body().as(Regions.class);

        System.out.println(regions.getCount());
        System.out.println(regions.getHasMore());
        System.out.println(regions.getOffset());

        System.out.println(regions.getItems().get(0).getRegionName());

    }

    @Test
    public void test5() {

        Gson gson = new Gson();

        String myJsonData = "{\n" +
                "    \"id\": 15,\n" +
                "    \"name\": \"Meta\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"phone\": 1938695106\n" +
                "}";
        Map<String, Object> map = gson.fromJson(myJsonData, Map.class);
        System.out.println(map);

        Spartan spartan = new Spartan(921392, "frederic", "male", 123123123);

        String jsonSpartan = gson.toJson(spartan);
        System.out.println(jsonSpartan);


    }
}