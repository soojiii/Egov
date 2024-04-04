package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.or.ddit.validate.groups.DeleteGroup;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.validate.groups.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 회원관리를 위한 Domain Layer
 *
 *	1번 그룹 (가입시 검증 그룹) : 아이디, 주민번호1, 주민번호2 + 기본 그룹
 *	2번 그룹 (수정시 검증 그룹) :  + 기본 그룹 
 *	기본 그룹 (가입과 수정시 모두 검증 그룹) : 비밀번호, 이름, 우편번호, 주소1, 주소2, 이메일
 *	3번 그룹 (탈퇴시 검증 그룹) : 비밀번호
 *
 */
@Data
@ToString(exclude = {"memPass", "memRegno1", "memRegno2"})
@EqualsAndHashCode(of = "memId")
public class MemberVO implements Serializable{
	@NotBlank(groups = InsertGroup.class)
	private String memId;
	@NotBlank(groups = {DeleteGroup.class, Default.class})
	@Size(min = 4, max = 12, groups = {DeleteGroup.class, Default.class})
	@JsonIgnore
	private transient String memPass;
	@NotBlank
	@Size(max = 20)
	private String memName;
	@NotBlank(message = "주민번호1번 누락", groups = InsertGroup.class)
	@JsonIgnore
	private transient String memRegno1;
	@NotBlank
	@JsonIgnore
	private transient String memRegno2;
	private String memBir;
	@NotBlank
	private String memZip;
	@NotBlank
	private String memAdd1;
	@NotBlank
	private String memAdd2;
	private String memHometel;
	private String memComtel;
	private String memHp;
	@NotBlank
	@Email
	private String memMail;
	private String memJob;
	private String memLike;
	private String memMemorial;
	private String memMemorialday;
	private Long memMileage;
	private boolean memDelete;
	
	
	//구매기록
	private Set<CartVO> cartList; //Has Many
	
	
}
