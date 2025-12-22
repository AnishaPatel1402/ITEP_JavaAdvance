package com.info.optimizedSpringJdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info.optimizedSpringJdbc.dao.StudentDao;
import com.info.optimizedSpringJdbc.entity.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentDao dao;
	
	@Transactional
	public boolean save(Student s) {
		return dao.saveStudent(s);
	}
	
	@Transactional
	public boolean update(Student s) {
		return dao.updateStudent(s);
	}
	
	@Transactional
	public boolean delete(int roll) {
		return dao.deleteStudent(roll);
	}
	
	public List<Student> getAll(){
		return dao.getList();
	}
	
	public Student get(int roll) {
		return dao.get(roll);
	}
	
}
