package org.tektutor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.specification.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class Steps {
	private String endpointURL;
	private RequestSpecification request;
	private Response response;
	private int expectedResponseCode, actualResponseCode;
	private String expectedResponseData, actualResponseData;

	@Given("the Training REST API is hosted at endpoint {string}")
	public void the_Training_REST_API_is_hostend_at_endpoint(String endpointURL ) {
		this.endpointURL = endpointURL;
	}

	@When("I invoke the REST API")
	public void i_invoke_the_REST_API() {
		RestAssured.baseURI = this.endpointURL;
		this.request = RestAssured.given();

		this.request.header( "Content-Type", "application/json" );
		this.response = request.get();

		this.actualResponseCode = this.response.getStatusCode();
	}

	@Then("I expect a status code {string}")
	public void i_expect_a_status_code(String strExpectedResponseCode) {
		this.expectedResponseCode = Integer.parseInt(strExpectedResponseCode);
		assertEquals ( this.expectedResponseCode, this.actualResponseCode );
	}

	@Then("I expect all the existing training records as response")
	public void i_expect_all_the_existing_training_records_as_response() {
		Training[] listOfTrainings = response.getBody().as(Training[].class);
		assertEquals ( 3, listOfTrainings.length );

		for ( int index=0; index < listOfTrainings.length; ++index ) {

			assertEquals ( index+1, listOfTrainings[index].getId() );
		        assertFalse  ( listOfTrainings[index].getName().isEmpty() );	
		        assertFalse  ( listOfTrainings[index].getDuration().isEmpty() );	
		}
	}

	@When("I invoke the REST API with id {string}")
	public void i_invoke_the_REST_API_with_id(String strId) {
		this.endpointURL = this.endpointURL + "/" + strId;

		RestAssured.baseURI = this.endpointURL;
		this.request = RestAssured.given();

		this.request.header( "Content-Type", "application/json" );
		this.response = request.get();

		this.actualResponseCode = this.response.getStatusCode();
		
	}

	@Then("I expect a single training record that matches id {string} as response")
	public void i_expect_a_single_training_record_that_matches_id_as_response(String strId) {
		Training training = response.getBody().as(Training.class);

		assertEquals ( Integer.parseInt(strId), training.getId() );
	        assertFalse  ( training.getName().isEmpty() );	
	        assertFalse  ( training.getDuration().isEmpty() );	
	}
}
