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
	 * Constructeur de la class company. 
	 * Retourne une instance de type Company.
	 * @param id
	 * @param name
	 */
	private Company(CompanyBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
	}
	
	/**
	 * 
	 * @return l'id de la company (int id)
	 */
	public int getId() {
		return id;
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
