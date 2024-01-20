package codelearn.io;

import java.util.Scanner;

public class ba_so_lon_nhat {

	public ba_so_lon_nhat() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int max,a,b,c;
		Scanner nhap = new Scanner(System.in);
		
		a = Integer.parseInt(nhap.nextLine());
		b = Integer.parseInt(nhap.nextLine());
		c = Integer.parseInt(nhap.nextLine());
		
		if (a > b && a > c) {
			max = a;
		} else if (b > a && b > c) {
			max = b;
		} else if(c > a && c > b) {
			max = c;
		}else {
			max = a;
		}
		System.out.println(max);

	}

}
