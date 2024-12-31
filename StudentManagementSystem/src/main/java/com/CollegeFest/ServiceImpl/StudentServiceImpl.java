package com.CollegeFest.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CollegeFest.Entity.Student;
import com.CollegeFest.Repository.StudentRepository;
import com.CollegeFest.Service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository StudentRepository;

	@Override
	public List<Student> findAll() {

		List<Student> Students = StudentRepository.findAll();
		return Students;
	}

	@Override
	public Student findById(long theId) {

		return StudentRepository.findById(theId).get();
	}

	@Override
	public void save(Student theStudent) {

		StudentRepository.save(theStudent);
	}

	@Override
	public void deleteById(long theId) {

		StudentRepository.deleteById(theId);
	}

}