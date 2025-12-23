package com.vti.backend;

import java.util.ArrayList;
import java.util.Scanner;

import com.vti.entity.Engineer;
import com.vti.entity.Gender;
import com.vti.entity.Staff;

public class StaffManagement {

	private Scanner scanner;
	private ArrayList<Staff> staffArrayList;

	public StaffManagement() {
		super();
		scanner = new Scanner(System.in);
		staffArrayList = new ArrayList<Staff>();
	}

	// Thêm mới cán bộ
	public void addNewStaff() {
		System.out.println("Thêm mới cán bộ");
		System.out.println("1. Thêm Engineer");
		System.out.println("2. Thêm Worker");
		System.out.println("3. Thêm Employee");

		int choose = scanner.nextInt();

		switch (choose) {
		case 1:
//			Lấy thông tin của đối tương Engineer
			System.out.println("Thêm mới Engineer");
			System.out.println("Nhập vào tên:");
			String nameEngineer = scanner.next();

			System.out.println("Nhập vào tuổi Engineer: ");
			int ageEngineer = scanner.nextInt();

			System.out.println("Lựa chọn giới tính: 1.MALE, 2.FEMALE, 3.UNKNOWN");
			int genderchoose = scanner.nextInt();
			Gender genderEngineer = null;

			switch (genderchoose) {
			case 1:
				genderEngineer = Gender.MALE;
				break;
			case 2:
				genderEngineer = Gender.FEMALE;
				break;
			case 3:
				genderEngineer = Gender.UNKNOWN;
				break;
			}

			System.out.println("Nhập vào địa chỉ Engineer: ");
			String addressEngineer = scanner.next();

			System.out.println("Nhập vào chuyên ngành Engineer: ");
			String specializedEngineer = scanner.next();

//			Tạo ra đối tượng Engineer
//			Engineer engineer = new Engineer();
//			engineer.setName(nameEngineer);
//			engineer.setAge(ageEngineer);
//			engineer.setGender(genderEngineer);
//			engineer.setAddress(addressEngineer);
//			engineer.setSpecialized(specializedEngineer);
			Engineer engineer = new Engineer(nameEngineer, ageEngineer, genderEngineer, addressEngineer,
					specializedEngineer);

//			Lưu trữ 1 mảng để quản lý
//			String[] nameRailway98 = { "Thủy", "Tiến", "Sơn", "Mạnh" };
//			mảng tĩnh==> Số phần tử trong mảng cố định

			staffArrayList.add(engineer);
			break;
		case 2:
			System.out.println("Thêm mới Worker");
//			
			break;
		case 3:
			System.out.println("Thêm mới Employee");
//			
			break;

		}
	}

//	Tìm kiếm theo họ tên
	public void findByName() {
		System.out.println("Tìm kiếm theo họ tên");
	}

//	Hiển thị danh sách cán bộ
	public void showListStaff() {
		System.out.println("Hiển thị thông tin danh sách cán bộ đang có trên hệ thống");
		for (Staff staff : staffArrayList) {
			System.out.println(staff.toString());
		}
	}

//	Xóa cán bộ theo họ tên
	public void deleteStaffByName() {
		// TODO Auto-generated method stub

	}

}
