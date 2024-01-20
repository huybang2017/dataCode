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
public class Ngaythangnam {
	private int ngay;
	private int thang;
	private int nam;

	public Ngaythangnam(int ngay, int thang, int nam) {
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}

	// Getter và Setter cho từng thuộc tính
	// ...

	@Override
	public String toString() {
		return ngay + "/" + thang + "/" + nam;
	}
}
