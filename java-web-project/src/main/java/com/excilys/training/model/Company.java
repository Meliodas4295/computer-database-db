package com.excilys.training.model;

import java.util.Objects;

public class Company {
<<<<<<< HEAD
	/**
	 * l'id de la company.
	 */
<<<<<<< HEAD
<<<<<<< HEAD
	private final int id;
	/**
	 * le nom de la company
	 */
	private final String name;
	
	/**
=======
=======
>>>>>>> develop
=======
>>>>>>> parent of 09d7b74... Add HikariCP
	private int id;
	private String name;
	
	public Company() {}
<<<<<<< HEAD
	
	/**
<<<<<<< HEAD
>>>>>>> develop
=======
>>>>>>> develop
	 * Constructeur de la class company. 
	 * Retourne une instance de type Company.
	 * @param id
	 * @param name
	 */
<<<<<<< HEAD
<<<<<<< HEAD
	private Company(CompanyBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
=======
=======
>>>>>>> develop
=======
>>>>>>> parent of 09d7b74... Add HikariCP
	public Company(int id, String name) {
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
	 * Écrit un id.
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
	 * @return le nom de la company.(String name)
	 */
	public String getName() {
		return name;
	}
	
<<<<<<< HEAD
<<<<<<< HEAD
	public static class CompanyBuilder {
		private String name;
		private final int id;
		
		public CompanyBuilder(int id) {
			this.id=id;
		}
		public CompanyBuilder name(String name) {
			this.name=name;
			return this;
		}
		
		public Company build() {
			return new Company(this);
		}
		
	}
=======
=======
>>>>>>> develop
	/**
	 * Écrit un nom.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
<<<<<<< HEAD
>>>>>>> develop
=======
>>>>>>> develop
=======

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

>>>>>>> parent of 09d7b74... Add HikariCP
	@Override
	public String toString() {
		return "Company [getId()=" + getId() + ", getName()=" + getName() + "]";
	}
	@Override
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
	 * Renvoie True si les deux objets sont des Company 
	 * et s'ils ont le même id et name.
	 */
=======
>>>>>>> parent of 09d7b74... Add HikariCP
	public boolean equals(Object o) {
		if(this == o) {
>>>>>>> develop
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
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
