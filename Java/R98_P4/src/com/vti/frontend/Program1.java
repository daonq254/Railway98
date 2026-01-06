package com.vti.frontend;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Program1 {
	public static void main(String[] args) {
// Lan, Thủy, Sơn, Tiến
		List<String> nameArrayList = new ArrayList<String>();
		nameArrayList.add("Lan");
		nameArrayList.add("Thủy");
		nameArrayList.add("Sơn");
		nameArrayList.add("Tiến");
//
		System.out.println("-- foreach--");
		for (String name : nameArrayList) {
			System.out.println(name);
		}

//		
		System.out.println("-- iterator--");
		Iterator<String> iterator = nameArrayList.iterator();
		while (iterator.hasNext()) {
			String name = iterator.next();
			System.out.println(name);
		}
//		
		System.out.println("-------------");
		System.out.println(nameArrayList.get(0));
		System.out.println("-------------");
		System.out.println(nameArrayList.contains("Thủy_1"));
		System.out.println("-------------");
		System.out.println(nameArrayList.indexOf("Sơn"));
	}
}
