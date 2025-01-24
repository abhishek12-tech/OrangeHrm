package Model;

import lombok.Data;

@Data
public class Studentaddress {

	private String country;
	private PermanentAddress permanentAddress;
	private CurrentAddress currentAddress;

}
