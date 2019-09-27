package com.spring.dataSource;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.dto.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)	//스프링 테스트 라고 명시	
@ContextConfiguration("classpath:com/spring/context/dataSource-context.xml")	//테스트가 쓸수있는 컨텍스 위치 지정
public class DataSourceTest {
	
	@Autowired
	private BasicDataSource dataSource;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	@Before
	public void init() throws Exception{
		conn=dataSource.getConnection();
	}
	
	@Test
	public void testConnection() throws Exception {
		assertThat(conn, not(nullValue()));
	}

	
	@Test
	public void testGetMember() throws Exception {
		String sql = "select * from member where id=?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "mimi");
		
		rs = pstmt.executeQuery();
		
		MemberVO member = new MemberVO();
		
		if(rs.next()) {
			member.setId(rs.getString("id"));
			member.setPwd(rs.getString("pwd"));
			
		}
		
		assertEquals("mimi", member.getPwd());		//같은지 다른지 비교
	}
}
