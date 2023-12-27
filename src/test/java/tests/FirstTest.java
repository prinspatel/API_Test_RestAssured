package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class FirstTest {

	@Test
	public void Test1() {

		// Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		// No need to use RestAssured. because import change with static
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println("Response Code: " + response.getStatusCode());
		System.out.println("Response Time: " + response.getTime());
		System.out.println("Response Body : " + response.getBody().asString());
		System.out.println("Response Status line : " + response.getStatusLine());
		System.out.println("Response Header : " + response.getHeader("content-type"));

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test
	public void test_2() {

		// Base URL
		baseURI = "https://reqres.in/api";
		// Verify status code 200.
		given().get("/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8)).log().all();

	}

}
