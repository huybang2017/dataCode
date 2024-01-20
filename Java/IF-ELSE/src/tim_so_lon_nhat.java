import java.util.Scanner;

public class tim_so_lon_nhat {

	public tim_so_lon_nhat() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b;
		Scanner nhap = new Scanner(System.in);
		
		a = Integer.parseInt(nhap.nextLine());
		b = Integer.parseInt(nhap.nextLine());
		
		if(a>b) {
			System.out.println(a);
		}else if (a<b) {
			System.out.println(b);
		}else {
			System.out.println(a);
		}
	}
	

}
