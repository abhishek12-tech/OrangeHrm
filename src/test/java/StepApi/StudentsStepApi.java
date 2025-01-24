package StepApi;

import BaseApi.BaseApi;
import Endpoints.StudentsEndpoints;
import Model.Students;
import Reader.JsonReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StudentsStepApi extends BaseApi {
	static String studentId;

	@Given("attach {string} request payload from students Payload json file")
	public void attach_request_payload_from_students_payload_json_file(String requestPayloadType) {

		request.body(JsonReader
				.serialization(JsonReader.deserialization("studentsPayload", Students.class, "createstudent")));
	}

	@When("create new students using post request")
	public void create_new_students_using_post_request() {

		response = request.post(StudentsEndpoints.POST_STUDENT);

	}

	@Then("capture students id number from response payload")
	public void capture_students_id_number_from_response_payload() {
		studentId = response.jsonPath().getString("id");

	}

}
