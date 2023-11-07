package com.sri.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//In My IDE lombok is not working properly so i manually create cons,getter,setter,toString
//use lombok suppliied annotation @Data,@AllArgConstrictor,@NoArgConstructor,@Getter,@Setter,@RequiredArgConstructor,@ToString,@NonNull
@Entity
public class Tourist implements Serializable {

    private static final long serialVersionUID = 1489581289887754717L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tId;
    @Column(length = 25, nullable = false)
    private String tName;
    private Byte age;
    @Column(length = 25, nullable = false)
    private String tAddress;
    private Long contactNo;
    @Column(length = 25, nullable = false)
    private String email;
    private final String journeyStarts = "PURI";
    private final String journeyEnds = "KEDARNATH";
    private Double budget;

    public Integer gettId() {
	return tId;
    }

    public void settId(Integer tId) {
	this.tId = tId;
    }

    public String gettName() {
	return tName;
    }

    public void settName(String tName) {
	this.tName = tName;
    }

    public Byte getAge() {
	return age;
    }

    public void setAge(Byte age) {
	this.age = age;
    }

    public String gettAddress() {
	return tAddress;
    }

    public void settAddress(String tAddress) {
	this.tAddress = tAddress;
    }

    public Long getContactNo() {
	return contactNo;
    }

    public void setContactNo(Long contactNo) {
	this.contactNo = contactNo;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getJourneyStarts() {
	return journeyStarts;
    }

    public String getJourneyEnds() {
	return journeyEnds;
    }

    public Double getBudget() {
	return budget;
    }

    public void setBudget(Double budget) {
	this.budget = budget;
    }

    // Zero param Constructor
    public Tourist() {
	super();
    }

    // AllArg Constructor
    public Tourist(Integer tId, String tName, Byte age, String tAddress, Long contactNo, String email,
	    String journeyStarts, String journeyEnds, Double budget) {
	super();
	this.tId = tId;
	this.tName = tName;
	this.age = age;
	this.tAddress = tAddress;
	this.contactNo = contactNo;
	this.email = email;
	this.budget = budget;
    }

    // create one constructor except tid
    public Tourist(String tName, Byte age, String tAddress, Long contactNo, String email, Double budget) {
	super();
	this.tName = tName;
	this.age = age;
	this.tAddress = tAddress;
	this.contactNo = contactNo;
	this.email = email;
	this.budget = budget;
    }

    @Override
    public String toString() {
	return "Tourist [tId=" + tId + ", tName=" + tName + ", age=" + age + ", tAddress=" + tAddress + ", contactNo="
		+ contactNo + ", email=" + email + ", journeyStarts=" + journeyStarts + ", journeyEnds=" + journeyEnds
		+ ", budget=" + budget + "]";
    }

}
