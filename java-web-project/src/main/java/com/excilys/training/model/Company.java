package com.excilys.training.model;

import java.util.Objects;

public class Company {
	/**
	 * l'id de la company.
	 */
	private final int id;
	/**
	 * le nom de la company
	 */
	private final String name;
	
	/**
	/**
	 * l'id de la company.
	 */
	private int id;
	/**
	 * le nom de la company
	 */
	private String name;
	
	/**
	 * Constructeur vide.
	 */
	public Company() {}
	
	/**

	/**

	 * Constructeur de la class company. 
	 * Retourne une instance de type Company.
	 * @param id
	 * @param name
	 */

	private Company(CompanyBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;

	public Company(int id, String name) {
		super();
		this.id = id;
		this.name = name;

	}
	
	/**
	 * 
	 * @return l'id de la company (int id)
	 */
	public int getId() {
		return id;
	}
	/**
	 * Écrit un id.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return le nom de la company.(String name)
	 */
	public String getName() {
		return name;
	}
	
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
	/**
	 * Écrit un nom.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Écrit un id.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return le nom de la company.(String name)
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Écrit un nom.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	/**
	 * Renvoie une chaine de caractère constituée des paramètres de la company.
	 */
	public String toString() {
		return "Company [getId()=" + getId() + ", getName()=" + getName() + "]";
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

	/**
	 * Renvoie True si les deux objets sont des Company 
	 * et s'ils ont le même id et name.
	 */
	public boolean equals(Object o) {
		if(this == o) {
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
