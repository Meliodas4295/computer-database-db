package com.excilys.training.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Computer {
	/**
	 * Id du Computer
	 */
	private int id;
	/**
	 * Nom du Computer
	 */
	private String name;
	/**
	 * La date d'introduction du Computer sur le marché.
	 */
	private LocalDateTime introduced;
	/**
	 * La date où le Computer a été arrêté.
	 */
	private LocalDateTime discontinued;
	/**
	 * L'id de la Company qui possède le Computer.
	 */
	private Integer company_id;
	
	/**
	 * Constructeur vide.
	 */
	public Computer() {}
	/**
	 * Constructeur ne dépendant pas de l'id.
	 * @param name
	 * @param introduced
	 * @param discontinued
	 * @param company_id
	 */
	public Computer(String name, LocalDateTime introduced, LocalDateTime discontinued, Integer company_id) {
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company_id = company_id;
	}
	/**
	 * Constructeur de la class Computer.
	 * @param id
	 * @param name
	 * @param introduced
	 * @param discontinued
	 * @param company_id
	 */
	public Computer(int id, String name, LocalDateTime introduced, LocalDateTime discontinued, Integer company_id) {
		super();
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company_id = company_id;
	}
	/**
	 * 
	 * @return l'id du computer (int id).
	 */
	public int getId() {
		return id;
	}
	/**
	 * Écrit l'id du Computer.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return le nom du computer (String name).
	 */
	public String getName() {
		return name;
	}
	/**
	 * Écrit le nom du Computer.
	 * @param id
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return la date d'introduction du computer (LocalDateTime introduced).
	 */
	public LocalDateTime getIntroduced() {
		return introduced;
	}
	/**
	 * Écrit la date d'introduction du Computer.
	 * @param id
	 */
	public void setIntroduced(LocalDateTime introduced) {
		this.introduced = introduced;
	}
	/**
	 * 
	 * @return la date d'arrêt du Computer (LocalDateTime discontinued).
	 */
	public LocalDateTime getDiscontinued() {
		return discontinued;
	}
	/**
	 * Écrit la date d'arrêt du Computer.
	 * @param id
	 */
	public void setDiscontinued(LocalDateTime discontinued) {
		this.discontinued = discontinued;
	}
	/**
	 * 
	 * @return l'id de la Company possédant le Computer (Integer company_id).
	 */
	public Integer getCompany_id() {
		return company_id;
	}
	/**
	 * Écrit l'id de la Company possédant le Computer.
	 * @param id
	 */
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}

	@Override
	/**
	 * Retourne une chaîne de caractère composée des paramètres du Computer.
	 */
	public String toString() {
		return "Computer [getId()=" + getId() + ", getName()=" + getName() + ", getIntroduced()=" + getIntroduced()
				+ ", getDiscontinued()=" + getDiscontinued() + ", getCompany_id()=" + getCompany_id() + "]";
	}
	@Override
	/**
	 * Renvoie True si les deux objets sont des Company 
	 * et s'ils ont le même id, name, introduced, discontinued et company_id.
	 */
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o==null || getClass()!= o.getClass()) {
			return false;
		}
		
		Computer that = (Computer) o;
		return Objects.equals(id, that.id) 
				&& Objects.equals(name, that.name) 
				&& Objects.equals(introduced, that.introduced)
				&& Objects.equals(discontinued, that.discontinued)
				&& Objects.equals(company_id, that.company_id);
	}
	
	
}
