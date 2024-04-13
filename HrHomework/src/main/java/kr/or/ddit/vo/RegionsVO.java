package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "regionId")
public class RegionsVO {
	@NotBlank
	private Long regionId;
	private String regionName;
}
