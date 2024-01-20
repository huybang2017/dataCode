/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QL_Thongtin;

/**
 *
 * @author ldkhai
 */
public class Tinhthanh {
	private String maTinh;
	private String tenTinh;

	public String getMaTinh() {
		return maTinh;
	}

	public void setMaTinh(String maTinh) {
		this.maTinh = maTinh;
	}

	public String getTenTinh() {
		return tenTinh;
	}

	public void setTenTinh(String tenTinh) {
		this.tenTinh = tenTinh;
	}

	public Tinhthanh(String maTinh, String tenTinh) {
		this.maTinh = maTinh;
		this.tenTinh = tenTinh;
	}

	// Các getter, setter và các phương thức khác

	private static final Tinhthanh[] TINH_THANHS = { new Tinhthanh("01", "Hà Nội"), new Tinhthanh("02", "Hà Giang"),

			new Tinhthanh("91", "Kiên Giang"), new Tinhthanh("92", "Cần Thơ"),

	};

	public static Tinhthanh timKiemTinhThanhTheoID(String id) {
		for (Tinhthanh tinh : TINH_THANHS) {
			if (tinh.getMaTinh().equals(id)) {
				return tinh;
			}
		}
		return null; // không tìm thấy
	}
}