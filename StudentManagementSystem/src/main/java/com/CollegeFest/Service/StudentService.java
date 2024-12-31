package com.CollegeFest.Service;

import java.util.List;

import com.CollegeFest.Entity.Student;

public interface StudentService {
	public List<Student> findAll();

	public Student findById(long id);

	public void save(Student theStudent);

	public void deleteById(long id);

}
