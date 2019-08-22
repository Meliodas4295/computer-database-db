package com.excilys.training.core;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.excilys.training.core.Computer.ComputerBuilder;

public class Computer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private Timestamp introduced;
	/**
	 * La date où le Computer a été arrêté.
	 */
	private Timestamp discontinued;
	/**
	 * L'id de la Company qui possède le Computer.
	 */
	private Company companyId;
	/**
	 * Constructeur de la class Computer.
	 * @param id
	 * @param name
	 * @param introduced
	 * @param discontinued
	 * @param company_id
	 */

	
	private Computer(ComputerBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.introduced = builder.introduced;
		this.discontinued = builder.discontinued;
		this.companyId = builder.companyId;
	}
	public Computer(int id, String name, Timestamp introduced, Timestamp discontinued, Company companyId) {
		super();
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.companyId = companyId;
	}
	public Computer() {
		
	}

	/**
	 * 
	 * @return l'id du computer (int id).
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @return le nom du computer (String name).
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @return la date d'introduction du computer (LocalDateTime introduced).
	 */
	public Timestamp getIntroduced() {
		return introduced;
	}
	/**
	 * 
	 * @return la date d'arrêt du Computer (LocalDateTime discontinued).
	 */
	public Timestamp getDiscontinued() {
		return discontinued;
	}
	/**
	 * 
	 * @return l'id de la Company possédant le Computer (Integer company_id).
	 */
	public Company getCompanyId() {
		return companyId;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setIntroduced(Timestamp introduced) {
		this.introduced = introduced;
	}
	public void setDiscontinued(Timestamp discontinued) {
		this.discontinued = discontinued;
	}
	public void setCompanyId(Company companyId) {
		this.companyId = companyId;
	}
	
	public static class ComputerBuilder{
		private  String name;
		private  Timestamp introduced;
		private  Timestamp discontinued;
		private  Company companyId;
		private  int id;
		
		public ComputerBuilder() {}
		public ComputerBuilder id(int id) {
			this.id=id;
			return this;
		}
		public ComputerBuilder name(String name) {
			this.name=name;
			return this;
		}
		public ComputerBuilder introduced(Timestamp introduced) {
			this.introduced=introduced;
			return this;
		}
		public ComputerBuilder discontinued(Timestamp discontinued) {
			this.discontinued=discontinued;
			return this;
		}
		public ComputerBuilder companyId(Company companyId) {
			this.companyId=companyId;
			return this;
		}
		
		public Computer build() {
			return new Computer(this);
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
		Computer other = (Computer) obj;
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
	@Override
	public String toString() {
		return "Computer [id=" + id + ", name=" + name + ", introduced=" + introduced + ", discontinued=" + discontinued
				+ ", companyId=" + companyId + "]";
	}
	
	
	
}
