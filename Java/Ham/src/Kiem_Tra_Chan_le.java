import java.util.Scanner;

public class Kiem_Tra_Chan_le {

	public Kiem_Tra_Chan_le() {
		// TODO Auto-generated constructor stub
	}

	public static boolean kiem_tra_chan_le(int a) {
		boolean kiemTra;
		if (a % 2 == 0) {
			kiemTra = true;
		} else {
			kiemTra = false;
		}
		return kiemTra;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int soNguyen;
		Scanner nhap = new Scanner(System.in);

		System.out.print("Nhập 1 số nguyên: ");
		soNguyen = Integer.parseInt(nhap.nextLine());

		Boolean ketQua = kiem_tra_chan_le(soNguyen);

		if (ketQua) {
			System.out.println("số chẵn");
		} else {
			System.out.println("số lẻ");
		}
	}

}
