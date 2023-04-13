package com.mvc.proj.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.proj.mvc.entity.Students;
import com.mvc.proj.mvc.repo.StudentsRepo;

@Service
public class StudentsService {
	
	@Autowired
	private StudentsRepo studentsRepo;
	
	public List<Students>findAllStuds(){
		return studentsRepo.findAll();
	}
	
	
	
	public Students saveStudent(Students students) {
		return studentsRepo.save(students);
	}
	
	public Students getStudentById(long id) {
		return studentsRepo.findById(id).get();
	}
	
	
	
	public Students updateStudent(long id,Students stud) {
		return null;
	}
	
	public void deletingStudent(long id) {
		studentsRepo.deleteById(id);
	}
}
