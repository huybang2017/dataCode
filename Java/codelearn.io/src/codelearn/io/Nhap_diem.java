package codelearn.io;

import java.util.Scanner;

public class Nhap_diem {

	public Nhap_diem() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner nhap = new Scanner(System.in);
		int score = Integer.parseInt(nhap.nextLine());
		
		if ((score <= 10) && (score >= 0)) {
			System.out.println("The score is valid");
		} else {
			System.out.println("The score is not valid");
		}
	}

}
