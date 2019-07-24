package com.excilys.training.web.controller.dto;

import java.util.Objects;

import com.excilys.training.model.Company;

public class CompanyDto {
	/**
	 * l'id de la classe CompanyDto.
	 */
	int id;
	/**
	 * le nom de la classe CompanyDto
	 */
	String name;
	
	/**
	 * Constructeur de la classe CompanyDto.
	 * @param id
	 * @param name
	 */
	public CompanyDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	/**
	 * 
	 * @return l'id de la CompanyDto.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Écrit l'id de la CompanyDto.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return le nom de la CompanyDto.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Écrit le nom de la CompanyDto.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Override
	/**
	 * Renvoie True si les deux objets sont des CompanyDto 
	 * et s'ils ont le même id et name.
	 */
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
