import java.util.Scanner;

public class nam_nhuan {

	public nam_nhuan() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
			/*
			 * bước 1 : khai báo biến day , month , year , flag ,top (top dùng để lưu tối đa ngày
			 * trong tháng)
			 * bước 2 : in nhập day month year
			 * bước 3
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * */
			int day,month,year;
			Boolean flag = true;
			int top = 0;
			int dayOfWeek;
			
			Scanner nhap = new Scanner(System.in);
			
			System.out.print("Vui lòng nhập ngày:  ");
			day = Integer.parseInt(nhap.nextLine());
			
			System.out.print("Vui lòng nhập tháng:  ");
			month = Integer.parseInt(nhap.nextLine());
	
			System.out.print("Vui lòng nhập năm:  ");
			year = Integer.parseInt(nhap.nextLine());
			
			if (year < 1582) {
				flag = false;
			}
			if (month < 1 || month > 12) {
				flag = false;
			}
			
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				top = 31;
				break;
			case 2:
				if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
					top = 29;
				}else {
					top = 28;
				}
				break;
			default:
				day =  30;
			}
			
			if (day < 1 || day > top) {
				flag = false;
			}
			
			if (!flag) {
				System.out.println("Không hợp lệ");
			} else {
				int a = (14 - month) / 12;
				year -= a;
				month += 12*a - 2;
				dayOfWeek = (day + year + year/4 - year/100 + year/400 + (31 * month)/12) % 7;
				if (dayOfWeek == 0) {
					System.out.println("chủ nhật");
				} else {
					System.out.println("thứ " + (dayOfWeek + 1));
				}
			}
			
	}

}
