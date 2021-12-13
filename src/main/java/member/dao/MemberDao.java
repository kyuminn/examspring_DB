package member.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDao {
	
	//jdbcTemplate 객체 : jsp에서 사용하던 Connection, PreparedStatement, ResultSet 의 역할을 적절히 대신해줌.
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
}
