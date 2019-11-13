package com.lti.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.lti.model.Users;

public class rowMapper implements RowMapper<Users> {



	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users u = new Users();
		u.setFirstname(rs.getString("FIRSTNAME"));
		u.setPassword(rs.getString("password"));
		u.setMobilenumber(rs.getString("phone"));
		u.setUsername(rs.getString("username"));
		u.setLastname(rs.getString("LASTNAME"));
		return u;
		
	}

}
