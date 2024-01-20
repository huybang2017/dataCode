package codelearn.io;

import java.util.Scanner;

public class So_sanh_bang_0 {

	public So_sanh_bang_0() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b;
		Scanner nhap = new Scanner(System.in);
		a = Integer.parseInt(nhap.nextLine());
		b = Integer.parseInt(nhap.nextLine());
		
		if (a != 0 && b != 0) {
			System.out.println("a is not equal to 0 and b is not equal to 0");
		} else {
			System.out.println("a is equal to 0 or b is equal to 0");
		}
	}

}
