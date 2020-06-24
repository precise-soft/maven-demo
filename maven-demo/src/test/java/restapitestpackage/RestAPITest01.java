package restapitestpackage;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAPITest01 {
	@Test
	public void verifyNumber() {

		
		RestAssured.baseURI = "http://ergast.com/api/f1/2017/circuits.json";

		Response response = null;

		try {
			response = RestAssured.given()
					.when()
					.get();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Response :" + response.asString());
		System.out.println("Status Code :" + response.getStatusCode());


		assertEquals(200, response.getStatusCode());
	}
}
