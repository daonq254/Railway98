package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.UserController;
import com.vti.entiy.Employee;
import com.vti.utils.ScannerUtils;

public class UserFunction {

	private UserController userController;

	public UserFunction() throws FileNotFoundException, IOException {
		userController = new UserController();
	}

	// Question 2. Tìm thành viên là Employee của Project theo ID
	public void getEmployeeByProjectId() throws ClassNotFoundException, SQLException {
		System.out.println("Mời bạn nhập vào ID của Project: ");
		int projectId = ScannerUtils.inputIntPositive(); // Nhập vào 1 số nguyên dương
		List<Employee> listEmployees = userController.getEmployeeByProjectId(projectId);

		String leftAlignFormat = "| %-2d | %-25s | %-21s |%n";
		System.out.format("+----+---------------------------+-----------------------+%n");
		System.out.format("|ID  | Email                     |   FullName            |%n");
		System.out.format("+----+---------------------------+-----------------------+%n");

		for (Employee employee : listEmployees) {
			System.out.format(leftAlignFormat, employee.getId(), employee.getEmail(), employee.getFullName());
		}
		System.out.format("+----+---------------------------+-----------------------+%n");

	}

}
