package com.ford.auto.stepdefinitions;

import java.util.HashMap;

import org.json.simple.JSONObject;
import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.equalTo;

public class RESTAPI_Test {
	
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	RequestSpecification request;
	Response response;
	JSONObject objJSON;
	
	//********* first feature file, GET record
	@Given("A record exists in page {int} with id {int}")
	public void a_record_exists_in_page_with_id(Integer pageNumber, Integer Id) {
		map.put("page", pageNumber);
		map.put("id", Id);
		RestAssured.proxy("internet.ford.com", 83);		
		
		request= RestAssured.given();				
		request.baseUri("https://reqres.in");
		request.queryParams(map);
	}

	@When("I fetch this record")
	public void i_try_to_fetch_it() {
		response = request.get("/api/users");
	}

	@Then("I should get the status code as {int}")
	public void i_should_get_the_status_code_as(Integer statusCode) {
		response.then()
		.statusCode(statusCode);				
	}
	
	@And("body should have data.id value as {int}")
	public void body_should_have_data_id_value_as(Integer dataId) {
		response.then()
		.log().all()
		.assertThat()
		.body("data.id",equalTo(dataId));	
	}
	
	//********* second feature file, POST record
	@Given("I have access to create new record")
	public void i_have_access_to_create_new_record(DataTable dt) {
		RestAssured.proxy("internet.ford.com", 83);	
		objJSON=new JSONObject();	
		request= RestAssured.given();				
		request.baseUri("https://reqres.in/api/users");
		
		List<List<String>> data = dt.asLists();
		objJSON.put("name", data.get(0).get(0));
		objJSON.put("job", data.get(0).get(1));
	}

	
	@When("I add a user record")
	public void i_add_a_user_record() {
		request.body(objJSON.toJSONString());
		response = request.post();
	}
	

}
