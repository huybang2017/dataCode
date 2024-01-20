import java.util.Scanner;

public class if_elseLong {

	public if_elseLong() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String name;
		int So_luong;
		float Don_gia;
		float SUM;
		final float Khuyến_mãi_8_phần_trăm = (1 - (8.0f / 100));
		final float Khuyến_mãi_12_phần_trăm = (1 - (12.0f / 100));
		final int QUATE1 = 50;
		final int QUATE2 = 100;
		
		Scanner nhap = new Scanner(System.in);
		
		System.out.print("Nhập tên mặt hàng: ");
		name = nhap.nextLine();
		
		System.out.print("Nhập số lượng hàng: ");
		So_luong = Integer.parseInt(nhap.nextLine());
		
		System.out.print("Nhập đơn giá: ");
		Don_gia = Float.parseFloat(nhap.nextLine());
		
		if ((So_luong > QUATE1) && (So_luong < QUATE2)) {
			SUM = QUATE1 * Don_gia + (So_luong - QUATE1) * Don_gia * Khuyến_mãi_8_phần_trăm;
		}else if (So_luong >= QUATE2) {
			SUM = QUATE2 * Don_gia + (So_luong - QUATE2) * Don_gia * Khuyến_mãi_12_phần_trăm;
		}else {
			SUM = So_luong * Don_gia;
		}
		
		System.out.println("Tổng giá tiền: " + SUM);
	}

}
