package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "locationId")
public class LocationsVO {
	@NotBlank
	private Long locationId;
	private String streetAddress;
	private String postalCode;
	@NotBlank
	private String city;
	private String stateProvince;
	private String countryId;
}
