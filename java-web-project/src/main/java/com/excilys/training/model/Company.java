package com.excilys.training.model;

import java.util.Objects;

public class Company {
	private int id;
	private String name;
	
	public Company() {}
	public Company(int id, String name) {
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
	public String toString() {
		return "Company [getId()=" + getId() + ", getName()=" + getName() + "]";
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o==null || getClass()!= o.getClass()) {
			return false;
		}
		
		Company that = (Company) o;
		return Objects.equals(id, that.id) && Objects.equals(name, that.name);
	}
	
	

}
