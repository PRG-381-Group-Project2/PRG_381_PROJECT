package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Register")
public class RegistrationCredentials {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "CourseName")
	private String CourseName;
	
	@Column(name = "StudentId")
	private String StudentId;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCourseName() {
		return firstName;
	}
	
	public void setCourseName(String CourseName) {
		this.CourseName = CourseName;
	}

	public String getStudentId() {
		return StudentId;
	}

	public void setStudentId(String email) {
		this.StudentId = StudentId;
	}
}
