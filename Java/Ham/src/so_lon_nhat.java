import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class so_lon_nhat {

	public so_lon_nhat() {
		// TODO Auto-generated constructor stub
	}
	public static int max(int a, int b, int c) {
		int max;
		if(a > b && a > c) {
			max = a;
		}else if (b > a && b > c) {
			max = b;
		}else if (c > b && c > a) {
			max = c;
		}else {
			max = a;
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1,num2,num3;
		
		Scanner nhap = new Scanner(System.in);
		
		System.out.print("Nhập số thứ nhất: ");
		num1 = Integer.parseInt(nhap.nextLine());
		
		System.out.print("Nhập số thứ hai: ");
		num2 = Integer.parseInt(nhap.nextLine());
		
		System.out.print("Nhập số thứ ba: ");
		num3 = Integer.parseInt(nhap.nextLine());
		
		int ketQua = max(num1,num2,num3);
		System.out.println("kết quả là: " + ketQua);
	}

}
