import java.util.Scanner;

public class chuvi_dientich_hinhtron {
	
	static final Float PI = 3.14f;
	public chuvi_dientich_hinhtron() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner nhap = new Scanner(System.in);
		Float ban_kinh = Float.parseFloat(nhap.nextLine());
		
		double chu_vi =  ban_kinh * 2 * PI ;
		double dien_tich = ban_kinh * ban_kinh * PI;
		
		System.out.printf ("%.3f",chu_vi + " " + "%.3f",dien_tich);
		
	}

}
