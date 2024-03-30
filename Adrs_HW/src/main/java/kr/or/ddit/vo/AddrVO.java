package kr.or.ddit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 주소록 관리를 위한 Domain Layer
 *
 */
@Data
@EqualsAndHashCode(of = "adrsNo")
public class AddrVO {
	private Long adrsNo;
	private String memId;
	private String adrsName;
	private String adrsTel;
	private String adrsAdd;
	
}
