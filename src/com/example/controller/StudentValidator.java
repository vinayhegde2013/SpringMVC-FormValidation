package com.example.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.entity.Student;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class c) {

		return Student.class.equals(c);
	}

	@Override
	public void validate(Object ob, Errors e) {
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "id", "Student.id.empty");

		Student c = (Student) ob;
		Integer id = c.getId();
		if (id != null) {
			if (id <= 0 || id > 150)
				e.rejectValue("id", "Student.id.range.invalid");
		}

	}

}
