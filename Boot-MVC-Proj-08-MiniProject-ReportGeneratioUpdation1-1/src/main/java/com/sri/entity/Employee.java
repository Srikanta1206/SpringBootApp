package com.sri.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Table(name = "employee")
@Entity
public class Employee {

	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "emp_reg", initialValue = 2001, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen1")
	private Integer empno;

	@Column
	private String ename;

	@Column
	private String desg;

	@Column
	private Float sal;
	
	@Column
	private Integer deptno;
	
	public Integer getDeptno() {
		return deptno;
	}



	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}



	public Integer getEmpno() {
		return empno;
	}



	public void setEmpno(Integer empno) {
		this.empno = empno;
	}



	public String getEname() {
		return ename;
	}



	public void setEname(String ename) {
		this.ename = ename;
	}



	public String getDesg() {
		return desg;
	}



	public void setDesg(String desg) {
		this.desg = desg;
	}



	public Float getSal() {
		return sal;
	}



	public void setSal(Float sal) {
		this.sal = sal;
	}



	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + ", desg=" + desg + ", sal=" + sal + ", deptno="
				+ deptno + "]";
	}

}
