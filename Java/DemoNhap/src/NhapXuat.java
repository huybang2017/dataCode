import java.util.Scanner;

public class NhapXuat {

	public NhapXuat() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("hay nhap so thu nhat");
		String value1 = scan.nextLine();
		System.out.println("hay nhap so thu hai");
		String value2= scan.nextLine();
		int sum1 = Integer.parseInt(value1);
		int sum2 = Integer.parseInt(value2);
		int tong = sum1 + sum2;
		System.out.println("tong hai so " + tong);
	}
}
