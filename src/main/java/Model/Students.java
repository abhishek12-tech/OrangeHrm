package Model;

import lombok.Data;

@Data
public class Students {

	private String fullName;
	private Education education;
	private Dob dob;
	private Studentaddress studentaddress;
	private Boolean gender;
}
