package StepApi;

import BaseApi.BaseApi;
import Endpoints.PersonalsEndpoints;
import Model.Personals;
import Reader.JsonReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PersonalsStepApi extends BaseApi {
	static String personalId;

	@Given("attach {string} request payload from personals Payload json file")
	public void attach_request_payload_from_personals_payload_json_file(String requestPayloadType) {

		request.body(JsonReader
				.serialization(JsonReader.deserialization("personalsPayload", Personals.class, "createpersonals")));
	}

	@When("create new personals using post request")
	public void create_new_personals_using_post_request() {

		response = request.post(PersonalsEndpoints.POST_PERSONALS);
	}

	@Then("capture personals id number from response payload")
	public void capture_personals_id_number_from_response_payload() {
		String personalId = response.jsonPath().getString("id");
	}

}
