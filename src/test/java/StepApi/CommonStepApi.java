package StepApi;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hamcrest.Matchers;

import BaseApi.BaseApi;
import Reader.PropertyReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;

public class CommonStepApi extends BaseApi {

	@Given("configure base uri")
	public void configure_base_uri() {
		RestAssured.baseURI = PropertyReader.getProperty("BASE_URI");
	}

	@Given("get request specification object")
	public void get_request_specification_object() {
		BaseApi.reqSpec();
	}

	@Then("get the validatable response object")
	public void get_the_validatable_response_object() {
		validateResponse = response.then().assertThat();

	}

	@Then("validate status code {int}")
	public void validate_status_code(Integer code) {
		validateResponse.statusCode(Matchers.equalTo(code));
	}

	@Then("validate status line {string}")
	public void validate_status_line(String line) {
		validateResponse.statusLine(Matchers.containsString(line));
	}

	@Then("validate response time should below {int} milliseconds")
	public void validate_response_time_should_below_milliseconds(Integer time) {
		validateResponse.time(Matchers.lessThan((long) time));
	}

	@Then("validate {string} and {string} response header")
	public void validate_and_response_header(String key, String value) {

		validateResponse.header(key, Matchers.containsString(value));
	}

	@Then("validate {string} and current month and year response header")
	public void validate_and_current_month_and_year_response_header(String key) {
		validateResponse.header(key, Matchers.containsString(new SimpleDateFormat("MMM yyyy").format(new Date())));
	}

	@Then("generate response logs")
	public void generate_response_logs() {
		validateResponse.log().all();
	}

}
