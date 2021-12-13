package member.main;

import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import member.dao.MemberDao;
import member.vo.MemberVo;

public class MainForMemberDao {
	private static MemberDao memberDao;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext appctx = new GenericXmlApplicationContext("classpath:appctx.xml");
		memberDao = appctx.getBean("memberDao", MemberDao.class);
		
		selectAll();
	}
	
	private static void selectAll() {
		System.out.println("=======selectAll=======");
		int total = memberDao.count();
		System.out.println("전체 데이터:"+total);
		List<MemberVo> vos = memberDao.selectAll();
		for (MemberVo vo : vos) {
			System.out.println(vo.getId()+":"+vo.getEmail()+":"+vo.getName());
		}
	}
	
	private static void updateMember() {
		System.out.println("========updateMember=========");
		MemberVo vo = memberDao.selectByEmail("paraday@naver.com");
		String oldPw= vo.getPassword();
		String newPw= Double.toHexString(Math.random());
		
	}
}
