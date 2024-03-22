package com.sri.model;

import java.time.LocalDate;

public class Place {
	private String source;
	private String destination;
	private LocalDate date;
	@Override
	public String toString() {
		return "Place [source=" + source + ", destination=" + destination + ", date=" + date + "]";
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
