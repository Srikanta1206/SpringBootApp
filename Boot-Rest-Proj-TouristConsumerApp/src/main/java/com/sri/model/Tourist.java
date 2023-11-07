package com.sri.model;

import java.io.Serializable;
//In My IDE lombok is not working properly so i manually create cons,getter,setter,toString
//use lombok suppliied annotation @Data,@AllArgConstrictor,@NoArgConstructor,@Getter,@Setter,@RequiredArgConstructor,@ToString,@NonNull

public class Tourist implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer tId;
    private String tName;
    private Byte age;
    private String tAddress;
    private Long contactNo;
    private String email;
    private final String journeyStarts = "PURI";
    private final String journeyEnds = "KEDARNATH";
    private Double budget;

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

    // Zero param Constructor
    public Tourist() {
	super();
    }

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

    @Override
    public String toString() {
	return "Tourist [tId=" + tId + ", tName=" + tName + ", age=" + age + ", tAddress=" + tAddress + ", contactNo="
		+ contactNo + ", email=" + email + ", journeyStarts=" + journeyStarts + ", journeyEnds=" + journeyEnds
		+ ", budget=" + budget + "]";
    }

}
