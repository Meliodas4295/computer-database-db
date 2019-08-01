package com.excilys.training.web.controller.dto;

import java.util.Objects;

import com.excilys.training.model.Company;

public class CompanyDto {

	/**
	 * l'id de la classe CompanyDto.
	 */
	private final int id;
	/**
	 * le nom de la classe CompanyDto
	 */
	private final String name;
	
	/**
	 * Constructeur de la classe CompanyDto.
	 * @param id
	 * @param name
	 */
	private CompanyDto(CompanyDtoBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
	}
	
	/**
	 * 
	 * @return l'id de la CompanyDto.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @return le nom de la CompanyDto.
	 */
	public String getName() {
		return name;
	}
	
	public static class CompanyDtoBuilder{
		private final int id;
		private String name;
		
		public CompanyDtoBuilder(int id) {
			this.id=id;
		}
		public CompanyDtoBuilder name(String name) {
			this.name=name;
			return this;
		}
		public CompanyDto build() {
			return new CompanyDto(this);
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyDto other = (CompanyDto) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
