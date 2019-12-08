package com.example.entity;

import org.springmodules.validation.bean.conf.loader.annotation.handler.Length;
import org.springmodules.validation.bean.conf.loader.annotation.handler.NotBlank;

public class Student {
	private Integer id;
	
	@NotBlank
	@Length(min = 5, max = 30)
	private String name;
	
	private String pname;

	public Student() {
	}

	public Student(Integer id, String name, String pname) {
		super();
		this.id = id;
		this.name = name;
		this.pname = pname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

}
