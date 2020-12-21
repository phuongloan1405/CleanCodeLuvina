package com.payroll.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.payroll.common.Common;
import com.payroll.entities.Employee;

public class PayrollController {
	public static final String FILE_NAME = "..\\employee.csv";
	private static List<Employee> employees = new ArrayList<>();

	public void readfileCSV() {
		List<String> employeeCSV;
		Employee employee = new Employee();
		try {
			File file = new File(FILE_NAME);
			BufferedReader fileReader = new BufferedReader(new FileReader(file));
			fileReader.readLine();
			String data = fileReader.readLine();
			while (data != null) { // doc lan luot tung dong trong file va luu vao danh sach Employee
				employeeCSV = Common.convertStringToListString(data);
				employee = getEmployeeFromListString(employeeCSV);
				employees.add(employee);
				data = fileReader.readLine();
			}
			fileReader.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void name() {

	}

	private Employee getEmployeeFromListString(List<String> employeeCSV) {
		Employee employee = new Employee();
		int index = 0;
		employee.setName(employeeCSV.get(index++));
		employee.setDob(employeeCSV.get(index++));
		employee.setRole(employeeCSV.get(index++));
		employee.setStartDate(employeeCSV.get(index++));
		employee.setStartSal(Common.convertStringToInt(employeeCSV.get(index++), Common.SAL_DEFAULT));
		employee.getAge();

		return employee;
	}

	public static void main(String[] args) {
		PayrollController controller = new PayrollController();
		controller.readfileCSV();
		for (Employee employee : employees) {
			System.out.println(employee.getName() + "-" + employee.getAge() + "-" + employee.getYearWorked().toString() + "-"
					+ employee.getNowSal());

		}
	}
}
