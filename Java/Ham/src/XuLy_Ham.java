import java.util.Scanner;

public class XuLy_Ham {

	public XuLy_Ham() {
		// TODO Auto-generated constructor stub
	}
	public static int tinhTong (int a,int b) {
		int tong = a + b;
		return tong;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x;
		int y;
		
		Scanner nhap = new Scanner(System.in);
		
		System.out.print("Nhập số thứ nhất: ");
		x = Integer.parseInt(nhap.nextLine());
		
		System.out.print("Nhập số thứ hai: ");
		y = Integer.parseInt(nhap.nextLine());
		
		int ketQua = tinhTong(x, y);
		System.out.println("kết quả là: " + ketQua);
	}

}
