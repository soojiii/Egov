package kr.or.ddit.vo;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class PersonVO implements Serializable{
	@NotBlank
	@Pattern(regexp = "^[A-Z]{1}[0-9]{4}$")
	@Size(min = 5, max = 5)
	private String id;
	@NotBlank
	@Size(max = 20)
	private String name;
	@NotBlank
	@Pattern(regexp = "^[MF]$")
	@Size(max = 1)
	private String gender;
	@Min(0)
	@Max(999)
	private long age;
	@Size(max = 100)
	private String address;
	
}
