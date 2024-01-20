import java.util.Scanner;

public class LuyenTap2 {

	public LuyenTap2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int n,a1,a2,a3,sum;
		Scanner nhap = new Scanner(System.in);
		System.out.println("NHẬP SỐ NGUYÊN DƯƠNG CÓ 3 CHỮ SỐ");
		n = Integer.parseInt(nhap.nextLine());
		a1 = n / 100;
		a2 = (n - (a1 * 100)) / 10;
		a3 = n - (a1 * 100 + a2 * 10);
		sum = a1 + a2 + a3;
		System.out.println("TỔNG KÝ SỐ CỦA 3 CHỮ SỐ " + sum);
	}
}
