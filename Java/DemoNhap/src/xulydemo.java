import java.util.Scanner;

public class xulydemo {

	public xulydemo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("Demo lenh nhap");
		Scanner scan = new Scanner(System.in);	// bat buoc phai co
		System.out.println("Vui long nhap vao mot so");
		String chuoi = scan.nextLine();			// lấy ra chuỗi nhập
		System.out.println("SO BAN VAO NHAP LA " + chuoi);

	}

}
