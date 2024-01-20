import java.io.StringReader;
import java.util.Scanner;

public class nháp {

	public nháp() {
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) {
		Scanner nhap = new Scanner(System.in);
		int a = Integer.parseInt(nhap.nextLine());
		int b = Integer.parseInt(nhap.nextLine());
		int c = Integer.parseInt(nhap.nextLine());
		if (a==b || a==c) {
			System.out.println(a);
		} else {
			System.out.println(b);
		}
	}

}
