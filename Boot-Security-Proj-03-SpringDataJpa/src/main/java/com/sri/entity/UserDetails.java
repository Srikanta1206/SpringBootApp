package com.sri.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
public class UserDetails implements Serializable {


	private static final long serialVersionUID = 6448315740344903538L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column()
	private String pwd;

	private String name;
	private LocalDate dob;

	private String mail;
	private String contact;


	/*
	 * @OneToMany(targetEntity = Security_Role.class,cascade = CascadeType.ALL,fetch
	 * = FetchType.EAGER)
	 * 
	 * @JoinColumn(name = "user_id",referencedColumnName = "id")
	 */
	@Column(name = "role")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Security_Role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
	private Set<String> roles;

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", dob=" + dob + ", mail=" + mail + ", contact=" + contact
				+ ", roles=" + roles + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
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

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}

}
