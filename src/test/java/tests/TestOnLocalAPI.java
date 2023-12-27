package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestOnLocalAPI {

	@Test
	public void get() {

		baseURI = "http://localhost:3000";

		given().get("/users").then().statusCode(200).log().all();
		;

	}

	@Test
	public void post() {
		JSONObject request = new JSONObject();
		request.put("firstName", "Chandrika");
		request.put("lastName", "Patel");
		request.put("subjectId", 2);

		baseURI = "http://localhost:3000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when()
				.post("/users").then().statusCode(201);
	}

	@Test
	public void put() {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("firstName", "Gopi");
		map.put("lastName", "Darji");
		map.put("subjectId", 2);

		JSONObject request = new JSONObject(map);

		baseURI = "http://localhost:3000";
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(request.toJSONString()).when()
				.put("/users/5").then().statusCode(200);
	}

	//@Test
	public void delete() {

		baseURI = "http://localhost:3000";
		when().delete("/users/2").then().statusCode(200);
	
	}

}
