package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "departmentId")
public class DepartmentsVO {
	@NotBlank
	private Long departmentId;
	@NotBlank
	private String departmentName;
	private Long managerId;
	private Long locationId;
}
