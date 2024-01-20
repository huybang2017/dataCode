import java.util.Scanner;

public class TimCanhHuyen {

	public TimCanhHuyen() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int edge1,edge2;
		System.out.println("nhap vao canh goc vuong thu 1");
		Scanner nhap = new Scanner(System.in);
		edge1 = Integer.parseInt(nhap.nextLine());
		System.out.println("nhap vao canh goc vuong thu 2");
		edge2 = Integer.parseInt(nhap.nextLine());
		double edge3= Math.sqrt(edge1*edge1 + edge2*edge2);
		System.out.println("canh huyen la " + edge3);
	}

}
