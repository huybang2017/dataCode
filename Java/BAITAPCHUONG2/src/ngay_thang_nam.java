import java.util.Scanner;

public class ngay_thang_nam {

	public ngay_thang_nam() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int d,m,y;
		
		Scanner nhap = new Scanner(System.in);
		
		System.out.print("Nhập ngày vào: ");
		d = Integer.parseInt(nhap.nextLine());
		System.out.print("Nhập tháng vào: ");
		m = Integer.parseInt(nhap.nextLine());
		System.out.print("Nhập năm vào: ");
		y = Integer.parseInt(nhap.nextLine());
		
		if (d < 1 || d > 31) {
			System.out.println("không hợp lệ");
		}
		if (m < 1 || m > 12) {
			System.out.println("không hợp lệ");
		}
		
		switch (m) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			d = 31;
			break;
		case 2:
			if ((y % 4 == 0 && y % 100 !=0) || (y % 400 == 0)) {
				d = 29;
			} else {
				d = 28;
			}
		default:
			d = 30;
		}
		
		int nd,nm,ny;
		nd = d;
		nm = m;
		ny = y;
		
		if (nd > 0 && nd < 30) {
			nd += 1;
		}else if (m = 1) {
			
		}
		
		
	}

}
