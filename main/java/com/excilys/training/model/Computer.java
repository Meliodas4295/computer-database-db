package main.java.com.excilys.training.model;

import java.time.LocalDateTime;

public class Computer {
	private int id;
	private String name;
	private LocalDateTime introduced;
	private LocalDateTime discontinued;
	private Integer company_id;
	
	public Computer(int id, String name, LocalDateTime introduced, LocalDateTime discontinued, Integer company_id) {
		super();
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company_id = company_id;
	}

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
	
	
}
