package com.mvc.proj.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.mvc.proj.mvc.entity.Students;
import com.mvc.proj.mvc.service.StudentsService;

import ch.qos.logback.core.model.Model;
import jakarta.annotation.Nullable;

@Controller
public class StudentController {
	@Autowired
	private StudentsService studentsService;
	
	@RequestMapping("/listOfStudents")
	public ModelAndView studentsList() {
		
		ModelAndView model=new ModelAndView("ListOfStudents");
		
		List<Students>students=studentsService.findAllStuds();
		
		model.addObject(students).addObject("students", students);
		
		return model;
		
		}
	
	@RequestMapping("/addingPage")
	public ModelAndView addingStudent() {
		ModelAndView model=new ModelAndView("addingPage");
		Students students=new Students();
		model.addObject("students", students);
		return model;
	}
	
	
	
	
	@RequestMapping("/save/student")
	public ModelAndView saveStudent(@ModelAttribute("students")Students students) {
		
		studentsService.saveStudent(students);
		
		ModelAndView model=new ModelAndView("successfullPage");
		return model;
	}
	
	
	
	
	@RequestMapping("/updatingPage/{id}")
	public ModelAndView updatingPage(@PathVariable(name="id") Long id) 
	{
		
		
		ModelAndView model=new ModelAndView("updatingPage");
		Students student=studentsService.getStudentById(id);
		model.addObject("student",student);
		return model;
	}
	
	@RequestMapping("/update/student/{id}")
	public String updatingStudent(@PathVariable Long id,@ModelAttribute("student") Students student,org.springframework.ui.Model model) {
	    	Students s=studentsService.getStudentById(id);
	    	s.setId(student.getId());
	    	s.setName(student.getName());
	    	s.setEmail(student.getEmail());
	    	s.setCollegeId(student.getCollegeId());
	    	
	    	studentsService.saveStudent(s);
	    	
	    	return"redirect:/listOfStudents";
	}
	
	
	@RequestMapping("/delete/{id}")
	public String deletingStudent(@PathVariable long id,org.springframework.ui.Model model) {
		
		studentsService.deletingStudent(id);
		return "redirect:/listOfStudents";
	}
	
	
	
	
	
	
	
}
