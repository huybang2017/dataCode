import java.util.Scanner;

public class quan_li_tuyen_sinh {
	

	public quan_li_tuyen_sinh() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		
		System.out.println("BÀI TẬP QUẢN LÍ TUYỂN SINH");
		System.out.print("thí sinh thuộc khu vực nào,nhập X nếu không có: ");
		String khu_vuc = nhap.nextLine();
		
		System.out.print("thí sinh thuộc đối tượng nào,nhập 0 nếu không có: ");
		int doi_tuong = Integer.parseInt(nhap.nextLine());
		
		System.out.println("Nhập điểm chuẩn của trường muốn xét tuyển: ");
		float diem_chuan = Float.parseFloat(nhap.nextLine());
		
		System.out.println("Nhập điểm 3 môn xét tuyển");
		System.out.print("môn thứ nhất: ");
		float first_subject = Float.parseFloat(nhap.nextLine());
		System.out.print("môn thứ hai: ");
		float second_subject = Float.parseFloat(nhap.nextLine());
		System.out.print("môn thứ ba: ");
		float third_subject = Float.parseFloat(nhap.nextLine());
		
		float diem_uu_tien = điểm_khu_vực(khu_vuc)+ điểm_đối_tượng(doi_tuong);
		float diem_tong = first_subject+second_subject+third_subject + diem_uu_tien;
		
		if (tính_điểm_liệt(first_subject, second_subject, third_subject) == true) {
			if (diem_tong >= diem_chuan) {
				System.out.println("bạn thi đậu");
			} else {
				System.out.println("bạn thi rớt");
			}
		} else {
			System.out.println("bạn thi rớt");
		}
		
		System.out.println("tổng điểm đạt được: " + diem_tong);
	}
	
	public static float điểm_khu_vực(String khu_vuc) {
		float diem_khu_vuc = 0;
		String a = "A";
		String b = "B";
		String c = "C";
		String khong_thuoc = "X";

		if (khu_vuc.equals(a)) {
			diem_khu_vuc = 2;
		}else if (khu_vuc.equals(b)) {
			diem_khu_vuc = 1;
		}else if(khu_vuc.equals(c)) {
			diem_khu_vuc = 0.5f;
		}else if(khu_vuc.equals(khong_thuoc)) {
			diem_khu_vuc = 0;
		}
		return diem_khu_vuc;
	}
	
	public static float điểm_đối_tượng(int doi_tuong) {
		float diem_doi_tuong = 0;
		if (doi_tuong == 1) {
			diem_doi_tuong = 2.5f;
		} else if (doi_tuong == 2) {
			diem_doi_tuong = 1.5f;
		} else if(doi_tuong == 3) {
			diem_doi_tuong = 1;
		} else if(doi_tuong == 0) {
			diem_doi_tuong = 0;
		}
		return diem_doi_tuong;
	}
	
	public static boolean tính_điểm_liệt(float first_subject,float second_subject,float third_subject ) {
		Boolean diem_liet;
		if (first_subject == 0 || second_subject == 0 || third_subject == 0) {
			diem_liet = false;
		} else {
			diem_liet = true;
		}
		return diem_liet;
	}

}
