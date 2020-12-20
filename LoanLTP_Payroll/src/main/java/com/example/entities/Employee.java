package com.example.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Employee {
	private static final double DAY_OF_YEAR = 365.2425;
	private String name;
	private String dob;
	private String role;
	private String startDate;
	private int startSal;
	private double age;
	private int nowSal;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the startSal
	 */
	public int getStartSal() {
		return startSal;
	}
	/**
	 * @param startSal the startSal to set
	 */
	public void setStartSal(int startSal) {
		this.startSal = startSal;
	}
	/**
	 * @return the age
	 */
	public double getAge() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		    LocalDate birthDay = LocalDate.parse(this.dob, dateFormatter);
		    age = birthDay.until(LocalDate.now(), ChronoUnit.DAYS) / DAY_OF_YEAR;
		    return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(double age) {
		this.age = age;
	}
	/**
	 * @return the nowSal
	 */
	public int getNowSal() {
		return nowSal;
	}
	/**
	 * @param nowSal the nowSal to set
	 */
	public void setNowSal(int nowSal) {
		this.nowSal = nowSal;
	}
	
	
}
