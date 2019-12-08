package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Place;
import com.example.entity.Student;

@Controller
public class StudentController {
	@Autowired
	Validator validator;

	@RequestMapping(value = "createStudent.htm", method = RequestMethod.GET)
	public ModelAndView createStudent() {
		Student s = new Student();
		ModelAndView mv = new ModelAndView();
		mv.addObject("s", s);
		mv.setViewName("addStudent");
		return mv;
	}

	@RequestMapping(value = "addStudent.htm", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute("s") Student student, BindingResult result) {
		ModelAndView mv = new ModelAndView();
		validator.validate(student, result);

		StudentValidator sv = new StudentValidator();
		sv.validate(student, result);
		if (result.hasErrors())
			mv.setViewName("addStudent");
		else {
			mv.addObject("stu", student);
			mv.setViewName("Show");
		}
		return mv;
	}

	@ModelAttribute("placeList")
	public List<Place> displayPlaces() {
		List<Place> all = new ArrayList<Place>();
		Place p1 = new Place();
		p1.setPid(1);
		p1.setPname("Chennai");
		Place p2 = new Place();
		p2.setPid(2);
		p2.setPname("Bangalore");
		Place p3 = new Place();
		p3.setPid(3);
		p3.setPname("Mumbai");
		Place p4 = new Place();
		p4.setPid(4);
		p4.setPname("Pune");

		all.add(p1);
		all.add(p2);
		all.add(p3);
		all.add(p4);

		return all;
	}
}
