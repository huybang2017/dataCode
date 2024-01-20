import java.util.Scanner;

public class BT1 {

	public BT1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1,num2,num3,num4,num5;
		float TBC;
		final float HangSo = 5;
		Scanner nhap = new Scanner(System.in);
		System.out.println("nhap so thu 1: ");
		num1 = Integer.parseInt(nhap.nextLine());
		System.out.println("nhap so thu 2: ");
		num2 = Integer.parseInt(nhap.nextLine());
		System.out.println("nhap so thu 3: ");
		num3 = Integer.parseInt(nhap.nextLine());
		System.out.println("nhap so thu 4: ");
		num4 = Integer.parseInt(nhap.nextLine());
		System.out.println("nhap so thu 5: ");
		num5 = Integer.parseInt(nhap.nextLine());
		num4 += num5;
		TBC = (1.0f)*(num1 + num2 + num3 + num4) / HangSo;
		System.out.println("giá trị trung bình của 5 số: " + TBC);
	}

}
