package Entity;

import java.util.Scanner;

public class PhieuHoaDon {
	static Scanner input = new Scanner(System.in);
	private String ID_HD;
	private String TongHD;
	private String NgayLap;
	private String PhuongThucTT;
	private String ID_KH;
	private String ID_NV;

	public PhieuHoaDon() {
	}

	public PhieuHoaDon(String ID_HD, String TongHD, String NgayLap, String PhuongThucTT, String ID_KH, String ID_NV) {
		this.ID_HD = ID_HD;
		this.TongHD = TongHD;
		this.NgayLap = NgayLap;
		this.PhuongThucTT = PhuongThucTT;
		this.ID_NV = ID_NV;
		this.ID_KH = ID_KH;
	}

	public String getID_HD() {
		return ID_HD;
	}

	public void setID_HD(String ID_HD) {
		this.ID_HD = ID_HD;
	}

	public String getTongHD() {
		return TongHD;
	}

	public void setTongHD(String TongHD) {
		this.TongHD = TongHD;
	}

	public String getNgayLap() {
		return NgayLap;
	}

	public void setNgayLap(String NgayLap) {
		this.NgayLap = NgayLap;
	}

	public String getPhuongThucTT() {
		return PhuongThucTT;
	}

	public void setPhuongThucTT(String PhuongThucTT) {
		this.PhuongThucTT = PhuongThucTT;
	}

	public String getID_NV() {
		return ID_NV;
	}

	public void setID_NV(String ID_NV) {
		this.ID_NV = ID_NV;
	}

	public String getID_KH() {
		return ID_KH;
	}

	public void setID_KH(String ID_KH) {
		this.ID_KH = ID_KH;
	}

	public void nhaphoadon() {
		System.out.print("Nhap Tong Hoa Don (Vd: 500.000): ");
		setTongHD(input.nextLine());
		System.out.print("Nhap Phuong Thuc Thanh Toan (Vd: Tien mat, Quet the, Online, v.v.): ");
		setPhuongThucTT(input.nextLine());
		System.out.print("Nhap ID Khach Hang (Vd: KH??): ");
		setID_KH(input.nextLine());
		System.out.print("Nhap ID Nhan Vien Lap Hoa Don (Vd: NV??): ");
		setID_NV(input.nextLine());
	}
}
