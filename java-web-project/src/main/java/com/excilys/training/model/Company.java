package com.excilys.training.model;

import java.util.Objects;

public class Company {
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
	 * Constructeur de la class company. 
	 * Retourne une instance de type Company.
	 * @param id
	 * @param name
	 */
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
	/**
	 * Renvoie True si les deux objets sont des Company 
	 * et s'ils ont le même id et name.
	 */
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
