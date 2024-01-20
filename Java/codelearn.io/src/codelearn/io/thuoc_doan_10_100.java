package codelearn.io;

import java.util.Scanner;

public class thuoc_doan_10_100 {

	public thuoc_doan_10_100() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner nhap = new Scanner(System.in);
		int So_Nguyen = Integer.parseInt(nhap.nextLine());
		
		if (So_Nguyen >=10 && So_Nguyen <=100) {
			System.out.println(So_Nguyen + " is in the range [10, 100]");
		} else {
			System.out.println(So_Nguyen + " is not in the range [10, 100]");	
		}
	}

}
