package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Administrator")
public class AdminCredentials {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "AdminName")
	private String AdminName;
	
	@Column(name = "AdminPasword")
	private String  AdminPassword;
	
	@Column(name = "AdminContact")
	private String AdminContact;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String AdminName) {
		this.AdminName = AdminName;
	}
	public String getAdminPasword() {
		return AdminPasword;
	}
	public void setAdminPasword(String AdminPasword) {
		this.AdminPasword = AdminPasword;
	}
	public String getAdminContact() {
		return AdminContact;
	}
	public void setAdminContact(String adminContact) {
		this.AdminContact = AdminContact;
	}
}
