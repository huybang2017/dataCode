package doituong.sach;

public class book {
	// biến instance
	String ten;
	String moTa;
	int price;
	
	// CONSTRUCTOR
	// vị trí constructor
	// chuột phải source contructor
	// public book(String ten,String moTa,int price) {
	//		this.ten = ten;
	//		this.moTa = moTa;
	//		this.price = price;
	// }
	//	
	
	
	public book(String ten, String moTa, int price) {
		super();
		this.ten = ten;
		this.moTa = moTa;
		this.price = price;
	}



	// hàm instance
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
