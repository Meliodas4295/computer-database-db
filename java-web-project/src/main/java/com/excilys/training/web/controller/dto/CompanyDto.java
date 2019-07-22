package com.excilys.training.web.controller.dto;

import java.util.Objects;

import com.excilys.training.model.Company;

public class CompanyDto {
	int id;
	String name;
	public CompanyDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o==null || getClass()!= o.getClass()) {
			return false;
		}
		
		CompanyDto that = (CompanyDto) o;
		return Objects.equals(id, that.id) && Objects.equals(name, that.name);
	}

	

}
