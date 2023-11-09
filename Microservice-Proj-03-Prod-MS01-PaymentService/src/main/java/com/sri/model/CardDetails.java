package com.sri.model;

public class CardDetails {

	private Long cardNo;
	private String name;
	private String expiry;
	private Short cvv;
	public CardDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CardDetails(Long cardNo, String name, String expiry, Short cvv) {
		super();
		this.cardNo = cardNo;
		this.name = name;
		this.expiry = expiry;
		this.cvv = cvv;
	}
	public Long getCardNo() {
		return cardNo;
	}
	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public Short getCvv() {
		return cvv;
	}
	public void setCvv(Short cvv) {
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "CardDetails [cardNo=" + cardNo + ", name=" + name + ", expiry=" + expiry + ", cvv=" + cvv + "]";
	}
	
	
}
