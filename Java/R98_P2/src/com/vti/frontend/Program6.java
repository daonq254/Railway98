package com.vti.frontend;

import java.util.ArrayList;
import java.util.Iterator;

public class Program6 {
	public static void main(String[] args) {
//	mảng động: Số phần tử không cố định
		ArrayList<String> nameStrings = new ArrayList<String>();
		nameStrings.add("Sơn");
		nameStrings.add("Nam");
		nameStrings.add("Bình");
		nameStrings.add("Bắc");
//		
//		
//		
		nameStrings.add("Thêm");

//		for (int i = 0; i < nameStrings.size(); i++) {
//			System.out.println(nameStrings.get(i));
//		}
//		
//		for (String name : nameStrings) {
//			System.out.println(name);
//		}
//	iterator
		Iterator<String> iterator = nameStrings.iterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}

//		
//		Person person = new Person();
//		person.setId(1);
//		person.setEmail("person1@gmail.com");
	}
}
