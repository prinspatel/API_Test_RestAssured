package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchandDeleteExample {

	@Test
	public void testPut() {

		// PUT Request
		// UPDATE

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "prins");
		map.put("job", "Automation");

		JSONObject request = new JSONObject(map);

		baseURI = "https://reqres.in/";
		given().body(request.toJSONString()).when().put("/api/users/2").then().statusCode(200).log().all();
	}

	@Test
	public void testPatch() {

		// PATCH Request
		// UPDATE

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "prins");
		map.put("job", "Automation");

		JSONObject request = new JSONObject(map);

		baseURI = "https://reqres.in/";
		given().body(request.toJSONString()).when().patch("/api/users/2").then().statusCode(200).log().all();
	}

	@Test
	public void testDelete() {

		// DELETE Request
		// UPDATE

		baseURI = "https://reqres.in/";
		when().delete("/api/users/2").then().statusCode(204).log().all();

	}

}
