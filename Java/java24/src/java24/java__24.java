package java24;

import java.util.Scanner;

public class java__24 {

	public java__24() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		chuyển đổi số nguyên thành số nhị phân
		int n;
		Scanner nhap = new Scanner(System.in);
		System.out.println("nhap so n > 0");
		n = Integer.parseInt(nhap.nextLine());
		String nhi_phan = "";
		while (n > 0) {
			nhi_phan = (n % 2) + nhi_phan;
			n /= 2;
		}
		System.out.println(nhi_phan);
//		int n;
//		int dem = 0;
//		Scanner nhap = new Scanner(System.in);
//		System.out.println("nhap so n > 0");
//		n = Integer.parseInt(nhap.nextLine());
//		int nhi_phan = 0;
//		int chia_het = n;
//		while (chia_het > 0) {
//			chia_het /= 2;
//			dem++;
//		}
//		System.out.println(dem);
//		int a[] = new int[dem];
//		for (int i = dem - 1; i >= 0; i--) {
//			nhi_phan = (n % 2) + nhi_phan;
//			n/=2;
//			System.out.print(a[i]);
//
//		}
//		Scanner nhap = new Scanner(System.in);
//		int n;
//		System.out.print("nhap n: ");
//		n = Integer.parseInt(nhap.nextLine());
//		String a[] = new String[n];
//		for (int i = 0; i < a.length; i++) {
//			System.out.println("nhap mang chuoi a[" + i + "]");
//			a[i] = nhap.nextLine();
//		}
//		String timtenlonnhat = timtendaiNhat(a);
//		System.out.println(timtenlonnhat);
	}

//	public static String timtendaiNhat(String ten[]) {
//		String ten_dai_nhat = ten[0];
//		for (int i = 1; i < ten.length; i++) {
//			if (ten_dai_nhat.length() < ten[i].length()) {
//				ten_dai_nhat = ten[i];
//			}
//		}
//		return ten_dai_nhat;
//	}
}
