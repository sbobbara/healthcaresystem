package com.cg.health.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "user_spring")
public class UserDetails {
	@Id
	private String userId;
	private String useremail;
	private String password;
	private String username;
	private Long contactNo;
	private String gender;
	private String age;
	private String role;
	
	
	public UserDetails() {
	}


	public UserDetails(String userId, String useremail, String password, String username, Long contactNo, String gender,
			String age, String role) {
		super();
		this.userId = userId;
		this.useremail = useremail;
		this.password = password;
		this.username = username;
		this.contactNo = contactNo;
		this.gender = gender;
		this.age = age;
		this.role=role;
	}


	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", useremail=" + useremail + ", password=" + password + ", username="
				+ username + ", contactNo=" + contactNo + ", gender=" + gender + ", age=" + age + ", role=" +role+ "]";
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUseremail() {
		return useremail;
	}


	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Long getContactNo() {
		return contactNo;
	}


	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
}
