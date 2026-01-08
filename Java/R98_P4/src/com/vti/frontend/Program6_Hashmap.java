package com.vti.frontend;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Program6_Hashmap {
	public static void main(String[] args) {
		Map<String, String> nameStudentHashMap = new HashMap<String, String>();

		nameStudentHashMap.put("VTI001", "Hoàng");
		nameStudentHashMap.put("VTI002", "Lâm");
		nameStudentHashMap.put("VTI003", "Thịnh");
		nameStudentHashMap.put("VTI004", "Hương");
		nameStudentHashMap.put("VTI005", "Thủy");

//		Hiển thị các phần tử trong Map
		for (Entry<String, String> entry : nameStudentHashMap.entrySet()) {
			System.out.println(entry.getKey() + "     " + entry.getValue());
		}

//		Sử dung iterator để hiển thị thông tin
		System.out.println("--------------Iterator-------------");
		Iterator<Entry<String, String>> iterator = nameStudentHashMap.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey() + "     " + entry.getValue());

		}
//
		System.out.println("---------------------------");
		System.out.println(nameStudentHashMap.get("VTI003"));
	}
}
