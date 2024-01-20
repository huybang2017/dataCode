import java.util.Scanner;

public class Diem_TB {

	public Diem_TB() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String ho_ten;
		float toan,ly,hoa,Diem_TB;
		final float MUC_GIOI = 8.5f;
		final float MUC_KHA = 6.5f;
		final float MUC_TB = 5.0f;
		
		Scanner nhap = new Scanner(System.in);
		
		System.out.print("Nhập họ và tên: ");
		ho_ten = nhap.nextLine();
		
		System.out.print("Nhập điểm toán: ");
		toan = Float.parseFloat(nhap.nextLine());
		
		System.out.print("Nhập điểm ly: ");
		ly = Float.parseFloat(nhap.nextLine());
		
		System.out.print("Nhập điểm hóa: ");
		hoa = Float.parseFloat(nhap.nextLine());
		
		Diem_TB = (1.0f * (toan + ly + hoa)) / 3;
		
		if (Diem_TB >= MUC_GIOI) {
			System.out.println("Học sinh đạt loại giỏi");
		} else if((Diem_TB >= MUC_KHA) && (Diem_TB < MUC_GIOI )) {
			System.out.println("Học sinh đạt loại khá");
		} else if((Diem_TB >= MUC_TB) && (Diem_TB < MUC_KHA)) {
			System.out.println("Học sinh đạt loại trung bình");
		} else if (Diem_TB < MUC_TB) {
			System.out.println("Học sinh đạt loại yếu");
		}
	}

}
