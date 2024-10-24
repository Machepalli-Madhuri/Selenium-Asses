package api;

import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.cucumber.java.en.*;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class ApiTest {
	private static final String URL = "https://api.restful-api.dev/objects";
	private String responseBody;
	private String id;
	private String createdAt;
	private String name;
	private int year;
	private double price;
@Test
	@When("adding a new device with name {string}, year {int}, price {double}, CPU model {string}, and hard disk size {string}")
	public void i_add_a_new_device(String name, int year, double price, String cpuModel, String hardDiskSize) {



		//  Payload request
		String requestBody = String.format(
				"{ \"name\": \"%s\", \"data\": { \"year\": %d, \"price\": %.2f, \"CPU model\": \"%s\", \"Hard disk size\": \"%s\" } }",
				name, year, price, cpuModel, hardDiskSize
				);

		// Send POST request 
		Response response = given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post(URL)
				.then()
				.statusCode(200) 
				.extract().response();

		//  response data assigned in a variable for validation
		responseBody = response.asString();
		id = response.jsonPath().getString("id");
		createdAt = response.jsonPath().getString("createdAt");
		this.name = response.jsonPath().getString("name");
		this.year = response.jsonPath().getInt("data.year");
		this.price = response.jsonPath().getDouble("data.price");
	}

	@Then("response should contain creation date and valid ID")
	public void response_validationFor_CreatedDate_ID() {
		assertNotNull(id, "ID should not be null");
		assertNotNull(createdAt, "CreatedAt should not be null");
	}

	@Then("added device details should match the information given")
	public void provided_information_Validation() {
		assertEquals(name, "Apple Max Pro 1TB", "Device name doesn't match");
		assertEquals(year, 2023, "Year does not match");
		assertEquals(price, 7999.99, 0.01, "Price doesn't match");
	}

	
}
