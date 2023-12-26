package tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstTest {

	
	@Test
	public void Test1() {
		
		Response response = RestAssured.get("https://reqres.in/api/users?page=2"); 
		System.out.println("Response Code: "+response.getStatusCode());
		System.out.println("Response Time: "+response.getTime());
		System.out.println("Response Body : " + response.getBody().asString());
		System.out.println("Response Status line : " + response.getStatusLine());
		System.out.println("Response Header : " + response.getHeader("content-type"));
		
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
