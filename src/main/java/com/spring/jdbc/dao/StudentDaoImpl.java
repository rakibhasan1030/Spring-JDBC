package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDaoImpl")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		// insert query
		String insertQuery = "insert into student(id, name, city) values(?, ?, ?)";
		return this.jdbcTemplate.update(insertQuery, student.getId(), student.getName(), student.getCity());
	}

	@Override
	public int update(Student student) {
		// insert query
		String updateQuery = "update student set name=?, city=? where id=?";
		return this.jdbcTemplate.update(updateQuery, student.getName(), student.getCity(), student.getId());
	}

	@Override
	public int delete(int studentId) {
		// delete query
		String deleteQuery = "delete from student where id=?";
		return this.jdbcTemplate.update(deleteQuery, studentId);
	}

	@Override
	public Student getStudent(int studentId) {
		// selecting single student data
		String query = "select * from student where id=?";
		return this.jdbcTemplate.queryForObject(query, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setCity(rs.getString(3));
				return student;
			}
		}, studentId);
	}

	@Override
	public List<Student> getAllStudent() {
		// selecting multiple student data
		String query = "select * from student";
		return this.jdbcTemplate.query(query, new RowMapper<Student>() {
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setId(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setCity(rs.getString(3));
				return student;
			}
		});
	}

}
