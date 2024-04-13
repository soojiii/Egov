package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "jobId")
public class JobsVO {
	@NotBlank
	private String jobId;
	@NotBlank
	private String jobTitle;
	private Long minSalary;
	private Long maxSalary;
}
