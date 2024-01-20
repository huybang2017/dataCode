package vong_lap;

import java.util.Scanner;

public class Tong_lon_hon {

	public Tong_lon_hon() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		float tong = Tong(nhap);
		System.out.println(tong);
	}
	public static float Tong(Scanner nhap) {
		float tong = 0;
		int scan = 1;
		while (scan > 0) {
			System.out.println("hãy nhập số lớn hơn 0 . Nhập 0 để dừng");
			scan = Integer.parseInt(nhap.nextLine());
			
			if (scan > 0) {
				tong += scan;
			} else {
				System.out.println("chương trình dừng lại");
			}
		}
		return tong;
	}
	
	public static float tong_flag(Scanner nhap) {
		float tong = 0;
		Boolean flag = true;
		while (flag) {
			System.out.println("hãy nhập số lớn hơn 0 . Nhập 0 để dừng");
			int scan = Integer.parseInt(nhap.nextLine());
			
			if (scan > 0) {
				tong += scan;
			} else {
				flag = false;
			}
		}
		return tong;
	}
}
