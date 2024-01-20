package switch_case;

import java.util.Scanner;

public class thang_bn_ngay {

	public thang_bn_ngay() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int month;
		int day = 0;
		
		Scanner nhap = new Scanner(System.in);
		month = Integer.parseInt(nhap.nextLine());
		
		switch (month) {
		case 1:
			day = 31;
			break;
		case 2:
			day = 28;
			break;
		case 3:
			day = 31;
			break;
		case 4:
			day = 30;
			break;
		case 5:
			day = 31;
			break;
		case 6:
			day = 30;
			break;
		case 7:
			day = 31;	
			break;
		case 8:
			day =31;
			break;
		case 9:
			day = 30;
			break;
		case 10:
			day = 31;
			break;
		case 11:
			day = 30;
			break;
		case 12:
			day = 31;
			break;
		default:
			System.out.println("Vui lòng nhập tháng hợp lệ từ 1 đến 12");
		}
		System.out.println(day);
	}

}
