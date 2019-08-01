package com.excilys.training.web.controller.dto;

import java.time.LocalDateTime;

import com.excilys.training.model.Company;

public class ComputerDto {
	/**
	 * l'id du ComputerDto.
	 */
	private final int id;
	/**
	 * le nom du ComputerDto.
	 */
	private final String name;
	/**
	 * la date d'introduction du ComputerDto sur le marché.
	 */
	private final String introduced;
	/**
	 * la date d'arrêt du ComputerDto
	 */
	private final String discontinued;
	/**
	 * la Company qui détient le ComputerDto.
	 */
	private final String companyId;
	
	/**
	 * Constructeur de la classe ComputerDto.
	 * @param id
	 * @param name
	 * @param introduced
	 * @param discontinued
	 * @param company_id
	 */
	private ComputerDto(ComputerDtoBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.introduced = builder.introduced;
		this.discontinued = builder.discontinued;
		this.companyId = builder.companyId;
	}
	/**
	 * 
	 * @return l'id du ComputerDto.
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @return le nom du ComputerDto.
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return la date d'introduction du ComputerDto (String introduced).
	 */
	public String getIntroduced() {
		return introduced;
	}
	/**
	 * 
	 * @return la date d'arrêt du ComputerDto (String discontinued).
	 */
	public String getDiscontinued() {
		return discontinued;
	}
	/**
	 * 
	 * @return l'id de la Company possédant le ComputerDto (String company_id).
	 */
	public String getCompanyId() {
		return companyId;
	}
	
	public static class ComputerDtoBuilder{
		private int id;
		private final String name;
		private final String introduced;
		private final String discontinued;
		private final String companyId;
		
		public ComputerDtoBuilder(String name, String introduced, String discontinued, String companyId) {
			this.name=name;
			this.introduced=introduced;
			this.discontinued=discontinued;
			this.companyId=companyId;
		}
		public ComputerDtoBuilder id(int id) {
			this.id = id;
			return this;
		}
		public ComputerDto build() {
			return new ComputerDto(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyId == null) ? 0 : companyId.hashCode());
		result = prime * result + ((discontinued == null) ? 0 : discontinued.hashCode());
		result = prime * result + id;
		result = prime * result + ((introduced == null) ? 0 : introduced.hashCode());
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
		ComputerDto other = (ComputerDto) obj;
		if (companyId == null) {
			if (other.companyId != null)
				return false;
		} else if (!companyId.equals(other.companyId))
			return false;
		if (discontinued == null) {
			if (other.discontinued != null)
				return false;
		} else if (!discontinued.equals(other.discontinued))
			return false;
		if (id != other.id)
			return false;
		if (introduced == null) {
			if (other.introduced != null)
				return false;
		} else if (!introduced.equals(other.introduced))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
