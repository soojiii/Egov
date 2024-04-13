package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "countryId")
public class CountriesVO {
	@NotBlank
	private String countryId;
	private String countryName;
	private Long regionId;
	
}
