package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class StudentCredentials {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "StudentName")
	private String StudentName;
	
	@Column(name = "StudentAddress")
	private String StudentAddress;
	
	@Column(name = "StudentEmail")
	private String StudentEmail;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String StudentName) {
		this.StudentName = StudentName;
	}
	public String getStudentAddress() {
		return StudentAddress;
	}
	public void StudentAddress(String StudentAddress) {
		this.StudentAddress = StudentAddress;
	}
	public String getStudentEmail() {
		return StudentEmail;
	}
	public void setStudentEmail(String StudentEmail) {
		this.StudentEmail= StudentEmail;
	}
}
