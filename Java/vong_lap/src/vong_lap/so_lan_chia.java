package vong_lap;

import java.util.Scanner;

public class so_lan_chia {

	public so_lan_chia() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		Scanner nhap = new Scanner(System.in);
		Float num = Float.parseFloat(nhap.nextLine());
		
		while (num > 1) {
			count++;
			num = num /2;
		}
		
		System.out.println(count);
	}

}
