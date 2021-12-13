package member.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import member.exception.IdPasswordNotMatchingException;
import member.exception.MemberNotFoundException;
import member.service.ChangePasswordService;

public class MainForCPS {
	public static void main(String[] args) {
		GenericXmlApplicationContext appctx = new GenericXmlApplicationContext("classpath:appctx.xml");
		
		ChangePasswordService cps = appctx.getBean("changePwdSvc", ChangePasswordService.class);
		try {
			cps.ChangePassword("paraday@naver.com", "1234", "1111");
			System.out.println("암호를 변경하였습니다");
		}catch(MemberNotFoundException e) {
			System.out.println("회원 정보가 존재하지 않습니다");
		}catch(IdPasswordNotMatchingException e) {
			System.out.println("암호를 다시 확인하세요");
		}
	}
}
