package com.excilys.training.web.controller.dto;

import java.util.Objects;

import com.excilys.training.model.Company;

public class CompanyDto {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

	/**
	 * l'id de la classe CompanyDto.
	 */
	private final int id;
	/**
	 * le nom de la classe CompanyDto
	 */
	private final String name;
=======
=======
>>>>>>> develop
	/**
	 * l'id de la classe CompanyDto.
	 */
=======
>>>>>>> parent of 09d7b74... Add HikariCP
	int id;
	String name;
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> develop
=======
>>>>>>> develop
	
	/**
	 * Constructeur de la classe CompanyDto.
	 * @param id
	 * @param name
	 */
<<<<<<< HEAD
<<<<<<< HEAD
	private CompanyDto(CompanyDtoBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
=======
=======
>>>>>>> develop
=======
>>>>>>> parent of 09d7b74... Add HikariCP
	public CompanyDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
>>>>>>> develop
	}
	public int getId() {
		return id;
	}
<<<<<<< HEAD
	
	/**
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> develop
	 * Écrit l'id de la CompanyDto.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
<<<<<<< HEAD
>>>>>>> develop
=======
>>>>>>> develop
	 * 
	 * @return le nom de la CompanyDto.
	 */
	public String getName() {
		return name;
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
=======
>>>>>>> develop
	/**
	 * Écrit le nom de la CompanyDto.
	 * @param name
	 */
=======
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
>>>>>>> parent of 09d7b74... Add HikariCP
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object o) {
		if(this == o) {
>>>>>>> develop
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
