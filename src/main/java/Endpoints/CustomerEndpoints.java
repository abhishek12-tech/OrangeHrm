package Endpoints;

public interface CustomerEndpoints {

	final String POST_CUSTOMER = "/customers";

	final String GET_CUSTOMER = "/customers/{id}";

	final String GET_All_CUSTOMER = "/customers";

	// Query Parameter
	final String GET_All_CUSTOMER_AS_PER_CONDITION = "/customers";

	final String PUT_CUSTOMER = "/customers/{id}";

	final String DELETE_CUSTOMER = "/customers/{id}";
}
