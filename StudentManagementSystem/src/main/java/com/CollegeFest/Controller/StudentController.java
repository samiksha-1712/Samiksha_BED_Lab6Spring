package com.CollegeFest.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.CollegeFest.Entity.Student;
import com.CollegeFest.Service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService StudentService;

	@RequestMapping("/list")
	public String listStudents(Model theModel) {

		// Get List of Students from the Database
		List<Student> theStudents = StudentService.findAll();

		// Associate Model to the Java Object
		theModel.addAttribute("Students", theStudents);

		return "list-Students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create Model Attribute to bind Form-Data
		Student theStudent = new Student();
		theModel.addAttribute("Student", theStudent);

		return "Student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") long theId, Model theModel) {

		// Get the Student By Id
		Student theStudent = StudentService.findById(theId);

		// Set Student as a Model attribute to Pre-populate the Form
		theModel.addAttribute("Student", theStudent);

		return "Student-form-update";
	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("Student") Student theStudent) {

		// Save the Student
		StudentService.save(theStudent);

		// Use a redirect to prevent Duplicate Submissions
		return "redirect:/students/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") long theId) {

		// Delete the Student
		StudentService.deleteById(theId);

		// Redirect to /Students/list
		return "redirect:/students/list";

	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
}
