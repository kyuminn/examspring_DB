package member.vo;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import member.exception.IdPasswordNotMatchingException;

@Getter
@Setter
public class MemberVo {
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date regdate;
	
	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword)) throw new IdPasswordNotMatchingException();
		this.password= newPassword;
	}
}
