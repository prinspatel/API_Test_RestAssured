package tests;

import static io.restassured.RestAssured.baseURI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static org.hamcrest.Matchers.equalTo;

public class SoapXMLRequest {

	@Test
	public void ValidateSoapXML() throws IOException {

		File file = new File("./Data/Add.xml");
		FileInputStream fileinputstream = new FileInputStream(file);

		if (file.exists()) {
			System.out.println(" >> File Exists >> ");
		}

		String requestbody = IOUtils.toString(fileinputstream, "UTF-8");

		baseURI = "https://ecs.syr.edu";
		RestAssured.given().contentType("text/xml").accept(ContentType.XML).body(requestbody).when()
				.post("/faculty/fawcett/Handouts/cse775/code/calcWebService/Calc.asmx").then().statusCode(200).log().all().and().
				body("//*:AddResult.text()", equalTo("5"));
	}

}
