import java.util.Scanner;

public class BT2 {

	public BT2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 cho tỉ số VND-USD là: 23.500đ, viết chương trình nhập vào số USD
		 và tính ra tiền VND
		 */
		int USD;
		final int VND = 23500;
		Scanner nhap = new Scanner(System.in);
		System.out.print("Hãy nhập số tiền USD: ");
		USD = Integer.parseInt(nhap.nextLine());
		USD = USD * VND;
		System.out.println("Đổi USD -> VND: " + USD);
	}

}
