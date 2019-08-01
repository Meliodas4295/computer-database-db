package com.excilys.training.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Computer {
<<<<<<< HEAD
	/**
	 * Id du Computer
	 */
<<<<<<< HEAD
<<<<<<< HEAD
	private final int id;
	/**
	 * Nom du Computer
	 */
	private final String name;
	/**
	 * La date d'introduction du Computer sur le marché.
	 */
	private final LocalDateTime introduced;
	/**
	 * La date où le Computer a été arrêté.
	 */
	private final LocalDateTime discontinued;
	/**
	 * L'id de la Company qui possède le Computer.
	 */
	private final Company companyId;
	
	/**
	 * Constructeur de la class Computer.
	 * @param id
=======
=======
>>>>>>> develop
=======
>>>>>>> parent of 09d7b74... Add HikariCP
	private int id;
	private String name;
	private LocalDateTime introduced;
	private LocalDateTime discontinued;
	private Integer company_id;
	
	public Computer() {}
<<<<<<< HEAD
	/**
	 * Constructeur ne dépendant pas de l'id.
<<<<<<< HEAD
>>>>>>> develop
=======
>>>>>>> develop
	 * @param name
	 * @param introduced
	 * @param discontinued
	 * @param company_id
	 */
<<<<<<< HEAD
<<<<<<< HEAD
	private Computer(ComputerBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.introduced = builder.introduced;
		this.discontinued = builder.discontinued;
		this.companyId = builder.companyId;
	}
	/**
=======
=======
>>>>>>> develop
=======
>>>>>>> parent of 09d7b74... Add HikariCP
	public Computer(String name, LocalDateTime introduced, LocalDateTime discontinued, Integer company_id) {
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company_id = company_id;
	}
	public Computer(int id, String name, LocalDateTime introduced, LocalDateTime discontinued, Integer company_id) {
		super();
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company_id = company_id;
	}
<<<<<<< HEAD
	/**
<<<<<<< HEAD
>>>>>>> develop
=======
>>>>>>> develop
	 * 
	 * @return l'id du computer (int id).
	 */
	public int getId() {
		return id;
	}
	/**
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> develop
	 * Écrit l'id du Computer.
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
	 * @return le nom du computer (String name).
	 */
	public String getName() {
		return name;
	}
	/**
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> develop
	 * Écrit le nom du Computer.
	 * @param id
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
<<<<<<< HEAD
>>>>>>> develop
=======
>>>>>>> develop
	 * 
	 * @return la date d'introduction du computer (LocalDateTime introduced).
	 */
	public LocalDateTime getIntroduced() {
		return introduced;
	}
	/**
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> develop
	 * Écrit la date d'introduction du Computer.
	 * @param id
	 */
	public void setIntroduced(LocalDateTime introduced) {
		this.introduced = introduced;
	}
	/**
<<<<<<< HEAD
>>>>>>> develop
=======
>>>>>>> develop
	 * 
	 * @return la date d'arrêt du Computer (LocalDateTime discontinued).
	 */
	public LocalDateTime getDiscontinued() {
		return discontinued;
	}
	/**
<<<<<<< HEAD
<<<<<<< HEAD
	 * 
	 * @return l'id de la Company possédant le Computer (Integer company_id).
	 */
	public Company getCompanyId() {
		return companyId;
	}
	
	public static class ComputerBuilder{
		private  String name;
		private  LocalDateTime introduced;
		private  LocalDateTime discontinued;
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
		public ComputerBuilder introduced(LocalDateTime introduced) {
			this.introduced=introduced;
			return this;
		}
		public ComputerBuilder discontinued(LocalDateTime discontinued) {
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
=======
=======
>>>>>>> develop
	 * Écrit la date d'arrêt du Computer.
	 * @param id
	 */
=======

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getIntroduced() {
		return introduced;
	}

	public void setIntroduced(LocalDateTime introduced) {
		this.introduced = introduced;
	}

	public LocalDateTime getDiscontinued() {
		return discontinued;
	}

>>>>>>> parent of 09d7b74... Add HikariCP
	public void setDiscontinued(LocalDateTime discontinued) {
		this.discontinued = discontinued;
	}

	public Integer getCompany_id() {
		return company_id;
	}

	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}

	@Override
	public String toString() {
		return "Computer [getId()=" + getId() + ", getName()=" + getName() + ", getIntroduced()=" + getIntroduced()
				+ ", getDiscontinued()=" + getDiscontinued() + ", getCompany_id()=" + getCompany_id() + "]";
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
