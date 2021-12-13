package member.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberVo {
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date regdate;
}
