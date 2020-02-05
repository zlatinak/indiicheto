package RestTests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class FunctionalTest {
//    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        } else {
            RestAssured.port = Integer.valueOf(port);
        }

        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            basePath = "/employees";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = " http://dummy.restapiexample.com/api/v1";

        }
        RestAssured.baseURI = baseHost;
//
//
//    }
    }
}
