package be.pxl.houses.api;

import be.pxl.houses.domain.EPCScore;

public class CreateHouseRequest {
	// TODO add validation: description, code, city and epcScore are mandatory
	private String code;
	private String description;
	// TODO add validation: area between 75 and 550 (boundaries inclusive)
	private int area;
	private String city;
	private EPCScore epcScore;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public EPCScore getEpcScore() {
		return epcScore;
	}

	public void setEpcScore(EPCScore epcScore) {
		this.epcScore = epcScore;
	}
}
