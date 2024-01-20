import java.util.Scanner;

public class BT3 {

	public BT3() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		/*
		 Viết phương trình nhập các tọa đọo (xC , yC ) là tâm của một đường tròn  
		 và R là bán kính của đường tròn đó. Nhập vào tọa độ (xM, yM) của điểm M nằm trong		 
		 trên hay nằm ngoài đường tròn. VD:
		 Nhập tọa độ tâm C (xC,yC) 0,5 4,3
		 Nhập bán kính R 7,4
		 Nhập tọa độ M(xM,yM) 3,2 6,5
		 M nằm trong C()
		 */
		float xC,yC,R,xM,yM;
		double CM;
		Scanner nhap = new Scanner(System.in);
		System.out.println("Nhập tọa độ tâm C(xC,yC)");
		xC = Float.parseFloat(nhap.nextLine());
		yC = Float.parseFloat(nhap.nextLine());
		System.out.println("Nhập bán kính R");
		R = Float.parseFloat(nhap.nextLine());
		System.out.println("Nhập tọa độ M(xM,yM)");
		xM = Float.parseFloat(nhap.nextLine());
		yM = Float.parseFloat(nhap.nextLine());
		CM = Math.sqrt((xM - xC)*(xM - xC)+(yM - yC)*(yM - yC));
		
		
		if(CM > R){
			System.out.println("M nằm ngoài C");
		}else if(CM < R) {
			System.out.println("M nằm trong C");
		}else {
			System.out.println("M thuộc C");
		}
	}

}
