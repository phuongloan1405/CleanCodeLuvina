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
	
	//PT đọc file CSV và gán các giá trị trong file vào 1 danh sách 
	public void readfileCSV() {
		List<String> lineCSV;
		Employee employee = new Employee();
		try {
			File file = new File(FILE_NAME);//khai báo và khởi tạo các đối tượng để đọc file
			BufferedReader fileReader = new BufferedReader(new FileReader(file));
			fileReader.readLine(); //bỏ qua dòng tiêu đề của file
			String data = fileReader.readLine();
			while (data != null) { // đọc lần lượt từng dòng trong file và gán giá trị vào 1 danh sách Employee
				lineCSV = Common.convertStringToListString(data);
				employee = getEmployeeFromListString(lineCSV);
				employees.add(employee);
				data = fileReader.readLine();
			}
			fileReader.close();
		} catch (IOException e) { // bắt và xử lý ngoại lệ
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	//PT tạo đối tượng employee từ list thuộc tính của đối tượng
	private Employee getEmployeeFromListString(List<String> employeeCSV) {
		Employee employee = new Employee();
		int index = 0; // khai báo biến chạy
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
