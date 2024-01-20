import java.util.Scanner;

public class thue_thu_nhap_ca_nhan {

	public thue_thu_nhap_ca_nhan() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		
		System.out.print("Nhập họ và tên: ");
		String ho_ten = nhap.nextLine();

		System.out.print("Nhập số người phụ thuộc: ");
		int so_nguoi_phu_thuoc = Integer.parseInt(nhap.nextLine());
		
		System.out.print("Nhập tổng thu nhập trong năm: ");
		float tong_thu_nhap = Float.parseFloat(nhap.nextLine());
		
		Double thue_phai_tra = thue_ca_nhan(so_nguoi_phu_thuoc, tong_thu_nhap);
		System.out.println("tiền thuế phải trả là: " + thue_phai_tra);
	}
	public static Double thue_ca_nhan(int so_nguoi_phu_thuoc, float tong_thu_nhap) {
		float thu_nhap_chiu_thue = tong_thu_nhap - 4000000 - (so_nguoi_phu_thuoc * 1600000);
		double thue_ca_nhan = 0;
		if (thu_nhap_chiu_thue > 0 && thu_nhap_chiu_thue <= 60000000) {
			thue_ca_nhan = thu_nhap_chiu_thue * 0.05f;
		} else if(thu_nhap_chiu_thue > 60000000 && thu_nhap_chiu_thue <= 120000000) {
			thue_ca_nhan = 60000000 * 0.05f + (thu_nhap_chiu_thue - 60000000) * 0.1f;
		} else if (thu_nhap_chiu_thue > 120000000 && thu_nhap_chiu_thue <= 216000000) {
			thue_ca_nhan = 60000000 * 0.05f + 60000000 * 0.1f +(thu_nhap_chiu_thue - 120000000) * 0.15f; 
		} else if (thu_nhap_chiu_thue > 216000000 && thu_nhap_chiu_thue <= 384000000) {
			thue_ca_nhan = 60000000 * 0.05f + 60000000 * 0.1f + 96000000 * 0.15f + (thu_nhap_chiu_thue - 216000000) * 0.2f;
		} else if (thu_nhap_chiu_thue > 384000000 && thu_nhap_chiu_thue <= 624000000) {
			thue_ca_nhan = 60000000 * 0.05f + 60000000 * 0.1f + 96000000 * 0.15f + 168000000 * 0.2f + (thu_nhap_chiu_thue - 384000000) * 0.25f;
		}else if (thu_nhap_chiu_thue > 624000000 && thu_nhap_chiu_thue <=960000000) {
			thue_ca_nhan = 60000000 * 0.05f + 60000000 * 0.1f + 96000000 * 0.15f + 168000000 * 0.2f + 240000000 * 0.25f + (thu_nhap_chiu_thue - 624000000) * 0.3f;
		}else {
			thue_ca_nhan = 60000000 * 0.05f + 60000000 * 0.1f + 96000000 * 0.15f + 168000000 * 0.2f + 240000000 * 0.25f + 336000000 * 0.3f + (thu_nhap_chiu_thue - 960000000)*0.35;
		}
		return thue_ca_nhan;
	}

}
