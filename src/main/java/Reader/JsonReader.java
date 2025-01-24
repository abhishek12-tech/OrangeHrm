package Reader;

import java.io.FileReader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {

	public static Object deserialization(String jsonPayloadFileName, Object className, String JsonNodeName) {
		String path = System.getProperty("user.dir") + "//src//test//resources//JsonPayload//" + jsonPayloadFileName
				+ ".json";

		try {

			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode = mapper.readTree(new FileReader(path));

			return mapper.treeToValue(jsonNode.get(JsonNodeName), className.getClass());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String serialization(Object className) {
		
		try {
			return new ObjectMapper().writeValueAsString(className);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
