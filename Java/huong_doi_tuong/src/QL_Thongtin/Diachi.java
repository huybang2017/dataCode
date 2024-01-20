/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QL_Thongtin;

import java.util.Scanner;

/**
 *
 * @author ldkhai
 */
public class Diachi {
	private String sonha;
	private String phuong;
	private String quan;
	private Tinhthanh tinhthanh;// hay String matinh

	public Diachi(String sonha, String phuong, String quan, Tinhthanh tinhthanh) {
		this.sonha = sonha;
		this.phuong = phuong;
		this.quan = quan;
		this.tinhthanh = tinhthanh;
	}

	public String getSonha() {
		return sonha;
	}

	public void setSonha(String sonha) {
		this.sonha = sonha;
	}

	public String getPhuong() {
		return phuong;
	}

	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public Tinhthanh getTinhthanh() {
		return tinhthanh;
	}

	public void setTinhthanh(Tinhthanh tinhthanh) {
		this.tinhthanh = tinhthanh;
	}

	public void nhapdiachi() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ma so nha: ");
		this.setSonha(sc.nextLine());
		System.out.print("Nhap ma tinh thanh: ");
		String id = sc.nextLine();

		Tinhthanh tinhthanh = Tinhthanh.timKiemTinhThanhTheoID(id);
		if (tinhthanh != null) {
			this.setTinhthanh(tinhthanh);
			System.out.println("Đã cập nhật thông tin tỉnh thành cho cá nhân!");
		} else {
			System.out.println("Không tìm thấy ID tỉnh thành này!");
		}
	}

	// ...
	@Override
	public String toString() {
		return sonha + ", " + phuong + ", " + quan + ", " + tinhthanh;
	}
}