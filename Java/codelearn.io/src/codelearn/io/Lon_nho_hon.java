package codelearn.io;

import java.util.Scanner;

public class Lon_nho_hon {

	public Lon_nho_hon() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b;
		Scanner nhap = new Scanner(System.in);
		
		a = Integer.parseInt(nhap.nextLine());
		b = Integer.parseInt(nhap.nextLine());
		
		if (a >= b) {
			System.out.println("a is greater than or equal to b");
		} else {
			System.out.println("a is smaller than b");
		}
	}

}
