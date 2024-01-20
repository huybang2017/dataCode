import java.util.Scanner;

public class SoLonNhat {

	public SoLonNhat() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int d1,d2,bigger;
		Scanner nhap = new Scanner(System.in);
		System.out.print("Nhập số thứ nhất: ");
		d1 = Integer.parseInt(nhap.nextLine());
		
		System.out.print("Nhập số thứ hai: ");
		d2 = Integer.parseInt(nhap.nextLine());
		
		if(d1 > d2){
			bigger = d1;	
		}else {
			bigger = d2;
		}
		System.out.println("Số lớn hơn là: " + bigger);
	}

}
