package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class GetAndPostExample {

	@Test
	public void testGet() {

		// GET Request
		// SINGLE USER
		baseURI = "https://reqres.in/";
		given().get("/api/users/2").then().statusCode(200).body("data.first_name", equalTo("Janet"));

	}

	@Test
	public void testPost() {

		// POST Request
		// CREATE

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "prins");
		map.put("job", "Automation");

		JSONObject request = new JSONObject(map);

		// other way to put
		// request.put("name", "Prince");
		// request.put("job", "Automation");

		baseURI = "https://reqres.in/";
		given().body(request.toJSONString()).when().post("/api/users").then().statusCode(201).log().all();
	}

}
