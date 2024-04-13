package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "employeeId")
public class EmployeesVO {
	@NotBlank
	private Long employeeId;
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	private String email;
	private String phoneNumber;
	@NotBlank
	private String hireDate;
	@NotBlank
	private String jobId;
	private Long salary;
	private Long commissionPct;
	private Long managerId;
	private Long departmentId;
	private String empName;
}
