package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import org.testng.annotations.Test;

public class JSONSchemaValidator {
	
	@Test
	public void SchematestGet() {

		baseURI = "https://reqres.in/";
		given().get("/api/users?page=2").then().assertThat().body(matchesJsonSchemaInClasspath("Schema.json"))
		.statusCode(200).body("data.first_name", equalTo("Janet"));

	}

}
