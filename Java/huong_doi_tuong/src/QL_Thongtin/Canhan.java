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
public class Canhan {
	private String madinhdanh;
	private String hoTen;
	private String tenTat;
	private Diachi thuongtru;
	private Ngaythangnam ngaysinh;

	public Canhan(String madinhdanh, String hoTen, String tenTat, Diachi thuongtru, Ngaythangnam ngaysinh) {
		this.madinhdanh = madinhdanh;
		this.hoTen = hoTen;
		this.tenTat = tenTat;
		this.thuongtru = thuongtru;
		this.ngaysinh = ngaysinh;
	}

	public String getMadinhdanh() {
		return madinhdanh;
	}

	public void setMadinhdanh(String madinhdanh) {
		this.madinhdanh = madinhdanh;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getTenTat() {
		return tenTat;
	}

	public void setTenTat(String tenTat) {
		this.tenTat = tenTat;
	}

	public Diachi getThuongtru() {
		return thuongtru;
	}

	public void setThuongtru(Diachi thuongtru) {
		this.thuongtru = thuongtru;
	}

	public Ngaythangnam getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Ngaythangnam ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	@Override
	public String toString() {
		return "Mã định danh: " + madinhdanh + "\n" + "Họ và tên: " + hoTen + "\n" + "Tên tắt: " + tenTat + "\n"
				+ "Thường trú: " + thuongtru.toString() + "\n" + "Ngày sinh: " + ngaysinh.toString();
	}
}
