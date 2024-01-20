package codelearn.io;

import java.util.Scanner;

public class ten_giong_nhau {

	public ten_giong_nhau() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a,b;
		Scanner nhap = new Scanner(System.in);
		
		a = nhap.nextLine();
		b = nhap.nextLine();
		
		if (a.equals(b)) {
			System.out.println("two people have the same name");
		} else {
			System.out.println("two people don't have the same name");
		}
	}

}
