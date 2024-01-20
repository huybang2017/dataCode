package codelearn.io;

import java.util.Scanner;

public class giam_tang_dan {

	public giam_tang_dan() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
	
		Scanner nhap = new Scanner(System.in);
		
		a = Integer.parseInt(nhap.nextLine());
		b = Integer.parseInt(nhap.nextLine());
		c = Integer.parseInt(nhap.nextLine());
		
		if (a <= b && b <= c) {
			System.out.println("increasing");
		} else if (a >= b && b >= c) {
			System.out.println("decreasing");
		}else {
			System.out.println("neither increasing nor decreasing order");
		}
	}

}
