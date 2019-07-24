package com.excilys.training.web.controller.dto;

public class ComputerDto {
	/**
	 * l'id du ComputerDto.
	 */
	private int id;
	/**
	 * le nom du ComputerDto.
	 */
	private String name;
	/**
	 * la date d'introduction du ComputerDto sur le marché.
	 */
	private String introduced;
	/**
	 * la date d'arrêt du ComputerDto
	 */
	private String discontinued;
	/**
	 * la Company qui détient le ComputerDto.
	 */
	private String company_id;
	
	/**
	 * Constructeur de la classe ComputerDto.
	 * @param id
	 * @param name
	 * @param introduced
	 * @param discontinued
	 * @param company_id
	 */
	public ComputerDto(int id, String name, String introduced, String discontinued, String company_id) {
		super();
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company_id = company_id;
	}
	
	/**
	 * Constructeur sans la composante id.
	 * @param name
	 * @param introduced
	 * @param discontinued
	 * @param company_id
	 */
	public ComputerDto(String name, String introduced, String discontinued, String company_id) {
		super();
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company_id = company_id;
	}
	/**
	 * 
	 * @return l'id du ComputerDto.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Écrit l'id du ComputerDto.
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return le nom du ComputerDto.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Écrit le nom du ComputerDto.
	 * @param id
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return la date d'introduction du ComputerDto (String introduced).
	 */
	public String getIntroduced() {
		return introduced;
	}
	/**
	 * Écrit la date d'introduction du ComputerDto.
	 * @param id
	 */
	public void setIntroduced(String introduced) {
		this.introduced = introduced;
	}
	/**
	 * 
	 * @return la date d'arrêt du ComputerDto (String discontinued).
	 */
	public String getDiscontinued() {
		return discontinued;
	}
	/**
	 * Écrit la date d'arrêt du ComputerDto.
	 * @param id
	 */
	public void setDiscontinued(String discontinued) {
		this.discontinued = discontinued;
	}
	/**
	 * 
	 * @return l'id de la Company possédant le ComputerDto (String company_id).
	 */
	public String getCompany_id() {
		return company_id;
	}
	/**
	 * Écrit l'id de la Company possédant le ComputerDto.
	 * @param id
	 */
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	
}
