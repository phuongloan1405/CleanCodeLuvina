package com.payroll.entities;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Employee {
	private static final double DAY_OF_YEAR = 365.2425;
	private static final double COEFFICIENT = 0.06;
	private String name;
	private String dob;
	private String role;
	private String startDate;
	private int startSal;
	private double age;
	private List<Integer> yearWorked = new ArrayList<Integer>() ;
	private String nowSal;

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
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
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
	 * @return the yearWorked
	 */
	@SuppressWarnings("unused")
	public List<Integer> getYearWorked() {
		    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
			LocalDate startDate = LocalDate.parse(this.startDate, dateFormatter);
			LocalDate dateNow = LocalDate.now();
			Period different = Period.between(startDate,dateNow);  
			yearWorked.add(different.getYears());
		    yearWorked.add(different.getMonths());
		return yearWorked;
	}

	/**
	 * @param yearWorked the yearWorked to set
	 */
	public void setYearWorked(List<Integer> yearWorked) {
		this.yearWorked = yearWorked;
	}

	/**
	 * @return the nowSal
	 */
	public String getNowSal() {
		double now = startSal*Math.pow(1+COEFFICIENT, yearWorked.get(0)-1);
		NumberFormat formatter = new DecimalFormat("0");
		nowSal = formatter.format(now);
		return nowSal;
	}

	/**
	 * @param nowSal the nowSal to set
	 */
	public void setNowSal(String nowSal) {
		this.nowSal = nowSal;
	}

	@Override
	public String toString() {
		return name + "-" + dob + "-" + role + "-" + startDate + "-" + startSal + "-" + getAge() + "-" + getYearWorked().toString() + "- " + getNowSal();
	}
}
