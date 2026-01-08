package com.vti.frontend;

import com.vti.entity.Trainee;

public class Program7_generic {
	public static void main(String[] args) {
//		VTI
//		Ngắn hạn:code 1 2 3 int
//		Dài hạn: code "VTI001", "VTI002",.. String

//		Trainee trainee1 = new Trainee();
//		trainee1.setCode(1);
//		trainee1.setName("T1");
//
//		Trainee trainee2 = new Trainee();
//		trainee2.setCode(2);
//		trainee2.setName("T2");

//		Trainee<Integer> trainee1 = new Trainee<Integer>();
//		trainee1.setCode(1);
//		trainee1.setName("T1");
//
//		Trainee<Integer> trainee2 = new Trainee<Integer>();
//		trainee2.setCode(2);
//		trainee2.setName("T2");
//
//		Trainee<String> trainee3 = new Trainee<String>();
//		trainee3.setCode("VTI003");
//		trainee3.setName("T3");
//
//		Trainee<Float> trainee5 = new Trainee<Float>();
//		trainee5.setCode(0.001f);
//		trainee5.setName("T5");
//
//		System.out.println(trainee1.toString());
//		System.out.println(trainee2.toString());
//		System.out.println(trainee3.toString());
//		System.out.println(trainee5.toString());

		Trainee<Integer, String> trainee1 = new Trainee<Integer, String>();
		trainee1.setCode(1);
		trainee1.setName("DAONQ");

	}
}
