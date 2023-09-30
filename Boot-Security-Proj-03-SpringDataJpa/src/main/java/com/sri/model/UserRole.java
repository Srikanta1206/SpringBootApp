package com.sri.model;

public class UserRole {

	private String name="srikanta";
	private String pwd;
	private String mail;
	private String contact;
	private String gender="male";
	private String[] roles;
	@Override
	public String toString() {
		return "UserRole [name=" + name + ", password=" + pwd + ", mail=" + mail + ", contact=" + contact
				+ ", gender=" + gender + ", role=" + roles + "]";
	}
	public String[] getRoles() {
		return roles;
	}
	public void setRoles(String[] roles) {
		this.roles = roles;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
