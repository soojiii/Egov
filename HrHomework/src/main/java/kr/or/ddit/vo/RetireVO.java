package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "employeeId")
public class RetireVO {
	@NotBlank
	private Long employeeId;
	private Long departmentId;
	private String hireDate;
	private String retireDate;
}
