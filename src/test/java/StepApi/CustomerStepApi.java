package StepApi;

import BaseApi.BaseApi;
import Endpoints.CustomerEndpoints;
import Model.Customers;
import Reader.JsonReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerStepApi extends BaseApi {
	static String customerId;

	@Given("attach {string} request payload from customers Payload json file")
	public void attach_request_payload_from_customers_payload_json_file(String requestPayloadType) {

		request.body(JsonReader
				.serialization(JsonReader.deserialization("customersPayload", Customers.class, "createcustomer")));
	}

	@When("create new customer using post request")
	public void create_new_customer_using_post_request() {

		response = request.post(CustomerEndpoints.POST_CUSTOMER);

	}

	@Then("capture customer id number from response payload")
	public void capture_customer_id_number_from_response_payload() {
		customerId = response.jsonPath().getString("id");

	}

}
