import java.util.Scanner;

public class LuongNhanVien {

	public LuongNhanVien() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		final int STANDARD_HOUR = 40;
		final float RATE_OF = 1.5f;
		int time_work;
		float rate;
		float payment;
		Scanner nhap = new Scanner(System.in);

		System.out.print("Nhập số giờ làm: ");
		time_work = Integer.parseInt(nhap.nextLine());

		System.out.print("Nhập lương theo giờ ");
		rate = Float.parseFloat(nhap.nextLine());

		if (time_work > STANDARD_HOUR) {
			payment = (float) (STANDARD_HOUR * rate + RATE_OF * (time_work - STANDARD_HOUR) * rate);
		} else {
			payment = time_work * rate;
		}

		System.out.println("lương của nhân viên là: " + payment);
	}

}
