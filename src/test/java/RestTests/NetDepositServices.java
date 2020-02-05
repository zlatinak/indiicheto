package RestTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.bytebuddy.asm.Advice;

import static org.testng.Assert.assertEquals;

public class NetDepositServices {

    public String netDepositService(Long merchantId, Long merchantSiteId, Long upoId) {


        RestAssured.baseURI = "https://qa1-tlv-netd1/api/NetDeposits";

        String requestBody = "{\"MerchantId\":2363,\"InternalUserId\":14769221,\"NetDepositPeriod\":30,\"VendorId\":121806,\"WebsiteId\":89506,\"UPOId\":7883511}\n";
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
