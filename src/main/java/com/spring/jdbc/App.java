package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("Started >> --- >");

		// this is for xml injection with jdbc-config.xml file
		// ApplicationContext context = new ClassPathXmlApplicationContext("/com/spring/jdbc/jdbc-config.xml");

		// this is for java injection with JdbcConfig file
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

		StudentDao studentDao = context.getBean("studentDaoImpl", StudentDao.class);

		// insert a student info
		/*
		 * Student student = new Student(101, "Sabbir Ahmad", "Khulna");
		 * System.out.println("Number of row inserted : " + studentDao.insert(student));
		 */

		// update a student info
		/*
		 * Student student = new Student(101, "Sabbir Ahmad", "Noakhali, Bangladesh");
		 * System.out.println("Number of row updated : " + studentDao.update(student));
		 */

		// delete a student
		// System.out.println("Number of row deleted : " + studentDao.delete(101));

		// get a student data
		System.out.println("Single student information : " + studentDao.getStudent(1023));

		// get a student data
		System.out.println("All student information : " + studentDao.getAllStudent());
		
		
		

	}
}
