package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"employeeId", "startDate"})
public class JobHistoryVO {
	@NotBlank
	private Long employeeId;
	@NotBlank
	private String startDate;
	@NotBlank
	private String endDate;
	@NotBlank
	private String jobId;
	private Long departmentId;
}
