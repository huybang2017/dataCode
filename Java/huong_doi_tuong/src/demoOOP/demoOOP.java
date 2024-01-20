package demoOOP;

public class demoOOP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinhVien sinhVienA = new SinhVien("huy","10","25-05-2004");
		System.out.println("kiểm tra: " + sinhVienA.ten);
		
		GiaoVien giaoVienA = new GiaoVien("thao", "khong co lop", "02-03-1992");
		giaoVienA.tinhLuong();

		HieuTruong hieuTruongB = new HieuTruong("Tung", "khong co lop", "02-03-1987");
//		System.out.println(hieuTruongB.ten);
		hieuTruongB.tinhLuong();
	}
}
class GiaoVien extends SinhVien{
	String lopGiangDay;
	String chucVu;
	
	public GiaoVien(String ten, String lop, String ngaySinh) {
		// TODO Auto-generated constructor stub
		super(ten,lop,ngaySinh);
	}
	
	public void tinhLuong() {
		// TODO Auto-generated method stub
		System.out.println("20tr");
	}
}

class HieuTruong extends GiaoVien{
	String quanLy;
	public HieuTruong(String ten, String lop, String ngaySinh) {
		// TODO Auto-generated constructor stub
		super(ten, lop, ngaySinh);
	}
	
	@Override
	public void tinhLuong() {
		// TODO Auto-generated method stub
		super.tinhLuong();
		System.out.println("40tr");
	}
}

class SinhVien {
	String ten;
	String lop;
	String ngaySinh;

	public SinhVien(String ten, String lop, String ngaySinh) {
		this.ten = ten;
		this.lop = lop;
		this.ngaySinh = ngaySinh;
	}

	public SinhVien() {
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

}