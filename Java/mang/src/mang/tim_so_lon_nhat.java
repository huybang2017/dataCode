package mang;

import java.util.Scanner;

public class tim_so_lon_nhat {

	public tim_so_lon_nhat() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner nhap = new Scanner(System.in);
		int n;
		System.out.print("nhap n: ");
		n = Integer.parseInt(nhap.nextLine());
		String a[] = new String[n];
		String[] nhap_mang = nhap_mang(a, nhap);
		String timtenlonnhat = timtendaiNhat(a);
		System.out.println(timtenlonnhat);
	}
	public static String[] nhap_mang(String a[],Scanner nhap) {
		for (int i = 0; i < a.length; i++) {
			System.out.println("nhap mang chuoi a[" + i + "]");
			a[i] = nhap.nextLine();
		}
		return a;
	}
	
	
	public static String timtendaiNhat(String ten[]) {
		String ten_dai_nhat = ten[0];
		for (int i = 1; i < ten.length; i++) {
			if (ten_dai_nhat.length() < ten[i].length()) {
				ten_dai_nhat = ten[i];
			}
		}
		return ten_dai_nhat;
	}
}
