package vong_lap;

import java.util.Scanner;

public class du_an_tinh_toan {

	public du_an_tinh_toan() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		System.out.print("Nhập số đầu tiên: ");
		int first_num = Integer.parseInt(nhap.nextLine());
		System.out.print("Nhập số thứ hai: ");
		int second_num = Integer.parseInt(nhap.nextLine());
		float ket_qua = xuly_menu(nhap, first_num, second_num);
		System.out.println("KẾT QUẢ LÀ: " + ket_qua);
	}
	public static int in_menu(Scanner nhap) {
		System.out.println("Nhập 1 : tính tổng "
				+ "Nhập 2 : tính hiệu\n"
				+ "Nhập 3 : tính nhân\n"
				+ "Nhập 4 : tính chia\n"
				+ "Nhập 0 : thoát\n"
				+ "tất cả nhập khac đều hợp lệ\n");
		int scan = Integer.parseInt(nhap.nextLine());
		return scan;
	}
	public static float xuly_menu(Scanner nhap, int first_num , int second_num) {
		float ket_qua = 0;
		Boolean flag = true;
		do {
			int xu_li = in_menu(nhap);
			if (xu_li >=0 && xu_li <=4) {
				if (xu_li == 1) {
					ket_qua = first_num + second_num;
				} else if (xu_li == 2) {
					if (first_num >= second_num) {
						ket_qua = first_num - second_num;
					} else {
						ket_qua = second_num - first_num;
					}
				} else if (xu_li == 3){
					ket_qua = first_num * second_num;
				} else if (xu_li == 4) {
					ket_qua = first_num / second_num;
				} else if(xu_li == 0) {
					flag = false;
					System.out.println("xác nhận thoát");
				}
			} else {
				System.out.println("Nhập không hợp lệ\n"
						+ "XIN VUI LÒNG NHẬP LẠI");
			}
		} while (flag = false);
		return ket_qua;
	}

}
