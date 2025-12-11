package com.vti.frontend;

import com.vti.backend.Math;

public class Program5 {
//	Hàm main
	public static void main(String[] args) {
		Math math = new Math();

		math.sum();
		math.minus();

//		sum();
//
//		minus();
//

		int c = 6;
		int d = 7;
		int resutl = math.multiply(c, d);
		System.out.println("Kết quả phép nhân 2 số c,d là: " + resutl);
	}

}
