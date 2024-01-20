package codelearn.io;

import java.util.Scanner;

public class Nguyen_duong_am {

	public Nguyen_duong_am() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner nhap = new Scanner(System.in);
		int n = Integer.parseInt(nhap.nextLine());
		
		if (n > 0) {
			System.out.println("n is a positive number");
		} else if (n < 0) {
			System.out.println("n is a negative number");
		}else {
			System.out.println("n is equal to 0");
		}
		
	}

}
