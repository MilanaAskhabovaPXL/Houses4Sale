package be.pxl.houses.api;

import be.pxl.houses.domain.EPCScore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateHouseRequest {
	// add validation: description, code, city and epcScore are mandatory
	@NotBlank
	private String code;
	@NotBlank
	private String description;
	// add validation: area between 75 and 550 (boundaries inclusive)

	@Min(75)
	@Max(550)
	private int area;
	@NotBlank
	private String city;
	@NotNull
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
