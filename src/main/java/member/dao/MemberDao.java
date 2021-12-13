package member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import member.vo.MemberVo;

public class MemberDao {
	
	//jdbcTemplate 객체 : jsp에서 사용하던 Connection, PreparedStatement, ResultSet 의 역할을 적절히 대신해줌.
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public MemberVo selectByEmail(String email) {
		String sql="select * from member where email=?";
		
		RowMapper<MemberVo> rowMapper = new RowMapper<MemberVo>() {
			@Override
			public MemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVo vo = new MemberVo();
				vo.setId(rs.getLong("id"));
				vo.setEmail(rs.getString("email"));
				vo.setPassword(rs.getString("password"));
				vo.setRegdate(rs.getDate("regdate"));
				return vo;
			}
		};
		
		List<MemberVo> result = jdbcTemplate.query(sql, rowMapper, email);
		return result.isEmpty()? null : result.get(0);
	}
	
	public List<MemberVo> selectAll(){
		
		String sql="select * from member";
		RowMapper<MemberVo> rowMapper = new RowMapper<MemberVo>() {
			@Override
			public MemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVo vo = new MemberVo();
				vo.setId(rs.getLong("id"));
				vo.setEmail(rs.getString("email"));
				vo.setName(rs.getString("name"));
				vo.setRegdate(rs.getDate("regdate"));
				return vo;
			}
		};
		List<MemberVo> result=jdbcTemplate.query(sql, rowMapper);
		return result;
	}
}
