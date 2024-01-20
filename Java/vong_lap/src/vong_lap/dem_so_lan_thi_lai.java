package vong_lap;

import java.util.Scanner;

public class dem_so_lan_thi_lai {

	public dem_so_lan_thi_lai() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		int count = 0;
		float diem = 2;
		
		while (diem < 5) {
			System.out.print("nhập điểm thi của bạn: ");
			diem = Float.parseFloat(nhap.nextLine());
			
			if (diem < 5) {
				count++;
			}else {
				System.out.println("chúc mứng bạn đã thi đậu");
			}

		}
		System.out.println(count);

	}
}
