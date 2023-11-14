package lt.codeacademy.javau7.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Employees {
	@Id
	@GeneratedValue
	private Long id;
	@NotBlank(message = "Name is empty")
	private String name;
	@NotBlank(message = "Email is empty")
	private String email;
	private String department;
	private String position;

	
	
	
	public Employees() {
	}

	public Employees(Long id, String name, String email, String department, String position) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
