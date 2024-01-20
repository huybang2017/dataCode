import java.util.Scanner;

public class PhiLaiSuatNganHang {

	public PhiLaiSuatNganHang() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		float CreditCardBalance,payment,balnace;
		float pently = 0;
		Scanner nhap = new Scanner(System.in);
		System.out.print("Nhập số dư tài khoản: ");
		CreditCardBalance = Float.parseFloat(nhap.nextLine());
		System.out.print("Nhập số tiền bạn đã thanh toán: ");
		payment = Float.parseFloat(nhap.nextLine());
		balnace = CreditCardBalance - payment;
		if(balnace > 0) {
			pently = balnace *1.5f/100;
		}
		System.out.println("số tiền phạt phải trả là: " + pently);
	}
}
