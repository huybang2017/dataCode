import java.util.Scanner;

public class ba_so_nguyen {

	public ba_so_nguyen() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1,num2,num3;
		Scanner nhap = new Scanner(System.in);
		
		System.out.print("nhập số thứ 1: ");
		num1 = Integer.parseInt(nhap.nextLine());
		
		System.out.print("nhập số thứ 2: ");
		num2 = Integer.parseInt(nhap.nextLine());
		
		System.out.print("nhập số thứ 3: ");
		num3 = Integer.parseInt(nhap.nextLine());
		
		if (num1 > num2 && num1 > num3) {
			if (num2 > num3) {
				System.out.print(num3 +" "+ num2 +" "+ num1);
			}else if (num2 < num3) {
				System.out.print(num2 +" "+ num3 +" "+ num1);
			}
		} else if(num2 > num1 && num2 > num3) {
			if (num1 > num3) {
				System.out.print(num3 +" "+ num1 +" "+ num2);
			} else if(num3 > num1) {
				System.out.print(num1 +" "+ num3 +" "+ num2);
			}
		} else if (num3 > num1 && num3 > num2) {
			if (num1 > num2) {
				System.out.print(num2 +" "+ num1 +" "+ num3);
			}else if (num2 > num1) {
				System.out.print(num1 +" "+ num2 +" "+ num3);
			}
		}else {
			System.out.print("Sắp xếp theo thứ tự tăng dần: " + num1 +" "+ num2 +" "+ num3);
		}
	
	
	}

}
