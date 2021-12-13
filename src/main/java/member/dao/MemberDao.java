package member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import member.rowMapper.MemberRowMapper;
import member.vo.MemberVo;

public class MemberDao {
	
	//jdbcTemplate 객체 : jsp에서 사용하던 Connection, PreparedStatement, ResultSet 의 역할을 적절히 대신해줌.
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public MemberVo selectByEmail(String email) {
		String sql="select * from member where email=?";
//		
//		RowMapper<MemberVo> rowMapper = new RowMapper<MemberVo>() {
//			@Override
//			public MemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
//				MemberVo vo = new MemberVo();
//				vo.setId(rs.getLong("id"));
//				vo.setEmail(rs.getString("email"));
//				vo.setPassword(rs.getString("password"));
//				vo.setRegdate(rs.getDate("regdate"));
//				return vo;
//			}
//		};
		
		List<MemberVo> result = jdbcTemplate.query(sql, new MemberRowMapper(), email);
		return result.isEmpty()? null : result.get(0);
	}
	
	public List<MemberVo> selectAll(){
		
		String sql="select * from member";
//		RowMapper<MemberVo> rowMapper = new RowMapper<MemberVo>() {
//			@Override
//			public MemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
//				MemberVo vo = new MemberVo();
//				vo.setId(rs.getLong("id"));
//				vo.setEmail(rs.getString("email"));
//				vo.setName(rs.getString("name"));
//				vo.setRegdate(rs.getDate("regdate"));
//				return vo;
//			}
//		};
		List<MemberVo> result=jdbcTemplate.query(sql, new MemberRowMapper());
		return result;
	}
	
	//결과가 하나의 행만을 가지는 것을 알때 사용하는 메서드 : queryForObject
	
	public int count() {
		String sql="select count(*) from member";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
	
	// insert, update, delete 쿼리 실행 시 사용하는 update() method
	
	public void update(MemberVo vo) {
		String sql="update member set name=?, password=? where email=?";
		jdbcTemplate.update(sql, vo.getName(), vo.getPassword(), vo.getEmail());
	}
	
}
