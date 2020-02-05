package RestTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import static org.testng.Assert.assertEquals;

public class PostApiTest {
    private NetDepositServices net;

    @Test
    public void createEmployess() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        String requestBody = "{\n" +
                " \"name\":\"tammy\",\n" +
                " \"salary\":\"5000\",\n" +
                " \"age\":\"20\"\n" +
                "}";

        Response response = null;

        response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post("/create");

        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
        System.out.println("Does Response contains 'tammy'? :" + response.asString().contains("tammy"));
System.out.println("Blabla "+response.jsonPath().getString("salary"));
        assertEquals(200, response.getStatusCode());


    }

    @Test
    public void returnNetDeposit() {

        this.net = new NetDepositServices();

        long merchantId = 2363;
        long merchantSiteId = 89506;
        long upoId = 7883511;
        String response =net.netDepositService(merchantId,merchantSiteId,upoId);
         System.out.println(response);

    }


    public String returnNetDeposit1(long merchantId,long merchantSiteId,long upoId){

        RestAssured.baseURI = "https://qa1-tlv-netd1/api/NetDeposits";

        String requestBody = "{\"MerchantId\":"+merchantId+",\"InternalUserId\":14769221,\"NetDepositPeriod\":30,\"VendorId\":121806,\"WebsiteId\":"+merchantSiteId+",\"UPOId\":"+upoId+"}\n";
        Response response = null;
        RestAssured.useRelaxedHTTPSValidation();//ignoring SSL certificate
        response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post("/GetNetDeposit");

        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
        System.out.println("Does Response contains 'tammy'? :" + response.asString().contains("tammy"));
        String response1 = response.asString();
        assertEquals(200, response.getStatusCode());
    return response1;
    }
}
