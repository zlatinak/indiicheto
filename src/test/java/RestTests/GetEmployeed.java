package RestTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GetEmployeed extends FunctionalTest {

    @Test
    public void retrieveSpecificEmployee() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        Response response = null;

        try {
            response = RestAssured.given().when().get("/employees");
        }
        catch (Exception e){
            e.printStackTrace();
        }


        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :"+response.getStatusCode());
        System.out.println("Does Response contains 'employee_salary'? :"+ response.asString().contains("employee_salar"));

        assertEquals(200, response.getStatusCode());

    }
}
