package com.vti.frontend;

import java.util.SortedSet;
import java.util.TreeSet;

public class Program5_Treeset {
	public static void main(String[] args) {
		SortedSet<String> nameTreeSet = new TreeSet<String>();

		nameTreeSet.add("Bảo");
		nameTreeSet.add("Nam");
		nameTreeSet.add("Thanh");
		nameTreeSet.add("Huy");
		nameTreeSet.add("An");
		nameTreeSet.add("Bình");
		nameTreeSet.add("Bình");
		nameTreeSet.add("Bình");
		nameTreeSet.add("Bình");
		nameTreeSet.add("Thức");
		nameTreeSet.add("Lan");

		for (String name : nameTreeSet) {
			System.out.println(name);
		}

	}
}
