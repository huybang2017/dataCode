package codelearn.io;

import java.util.Scanner;

public class x_y_nam_dau {

	public x_y_nam_dau() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0;
		int y = 0;
		Scanner nhap = new Scanner(System.in);
		
		x = Integer.parseInt(nhap.nextLine());
		y = Integer.parseInt(nhap.nextLine());
		
		if (x != 0 && y != 0) {
			if (x > 0 && y > 0) {
				System.out.println("This point lies in the First quadrant");
			} else if (x < 0 && y > 0){
				System.out.println("This point lies in the Second quadrant");
			} else if (x < 0 && y < 0){
				System.out.println("This point lies in the Third quadrant");
			} else {
				System.out.println("This point lies in the Fourth quadrant");
			}
		}
	}

}
