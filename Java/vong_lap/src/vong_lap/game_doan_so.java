package vong_lap;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class game_doan_so {

	public game_doan_so() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		DoanSo(nhap);
	}
	public static void DoanSo(Scanner Scan) {
		int So_bi_mat = (int) (Math.random() * 99 + 1);
		int nhap;
		do {
			System.out.println("Vui lòng nhập 1 số: ");
			nhap = Integer.parseInt(Scan.nextLine());
			
			if (So_bi_mat > nhap) {
				System.out.println("Vui lòng nhập số lớn hơn!!!!!");
			} else if (So_bi_mat < nhap) {
				System.out.println("Vui lòng nhập số bé hơn!!!!!");
			} else {
				System.out.println("winner game over");
			}
		} while (So_bi_mat != nhap);
	}

}
