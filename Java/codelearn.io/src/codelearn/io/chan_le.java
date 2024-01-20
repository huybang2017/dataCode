package codelearn.io;

import java.util.Scanner;

public class chan_le {

	public chan_le() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner nhap = new Scanner(System.in);
		int n = Integer.parseInt(nhap.nextLine());
		
		if (n % 2 == 0) {
			System.out.println("n is an even number");
		} else {
			System.out.println("n is an odd number");
		}
	}

}
