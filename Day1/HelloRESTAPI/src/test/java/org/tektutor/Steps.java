package org.tektutor;

import io.restassured.*;
import io.restassured.specification.*;
import io.restassured.response.Response;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

//import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.Gson;

public class Steps{

	private String endPointURL; 
	private String actualResponse;
	private int statusCode;

	@Given("the Hello REST API is alive")
	public void the_Hello_REST_API_is_alive() {
		endPointURL = "";
	}

	@When("I invoke the Hello REST API endpoint {string}")
	public void i_invoke_the_Hello_REST_API_endpoint(String url) {
		this.endPointURL = url;
	}

	@Then("I expect {string} response message")
	public void i_expect_response_message(String expectedResponse) {
		RestAssured.baseURI = endPointURL;
		RequestSpecification request = RestAssured.given();

		request.header( "Content-type", "application/json" );
		Response response = request.get();

		statusCode = response.getStatusCode();

		assertEquals ( 200, statusCode );	

		actualResponse = response.getBody().asString();
		assertThat( actualResponse, containsString(expectedResponse) );

		Gson jsonObject = new Gson();
		Hello hello = jsonObject.fromJson( actualResponse, Hello.class );

		assertEquals ( "Hello REST API", hello.getMessage() ); 

		Hello hello1 = request.get().as(Hello.class);
		assertEquals ( "Hello REST API", hello1.getMessage() ); 
	}

}
