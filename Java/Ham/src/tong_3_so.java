import java.util.Scanner;

public abstract class tong_3_so {

	public tong_3_so() {
		// TODO Auto-generated constructor stub
	}

	public static int tinhTong(int a, int b, int c) {
		int sum = a + b + c;
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1, num2, num3;
		Scanner nhap = new Scanner(System.in);
		
		System.out.print("Nhập số thứ nhất: ");
		num1 = Integer.parseInt(nhap.nextLine());
		
		System.out.print("Nhập số thứ hai: ");
		num2 = Integer.parseInt(nhap.nextLine());
		
		System.out.print("Nhập số thứ ba: ");
		num3 = Integer.parseInt(nhap.nextLine());
		
		int Tong = tinhTong(num1, num2, num3);
		System.out.println("tổng ba số là: " + Tong);
	}

}
